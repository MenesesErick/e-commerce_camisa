package br.unitins.tp1.service;

import br.unitins.tp1.dto.AuthUsuarioDTO;
import br.unitins.tp1.dto.usuario.UsuarioResponseDTO;

public interface JwtService {
    String generateJwt(AuthUsuarioDTO authDTO, UsuarioResponseDTO dto);
}
