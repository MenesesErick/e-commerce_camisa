package br.unitins.tp1.resource;

import org.jboss.logging.Logger;

import br.unitins.tp1.dto.AtualizarSenhaDTO;
import br.unitins.tp1.dto.AtualizarUsernameDTO;
import br.unitins.tp1.dto.cliente.ClienteDTO;
import br.unitins.tp1.service.cliente.ClienteService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
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
@Path("/clientes")
public class ClienteResource {

    @Inject
    public ClienteService clienteService;

    private static final Logger LOG = Logger.getLogger(ClienteResource.class);

    @GET
    @RolesAllowed({"Funcionario"})
    public Response findAll() {
        LOG.infof("Executando o findAll");
        return Response.ok(clienteService.findAll()).build();
    }

    @GET
    @Path("/search/cpf/{cpf}")
    @RolesAllowed({"Funcionario"})
    public Response findByCpf(@PathParam("cpf") String cpf) {
        LOG.infof("Buscando por Cpf");
        return Response.ok(clienteService.findByCpf(cpf)).build();
    }

    @PUT
    @Path("/{id}")
    @RolesAllowed({ "Funcionario", "Cliente" })
    public Response update(@PathParam("id") Long id, ClienteDTO dto) {
        LOG.infof("Executando o Update");

        try {

            clienteService.update(id, dto);
            Response response = Response.status(Status.NO_CONTENT).build();
            LOG.infof("Update concluido");
            return response;

        } catch (Exception e) {
            LOG.errorf("Erro no Update");
            return null;
        }
    }

    @DELETE
    @Path("/{id}")
    @RolesAllowed({ "Funcionario", "Cliente" })
    public Response delete(@PathParam("id") Long id) {
        LOG.infof("Iniciando delete de Cliente");
        try {
            clienteService.delete(id);
            Response response = Response.status(Status.NO_CONTENT).build();
            LOG.infof("Cliente deletado");
            return response;

        } catch (Exception e) {
            LOG.errorf("Erro ao deletar");
            return null;
        }
    }

    @POST
    @RolesAllowed({ "Funcionario", "Cliente" })
    public Response create(@Valid ClienteDTO dto) {
        LOG.infof("Iniciando Criação de Cliente");
        try {
            Response response = Response.status(Status.CREATED).entity(clienteService.create(dto)).build();
            LOG.infof("Cliente inserido");
            return response;
        } catch (Exception e) {
            LOG.errorf("Erro ao Inserir");
            return null;
        }
    }

    @PATCH
    @Path("/atualizarSenha/{id}")
    @RolesAllowed({ "Funcionario", "Cliente" })
    public Response atualizarSenha(@PathParam("id") Long id, AtualizarSenhaDTO dto) {
        LOG.info("Atualizando senha");
        clienteService.atualizarSenha(id, dto);
        return Response.status(Status.NO_CONTENT).build();
    }

    @PATCH
    @Path("/atualizarUsername/{id}")
    @RolesAllowed({"Funcionario","Cliente"})
    public Response atualizarUsername(@PathParam("id") Long id, AtualizarUsernameDTO dto) {
        LOG.info("Atualizando username");
        clienteService.atualizarUsername(id, dto);
        return Response.status(Status.NO_CONTENT).build();
    }

    @GET
    @Path("/{id}")
    @RolesAllowed({"Funcionario", "Cliente"})
    public Response findById(@PathParam("id") Long id) {
        LOG.infof("Buscando por Id");
        return Response.ok(clienteService.findById(id)).build();
    }
}
