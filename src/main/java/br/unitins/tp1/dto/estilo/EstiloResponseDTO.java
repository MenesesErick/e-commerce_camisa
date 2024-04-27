package br.unitins.tp1.dto.estilo;

import br.unitins.tp1.model.produto.Estilo;

public record EstiloResponseDTO (
    Long id,
    String nome,
    String descricao

) {

    public static EstiloResponseDTO valueOf(Estilo estilo) {
        return new EstiloResponseDTO(
            estilo.getId(),
            estilo.getNome(), 
            estilo.getDescricao());
    }
    
}
