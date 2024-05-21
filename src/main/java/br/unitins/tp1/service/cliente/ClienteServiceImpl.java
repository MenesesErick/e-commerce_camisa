package br.unitins.tp1.service.cliente;

import java.util.List;

import br.unitins.tp1.dto.cliente.ClienteDTO;
import br.unitins.tp1.dto.cliente.ClienteResponseDTO;
import br.unitins.tp1.dto.usuario.UsuarioResponseDTO;
import br.unitins.tp1.model.outros.Endereco;
import br.unitins.tp1.model.outros.Telefone;
import br.unitins.tp1.model.usuario.Cliente;
import br.unitins.tp1.model.usuario.Sexo;
import br.unitins.tp1.model.usuario.Usuario;
import br.unitins.tp1.repository.ClienteRepository;
import br.unitins.tp1.repository.UsuarioRepository;
import br.unitins.tp1.service.HashService;
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

    @Inject
    public HashService hashService;

    @Override
    @Transactional
    public ClienteResponseDTO create(@Valid ClienteDTO dto) {
        validarCpf(dto.cpf());

        Endereco endereco = new Endereco();
        endereco.setCep(dto.endereco().cep());
        endereco.setLogradouro(dto.endereco().logradouro());
        endereco.setBairro(dto.endereco().bairro());
        endereco.setNumero(dto.endereco().numero());
        endereco.setComplemento(dto.endereco().complemeto());
        endereco.setCidade(dto.endereco().cidade());
        endereco.setEstado(dto.endereco().estado());
    
        Telefone telefone = new Telefone();
        telefone.setCodigoArea(dto.telefone().codigoArea());
        telefone.setNumero(dto.telefone().numero());
    
        Usuario usuario = new Usuario();
        usuario.setNome(dto.nome());
        usuario.setUsername(dto.username());
        usuario.setGmail(dto.gmail());
        usuario.setSenha(hashService.getHashSenha(dto.senha())); // gerando o hash da senha
        usuario.setSexo(Sexo.valueOf(dto.idSexo()));
        usuario.setEndereco(endereco);
        usuario.setTelefone(telefone);

        usuarioRepository.persist(usuario);

        Cliente cliente = new Cliente();
        cliente.setCpf(dto.cpf());
        cliente.setUsuario(usuario);

        clienteRepository.persist(cliente);
        return ClienteResponseDTO.valueOf(cliente);
    }

    @Override
    @Transactional
    public void update(Long id, ClienteDTO dto) {
        Cliente clienteBanco = clienteRepository.findById(id);
        Usuario usuarioBanco = clienteBanco.getUsuario();
        
        clienteBanco.setCpf(dto.cpf());

        usuarioBanco.setNome(dto.nome());
        usuarioBanco.setGmail(dto.gmail());
        usuarioBanco.setSenha(hashService.getHashSenha(dto.senha())); // gerando o hash da senha
        usuarioBanco.setSexo(Sexo.valueOf(dto.idSexo()));

        Endereco endereco = clienteBanco.getUsuario().getEndereco();
        endereco.setCep(dto.endereco().cep());
        endereco.setLogradouro(dto.endereco().logradouro());
        endereco.setBairro(dto.endereco().bairro());
        endereco.setNumero(dto.endereco().numero());
        endereco.setComplemento(dto.endereco().complemeto());
        endereco.setCidade(dto.endereco().cidade());
        endereco.setEstado(dto.endereco().estado());

        Telefone telefone = clienteBanco.getUsuario().getTelefone();
        telefone.setCodigoArea(dto.telefone().codigoArea());
        telefone.setNumero(dto.telefone().numero());
        
        clienteBanco.setUsuario(usuarioBanco);
    }

    public void validarCpf(String cpf) {
        Cliente cliente = clienteRepository.validarCpf(cpf);
        if (cliente != null)
            throw  new ValidationException("pessoa.cpf", "O cpf '"+ cpf +"' já existe.");
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

    @Override
    public UsuarioResponseDTO login(String username, String senha) {
        Cliente cliente = clienteRepository.findByUsernameAndSenha(username, senha);
        return UsuarioResponseDTO.valueOf(cliente.getUsuario());
    }

}
