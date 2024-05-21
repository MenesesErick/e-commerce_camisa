package br.unitins.tp1.dto.usuario;

import br.unitins.tp1.dto.endereco.EnderecoResponseDTO;
import br.unitins.tp1.dto.telefone.TelefoneResponseDTO;
import br.unitins.tp1.model.usuario.Sexo;
import br.unitins.tp1.model.usuario.Usuario;

public record UsuarioResponseDTO(
    Long id,
    String nome, 
    String username,
    String gmail,  
    Sexo sexo,
    EnderecoResponseDTO endereco,
    TelefoneResponseDTO telefone
    )
 {

    public static UsuarioResponseDTO valueOf(Usuario usuario){
        return new UsuarioResponseDTO(
            usuario.getId(),
            usuario.getNome(),
            usuario.getUsername(),
            usuario.getGmail(),
            usuario.getSexo(),
            EnderecoResponseDTO.valueOf(usuario.getEndereco()),
            TelefoneResponseDTO.valueOf(usuario.getTelefone())
        );

    }
    
}
