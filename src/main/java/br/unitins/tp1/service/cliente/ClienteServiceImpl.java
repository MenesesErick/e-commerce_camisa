package br.unitins.tp1.service.cliente;

import java.util.List;

import br.unitins.tp1.dto.cliente.ClienteDTO;
import br.unitins.tp1.dto.cliente.ClienteResponseDTO;
import br.unitins.tp1.model.usuario.Cliente;
import br.unitins.tp1.repository.ClienteRepository;
import br.unitins.tp1.repository.UsuarioRepository;
import br.unitins.tp1.validation.ValidationException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.GET;

@ApplicationScoped
public class ClienteServiceImpl implements ClienteService {

    @Inject
    public ClienteRepository clienteRepository;

    @Inject
    public UsuarioRepository usuarioRepository;

    @Override
    @Transactional
    public ClienteResponseDTO create(@Valid ClienteDTO dto) {
        Cliente cliente = new Cliente();
        cliente.setCpf(dto.cpf());
        cliente.setUsuario(usuarioRepository.findById(dto.idUsuario()));

        clienteRepository.persist(cliente);
        return ClienteResponseDTO.valueOf(cliente);
    }

    @Override
    @Transactional
    public void update(Long id, ClienteDTO dto) {
        Cliente cliente = clienteRepository.findById(id);
        cliente.setCpf(dto.cpf());
        cliente.setUsuario(usuarioRepository.findById(dto.idUsuario()));

    }

    public void validarCpfIgual(String cpfIgual) {
        Cliente cliente = clienteRepository.findByCpfIgual(cpfIgual);
        if (cliente != null)
            throw new ValidationException("nome", "O nome '" + cpfIgual + "' já existe.");
    }

    @Override
    @Transactional
    public void delete(Long id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public ClienteResponseDTO findById(Long id) {
        return ClienteResponseDTO.valueOf(clienteRepository.findById(id));
    }

    @GET
    public List<ClienteResponseDTO> findAll() {
        return clienteRepository
                .listAll()
                .stream()
                .map(e -> ClienteResponseDTO.valueOf(e))
                .toList();
    }

    @Override
    public List<ClienteResponseDTO> findByCpf(String cpf) {
        return clienteRepository.findByCpf(cpf)
                .stream()
                .map(e -> ClienteResponseDTO.valueOf(e)).toList();

    }

}
