package br.unitins.tp1.dto.itemPedido;

import br.unitins.tp1.dto.camisa.CamisaResponseDTO;
import br.unitins.tp1.model.pedido.ItemPedido;

public record ItemPedidoResponseDTO (
    Long id,
    String nome,
    Integer quantidade,
    CamisaResponseDTO camisaResponseDTO
) {
    public static ItemPedidoResponseDTO valueOf(ItemPedido item) {
        return new ItemPedidoResponseDTO(
            item.getId(), 
            item.getCamisa().getNome(), 
            item.getQuantidade(),
            CamisaResponseDTO.valueOf(item.getCamisa()));

    }
}
