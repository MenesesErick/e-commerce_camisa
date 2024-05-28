package br.unitins.tp1.model.pedido;

public enum ChavePix {
    CPF(1, "CPF"),
    CNPJ(2, "CNPJ"),
    EMAIL(3, "email"),
    CELULAR(4, "celular"),
    ALEATORIO(5, "aleatorio");

    private final Integer id;
    private final String nome;

    ChavePix(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public static ChavePix valueOf(Integer id) throws IllegalArgumentException {
        if (id == null)
            return null;
        for (ChavePix tipoDeChavePix : ChavePix.values()) {
            if (tipoDeChavePix.getId().equals(id))
                return tipoDeChavePix;
        }

        throw new IllegalArgumentException("Id inválida" + id);
    }
    
}
