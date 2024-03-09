package br.unitins.tp1.dto;

import br.unitins.tp1.model.Material;
import br.unitins.tp1.model.Tamanho;
import br.unitins.tp1.model.Estilo;

public record CamisaDTO(
    String nomeCamisa,
    String marca,
    String cor, 
    String descricao, 
    double preco, 
    Material material, 
    Tamanho tamanho, 
    Estilo estilo) 
    {
}  


