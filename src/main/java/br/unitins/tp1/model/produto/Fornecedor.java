package br.unitins.tp1.model.produto;

import br.unitins.tp1.model.DefaultEntity;
import br.unitins.tp1.model.outros.Telefone;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Fornecedor extends DefaultEntity {

    private String nome;
    private String gmail;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_telefone")
    private Telefone telefone;

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

}
