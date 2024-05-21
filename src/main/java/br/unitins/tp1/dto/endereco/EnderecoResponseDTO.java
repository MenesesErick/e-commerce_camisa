package br.unitins.tp1.dto.endereco;

import br.unitins.tp1.model.outros.Endereco;

public record EnderecoResponseDTO(
        String cep,
        String logradouro,
        String bairro,
        String numero,
        String complemento,
        String cidade,
        String estado) {

    public static EnderecoResponseDTO valueOf(Endereco endereco) {
        return new EnderecoResponseDTO(
                endereco.getCep(),
                endereco.getLogradouro(),
                endereco.getBairro(),
                endereco.getNumero(),
                endereco.getComplemento(),
                endereco.getCidade(),
                endereco.getEstado());
    }
}