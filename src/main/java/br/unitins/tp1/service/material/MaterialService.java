package br.unitins.tp1.service.material;

import java.util.List;

import br.unitins.tp1.dto.material.MaterialDTO;
import br.unitins.tp1.dto.material.MaterialResponseDTO;
import jakarta.validation.Valid;

public interface MaterialService {

    public MaterialResponseDTO create(@Valid MaterialDTO dto);

    public void update(Long id, MaterialDTO dto);

    public void delete(Long id);

    public MaterialResponseDTO findById(Long id);

    public List<MaterialResponseDTO> findAll();

    public List<MaterialResponseDTO> findByNome(String nome);
    
}
