package br.unitins.tp1.resource;

import org.jboss.logging.Logger;

import br.unitins.tp1.dto.estilo.EstiloDTO;
import br.unitins.tp1.service.estilo.EstiloService;
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
@Path("/estilos")
public class EstiloResource {

    @Inject
    public EstiloService estiloService;

    private static final Logger LOG = Logger.getLogger(EstiloResource.class);

    @GET
    @RolesAllowed({ "Funcionario", "Cliente" })
    public Response findAll() {
        LOG.infof("Executando o findAll");
        return Response.ok(estiloService.findAll()).build();
    }

    @GET
    @Path("/search/nome/{nome}")
    @RolesAllowed({ "Funcionario", "Cliente" })
    public Response findByNome(@PathParam("nome") String nome) {
        LOG.infof("Buscando por nome");
        return Response.ok(estiloService.findByNome(nome)).build();
    }

    @PUT
    @Path("/{id}")
    @RolesAllowed({ "Funcionario" })
    public Response update(@PathParam("id") Long id, EstiloDTO dto) {
        LOG.infof("Atualizando estilo");

        try {
            estiloService.update(id, dto);
            Response response = Response.status(Status.NO_CONTENT).build();
            LOG.infof("Atulizção concluida");
            return response;

        } catch (Exception e) {
            LOG.errorf("Erro ao atualizar estilo");
            return null;
        }
    }

    @DELETE
    @Path("/{id}")
    @RolesAllowed({ "Funcionario" })
    public Response delete(@PathParam("id") Long id) {
        LOG.infof("Deletando estilo");
        try {
            estiloService.delete(id);
            Response response = Response.status(Status.NO_CONTENT).build();
            LOG.infof("Estilo deletado");
            return response;

        } catch (Exception e) {
            LOG.errorf("Erro ao deletar estilo");
            return null;
        }
    }

    @POST
    @RolesAllowed({ "Funcionario" })
    public Response create(@Valid EstiloDTO dto) {
        LOG.infof("Criando estilo");
        try {
            Response response = Response.status(Status.CREATED).entity(estiloService.create(dto)).build();
            LOG.infof("Estilo criado");
            return response;

        } catch (Exception e) {
            LOG.errorf("Erro ao criar estilo");
            return null;

        }
    }

    @GET
    @Path("/{id}")
    @RolesAllowed({ "Funcionario", "Cliente" })
    public Response findById(@PathParam("id") Long id) {
        LOG.infof("Executando o FindById");
        return Response.ok(estiloService.findById(id)).build();
    }
}
