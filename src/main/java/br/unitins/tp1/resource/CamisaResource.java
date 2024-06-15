package br.unitins.tp1.resource;

import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import org.jboss.logging.Logger;

import br.unitins.tp1.dto.camisa.CamisaDTO;
import br.unitins.tp1.form.ImageForm;
import br.unitins.tp1.service.camisa.CamisaFileServiceImpl;
import br.unitins.tp1.service.camisa.CamisaService;
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
import jakarta.ws.rs.core.Response.ResponseBuilder;
import jakarta.ws.rs.core.Response.Status;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/camisas")
public class CamisaResource {

    private static final Logger LOG = Logger.getLogger(CamisaResource.class);

    @Inject
    public CamisaFileServiceImpl fileService;

    @Inject
    public CamisaService camisaService;

    @GET
    @RolesAllowed({ "Funcionario", "Cliente" })
    public Response findAll() {
        LOG.infof("Executando o findAll");
        return Response.ok(camisaService.findAll()).build();
    }

    @GET
    @Path("/search/nome/{nome}")
    @RolesAllowed({ "Funcionario", "Cliente" })
    public Response findByNome(@PathParam("nome") String nome) {
        LOG.infof("Buscando por Nome");
        return Response.ok(camisaService.findByNome(nome)).build();
    }

    @GET
    @Path("/search/descricao/{descricao}")
    @RolesAllowed({ "Funcionario", "Cliente" })
    public Response findByDescricao(@PathParam("descricao") String descricao) {
        LOG.infof("Buscando por Descriçao");
        return Response.ok(camisaService.findByDescricao(descricao)).build();
    }

    @PUT
    @Path("/{id}")
    @RolesAllowed({ "Funcionario" })
    public Response update(@PathParam("id") Long id, CamisaDTO dto) {

        LOG.infof("Iniciando Update de camisa");
        try {
            camisaService.update(id, dto);
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
    @RolesAllowed({ "Funcionario" })
    public Response delete(@PathParam("id") Long id) {
        LOG.infof("Iniciando o delete camisa");

        try {
            camisaService.delete(id);
            Response response = Response.status(Status.NO_CONTENT).build();
            LOG.infof("Camisa deletada");
            return response;

        } catch (Exception e) {
            LOG.errorf("Erro ao deletar");
            return null;
        }

    }

    @POST
    @RolesAllowed({ "Funcionario" })
    public Response create(@Valid CamisaDTO dto) {
        LOG.info("Iniciando Inserção de Camisa");
        try {
            Response response = Response.status(Status.CREATED).entity(camisaService.create(dto)).build();
            LOG.info("Camisa Inserida");
            return response;

        } catch (Exception e) {
            LOG.error("Erro ao Inserir");
            return null;
        }
    }

    @GET
    @Path("/{id}")
    @RolesAllowed({ "Funcionario", "Cliente" })
    public Response findById(@PathParam("id") Long id) {
        return Response.ok(camisaService.findById(id)).build();
    }

    @PATCH
    @Path("/{id}/image/upload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response upload(@PathParam("id") Long id, @MultipartForm ImageForm form) {
        LOG.info("Iniciando upload de imagem");
        fileService.salvar(id, form.getNomeImagem(), form.getImagem());
        return Response.noContent().build();
    }

    @GET
    @Path("/image/download/{nomeImagem}")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response download(@PathParam("nomeImagem") String nomeImagem) {
        LOG.info("Iniciando download de imagem");
        fileService.download(nomeImagem);
        ResponseBuilder response = Response.ok(fileService.download(nomeImagem));
        response.header("Content-Disposition", "attachment; filename=" + nomeImagem);
        return response.build();
    }
}
