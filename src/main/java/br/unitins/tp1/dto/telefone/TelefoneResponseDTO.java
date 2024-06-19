package br.unitins.tp1.dto.telefone;

import br.unitins.tp1.model.outros.Telefone;

public record TelefoneResponseDTO(
    String codigoArea,
    String numero
) {
    public static TelefoneResponseDTO valueOf(Telefone telefone) {
        if (telefone == null) {
            return null;
        }
        return new TelefoneResponseDTO(
            telefone.getCodigoArea(), 
            telefone.getNumero());
    }
    
}
