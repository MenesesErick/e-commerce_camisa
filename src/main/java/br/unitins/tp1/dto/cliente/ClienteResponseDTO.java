package br.unitins.tp1.dto.cliente;

import br.unitins.tp1.dto.usuario.UsuarioResponseDTO;
import br.unitins.tp1.model.usuario.Cliente;

public record ClienteResponseDTO(
        Long id,
        String cpf,
        UsuarioResponseDTO usuario) {

    public static ClienteResponseDTO valueOf(Cliente cliente) {
        return new ClienteResponseDTO(
                cliente.getId(),
                cliente.getCpf(),
                UsuarioResponseDTO.valueOf(cliente.getUsuario()));
    }

}
