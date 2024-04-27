package br.unitins.tp1.service.cliente;

import java.util.List;

import br.unitins.tp1.dto.cliente.ClienteDTO;
import br.unitins.tp1.dto.cliente.ClienteResponseDTO;
import jakarta.validation.Valid;

public interface ClienteService {

    public ClienteResponseDTO create(@Valid ClienteDTO dto);

    public void update(Long id, ClienteDTO dto);

    public void delete(Long id);

    public ClienteResponseDTO findById(Long id);

    public List<ClienteResponseDTO> findAll();

    public List<ClienteResponseDTO> findByCpf(String cpf);
    
}
