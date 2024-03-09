package br.unitins.tp1.dto;

import br.unitins.tp1.model.Camisa;
import br.unitins.tp1.model.Material;
import br.unitins.tp1.model.Tamanho;
import br.unitins.tp1.model.Estilo;

public record CamisaResponseDTO (
    Long id,
    String nomeCamisa,
    String marca,
    String cor, 
    String descricao, 
    double preco, 
    Material material, 
    Tamanho tamanho, 
    Estilo estilo) {
  
    public static CamisaResponseDTO valueOf(Camisa camisa){
        return new CamisaResponseDTO(
            camisa.getId(), 
            camisa.getNomeCamisa(), 
            camisa.getMarca(), 
            camisa.getCor(),
            camisa.getDescricao(),
            camisa.getPreco(),
            camisa.getMaterial(),
            camisa.getTamanho(),
            camisa.getEstilo() );
    }
    
    
}
