package br.unitins.tp1.dto.fornecedor;

import br.unitins.tp1.dto.telefone.TelefoneResponseDTO;
import br.unitins.tp1.model.produto.Fornecedor;

public record FornecedorResponseDTO (
    Long id,
    String nome,
    String gmail,
    TelefoneResponseDTO telefone
) {
    public static FornecedorResponseDTO valueOf(Fornecedor fornecedor){
        return new FornecedorResponseDTO( 
            fornecedor.getId(),
            fornecedor.getNome(),
            fornecedor.getGmail(),
            TelefoneResponseDTO.valueOf(fornecedor.getTelefone())
        );
    }

}
