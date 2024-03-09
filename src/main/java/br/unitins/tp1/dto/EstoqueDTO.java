package br.unitins.tp1.dto;

import br.unitins.tp1.model.Camisa;

public record EstoqueDTO(

    int quantidade,
    Camisa camisa,
    Long idCamisa
) {

    
}
