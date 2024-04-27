package br.unitins.tp1.service.telefone;

import java.util.List;

import br.unitins.tp1.dto.telefone.TelefoneDTO;
import br.unitins.tp1.dto.telefone.TelefoneResponseDTO;
import jakarta.validation.Valid;

public interface TelefoneService {

    public TelefoneResponseDTO create(@Valid TelefoneDTO dto);

    public void update(Long id, TelefoneDTO dto);

    public void delete(Long id);

    public TelefoneResponseDTO findById(Long id);

    public List <TelefoneResponseDTO> findAll();

    public List<TelefoneResponseDTO> findByCodigoArea(String codigoArea);
    
    public List<TelefoneResponseDTO> findByNumero(String numero);
}
