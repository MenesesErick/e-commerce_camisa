package br.unitins.tp1.service.pedido;

import java.util.List;

import br.unitins.tp1.dto.pedido.PedidoDTO;
import br.unitins.tp1.dto.pedido.PedidoResponseDTO;
import jakarta.validation.Valid;

public interface PedidoService {

    public PedidoResponseDTO create(@Valid PedidoDTO dto);
    public PedidoResponseDTO findById(Long id);
    public List<PedidoResponseDTO> findAll();
    public List<PedidoResponseDTO> findByCliente(Long idCliente);
    boolean AutenticacaoCliente(String username, Long idCliente);

    public void alterarStatusPagamento(Long id);

    public List<PedidoResponseDTO> listaPedidos();

}
