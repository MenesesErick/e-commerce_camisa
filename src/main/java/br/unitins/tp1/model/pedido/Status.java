package br.unitins.tp1.model.pedido;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Status {
    PENDENTE(1, "Pendente"),
    PAGO(2, "Pago");

    private int id;
    private String nome;

    Status(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public static Status valueOf(Integer id) throws IllegalArgumentException {
        for (Status status : Status.values()) {
            if (status.id == id)
                return status;
        }
        throw new IllegalArgumentException("id inválido.");
    }


}
