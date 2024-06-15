package br.unitins.tp1.resource;

import org.jboss.logging.Logger;

import br.unitins.tp1.dto.pedido.PedidoDTO;
import br.unitins.tp1.service.pedido.PedidoService;
import io.quarkus.security.identity.SecurityIdentity;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/pedidos")
public class PedidoResource {

    private static final Logger LOG = Logger.getLogger(PedidoResource.class);

    @Inject
    public PedidoService pedidoService;

    @Inject
    SecurityIdentity securityIdentity;

    @POST
    @RolesAllowed("Cliente")
    public Response create(@Valid PedidoDTO dto) {
        LOG.info("Executando criação de pedido");
        try {
            Response response = Response.status(Status.CREATED).entity(pedidoService.create(dto)).build();
            return response;

        } catch (Exception e) {
            LOG.errorf("Erro ao executar a criação");
            return null;
        }
    }

    @GET
    @RolesAllowed("Funcionario")
    public Response findAll() {
        LOG.info("Executando FindAll");
        return Response.ok(pedidoService.findAll()).build();
    }

    @GET
    @Path("/{id}")
    @RolesAllowed({ "Cliente", "Funcionario" })
    public Response findById(@PathParam("id") Long id) {
        LOG.infof("Executando o findById");
        return Response.ok(pedidoService.findById(id)).build();
    }

    @GET
    @Path("/search/cliente/{id}")
    @RolesAllowed({ "Cliente", "Funcionario" })
    public Response findByCliente(@PathParam("id") Long idCliente) {
        return Response.ok(pedidoService.findByCliente(idCliente)).build();
    }

    @PATCH
    @Path("/alterarStatusPagamento/{idPedido}")
    @RolesAllowed({ "Cliente" })
    public Response alterarStatusPagamento(@PathParam("idPedido") Long idPedido) {
        LOG.info("Executando alteração de status de pagamento");
        pedidoService.alterarStatusPagamento(idPedido);
        return Response.noContent().build();
    }
}