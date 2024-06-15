package br.unitins.tp1.resource;

import org.jboss.logging.Logger;

import br.unitins.tp1.dto.cadastro.CadastroDTO;
import br.unitins.tp1.service.cadastroBasico.CadastroService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/cadastros")
public class CadastroBasicoResource {
    @Inject
    CadastroService service;

    private static final Logger LOG = Logger.getLogger(String.valueOf(CadastroBasicoResource.class));

    @POST
    public Response create(@Valid CadastroDTO dto) {
        LOG.info("Cadastrando um usuario.");
        return Response.status(Response.Status.CREATED).entity(service.create(dto)).build();
    }
}

