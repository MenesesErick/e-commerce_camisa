package br.unitins.tp1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Promocao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200, nullable = false)
    private String nomePromocao;

    @Column()
    private double porcentualDesconto;

    @Column(length = 200, nullable = false)
    private String descricaoDesconto;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomePromocao() {
        return nomePromocao;
    }

    public void setNomePromocao(String nomePromocao) {
        this.nomePromocao = nomePromocao;
    }

    public double getPorcentualDesconto() {
        return porcentualDesconto;
    }

    public void setPorcentualDesconto(double porcentualDesconto) {
        this.porcentualDesconto = porcentualDesconto;
    }

    public String getDescricaoDesconto() {
        return descricaoDesconto;
    }

    public void setDescricaoDesconto(String descricaoDesconto) {
        this.descricaoDesconto = descricaoDesconto;
    }
}
