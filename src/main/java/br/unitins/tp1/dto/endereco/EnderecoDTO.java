package br.unitins.tp1.dto.endereco;

import br.unitins.tp1.model.outros.Endereco;

public record EnderecoDTO(

        String cep,
        String logradouro,
        String bairro,
        String numero,
        String complemeto,
        String cidade,
        String estado) {
    public static Endereco convertToEndereco(EnderecoDTO dto) {
        Endereco endereco = new Endereco();

        endereco.setCep(dto.cep);
        endereco.setLogradouro(dto.logradouro);
        endereco.setBairro(dto.bairro);
        endereco.setNumero(dto.numero);
        endereco.setComplemento(dto.complemeto);
        endereco.setCidade(dto.cidade);
        endereco.setEstado(dto.estado);

        return endereco;

    }

}
