package br.unitins.tp1.dto.cadastro;

import jakarta.validation.constraints.NotBlank;

public record CadastroDTO(
        @NotBlank(message = "O campo nome não pode ser nulo.")
        String nome,
        String username,
        String senha,
        Integer idSexo

        
) {

}
