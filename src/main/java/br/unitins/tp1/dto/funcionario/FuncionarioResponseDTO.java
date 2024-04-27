package br.unitins.tp1.dto.funcionario;

import br.unitins.tp1.dto.usuario.UsuarioResponseDTO;
import br.unitins.tp1.model.usuario.Funcionario;

public record FuncionarioResponseDTO(
        Long id,
        String cargo,
        UsuarioResponseDTO usuario) {

    public static FuncionarioResponseDTO valueOf(Funcionario funcionario) {
        return new FuncionarioResponseDTO(
                funcionario.getId(),
                funcionario.getCargo(),
                UsuarioResponseDTO.valueOf(funcionario.getUsuario()));
    }

}
