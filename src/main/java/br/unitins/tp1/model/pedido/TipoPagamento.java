package br.unitins.tp1.model.pedido;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TipoPagamento {

    DEBITO(1, "Débito"),
    CREDITO(2, "Crédito"),
    PIX(3, "Pix");

    private Integer id;
    private String nome;

    private TipoPagamento(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public static TipoPagamento valueOf(Integer id) throws IllegalArgumentException {
        for (TipoPagamento pagamento : TipoPagamento.values()) {
            if (pagamento.id == id)
                return pagamento;
        }
        throw new IllegalArgumentException("id tipoPagamento inválido.");
    }
}
