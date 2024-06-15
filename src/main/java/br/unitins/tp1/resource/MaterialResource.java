package br.unitins.tp1.resource;

import org.jboss.logging.Logger;

import br.unitins.tp1.dto.material.MaterialDTO;
import br.unitins.tp1.service.material.MaterialService;
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
@Path("/materiais")
public class MaterialResource {

    @Inject
    public MaterialService materialService;

    private static final Logger LOG = Logger.getLogger(MaterialResource.class);

    @GET
    @RolesAllowed({ "Funcionario", "Cliente" })
    public Response findAll() {
        LOG.infof("Executando o findAll");
        return Response.ok(materialService.findAll()).build();
    }

    @GET
    @Path("/search/nome/{nome}")
    @RolesAllowed({ "Funcionario", "Cliente" })
    public Response findByNome(@PathParam("nome") String nome) {
        LOG.infof("Buscando por nome");
        return Response.ok(materialService.findByNome(nome)).build();
    }

    @PUT
    @Path("/{id}")
    @RolesAllowed({ "Funcionario" })
    public Response update(@PathParam("id") Long id, MaterialDTO dto) {
        LOG.infof("Atualizando material");

        try {
            materialService.update(id, dto);
            Response response = Response.status(Status.NO_CONTENT).build();
            LOG.infof("Atulizção concluida");
            return response;

        } catch (Exception e) {
            LOG.errorf("Erro ao atualizar material");
            return null;
        }
    }

    @DELETE
    @Path("/{id}")
    @RolesAllowed({ "Funcionario" })
    public Response delete(@PathParam("id") Long id) {
        LOG.infof("Deletando material");
        try {
            materialService.delete(id);
            Response response = Response.status(Status.NO_CONTENT).build();
            LOG.infof("Material deletado");
            return response;

        } catch (Exception e) {
            LOG.errorf("Erro ao deletar material");
            return null;
        }
    }

    @POST
    @RolesAllowed({ "Funcionario" })
    public Response create(@Valid MaterialDTO dto) {
        LOG.infof("Criando material");
        try {
            Response response = Response.status(Status.CREATED).entity(materialService.create(dto)).build();
            LOG.infof("Material criado");
            return response;

        } catch (Exception e) {
            LOG.errorf("Erro ao criar material");
            return null;

        }
    }

    @GET
    @Path("/{id}")
    @RolesAllowed({ "Funcionario", "Cliente" })
    public Response findById(@PathParam("id") Long id) {
        LOG.infof("Executando o findById");
        return Response.ok(materialService.findById(id)).build();
    }
}
