package br.unitins.tp1.dto.cadastro;

import br.unitins.tp1.model.usuario.Cliente;
import br.unitins.tp1.model.usuario.Sexo;

public record CadastroResponseDTO(

        Long id,
        String nome,
        String username,
        Sexo sexo
) {
    public static CadastroResponseDTO valueOf(Cliente cliente){

        return new CadastroResponseDTO(
                cliente.getUsuario().getId(),
                cliente.getUsuario().getNome(),
                cliente.getUsuario().getUsername(),
                cliente.getUsuario().getSexo()
        );
    }
}