package br.unitins.tp1.service.cadastroBasico;

import br.unitins.tp1.dto.cadastro.CadastroDTO;
import br.unitins.tp1.dto.cadastro.CadastroResponseDTO;
import br.unitins.tp1.model.usuario.Cliente;
import br.unitins.tp1.model.usuario.Sexo;
import br.unitins.tp1.model.usuario.Usuario;
import br.unitins.tp1.repository.ClienteRepository;
import br.unitins.tp1.repository.UsuarioRepository;
import br.unitins.tp1.service.HashService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@ApplicationScoped
public class CadastroServiceImpl implements CadastroService {

    @Inject
    ClienteRepository clienteRepository;
    @Inject
    UsuarioRepository repository;
    @Inject
    HashService hashService;

    @Override
    @Transactional
    public CadastroResponseDTO create(@Valid CadastroDTO dto) {
        Cliente cliente = new Cliente();
        Usuario usuario = new Usuario();
        usuario.setNome(dto.nome());
        usuario.setUsername(dto.username());
        usuario.setSenha(hashService.getHashSenha(dto.senha()));
        usuario.setSexo(Sexo.valueOf(dto.idSexo()));

        cliente.setUsuario(usuario);
        cliente.setCpf(null);

        repository.persist(usuario);
        clienteRepository.persist(cliente);

        return CadastroResponseDTO.valueOf(usuario);
    }

}
