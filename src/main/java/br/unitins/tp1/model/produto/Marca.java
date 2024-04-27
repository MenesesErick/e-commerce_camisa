package br.unitins.tp1.model.produto;

import br.unitins.tp1.model.DefaultEntity;
import jakarta.persistence.Entity;

@Entity
public class Marca extends DefaultEntity {

    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
