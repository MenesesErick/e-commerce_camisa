package br.unitins.tp1.resource;

import br.unitins.tp1.dto.pedido.PedidoDTO;
import br.unitins.tp1.service.pedido.PedidoService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
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

    @Inject
    public PedidoService pedidoService;

    @POST
    public Response create(@Valid PedidoDTO dto) {
        return Response.status(Status.CREATED).entity(pedidoService.create(dto)).build();
    }

    @GET
    public Response findAll() {
        return Response.ok(pedidoService.findAll()).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("idPedido") Long id) {
        return Response.ok(pedidoService.findById(id)).build();
    }

    @GET
    @Path("/search/cliente/{id}")
    public Response findByCliente(@PathParam("idCliente") Long idCliente) {
        return Response.ok(pedidoService.findByCliente(idCliente)).build();
    }
}