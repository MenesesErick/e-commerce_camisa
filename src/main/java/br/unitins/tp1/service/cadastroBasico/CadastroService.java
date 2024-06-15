package br.unitins.tp1.service.cadastroBasico;

import br.unitins.tp1.dto.cadastro.CadastroDTO;
import br.unitins.tp1.dto.cadastro.CadastroResponseDTO;
import jakarta.validation.Valid;

public interface CadastroService {
    public CadastroResponseDTO create(@Valid CadastroDTO dto);
}
