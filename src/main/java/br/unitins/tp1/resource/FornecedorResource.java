package br.unitins.tp1.resource;

import org.jboss.logging.Logger;

import br.unitins.tp1.dto.fornecedor.FornecedorDTO;
import br.unitins.tp1.service.fornecedor.FornecedorService;
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
@Path("/fornecedores")
public class FornecedorResource {

    @Inject
    public FornecedorService fornecedorService;

    private static final Logger LOG = Logger.getLogger(FornecedorResource.class);

    @GET
    @RolesAllowed({ "Funcionario", "Cliente" })
    public Response findAll() {
        LOG.infof("Executando o findAll");
        return Response.ok(fornecedorService.findAll()).build();
    }

    @GET
    @Path("/search/nome/{nome}")
    @RolesAllowed({ "Funcionario", "Cliente" })
    public Response findByNome(@PathParam("nome") String nome) {
        LOG.infof("Executando o findByNome");
        return Response.ok(fornecedorService.findByNome(nome)).build();
    }

    @PUT
    @Path("/{id}")
    @RolesAllowed({ "Funcionario" })
    public Response update(@PathParam("id") Long id, FornecedorDTO dto) {
        LOG.infof("Executando o update de fornecedor");
        try {
            fornecedorService.update(id, dto);
            Response response = Response.status(Status.NO_CONTENT).build();
            LOG.infof("Update de fornecedor concluido");
            return response;

        } catch (Exception e) {
            LOG.errorf("Erro no Update");
            return null;
        }
    }

    @DELETE
    @Path("/{id}")
    @RolesAllowed({ "Funcionario" })
    public Response delete(@PathParam("id") Long id) {
        LOG.infof("Iniciando delete de fornecedor");

        try {
            fornecedorService.delete(id);
            Response response = Response.status(Status.NO_CONTENT).build();
            LOG.infof("Fornecedor deletado");
            return response;

        } catch (Exception e) {
            LOG.errorf("Erro ao deletar o fornecedor");
            return null;
        }
    }

    @POST
    @RolesAllowed({ "Funcionario" })
    public Response create(@Valid FornecedorDTO dto) {
        LOG.infof("Executando Inserção de Fornecedor");
        try {
            Response response = Response.status(Status.CREATED).entity(fornecedorService.create(dto)).build();
            LOG.infof("Fornecedor criado com sucesso");
            return response;

        } catch (Exception e) {
            LOG.infof("Erro ao deletar fornecedor");
            return null;
        }
    }

    @GET
    @Path("/{id}")
    @RolesAllowed({ "Funcionario", "Cliente" })
    public Response findById(@PathParam("id") Long id) {
        LOG.infof("Executando o FindById");
        return Response.ok(fornecedorService.findById(id)).build();
    }

}
