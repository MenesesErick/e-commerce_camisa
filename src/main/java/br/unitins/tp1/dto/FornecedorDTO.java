package br.unitins.tp1.dto;

import br.unitins.tp1.model.Camisa;

public record FornecedorDTO(

    Long idCamisa,
    String nomeFornecedor,
    String gmailFornecedor,
    Camisa camisa
) {
}  
    

