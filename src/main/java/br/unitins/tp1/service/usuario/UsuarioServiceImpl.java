package br.unitins.tp1.service.usuario;

import java.util.List;

import br.unitins.tp1.dto.usuario.UsuarioDTO;
import br.unitins.tp1.dto.usuario.UsuarioResponseDTO;
import br.unitins.tp1.model.usuario.Sexo;
import br.unitins.tp1.model.usuario.Usuario;
import br.unitins.tp1.repository.EnderecoRepository;
import br.unitins.tp1.repository.TelefoneRepository;
import br.unitins.tp1.repository.UsuarioRepository;
import br.unitins.tp1.validation.ValidationException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.GET;

@ApplicationScoped
public class UsuarioServiceImpl implements UsuarioService {

    @Inject
    public UsuarioRepository usuarioRepository;

    @Inject
    public EnderecoRepository enderecoRepository;

    @Inject
    public TelefoneRepository telefoneRepository;

    @Override
    @Transactional
    public UsuarioResponseDTO create(@Valid UsuarioDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setNome(dto.nome());
        usuario.setGmail(dto.gmail());
        usuario.setSenha(dto.senha());
        usuario.setSexo(Sexo.valueOf((dto.idSexo())));
        usuario.setTelefone(telefoneRepository.findById(dto.idTelefone()));
        usuario.setEndereco(enderecoRepository.findById(dto.idEndereco()));

        usuarioRepository.persist(usuario);
        return UsuarioResponseDTO.valueOf(usuario);
    }

        public void validarGmail(String gmail) {
        Usuario usuario = usuarioRepository.findByGmail(gmail);
        if (usuario != null)
            throw  new ValidationException ("gmail", "O gmail '"+gmail+"' já existe.");
    }

    @Override
    @Transactional
    public void update(Long id, UsuarioDTO dto) {
        Usuario usuario = usuarioRepository.findById(id);
        usuario.setNome(dto.nome());
        usuario.setGmail(dto.gmail());
        usuario.setSenha(dto.senha());
        usuario.setSexo(Sexo.valueOf((dto.idSexo())));
        usuario.setTelefone(telefoneRepository.findById(dto.idTelefone()));
        usuario.setEndereco(enderecoRepository.findById(dto.idEndereco()));

    }

    @Override
    @Transactional
    public void delete(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public UsuarioResponseDTO findById(Long id) {
        return UsuarioResponseDTO.valueOf(usuarioRepository.findById(id));
    }

    @GET
    public List<UsuarioResponseDTO> findAll() {
        return usuarioRepository.listAll()
                .stream()
                .map(e -> UsuarioResponseDTO.valueOf(e))
                .toList();
    }

    @Override
    public List<UsuarioResponseDTO> findByNome(String nome) {
        return usuarioRepository.findByNome(nome)
                .stream()
                .map(e -> UsuarioResponseDTO.valueOf(e)).toList();

    }

}
