package br.unitins.tp1.model.converterjpa;

import br.unitins.tp1.model.produto.Tamanho;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class TamanhoConverter implements AttributeConverter<Tamanho, Integer>{

    @Override
    public Integer convertToDatabaseColumn(Tamanho tamanho) {
       return tamanho.getCodigo();
    }

    @Override
    public Tamanho convertToEntityAttribute(Integer id) {
        return Tamanho.valueOf(id);
    }
    
}
