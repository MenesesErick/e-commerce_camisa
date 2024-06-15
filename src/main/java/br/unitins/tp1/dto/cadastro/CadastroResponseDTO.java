package br.unitins.tp1.dto.cadastro;

import br.unitins.tp1.model.usuario.Sexo;
import br.unitins.tp1.model.usuario.Usuario;

public record CadastroResponseDTO(

        Long id,

        String nome,
        String username,
        String senha,
        Sexo sexo
) {
    public static CadastroResponseDTO valueOf(Usuario usuario){

        return new CadastroResponseDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getUsername(),
                usuario.getSenha(),
                usuario.getSexo()
   
        );
    }
}