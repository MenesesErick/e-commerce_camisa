package br.unitins.tp1.service.fornecedor;

import java.util.List;

import br.unitins.tp1.dto.fornecedor.FornecedorDTO;
import br.unitins.tp1.dto.fornecedor.FornecedorResponseDTO;
import br.unitins.tp1.model.produto.Fornecedor;
import br.unitins.tp1.repository.FornecedorRepository;
import br.unitins.tp1.repository.TelefoneRepository;
import br.unitins.tp1.validation.ValidationException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.GET;

@ApplicationScoped
public class FornecedorServiceImpl implements FornecedorService {

    @Inject
    public FornecedorRepository fornecedorRepository;

    @Inject
    public TelefoneRepository telefoneRepository;

    @Override
    @Transactional
    public FornecedorResponseDTO create(@Valid FornecedorDTO dto) {
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setNome(dto.nome());
        fornecedor.setGmail(dto.gmail());
        fornecedor.setTelefone(telefoneRepository.findById(dto.idTelefone()));

        fornecedorRepository.persist(fornecedor);
        return FornecedorResponseDTO.valueOf(fornecedor);
    }

    public void validarNomeFornecedor(String nome) {
        Fornecedor fornecedor = fornecedorRepository.findByNomeCompleto(nome);
        if (fornecedor != null)
            throw new ValidationException("nome", "O nome '" + nome + "' já existe.");
    }

    @Override
    @Transactional
    public void update(Long id, FornecedorDTO dto) {
        Fornecedor fornecedor = fornecedorRepository.findById(id);
        fornecedor.setNome(dto.nome());
        fornecedor.setGmail(dto.gmail());
        fornecedor.setTelefone(telefoneRepository.findById(dto.idTelefone()));

    }

    @Override
    @Transactional
    public void delete(Long id) {
        fornecedorRepository.deleteById(id);
    }

    @Override
    public FornecedorResponseDTO findById(Long id) {
        return FornecedorResponseDTO.valueOf(fornecedorRepository.findById(id));
    }

    @GET
    public List<FornecedorResponseDTO> findAll() {
        return fornecedorRepository
                .listAll()
                .stream()
                .map(e -> FornecedorResponseDTO.valueOf(e))
                .toList();
    }

    @Override
    public List<FornecedorResponseDTO> findByNome(String nome) {
        return fornecedorRepository.findByNome(nome)
                .stream()
                .map(e -> FornecedorResponseDTO.valueOf(e))
                .toList();
    }
}
