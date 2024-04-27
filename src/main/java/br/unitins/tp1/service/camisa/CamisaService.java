package br.unitins.tp1.service.camisa;

import java.util.List;

import br.unitins.tp1.dto.camisa.CamisaDTO;
import br.unitins.tp1.dto.camisa.CamisaResponseDTO;
import jakarta.validation.Valid;

public interface CamisaService {

    public CamisaResponseDTO create(@Valid CamisaDTO dto);

    public void update(Long id, CamisaDTO dto);

    public void delete(Long id);

    public CamisaResponseDTO findById(Long id);

    public List<CamisaResponseDTO> findAll();

    public List<CamisaResponseDTO> findByNome(String nome);

    public List<CamisaResponseDTO> findByDescricao(String descricao);

}
