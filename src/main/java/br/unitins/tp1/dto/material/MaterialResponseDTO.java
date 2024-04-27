package br.unitins.tp1.dto.material;

import br.unitins.tp1.model.produto.Material;

public record MaterialResponseDTO(
    Long id,
    String nome,
    double porcentagem
) {
    public static MaterialResponseDTO valueOf(Material material){
        return new MaterialResponseDTO( 
            material.getId(),
            material.getNome(),
            material.getPorcentagem()
        );
    }
}
