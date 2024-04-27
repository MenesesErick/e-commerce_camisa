package br.unitins.tp1.model.produto;

import br.unitins.tp1.model.DefaultEntity;
import jakarta.persistence.Entity;

@Entity
public class Estilo extends DefaultEntity {
    private String nome;
    private String descricao;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
