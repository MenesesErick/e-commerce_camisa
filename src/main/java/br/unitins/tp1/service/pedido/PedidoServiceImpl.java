package br.unitins.tp1.service.pedido;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.microprofile.jwt.JsonWebToken;

import br.unitins.tp1.dto.itemPedido.ItemPedidoDTO;
import br.unitins.tp1.dto.pedido.PedidoDTO;
import br.unitins.tp1.dto.pedido.PedidoResponseDTO;
import br.unitins.tp1.model.pedido.ItemPedido;
import br.unitins.tp1.model.pedido.Pedido;
import br.unitins.tp1.model.pedido.Status;
import br.unitins.tp1.model.pedido.TipoPagamento;
import br.unitins.tp1.model.produto.Camisa;
import br.unitins.tp1.model.usuario.Cliente;
import br.unitins.tp1.repository.CamisaRepository;
import br.unitins.tp1.repository.ClienteRepository;
import br.unitins.tp1.repository.PedidoRepository;
import br.unitins.tp1.validation.ValidationException;
import io.quarkus.security.identity.SecurityIdentity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@ApplicationScoped
public class PedidoServiceImpl implements PedidoService {

    @Inject
    private PedidoRepository pedidoRepository;

    @Inject
    private CamisaRepository camisaRepository;

    @Inject
    private ClienteRepository clienteRepository;

    @Inject
    SecurityIdentity securityIdentity;

    @Inject
    JsonWebToken jwt;

    @Override
    @Transactional
    public PedidoResponseDTO create(@Valid PedidoDTO dto) {

        String username = securityIdentity.getPrincipal().getName();

        if (!AutenticacaoCliente(username, dto.idCliente())) {
            throw new ValidationException("Verificando...", "Você não pode fazer o pedido.");
        }

        Cliente clienteAutenticado = clienteRepository.findById(dto.idCliente());
        if (clienteAutenticado == null) {
            throw new ValidationException("Buscando Cliente", "Cliente não encontrado");
        }

        Pedido pedido = new Pedido();

        pedido.setData(LocalDateTime.now());
        pedido.setCliente(clienteRepository.findById(dto.idCliente()));

        pedido.setPagamento(TipoPagamento.valueOf(dto.idPagamento()));

        List<ItemPedido> itens = new ArrayList<ItemPedido>();
        double total = 0;

        for (ItemPedidoDTO itemDTO : dto.itens()) {
            ItemPedido item = new ItemPedido();

            item.setCamisa(camisaRepository.findById(itemDTO.idCamisa()));
            item.setQuantidade((itemDTO.quantidade()));

            if (item.getQuantidade() <= item.getCamisa().getEstoque()) {
                item.getCamisa().setEstoque(item.getCamisa().getEstoque() - item.getQuantidade());
            } else {
                throw new ValidationException("QuantidadeDisponivel", "Quantidade Indisponivel");
            }

            itens.add(item);

            total += calcularValorTotal(item.getCamisa(), item);
            total = total - (total * calcularDesconto(item));

        }

        pedido.setItens(itens);
        pedido.setTotal(total);

        pedido.setStatus(Status.PENDENTE);

        pedidoRepository.persist(pedido);
        return PedidoResponseDTO.valueOf(pedido);

    }

    private double calcularDesconto(ItemPedido item) {

        double desconto = 0;
        if (item.getQuantidade() == 3) {
            desconto = 0.20;
        }
        if (item.getQuantidade() >= 4) {
            desconto = 0.30;
        }
        return desconto;
    }

    private double calcularValorTotal(Camisa camisa, ItemPedido item) {
        double precoCamisa = camisa.getPreco();
        return (precoCamisa * item.getQuantidade());
    }

    public boolean AutenticacaoCliente(String username, Long idCliente) {
        Cliente clienteAut = clienteRepository.findByUsername(username);
        return clienteAut != null && clienteAut.getId().equals(idCliente);
    }

    @Override
    public PedidoResponseDTO findById(Long id) {
        Pedido pedido = pedidoRepository.findById(id);
        if (pedido != null)
            return PedidoResponseDTO.valueOf(pedido);
        return null;
    }

    @Override
    public List<PedidoResponseDTO> findAll() {
        return pedidoRepository
                .listAll()
                .stream()
                .map(e -> PedidoResponseDTO.valueOf(e)).toList();
    }

    @Override
    public List<PedidoResponseDTO> findByCliente(Long idCliente) {
        return pedidoRepository.findByCliente(idCliente).stream()
                .map(e -> PedidoResponseDTO.valueOf(e)).toList();
    }

    @Override
    @Transactional
    public void alterarStatusPagamento(Long id) {
        Pedido pedido = pedidoRepository.findById(id);

        String nomeCliente = jwt.getName();

        if (pedido == null) {
            throw new ValidationException("Buscando Pedido", "O Pedido não foi encontrado");
        }

        if (!pedido.getCliente().getUsuario().getUsername().equals(nomeCliente)) {
            throw new ValidationException("Verificando...",
                    "Você não tem permissão para alterar o status de pagamento desse");
        }

        if (pedido.getStatus() == Status.PENDENTE) {
            pedido.setStatus(Status.PAGO);
        }else if(pedido.getStatus() == Status.PAGO){
            throw new ValidationException("Situação:", "Pedido ja esta pago");
        }

    }

    @Override
    @Transactional
    public List<PedidoResponseDTO> listaPedidos() {
        String username = jwt.getName();
        List<PedidoResponseDTO> pedidos = pedidoRepository.find("cliente.usuario.username", username).stream()
                .map(e -> PedidoResponseDTO.valueOf(e)).toList();

        if (pedidos.isEmpty()) {
            throw new ValidationException("Verificando...", "Você ainda não fez nenhum pedido :(");
        }
        return pedidos;

    }

}
