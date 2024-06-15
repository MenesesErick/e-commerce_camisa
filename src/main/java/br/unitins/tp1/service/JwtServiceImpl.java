package br.unitins.tp1.service;

import java.time.Duration;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import br.unitins.tp1.dto.AuthUsuarioDTO;
import br.unitins.tp1.dto.usuario.UsuarioResponseDTO;
import io.smallrye.jwt.build.Jwt;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class JwtServiceImpl implements JwtService {

    private static final Duration EXPIRATION_TIME = Duration.ofHours(24);

    @Override
    public String generateJwt(AuthUsuarioDTO idAuth,UsuarioResponseDTO dto) {
        Instant now = Instant.now();
        Instant expiryDate = now.plus(EXPIRATION_TIME);

        Set<String> roles = new HashSet<String>();
        if (idAuth.perfil() == 1) {
            roles.add("Funcionario");
        } else if (idAuth.perfil() == 2) {
            roles.add("Cliente");
        }
        return Jwt.issuer("unitins-jwt")
                .claim("Id", dto.id())
                .subject(dto.nome())
                .groups(roles)
                .expiresAt(expiryDate)
                .sign();
    }

}
