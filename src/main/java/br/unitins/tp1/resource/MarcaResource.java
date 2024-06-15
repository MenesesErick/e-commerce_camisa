package br.unitins.tp1.resource;

import org.jboss.logging.Logger;

import br.unitins.tp1.dto.marca.MarcaDTO;
import br.unitins.tp1.service.marca.MarcaService;
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
@Path("/marcas")
public class MarcaResource {

    @Inject
    public MarcaService marcaService;

    private static final Logger LOG = Logger.getLogger(MarcaResource.class);

    @GET
    @RolesAllowed({ "Funcionario", "Cliente" })
    public Response findAll() {
        LOG.infof("Executando o findAll");
        return Response.ok(marcaService.findAll()).build();
    }

    @GET
    @Path("/search/nome/{nome}")
    @RolesAllowed({ "Funcionario", "Cliente" })
    public Response findByNome(@PathParam("nome") String nome) {
        LOG.infof("Buscando por nome");
        return Response.ok(marcaService.findByNome(nome)).build();
    }

    @PUT
    @Path("/{id}")
    @RolesAllowed({ "Funcionario" })
    public Response update(@PathParam("id") Long id, MarcaDTO dto) {
        LOG.infof("Executando update Marca");
        try {
            marcaService.update(id, dto);
            Response response = Response.status(Status.NO_CONTENT).build();
            LOG.infof("Marca Atualizada");
            return response;

        } catch (Exception e) {
            LOG.errorf("Erro no update de marca");
            return null;
        }
    }

    @DELETE
    @Path("/{id}")
    @RolesAllowed({ "Funcionario" })
    public Response delete(@PathParam("id") Long id) {
        LOG.infof("Executando delete Marca");
        try {
            marcaService.delete(id);
            Response response = Response.status(Status.NO_CONTENT).build();
            LOG.infof("Erro ao deletar marca");
            return response;
        } catch (Exception e) {
            LOG.errorf("Erro ao deletar marca");
            return null;
        }
    }

    @POST
    @RolesAllowed({ "Funcionario" })
    public Response create(@Valid MarcaDTO dto) {
        LOG.infof("Executando create Marca");
        try {
            Response response = Response.status(Status.CREATED).entity(marcaService.create(dto)).build();
            LOG.infof("Marca foi criada");
            return response;

        } catch (Exception e) {
            LOG.errorf("Erro ao criar marca");
            return null;
        }
    }

    @GET
    @Path("/{id}")
    @RolesAllowed({ "Funcionario", "Cliente" })
    public Response findById(@PathParam("id") Long id) {
        LOG.infof("Executando o FindById");
        return Response.ok(marcaService.findById(id)).build();
    }
}
