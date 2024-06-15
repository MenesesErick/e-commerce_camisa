package br.unitins.tp1.dto.pedido;

import java.time.LocalDateTime;
import java.util.List;

import br.unitins.tp1.dto.cliente.ClienteResponseDTO;
import br.unitins.tp1.dto.itemPedido.ItemPedidoResponseDTO;
import br.unitins.tp1.model.pedido.Pedido;
import br.unitins.tp1.model.pedido.Status;
import br.unitins.tp1.model.pedido.TipoPagamento;

public record PedidoResponseDTO(
        Long id,
        ClienteResponseDTO cliente,
        Double total,
        LocalDateTime data,
        TipoPagamento pagamento,
        Status status,
        List<ItemPedidoResponseDTO> itens


) {
    public static PedidoResponseDTO valueOf(Pedido pedido) {
        List<ItemPedidoResponseDTO> lista = pedido.getItens()
                                                .stream()
                                                .map(ItemPedidoResponseDTO::valueOf)
                                                .toList();
                return new PedidoResponseDTO(
                        pedido.getId(), 
                        ClienteResponseDTO.valueOf(pedido.getCliente()),
                        pedido.getTotal(),
                        pedido.getData(),
                        pedido.getPagamento(),
                        pedido.getStatus(),
                        lista
                );  
    }
}
