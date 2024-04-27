package br.unitins.tp1.service.endereco;

import java.util.List;

import br.unitins.tp1.dto.endereco.EnderecoDTO;
import br.unitins.tp1.dto.endereco.EnderecoResponseDTO;
import br.unitins.tp1.model.outros.Endereco;
import br.unitins.tp1.repository.EnderecoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.GET;

@ApplicationScoped
public class EnderecoServiceImpl implements EnderecoService {

    @Inject
    public EnderecoRepository enderecoRepository;

    @Override
    @Transactional
    public EnderecoResponseDTO create(@Valid EnderecoDTO dto) {
        Endereco endereco = new Endereco();
        endereco.setCep(dto.cep());
        endereco.setLogradouro(dto.logradouro());
        endereco.setBairro(dto.bairro());
        endereco.setNumero(dto.numero());
        endereco.setComplemento(dto.complemeto());
        endereco.setCidade(dto.cidade());
        endereco.setEstado(dto.estado());

        enderecoRepository.persist(endereco);
        return EnderecoResponseDTO.valueOf(endereco);
    }

    @Override
    @Transactional
    public void update(Long id, EnderecoDTO dto) {
        Endereco endereco = enderecoRepository.findById(id);
        endereco.setCep(dto.cep());
        endereco.setLogradouro(dto.logradouro());
        endereco.setBairro(dto.bairro());
        endereco.setNumero(dto.numero());
        endereco.setComplemento(dto.complemeto());
        endereco.setCidade(dto.cidade());
        endereco.setEstado(dto.estado());

    }

    @Override
    @Transactional
    public void delete(Long id) {
        enderecoRepository.deleteById(id);

    }

    @Override
    public EnderecoResponseDTO findById(Long id) {
        return EnderecoResponseDTO.valueOf(enderecoRepository.findById(id));
    }

    @GET
    public List<EnderecoResponseDTO> findAll() {
        return enderecoRepository
                .listAll()
                .stream()
                .map(e -> EnderecoResponseDTO.valueOf(e))
                .toList();
    }

    @Override
    public List<EnderecoResponseDTO> findByCep(String cep) {
        return enderecoRepository.findByCep(cep)
                .stream()
                .map(e -> EnderecoResponseDTO.valueOf(e)).toList();

    }

    @Override
    public List<EnderecoResponseDTO> findByCidade(String cidade) {
        return enderecoRepository.findByCidade(cidade)
                .stream()
                .map(e -> EnderecoResponseDTO.valueOf(e)).toList();

    }

}
