package br.unitins.tp1.model.converterjpa;

import br.unitins.tp1.model.pedido.TipoPagamento;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class TipoPagamentoConverter implements AttributeConverter<TipoPagamento, Integer> {
    @Override
    public Integer convertToDatabaseColumn(TipoPagamento pagamento) {
        return pagamento.getId();
    }

    @Override
    public TipoPagamento convertToEntityAttribute(Integer id) {
        return TipoPagamento.valueOf(id);
    }
}
