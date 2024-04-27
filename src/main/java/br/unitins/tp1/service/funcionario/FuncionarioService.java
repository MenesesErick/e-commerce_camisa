package br.unitins.tp1.service.funcionario;

import java.util.List;

import br.unitins.tp1.dto.funcionario.FuncionarioDTO;
import br.unitins.tp1.dto.funcionario.FuncionarioResponseDTO;
import jakarta.validation.Valid;

public interface FuncionarioService {

    public FuncionarioResponseDTO create(@Valid FuncionarioDTO dto);

    public void update(Long id, FuncionarioDTO dto);

    public void delete(Long id);

    public FuncionarioResponseDTO findById(Long id);

    public List<FuncionarioResponseDTO> findAll();

    public List<FuncionarioResponseDTO> findByCargo(String cargo);
    
}
