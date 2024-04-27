package br.unitins.tp1.resource;

import br.unitins.tp1.dto.usuario.UsuarioDTO;
import br.unitins.tp1.service.usuario.UsuarioService;
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
@Path("/usuarios")
public class UsuarioResource {

    @Inject
    public UsuarioService usuarioService;


    @GET
    public Response findAll() {
        return Response.ok(usuarioService.findAll()).build();
    }

    @GET
    @Path("/search/nome/{nome}") 
    public Response findByNome(@PathParam("nome") String nome){
        return Response.ok(usuarioService.findByNome(nome)).build();
    }

    

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, UsuarioDTO dto) {
        usuarioService.update(id, dto);
        return Response.status(Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        usuarioService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }

    @POST  
    public Response create(@Valid UsuarioDTO dto){
        return Response.status(Status.CREATED).entity(usuarioService.create(dto)).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id")Long id){
        return Response.ok(usuarioService.findById(id)).build(); 
    }
    
}
