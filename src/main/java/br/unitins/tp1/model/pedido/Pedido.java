package br.unitins.tp1.model.pedido;

import java.time.LocalDateTime;
import java.util.List;

import br.unitins.tp1.model.DefaultEntity;
import br.unitins.tp1.model.usuario.Cliente;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Pedido extends DefaultEntity {

    private LocalDateTime data;
    private Double total;
    private Double desconto;

    @Column(nullable = false)
    private TipoPagamento tipoPagamento;

    
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_pedido")
    private List<ItemPedido> itens;
    
    
    
    public LocalDateTime getData() {
        return data;
    }
    
    public void setData(LocalDateTime data) {
        this.data = data;
    }
    
    public Double getTotal() {
        return total;
    }
    
    public void setTotal(Double total) {
        this.total = total;
    }
    
    public Cliente getCliente() {
        return cliente;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }
    
    public Double getDesconto() {
        return desconto;
    }
    
    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }
    
    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }
    
    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }
}
