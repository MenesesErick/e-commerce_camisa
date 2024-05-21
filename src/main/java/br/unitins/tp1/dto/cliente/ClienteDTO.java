package br.unitins.tp1.dto.cliente;

import br.unitins.tp1.dto.endereco.EnderecoDTO;
import br.unitins.tp1.dto.telefone.TelefoneDTO;

public record ClienteDTO(
    String cpf,
    String nome,
    String username,
    String gmail,
    String senha,
    Integer idSexo,
    EnderecoDTO endereco,
    TelefoneDTO telefone) {

}
