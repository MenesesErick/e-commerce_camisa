package br.unitins.tp1.resource;

import java.util.List;


import br.unitins.tp1.dto.FornecedorDTO;
import br.unitins.tp1.dto.FornecedorResponseDTO;
import br.unitins.tp1.model.Fornecedor;
import br.unitins.tp1.repository.CamisaRepository;
import br.unitins.tp1.repository.FornecedorRepository;
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
@Path("/Fornecedor")
public class FornecedorResource {

    @Inject
    public FornecedorRepository fornecedorRepository;
    @Inject
    public CamisaRepository camisaRepository;

    @GET
    @Path("/id")
    public Fornecedor findById(@PathParam("id") Long id){
        return fornecedorRepository.findById(id);
    }

    @GET
    public List<FornecedorResponseDTO> findAll(){
        return fornecedorRepository
        .listAll()
        .stream()
        .map(e -> FornecedorResponseDTO.valueOf(e)).toList();
    
    }

    @GET
    @Path("/search/nomeFornecedor/{nomeFornecedor}")
    public List<FornecedorResponseDTO> findByNomeFornecedor(@PathParam("nome") String nome) {
        return fornecedorRepository.findByNomeFornecedor(nome)
        .stream()
        .map(e -> FornecedorResponseDTO.valueOf(e)).toList();
    }

    @GET
    @Path("/search/gmailFornecedor/{gmailFornecedor}")
    public List<FornecedorResponseDTO> findByGmailFornecedor(@PathParam("gmail") String gmail) {
        return fornecedorRepository.findByGmailFornecedor(gmail)
        .stream()
        .map(e -> FornecedorResponseDTO.valueOf(e)).toList();
    }

    @POST
    @Transactional
    public FornecedorResponseDTO create(FornecedorDTO dto){
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setNomeFornecedor(dto.nomeFornecedor());
        fornecedor.setGmailFornecedor(dto.gmailFornecedor());
        fornecedor.setCamisa(camisaRepository.findById(dto.idCamisa()));

        fornecedorRepository.persist(fornecedor);
        return FornecedorResponseDTO.valueOf(fornecedor);
    }

    @PUT
    @Transactional
    @Path("/{id}")
    public void update(@PathParam("id") Long id, FornecedorDTO dto){
        Fornecedor bancoFornecedor = fornecedorRepository.findById(id);
        bancoFornecedor.setNomeFornecedor(dto.nomeFornecedor());
        bancoFornecedor.setGmailFornecedor(dto.gmailFornecedor());
        bancoFornecedor.setCamisa(camisaRepository.findById(dto.idCamisa()));
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
        fornecedorRepository.deleteById(id);

    }
    
}
