package br.unitins.tp1.service.telefone;

import java.util.List;

import br.unitins.tp1.dto.telefone.TelefoneDTO;
import br.unitins.tp1.dto.telefone.TelefoneResponseDTO;
import br.unitins.tp1.model.outros.Telefone;
import br.unitins.tp1.repository.TelefoneRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.GET;

@ApplicationScoped
public class TelefoneServiceImpl implements TelefoneService {

    @Inject
    public TelefoneRepository telefoneRepository;

    @Override
    @Transactional
    public TelefoneResponseDTO create(@Valid TelefoneDTO dto) {
        Telefone telefone = new Telefone();
        telefone.setNumero(dto.numero());
        telefone.setCodigoArea(dto.codigoArea());

        telefoneRepository.persist(telefone);
        return TelefoneResponseDTO.valueOf(telefone);

    }

    @Override
    @Transactional
    public void update(Long id, TelefoneDTO dto) {
        Telefone telefone = telefoneRepository.findById(id);
        telefone.setNumero(dto.numero());
        telefone.setCodigoArea(dto.codigoArea());

    }

    @Override
    @Transactional
    public void delete(Long id) {
        telefoneRepository.deleteById(id);
    }

    @Override
    public TelefoneResponseDTO findById(Long id) {
        return TelefoneResponseDTO.valueOf(telefoneRepository.findById(id));
    }

    @GET
    public List<TelefoneResponseDTO> findAll() {
        return telefoneRepository
                .listAll()
                .stream()
                .map(e -> TelefoneResponseDTO.valueOf(e))
                .toList();
    }

    @Override
    public List<TelefoneResponseDTO> findByCodigoArea(String codigoArea) {
        return telefoneRepository
                .findByCodigoArea(codigoArea)
                .stream()
                .map(e -> TelefoneResponseDTO.valueOf(e))
                .toList();
    }

    @Override
    public List<TelefoneResponseDTO> findByNumero(String numero) {
        return telefoneRepository
                .findByNumero(numero)
                .stream()
                .map(e -> TelefoneResponseDTO.valueOf(e))
                .toList();
    }
}
