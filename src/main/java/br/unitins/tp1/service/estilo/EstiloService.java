package br.unitins.tp1.service.estilo;

import java.util.List;

import br.unitins.tp1.dto.estilo.EstiloDTO;
import br.unitins.tp1.dto.estilo.EstiloResponseDTO;
import jakarta.validation.Valid;

public interface EstiloService {
    
    public EstiloResponseDTO create(@Valid EstiloDTO dto);

    public void update(Long id, EstiloDTO dto);

    public void delete(Long id);

    public EstiloResponseDTO findById(Long id);

    public List<EstiloResponseDTO> findAll();

    public List<EstiloResponseDTO> findByNome(String nome);
}
