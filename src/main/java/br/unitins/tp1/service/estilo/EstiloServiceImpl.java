package br.unitins.tp1.service.estilo;

import java.util.List;

import br.unitins.tp1.dto.estilo.EstiloDTO;
import br.unitins.tp1.dto.estilo.EstiloResponseDTO;
import br.unitins.tp1.model.produto.Estilo;
import br.unitins.tp1.repository.EstiloRepository;
import br.unitins.tp1.validation.ValidationException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.GET;

@ApplicationScoped
public class EstiloServiceImpl implements EstiloService {

    @Inject
    public EstiloRepository estiloRepository;

    @Override
    @Transactional
    public EstiloResponseDTO create(@Valid EstiloDTO dto) {
        Estilo estilo = new Estilo();
        estilo.setNome(dto.nome());
        estilo.setDescricao(dto.descricao());

        estiloRepository.persist(estilo);
        return EstiloResponseDTO.valueOf(estilo);

    }

    public void validarNomeEstilo(String nome) {
        Estilo estilo = estiloRepository.findByNomeCompleto(nome);
        if (estilo != null)
            throw  new ValidationException ("nome", "O nome '"+nome+"' já existe.");
    }

    @Override
    @Transactional
    public void update(Long id, EstiloDTO dto) {
        Estilo estilo = estiloRepository.findById(id);
        estilo.setNome(dto.nome());
        estilo.setDescricao(dto.descricao());

    }

    @Override
    @Transactional
    public void delete(Long id) {
        estiloRepository.deleteById(id);

    }

    @Override
    public EstiloResponseDTO findById(Long id) {
        return EstiloResponseDTO.valueOf(estiloRepository.findById(id));

    }

    @GET
    public List<EstiloResponseDTO> findAll() {
        return estiloRepository
                .listAll()
                .stream()
                .map(e -> EstiloResponseDTO.valueOf(e))
                .toList();

    }

    @Override
    public List<EstiloResponseDTO> findByNome(String nome) {
        return estiloRepository.findByNome(nome)
                .stream()
                .map(e -> EstiloResponseDTO.valueOf(e)).toList();

    }

}
