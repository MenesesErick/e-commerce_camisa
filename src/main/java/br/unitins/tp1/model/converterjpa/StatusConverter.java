package br.unitins.tp1.model.converterjpa;

import br.unitins.tp1.model.pedido.Status;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class StatusConverter implements AttributeConverter<Status, Integer>{
    @Override
    public Integer convertToDatabaseColumn(Status status) {
       return status.getId();
    }

    @Override
    public Status convertToEntityAttribute(Integer id) {
        return Status.valueOf(id);
    }
    
}
