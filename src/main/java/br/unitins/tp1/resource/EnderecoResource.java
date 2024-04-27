package br.unitins.tp1.resource;

import br.unitins.tp1.dto.endereco.EnderecoDTO;
import br.unitins.tp1.service.endereco.EnderecoService;
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
@Path("/enderecos")
public class EnderecoResource {

    @Inject
    public EnderecoService enderecoService;

    @GET
    public Response findAll() {
        return Response.ok(enderecoService.findAll()).build();
    }

    @GET
    @Path("/search/cep/{cep}")
    public Response findByCep(@PathParam("cep") String cep) {
        return Response.ok(enderecoService.findByCep(cep)).build();
    }

    @GET
    @Path("/search/cidade/{cidade}")
    public Response findByCidade(@PathParam("cidade") String cidade) {
        return Response.ok(enderecoService.findByCidade(cidade)).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, EnderecoDTO dto) {
        enderecoService.update(id, dto);
        return Response.status(Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        enderecoService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }

    @POST
    public Response create(@Valid EnderecoDTO dto) {
        return Response.status(Status.CREATED).entity(enderecoService.create(dto)).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        return Response.ok(enderecoService.findById(id)).build();
    }
}
