package br.unitins.tp1.model;

public enum Tamanho {

    P (1,  "Pequeno"),
    M (2, "Médio"),
    G (3, "Grande"),
    GG (4, "Extra Grande");
 
    private int codigo;
    private String descricao;

    public static Tamanho valueOf(int opcao){
        for (Tamanho tamanho : Tamanho.values()) {
            if (tamanho.getCodigo() == opcao) {
                return tamanho;
            }
        }
        return null;
            
    }

    
    private Tamanho(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
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
