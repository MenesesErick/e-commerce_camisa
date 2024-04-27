package br.unitins.tp1.dto.telefone;

import br.unitins.tp1.model.outros.Telefone;

public record TelefoneResponseDTO(
    Long id,
    String codigoArea,
    String numero
) {
    public static TelefoneResponseDTO valueOf(Telefone telefone) {
        return new TelefoneResponseDTO(
            telefone.getId(),
            telefone.getCodigoArea(), 
            telefone.getNumero());
    }
    
}
