package br.unitins.tp1.model.converterjpa;

import br.unitins.tp1.model.pedido.ChavePix;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class ChavePixConverter implements AttributeConverter<ChavePix, Integer>{
    @Override
    public Integer convertToDatabaseColumn(ChavePix chavePix) {
        return chavePix.getId();
    }

    @Override
    public ChavePix convertToEntityAttribute(Integer id) {
        return ChavePix.valueOf(id);
    }
}
