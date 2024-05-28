package br.unitins.tp1.service.pedido;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.unitins.tp1.dto.itemPedido.ItemPedidoDTO;
import br.unitins.tp1.dto.pedido.PedidoDTO;
import br.unitins.tp1.dto.pedido.PedidoResponseDTO;
import br.unitins.tp1.model.pedido.ItemPedido;
import br.unitins.tp1.model.pedido.Pedido;
import br.unitins.tp1.model.pedido.TipoPagamento;
import br.unitins.tp1.model.produto.Camisa;
import br.unitins.tp1.repository.CamisaRepository;
import br.unitins.tp1.repository.ClienteRepository;
import br.unitins.tp1.repository.PedidoRepository;
import br.unitins.tp1.validation.ValidationException;
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

    @Override
    @Transactional
    public PedidoResponseDTO create(@Valid PedidoDTO dto) {
        Pedido pedido = new Pedido();

        
        pedido.setData(LocalDateTime.now());
        pedido.setTipoPagamento(TipoPagamento.valueOf(dto.idTipoPagamento()));
        pedido.setCliente(clienteRepository.findById(dto.idCliente()));

        List<ItemPedido> itens = new ArrayList<ItemPedido>();
        double total = 0;

        for (ItemPedidoDTO itemDTO : dto.itens()) {
            ItemPedido item = new ItemPedido();

            item.setCamisa(camisaRepository.findById(itemDTO.idCamisa()));
            item.setQuantidade((itemDTO.quantidade()));

            if (item.getQuantidade() <= item.getCamisa().getEstoque()) {
                item.getCamisa().setEstoque(item.getCamisa().getEstoque() - item.getQuantidade());
            } else {
                throw new ValidationException("QuantidadeDisponivel", "QuantidadeIndisponivel");
            }

            total += calcularValorTotal(item.getCamisa(), item);
            total = total - (total * calcularDesconto(item));

            itens.add(item);
        }

        pedido.setItens(itens);
        pedido.setTotal(total);
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
        return precoCamisa * item.getQuantidade();
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

}
