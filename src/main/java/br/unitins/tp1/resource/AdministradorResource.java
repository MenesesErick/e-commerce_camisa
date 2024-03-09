package br.unitins.tp1.resource;

import java.util.List;

import br.unitins.tp1.dto.AdministradorDTO;
import br.unitins.tp1.dto.AdministradorResponseDTO;
import br.unitins.tp1.model.Administrador;
import br.unitins.tp1.repository.AdministradorRepository;
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
@Path("/Admin")
public class AdministradorResource {
    
    @Inject
    public AdministradorRepository admRepository;

    @GET
    @Path("/{id}")
    public Administrador findById(@PathParam("id") Long id){
        return admRepository.findById(id);
    }

     @GET
    public List<AdministradorResponseDTO> findAll() {

        return admRepository
        .listAll()
        .stream()
        .map(e -> AdministradorResponseDTO.valueOf(e))
        .toList() ;
    }

    @GET
    @Path("/serach/nomeAdm/{nomeAdm}")
    public List<AdministradorResponseDTO> findByNome(@PathParam("nome") String nomeAdm){
        return admRepository.findByNome(nomeAdm)
        .stream()
        .map(e -> AdministradorResponseDTO.valueOf(e)).toList();

    }

    @GET
    @Path("/serach/gmail/{gmail}")
    public List<AdministradorResponseDTO> findByGmail(@PathParam("gmail") String gmail){
        return admRepository.findByGmail(gmail)
        .stream()
        .map(e -> AdministradorResponseDTO.valueOf(e)).toList();

    }

    @GET
    @Path("/serach/senha/{senha}")
    public List<AdministradorResponseDTO> findBySenha(@PathParam("senha") String senha){
        return admRepository.findBySenha(senha)
        .stream()
        .map(e -> AdministradorResponseDTO.valueOf(e)).toList();

    }

    @POST
    @Transactional
    @Path("/{id}")
    public void update (@PathParam("id") Long id, AdministradorDTO adm){
        Administrador bancoAdm = admRepository.findById(id);
        bancoAdm.setNomeAdm(adm.nomeAdm());
        bancoAdm.setGmail(adm.gmail() );
        bancoAdm.setSenha(adm.senha()); 
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public void delete (@PathParam("id") Long id){
        admRepository.deleteById(id);
    }
}
