package br.unitins.tp1.resource;


import java.util.List;

import br.unitins.tp1.dto.EstoqueDTO;
import br.unitins.tp1.dto.EstoqueResponseDTO;
import br.unitins.tp1.model.Estoque;
import br.unitins.tp1.repository.CamisaRepository;
import br.unitins.tp1.repository.EstoqueRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/Estoque")
public class EstoqueResource {

    @Inject
    public EstoqueRepository estoqueRepository;

    @Inject
    public CamisaRepository camisaRepository;

    @GET
    @Path("/id")
    public Estoque findById(@PathParam("id") Long id){
        return estoqueRepository.findById(id);
        
    }
    
    @GET
    public List<EstoqueResponseDTO> findAll(){
        return estoqueRepository
        .listAll()
        .stream()
        .map(e -> EstoqueResponseDTO.valueOf(e)).toList();
    
    }

    @GET
    @Path("/search/quantidade/{quantidade}")
    public List<EstoqueResponseDTO> findByQuantidade(@PathParam("quantidade") int quantidade) {
        return estoqueRepository.findByQuantidade(quantidade)
        .stream()
        .map(e -> EstoqueResponseDTO.valueOf(e)).toList();
    }

    @POST
    @Transactional
    public EstoqueResponseDTO create(EstoqueDTO dto){
        Estoque estoque = new Estoque();
        estoque.setQuantidade(dto.quantidade());
        estoque.setCamisa(camisaRepository.findById(dto.idCamisa()));

        estoqueRepository.persist(estoque);
        return EstoqueResponseDTO.valueOf(estoque);
    }

    @PUT
    @Transactional
    @Path("/{id}")
    public void update(@PathParam("id") Long id, EstoqueDTO dto){

        Estoque bancoEstoque = estoqueRepository.findById(id);
        bancoEstoque.setQuantidade(dto.quantidade());
        bancoEstoque.setCamisa(camisaRepository.findById(dto.idCamisa()));

    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
        estoqueRepository.deleteById(id);

    }

}
