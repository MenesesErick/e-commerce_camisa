package br.unitins.tp1.dto;

import br.unitins.tp1.model.Estoque;

public record EstoqueResponseDTO(
    long id,
    int quantidade,
    CamisaResponseDTO camisa

) {
    public static EstoqueResponseDTO valueOf(Estoque estoque){
        return new EstoqueResponseDTO(
        estoque.getId() ,
        estoque.getQuantidade(),
        CamisaResponseDTO.valueOf(estoque.getCamisa()));
    }
    
}
