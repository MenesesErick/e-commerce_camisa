package br.unitins.tp1.dto.camisa;

import java.util.List;

import br.unitins.tp1.dto.estilo.EstiloResponseDTO;
import br.unitins.tp1.dto.fornecedor.FornecedorResponseDTO;
import br.unitins.tp1.dto.marca.MarcaResponseDTO;
import br.unitins.tp1.dto.material.MaterialResponseDTO;
import br.unitins.tp1.model.produto.Camisa;
import br.unitins.tp1.model.produto.Tamanho;

public record CamisaResponseDTO(
        Long id,
        String nome,
        String descricao,
        String cor,
        double preco,
        Integer largura,
        Integer comprimento,
        Integer estoque,
        Tamanho Tamanho,
        FornecedorResponseDTO fornecedor,
        EstiloResponseDTO fstilo,
        MarcaResponseDTO marca,
        List <MaterialResponseDTO> listaMaterial) {

    public static CamisaResponseDTO valueOf(Camisa camisa) {
        return new CamisaResponseDTO(
                camisa.getId(),
                camisa.getNome(),
                camisa.getDescricao(),
                camisa.getCor(),
                camisa.getPreco(),
                camisa.getLargura(),
                camisa.getComprimento(),
                camisa.getEstoque(),
                camisa.getTamanho(),
                FornecedorResponseDTO.valueOf(camisa.getFornecedor()),
                EstiloResponseDTO.valueOf(camisa.getEstilo()),
                MarcaResponseDTO.valueOf(camisa.getMarca()),
                camisa.getListaMaterial().stream().map(r -> MaterialResponseDTO.valueOf(r)).toList()); 
    }

}
