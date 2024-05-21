package br.unitins.tp1.dto.telefone;

import br.unitins.tp1.model.outros.Telefone;

public record TelefoneDTO(
    String codigoArea,
    String numero
) {
    public static Telefone convertToTelefone(TelefoneDTO dto){
        Telefone telefone = new Telefone();

        telefone.setCodigoArea(dto.codigoArea());
        telefone.setNumero(dto.numero());
        return telefone;
    } 
}
