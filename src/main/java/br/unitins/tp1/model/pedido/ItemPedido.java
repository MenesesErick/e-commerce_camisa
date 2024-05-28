package br.unitins.tp1.model.pedido;

import br.unitins.tp1.model.DefaultEntity;
import br.unitins.tp1.model.produto.Camisa;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ItemPedido extends DefaultEntity { 
    private Integer quantidade;

    @ManyToOne
    @JoinColumn(name = "id_camisa")
    private Camisa camisa;

  
    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Camisa getCamisa() {
        return camisa;
    }

    public void setCamisa(Camisa camisa) {
        this.camisa = camisa;
    }
}
