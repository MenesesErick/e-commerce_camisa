package br.unitins.tp1.resource;

import java.util.List;

import br.unitins.tp1.dto.CamisaDTO;
import br.unitins.tp1.dto.CamisaResponseDTO;
import br.unitins.tp1.model.Camisa;
import br.unitins.tp1.model.Estilo;
import br.unitins.tp1.model.Material;
import br.unitins.tp1.model.Tamanho;
import br.unitins.tp1.repository.CamisaRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/camisas")
public class CamisaResource {

    @Inject
    public CamisaRepository camisaRepository;

    @GET
    @Path("/{id}")
    public Camisa findById(@PathParam("id") Long id){
        return camisaRepository.findById(id);
    }

    @GET
    public List<CamisaResponseDTO> findAll() {

        return camisaRepository
        .listAll()
        .stream()
        .map(e -> CamisaResponseDTO.valueOf(e))
        .toList() ;
    }

    @GET
    @Path("/serach/nomeCamisa/{nomeCamisa}")
    public List<CamisaResponseDTO> findByNome(@PathParam("nome") String nomeCamisa){
        return camisaRepository.findByNome(nomeCamisa)
        .stream()
        .map(e -> CamisaResponseDTO.valueOf(e)).toList();

    }

    @GET
    @Path("/serach/marca/{marca}")
    public List<CamisaResponseDTO> findByMarca(@PathParam("marca") String marca){
        return camisaRepository.findByNome(marca)
        .stream()
        .map(e -> CamisaResponseDTO.valueOf(e)).toList();

    }

    @GET
    @Path("/serach/cor/{cor}")
    public List<CamisaResponseDTO> findByCor(@PathParam("cor") String cor){
        return camisaRepository.findByCor(cor)
        .stream()
        .map(e -> CamisaResponseDTO.valueOf(e)).toList();

    }

    @GET
    @Path("/serach/descricao/{descricao}")
    public List<CamisaResponseDTO> findByDescricao(@PathParam("descricao") String descricao){
        return camisaRepository.findByDescricao(descricao)
        .stream()
        .map(e -> CamisaResponseDTO.valueOf(e)).toList();

    }

    @GET
    @Path("/serach/preco/{preco}")
    public List<CamisaResponseDTO> findByPreco(@PathParam("preco") double preco){
        return camisaRepository.findByPreco(preco)
        .stream()
        .map(e -> CamisaResponseDTO.valueOf(e)).toList();

    }

    @GET
    @Path("/search/material/{material}")
    public List<CamisaResponseDTO> findByMaterial(@PathParam("material") String material){
        Material materialEnum = Material.valueOf(material.toUpperCase());
        return camisaRepository.findByMaterial(materialEnum)
        .stream()
        .map(e -> CamisaResponseDTO.valueOf(e)).toList();
    }

    @GET
    @Path("/search/tamanho/{tamanho}")
    public List<CamisaResponseDTO> findByTamanho(@PathParam("tamanho") String tamanho){
        Tamanho tamanhoEnum = Tamanho.valueOf(tamanho.toUpperCase());
        return camisaRepository.findByTamanho(tamanhoEnum)
        .stream()
        .map(e -> CamisaResponseDTO.valueOf(e)).toList();
    }

    @GET
    @Path("/search/estilo/{estilo}")
    public List<CamisaResponseDTO> findByEstilo(@PathParam("estilo") String estilo){
        Estilo estiloEnum = Estilo.valueOf(estilo.toUpperCase());
        return camisaRepository.findByEstilo(estiloEnum)
        .stream()
        .map(e -> CamisaResponseDTO.valueOf(e)).toList();
    }

    @POST
    @Transactional
    @Path("/{id}")
    public void update (@PathParam("id") Long id, CamisaDTO dto){
        Camisa bancoCamisa = camisaRepository.findById(id);
        bancoCamisa.setNomeCamisa(dto.nomeCamisa());
        bancoCamisa.setCor(dto.cor());
        bancoCamisa.setPreco(dto.preco());
        bancoCamisa.setDescricao(dto.descricao());
        bancoCamisa.setMarca(dto.marca());
        bancoCamisa.setMaterial(dto.material());
        bancoCamisa.setTamanho(dto.tamanho());
        bancoCamisa.setEstilo(dto.estilo());

    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public void delete (@PathParam("id") Long id){
        camisaRepository.deleteById(id);
    }
}
