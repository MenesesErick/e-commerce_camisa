package br.unitins.tp1.repository;

import java.util.List;

import br.unitins.tp1.model.pedido.Pedido;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PedidoRepository implements PanacheRepository<Pedido>{

    public List<Pedido> findByCliente(Long clienteId) {
        return find("upper(CAST(cliente.id AS string)) = ?1", clienteId.toString().toUpperCase()).list();
    
    }
}
