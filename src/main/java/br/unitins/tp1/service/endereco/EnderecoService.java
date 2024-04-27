package br.unitins.tp1.service.endereco;

import java.util.List;

import br.unitins.tp1.dto.endereco.EnderecoDTO;
import br.unitins.tp1.dto.endereco.EnderecoResponseDTO;
import jakarta.validation.Valid;

public interface EnderecoService  {

    public EnderecoResponseDTO create(@Valid EnderecoDTO dto);

    public void update(Long id, EnderecoDTO dto);

    public void delete(Long id);

    public EnderecoResponseDTO findById(Long id);

    public List<EnderecoResponseDTO> findAll();

    public List<EnderecoResponseDTO> findByCep(String cep);

    public List<EnderecoResponseDTO> findByCidade(String cidade);
    
}
