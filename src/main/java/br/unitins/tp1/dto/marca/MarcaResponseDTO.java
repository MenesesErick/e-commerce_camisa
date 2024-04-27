package br.unitins.tp1.dto.marca;

import br.unitins.tp1.model.produto.Marca;

public record MarcaResponseDTO(
    Long id,
    String nome
) {
    public static MarcaResponseDTO valueOf(Marca marca) {
        return new MarcaResponseDTO(
            marca.getId(),
            marca.getNome());
           
    }
}
