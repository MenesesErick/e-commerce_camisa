package br.unitins.tp1.dto;

import br.unitins.tp1.model.Promocao;

public record PromocaoResponseDTO (
    Long id,
    String nomePromocao,
    double porcentualDesconto
){

    public static PromocaoResponseDTO valueOf(Promocao promocao){
        return new PromocaoResponseDTO(promocao.getId(),  promocao.getNomePromocao(), promocao.getPorcentualDesconto());
    }
    
}
