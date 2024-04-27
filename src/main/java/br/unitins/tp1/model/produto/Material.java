package br.unitins.tp1.model.produto;

import br.unitins.tp1.model.DefaultEntity;
import jakarta.persistence.Entity;

@Entity
public class Material extends DefaultEntity {

    private String nome;
    private double porcentagem;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPorcentagem() {
        return porcentagem;
    }

    public void setPorcentagem(double porcentagem) {
        this.porcentagem = porcentagem;
    }

}
