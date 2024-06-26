package br.unitins.tp1.service.cliente;

import java.util.List;

import br.unitins.tp1.dto.AtualizarSenhaDTO;
import br.unitins.tp1.dto.AtualizarUsernameDTO;
import br.unitins.tp1.dto.cliente.ClienteDTO;
import br.unitins.tp1.dto.cliente.ClienteResponseDTO;
import br.unitins.tp1.dto.usuario.UsuarioResponseDTO;
import jakarta.validation.Valid;

public interface ClienteService {

    public ClienteResponseDTO create(@Valid ClienteDTO dto);

    public void update(Long id, ClienteDTO dto);

    public void delete(Long id);

    public ClienteResponseDTO findById(Long id);

    public List<ClienteResponseDTO> findAll();

    public List<ClienteResponseDTO> findByCpf(String cpf);

    public UsuarioResponseDTO login(String username, String senha);

    public void atualizarSenha(Long id, AtualizarSenhaDTO AtualizarSenhaDTO);

    public void atualizarUsername(Long id, AtualizarUsernameDTO AtualizarUsernameDTO);

}
