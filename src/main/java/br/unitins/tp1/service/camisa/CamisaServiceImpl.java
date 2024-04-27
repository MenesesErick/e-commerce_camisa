package br.unitins.tp1.service.camisa;

import java.util.List;

import br.unitins.tp1.dto.camisa.CamisaDTO;
import br.unitins.tp1.dto.camisa.CamisaResponseDTO;
import br.unitins.tp1.model.produto.Camisa;
import br.unitins.tp1.model.produto.Tamanho;
import br.unitins.tp1.repository.CamisaRepository;
import br.unitins.tp1.repository.EstiloRepository;
import br.unitins.tp1.repository.FornecedorRepository;
import br.unitins.tp1.repository.MarcaRepository;
import br.unitins.tp1.repository.MaterialRepository;
import br.unitins.tp1.validation.ValidationException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.GET;

@ApplicationScoped
public class CamisaServiceImpl implements CamisaService {

    @Inject
    public CamisaRepository camisaRepository;

    @Inject
    public FornecedorRepository fornecedorRepository;

    @Inject
    public EstiloRepository estiloRepository;

    @Inject
    public MarcaRepository marcaRepository;

    @Inject
    public MaterialRepository materialRepository;

    @Override
    @Transactional
    public CamisaResponseDTO create(@Valid CamisaDTO dto) {
        Camisa camisa = new Camisa();
        camisa.setNome(dto.nome());
        camisa.setDescricao(dto.descricao());
        camisa.setCor(dto.cor());
        camisa.setPreco(dto.preco());
        camisa.setLargura(dto.largura());
        camisa.setComprimento(dto.comprimento());
        camisa.setEstoque(dto.estoque());
        camisa.setTamanho(Tamanho.valueOf(dto.idTamanho()));
        camisa.setFornecedor(fornecedorRepository.findById(dto.idFornecedor()));
        camisa.setEstilo(estiloRepository.findById(dto.idEstilo()));
        camisa.setMarca(marcaRepository.findById(dto.idMarca()));
        camisa.setListaMaterial(dto.listaMaterial().stream().map(e -> materialRepository.findById(e)).toList());

        camisaRepository.persist(camisa);
        return CamisaResponseDTO.valueOf(camisa);

    }

    public void validarNomeCamisa(String nome) {
        Camisa camisa = camisaRepository.findByNomeCompleto(nome);
        if (camisa != null)
            throw new ValidationException("nome", "O nome '" + nome + "' já existe.");
    }

    @Override
    @Transactional
    public void update(Long id, CamisaDTO dto) {
        Camisa camisa = camisaRepository.findById(id);
        camisa.setNome(dto.nome());
        camisa.setDescricao(dto.descricao());
        camisa.setCor(dto.cor());
        camisa.setPreco(dto.preco());
        camisa.setLargura(dto.largura());
        camisa.setComprimento(dto.comprimento());
        camisa.setEstoque(dto.estoque());
        camisa.setTamanho(Tamanho.valueOf(dto.idTamanho()));
        camisa.setFornecedor(fornecedorRepository.findById(dto.idFornecedor()));
        camisa.setEstilo(estiloRepository.findById(dto.idEstilo()));
        camisa.setMarca(marcaRepository.findById(dto.idMarca()));
        camisa.setListaMaterial(dto.listaMaterial().stream().map(e -> materialRepository.findById(e)).toList());

    }

    @Override
    @Transactional
    public void delete(Long id) {
        camisaRepository.deleteById(id);
    }

    @Override
    public CamisaResponseDTO findById(Long id) {
        return CamisaResponseDTO.valueOf(camisaRepository.findById(id));
    }

    @GET
    public List<CamisaResponseDTO> findAll() {
        return camisaRepository
                .listAll()
                .stream()
                .map(e -> CamisaResponseDTO.valueOf(e))
                .toList();
    }

    @Override
    public List<CamisaResponseDTO> findByNome(String nome) {
        return camisaRepository.findByNome(nome)
                .stream()
                .map(e -> CamisaResponseDTO.valueOf(e)).toList();

    }

    @Override
    public List<CamisaResponseDTO> findByDescricao(String descricao) {
        return camisaRepository.findByDescricao(descricao)
                .stream()
                .map(e -> CamisaResponseDTO.valueOf(e)).toList();

    }

}
