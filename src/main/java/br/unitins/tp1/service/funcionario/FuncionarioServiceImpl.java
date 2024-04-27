package br.unitins.tp1.service.funcionario;

import java.util.List;

import br.unitins.tp1.dto.funcionario.FuncionarioDTO;
import br.unitins.tp1.dto.funcionario.FuncionarioResponseDTO;
import br.unitins.tp1.model.usuario.Funcionario;
import br.unitins.tp1.repository.FuncionarioRepository;
import br.unitins.tp1.repository.UsuarioRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.GET;

@ApplicationScoped
public class FuncionarioServiceImpl implements FuncionarioService {

    @Inject
    public FuncionarioRepository funcionarioRepository;

    @Inject
    public UsuarioRepository usuarioRepository;

    @Override
    @Transactional
    public FuncionarioResponseDTO create(@Valid FuncionarioDTO dto) {
        Funcionario funcionario = new Funcionario();
        funcionario.setCargo(dto.cargo());
        funcionario.setUsuario(usuarioRepository.findById(dto.idUsuario()));

        funcionarioRepository.persist(funcionario);
        return FuncionarioResponseDTO.valueOf(funcionario);
    }

    @Override
    @Transactional
    public void update(Long id, FuncionarioDTO dto) {
        Funcionario funcionario = funcionarioRepository.findById(id);
        funcionario.setCargo(dto.cargo());
        funcionario.setUsuario(usuarioRepository.findById(dto.idUsuario()));

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
}
