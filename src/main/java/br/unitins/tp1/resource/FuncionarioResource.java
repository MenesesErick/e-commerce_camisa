package br.unitins.tp1.resource;

import org.jboss.logging.Logger;

import br.unitins.tp1.dto.funcionario.FuncionarioDTO;
import br.unitins.tp1.service.funcionario.FuncionarioService;
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
@Path("/funcionarios")
public class FuncionarioResource {

    @Inject
    public FuncionarioService funcionarioService;

    private static final Logger LOG = Logger.getLogger(FuncionarioResource.class);

    @GET
    @RolesAllowed({ "Funcionario" })
    public Response findAll() {
        LOG.infof("Executando finAll");
        return Response.ok(funcionarioService.findAll()).build();
    }

    @GET
    @Path("/search/cargo/{cargo}")
    @RolesAllowed({ "Funcionario" })
    public Response findByCargo(@PathParam("cargo") String cargo) {
        LOG.infof("Executando findByCargo");
        return Response.ok(funcionarioService.findByCargo(cargo)).build();
    }

    @PUT
    @Path("/{id}")
    @RolesAllowed({ "Funcionario" })
    public Response update(@PathParam("id") Long id, FuncionarioDTO dto) {
        LOG.infof("Executando update de funcionario");
        try {
            funcionarioService.update(id, dto);
            Response response = Response.status(Status.NO_CONTENT).build();
            LOG.infof("Update de funcionario concluido");
            return response;

        } catch (Exception e) {
            LOG.errorf("Erro ao Atualizar funcionario");
            return null;
        }
    }

    @DELETE
    @Path("/{id}")
    @RolesAllowed({ "Funcionario" })
    public Response delete(@PathParam("id") Long id) {
        LOG.infof("Deletando funcionario");
        try {
            funcionarioService.delete(id);
            Response response = Response.status(Status.NO_CONTENT).build();
            LOG.infof("Funcionario deletado");
            return response;

        } catch (Exception e) {
            LOG.errorf("Erro ao deletar Funcionario");
            return null;
        }
    }

    @POST
    @RolesAllowed({ "Funcionario" })
    public Response create(@Valid FuncionarioDTO dto) {
        LOG.infof("Criando funcionario");
        try {
            Response response = Response.status(Status.CREATED).entity(funcionarioService.create(dto)).build();
            LOG.infof("Funcionario Criado");
            return response;

        } catch (Exception e) {
            LOG.errorf("Erro ao criar funcionario");
            return null;
        }
    }

    @GET
    @Path("/{id}")
    @RolesAllowed({ "Funcionario" })
    public Response findById(@PathParam("id") Long id) {
        LOG.infof("Executando FindById");
        return Response.ok(funcionarioService.findById(id)).build();
    }

}
