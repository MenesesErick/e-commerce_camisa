package br.unitins.tp1.service.marca;

import java.util.List;

import br.unitins.tp1.dto.marca.MarcaDTO;
import br.unitins.tp1.dto.marca.MarcaResponseDTO;
import jakarta.validation.Valid;

public interface MarcaService {

    public MarcaResponseDTO create(@Valid MarcaDTO dto);

    public void update(Long id, MarcaDTO dto);

    public void delete(Long id);

    public MarcaResponseDTO findById(Long id);

    public List<MarcaResponseDTO> findAll();

    public List<MarcaResponseDTO> findByNome(String nome);

}
