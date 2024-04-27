package br.unitins.tp1.repository;

import java.util.List;

import br.unitins.tp1.model.usuario.Cliente;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ClienteRepository implements PanacheRepository<Cliente> {

    public List<Cliente> findByCpf(String cpf) {
        return find("UPPER(cpf) LIKE ?1", "%" + cpf.toUpperCase() + "%").list();
    }

    public Cliente findByCpfIgual(String cpfIgual) {
        return find("UPPER(cpfIgual) = ?1", cpfIgual.toUpperCase()).firstResult();
    }

}
