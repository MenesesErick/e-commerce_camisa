package br.unitins.tp1.dto.camisa;

import java.util.List;

public record CamisaDTO(
    String nome,
    String descricao, 
    String cor, 
    double preco, 
    Integer largura,
    Integer comprimento,
    Integer estoque,
    Integer idTamanho,
    Long idFornecedor,
    Long idEstilo,
    Long idMarca,
    List<Long> listaMaterial

) 
{}  


