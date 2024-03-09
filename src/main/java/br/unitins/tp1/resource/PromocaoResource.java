package br.unitins.tp1.resource;

import java.util.List;

import br.unitins.tp1.dto.PromocaoDTO;
import br.unitins.tp1.dto.PromocaoResponseDTO;
import br.unitins.tp1.model.Promocao;
import br.unitins.tp1.repository.PromocaoRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/promocao")
public class PromocaoResource {

    @Inject
    public PromocaoRepository promocaoRepository;
    
    
    @GET
    @Path("/{id}")
    public Promocao findById(@PathParam("id") Long id){
        return promocaoRepository.findById(id);
    }
    
    @GET
    public List<PromocaoResponseDTO> findAll() {
        return  promocaoRepository
        .listAll()
        .stream()
        .map(e -> PromocaoResponseDTO.valueOf(e)).toList();
    }

    @GET
    @Path("/search/nome/{nome}")
    public List<PromocaoResponseDTO> findByNome(@PathParam("nome") String nome){
        return promocaoRepository.findByNome(nome)
        .stream()
        .map(e -> PromocaoResponseDTO.valueOf(e)).toList();
    }

    @GET
    @Path("/search/descricao/{descricao}")
    public List<PromocaoResponseDTO> findByDescricao(@PathParam("descricao") String descricao){
        return promocaoRepository.findByDescricao(descricao)
        .stream()
        .map(e -> PromocaoResponseDTO.valueOf(e)).toList();
    }

    @POST
    @Transactional
    public PromocaoResponseDTO create(PromocaoDTO dto){
        Promocao promocao = new Promocao();
        promocao.setNomePromocao(dto.nomePromocao());
        promocao.setPorcentualDesconto(dto.porcentualDesconto());
        promocao.setDescricaoDesconto(dto.descricaoPromocao());

        promocaoRepository.persist(promocao);
        return PromocaoResponseDTO.valueOf(promocao);
    }

    @POST  
    @Transactional
    public void update(@PathParam("id") Long id, PromocaoDTO promocao){

        Promocao promocaoBanco = promocaoRepository.findById(id);
        promocaoBanco.setNomePromocao(promocao.nomePromocao());
        promocaoBanco.setPorcentualDesconto(promocao.porcentualDesconto());
        promocaoBanco.setDescricaoDesconto(promocao.descricaoPromocao());
    }

    @PUT
    @Transactional
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
        promocaoRepository.deleteById(id);
    }

}
