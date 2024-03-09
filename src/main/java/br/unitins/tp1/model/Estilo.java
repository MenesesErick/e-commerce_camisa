package br.unitins.tp1.model;

public enum Estilo {

    OVERSIZED (1, "Oversized"),
    ESPORTIVA (2, "Esportiva"),
    BASICA (3, "Basica"),
    POLO  (4, "Polo");

    private int  codigo;
    private String descricao;

    private Estilo(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public static Estilo valueOf(int opcao){
        for (Estilo estilo : Estilo.values()) {
            if (estilo .getCodigo() == opcao) {
                return estilo;
            }
        }
        return null;
            
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
}
