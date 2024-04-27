package br.unitins.tp1.service.marca;

import java.util.List;

import br.unitins.tp1.dto.marca.MarcaDTO;
import br.unitins.tp1.dto.marca.MarcaResponseDTO;
import br.unitins.tp1.model.produto.Marca;
import br.unitins.tp1.repository.MarcaRepository;
import br.unitins.tp1.validation.ValidationException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.GET;

@ApplicationScoped
public class MarcaServiceImpl implements MarcaService {

    @Inject
    public MarcaRepository marcaRepository;

    @Override
    @Transactional
    public MarcaResponseDTO create(@Valid MarcaDTO dto) {
        Marca marca = new Marca();
        marca.setNome(dto.nome());

        marcaRepository.persist(marca);
        return MarcaResponseDTO.valueOf(marca);
    }

    public void validarNomeMarca(String nome) {
        Marca marca = marcaRepository.findByNomeCompleto(nome);
        if (marca != null)
            throw new ValidationException("nome", "O nome '" + nome + "' já existe.");
    }

    @Override
    @Transactional
    public void update(Long id, MarcaDTO dto) {
        Marca marca = marcaRepository.findById(id);
        marca.setNome(dto.nome());
    }

    @Override
    @Transactional
    public void delete(Long id) {
        marcaRepository.deleteById(id);
    }

    @Override
    public MarcaResponseDTO findById(Long id) {
        return MarcaResponseDTO.valueOf(marcaRepository.findById(id));
    }

    @GET
    public List<MarcaResponseDTO> findAll() {
        return marcaRepository
                .listAll()
                .stream()
                .map(e -> MarcaResponseDTO.valueOf(e))
                .toList();
    }

    @Override
    public List<MarcaResponseDTO> findByNome(String nome) {
        return marcaRepository.findByNome(nome)
                .stream()
                .map(e -> MarcaResponseDTO.valueOf(e)).toList();

    }
}
