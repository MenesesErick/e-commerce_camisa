package br.unitins.tp1.model;

public enum Material {
    
    DRYFIT (1, "DryFit"),
    POLIESTER (2, "Poliester"),
    ALGODAO (3, "Algodão"),
    CETIM (4, "Cetim");

    private int codigo;
    private String descricao;
    
    private Material(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public static Material valueOf(int opcao){
        for (Material material : Material.values()) {
            if (material.getCodigo() == opcao) {
                return material;
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
