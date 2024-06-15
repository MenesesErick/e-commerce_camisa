package br.unitins.tp1.service.funcionario;

import java.util.List;

import br.unitins.tp1.dto.AtualizarSenhaDTO;
import br.unitins.tp1.dto.AtualizarUsernameDTO;
import br.unitins.tp1.dto.funcionario.FuncionarioDTO;
import br.unitins.tp1.dto.funcionario.FuncionarioResponseDTO;
import br.unitins.tp1.dto.usuario.UsuarioResponseDTO;
import br.unitins.tp1.model.outros.Endereco;
import br.unitins.tp1.model.outros.Telefone;
import br.unitins.tp1.model.usuario.Funcionario;
import br.unitins.tp1.model.usuario.Sexo;
import br.unitins.tp1.model.usuario.Usuario;
import br.unitins.tp1.repository.FuncionarioRepository;
import br.unitins.tp1.repository.UsuarioRepository;
import br.unitins.tp1.service.HashService;
import br.unitins.tp1.validation.ValidationException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class FuncionarioServiceImpl implements FuncionarioService {

    @Inject
    public FuncionarioRepository funcionarioRepository;

    @Inject
    public UsuarioRepository usuarioRepository;

    @Inject
    public HashService hashService;
    @Override
    @Transactional
    public FuncionarioResponseDTO create(@Valid FuncionarioDTO dto) {
    
        // Criando e configurando as entidades
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
    
        // Persistir o usuário, que deve persistir endereço e telefone devido ao CascadeType
        usuarioRepository.persist(usuario);
    
        Funcionario funcionario = new Funcionario();
        funcionario.setCargo(dto.cargo());
        funcionario.setUsuario(usuario);
    
        // Persistir o funcionário
        funcionarioRepository.persist(funcionario);
    
        return FuncionarioResponseDTO.valueOf(funcionario);
    }
    

    @Override
    @Transactional
    public void update(Long id, FuncionarioDTO dto) {
        Funcionario funcionarioBanco = funcionarioRepository.findById(id);
        Usuario usuarioBanco = funcionarioBanco.getUsuario();

        funcionarioBanco.setCargo(dto.cargo());

        usuarioBanco.setNome(dto.nome());
        usuarioBanco.setGmail(dto.gmail());
        usuarioBanco.setSenha(hashService.getHashSenha(dto.senha())); // gerando o hash da senha
        usuarioBanco.setSexo(Sexo.valueOf(dto.idSexo()));

        Endereco endereco = funcionarioBanco.getUsuario().getEndereco();
        endereco.setCep(dto.endereco().cep());
        endereco.setLogradouro(dto.endereco().logradouro());
        endereco.setBairro(dto.endereco().bairro());
        endereco.setNumero(dto.endereco().numero());
        endereco.setComplemento(dto.endereco().complemeto());
        endereco.setCidade(dto.endereco().cidade());
        endereco.setEstado(dto.endereco().estado());

        Telefone telefone = funcionarioBanco.getUsuario().getTelefone();
        telefone.setCodigoArea(dto.telefone().codigoArea());
        telefone.setNumero(dto.telefone().numero());

        funcionarioBanco.setUsuario(usuarioBanco);

    }

    @Override
    @Transactional
    public void delete(Long id) {
        funcionarioRepository.deleteById(id);
    }

    @Override
    public FuncionarioResponseDTO findById(Long id) {
        return FuncionarioResponseDTO.valueOf(funcionarioRepository.findById(id));
    }

    @GET
    public List<FuncionarioResponseDTO> findAll() {
        return funcionarioRepository
                .listAll()
                .stream()
                .map(e -> FuncionarioResponseDTO.valueOf(e))
                .toList();
    }

    @Override
    public List<FuncionarioResponseDTO> findByCargo(String cargo) {
        return funcionarioRepository.findByCargo(cargo)
                .stream()
                .map(e -> FuncionarioResponseDTO.valueOf(e)).toList();

    }

    @Override
    public UsuarioResponseDTO login(String username, String senha) {
        Funcionario funcionario = funcionarioRepository.findByUsernameAndSenha(username, senha);
        return UsuarioResponseDTO.valueOf(funcionario.getUsuario());
    }

    @Override
    @Transactional
    public void AtualizarSenha(Long id, AtualizarSenhaDTO dto) {
        Funcionario funcionario = funcionarioRepository.findById(id);
        String hashSenhaAnterior = hashService.getHashSenha(dto.senhaAntiga());

        if (funcionario != null) {
            if (funcionario.getUsuario().getSenha().equals(hashSenhaAnterior)) {
                String hashNovaSenha = hashService.getHashSenha(dto.novaSenha());
                funcionario.getUsuario().setSenha(hashNovaSenha);
            } else {
                throw new ValidationException("Perai...", "A senha anterior não corresponde. Tente novamente.");
            }
        } else {
            throw new NotFoundException();
        }
    }

    @Override
    @Transactional
    public void AtualizarUsername(Long id, AtualizarUsernameDTO dto) {
        Funcionario funcionario = funcionarioRepository.findById(id);
        if (funcionario != null) {
            funcionario.getUsuario().setUsername(dto.novoUsername());
        } else {
            throw new NotFoundException();
        }
    }
}
