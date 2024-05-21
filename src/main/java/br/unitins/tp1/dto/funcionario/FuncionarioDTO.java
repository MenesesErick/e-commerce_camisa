package br.unitins.tp1.dto.funcionario;

import br.unitins.tp1.dto.endereco.EnderecoDTO;
import br.unitins.tp1.dto.telefone.TelefoneDTO;

public record FuncionarioDTO(
        String cargo,
        String nome,
        String username,
        String gmail,
        String senha,
        Integer idSexo,
        EnderecoDTO endereco,
        TelefoneDTO telefone

) {

}
