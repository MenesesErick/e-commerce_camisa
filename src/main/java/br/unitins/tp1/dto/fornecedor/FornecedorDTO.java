package br.unitins.tp1.dto.fornecedor;

import br.unitins.tp1.dto.telefone.TelefoneDTO;

public record FornecedorDTO(
    String nome,
    String gmail,
    TelefoneDTO telefone
    
) {}  