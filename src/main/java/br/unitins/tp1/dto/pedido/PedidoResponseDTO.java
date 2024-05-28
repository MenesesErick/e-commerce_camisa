package br.unitins.tp1.dto.pedido;

import java.util.List;

import br.unitins.tp1.dto.cliente.ClienteResponseDTO;
import br.unitins.tp1.dto.itemPedido.ItemPedidoResponseDTO;
import br.unitins.tp1.model.pedido.Pedido;
import br.unitins.tp1.model.pedido.TipoPagamento;

public record PedidoResponseDTO(
        Long id,
        ClienteResponseDTO cliente,
        Double desconto,
        Double total,
        TipoPagamento tipoPagamento,
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
                pedido.getDesconto(),
                pedido.getTotal(),
                pedido.getTipoPagamento(),
                lista);
    }
}
