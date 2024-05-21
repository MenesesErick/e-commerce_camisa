package br.unitins.tp1.resource;

import br.unitins.tp1.dto.AuthUsuarioDTO;
import br.unitins.tp1.dto.usuario.UsuarioResponseDTO;
import br.unitins.tp1.service.HashService;
import br.unitins.tp1.service.JwtService;
import br.unitins.tp1.service.cliente.ClienteService;
import br.unitins.tp1.service.funcionario.FuncionarioService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/auth")
public class AuthResource {

    @Inject
    public FuncionarioService funcionarioService;

    @Inject
    public ClienteService clienteService;

    @Inject
    public HashService hashService;

    @Inject
    public JwtService jwtService;

    @POST
    public Response login(AuthUsuarioDTO dto) {
        String hash = hashService.getHashSenha(dto.senha());

        UsuarioResponseDTO usuario = null;
        // perfil 1 = funcionario
        if (dto.perfil() == 1) {
            usuario = funcionarioService.login(dto.username(), hash);
        } else if (dto.perfil() == 2) { // cliente
           usuario = clienteService.login(dto.username(), hash);
        } else {
            return Response.status(Status.NOT_FOUND).build();
        }
        return Response.ok(usuario)
                .header("Authorization", jwtService.generateJwt(usuario, dto.perfil()))
                .build();
    }

}
