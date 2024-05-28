package br.unitins.tp1.dto.pedido;

import java.util.List;

import br.unitins.tp1.dto.itemPedido.ItemPedidoDTO;

public record PedidoDTO (
    Long idCliente,
    Double desconto,
    Integer idTipoPagamento,
    List<ItemPedidoDTO> itens) 
{ }

