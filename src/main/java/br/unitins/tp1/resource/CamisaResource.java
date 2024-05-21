package br.unitins.tp1.resource;

import br.unitins.tp1.dto.camisa.CamisaDTO;
import br.unitins.tp1.service.camisa.CamisaService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/camisas")
public class CamisaResource {

    @Inject
    public CamisaService camisaService;

    @GET
    @RolesAllowed({"Funcionario", "Cliente"})
    public Response findAll() {
        return Response.ok(camisaService.findAll()).build();
    }

    
    @GET
    @Path("/search/nome/{nome}")
    @RolesAllowed({"Funcionario", "Cliente"})
    public Response findByNome(@PathParam("nome") String nome) {
        return Response.ok(camisaService.findByNome(nome)).build();
    }

    @GET
    @Path("/search/descricao/{descricao}")
    @RolesAllowed({"Funcionario", "Cliente"})
    public Response findByDescricao(@PathParam("descricao") String descricao) {
        return Response.ok(camisaService.findByDescricao(descricao)).build();
    }

    @PUT
    @Path("/{id}")
    @RolesAllowed({"Funcionario"})
    public Response update(@PathParam("id") Long id, CamisaDTO dto) {
        camisaService.update(id, dto);
        return Response.status(Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("/{id}")
    @RolesAllowed({"Funcionario"})
    public Response delete(@PathParam("id") Long id) {
        camisaService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }

    @POST
    @RolesAllowed({"Funcionario"})
    public Response create(@Valid CamisaDTO dto) {
        return Response.status(Status.CREATED).entity(camisaService.create(dto)).build();
    }

    @GET
    @Path("/{id}")
    @RolesAllowed({"Funcionario", "Cliente"})
    public Response findById(@PathParam("id") Long id) {
        return Response.ok(camisaService.findById(id)).build();
    }
}
