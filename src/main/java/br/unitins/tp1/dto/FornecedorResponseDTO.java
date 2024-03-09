package br.unitins.tp1.dto;

import br.unitins.tp1.model.Fornecedor;

public record FornecedorResponseDTO(
    Long id,
    String nomeFornecedor,
    String gmailFornecedor,
    CamisaResponseDTO camisa
) {
    public static FornecedorResponseDTO valueOf(Fornecedor fornecedor){
        return new FornecedorResponseDTO(
            fornecedor.getId(),
            fornecedor.getNomeFornecedor(),
            fornecedor.getGmailFornecedor(),
            CamisaResponseDTO.valueOf(fornecedor.getCamisa()));
        
    }
}
