package br.unitins.tp1.service.usuario;

import java.util.List;

import br.unitins.tp1.dto.usuario.UsuarioDTO;
import br.unitins.tp1.dto.usuario.UsuarioResponseDTO;
import jakarta.validation.Valid;

public interface UsuarioService {
    public UsuarioResponseDTO create(@Valid UsuarioDTO dto);

    public void update(Long id, UsuarioDTO dto);

    public void delete(Long id);

    public UsuarioResponseDTO findById(Long id);

    public List<UsuarioResponseDTO> findAll();

    public List<UsuarioResponseDTO> findByNome(String nome);

}
