package br.unitins.tp1.repository;

import java.util.List;

import br.unitins.tp1.model.produto.Fornecedor;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FornecedorRepository implements PanacheRepository<Fornecedor> {

    public List<Fornecedor> findByNome(String nome) {
        return find("UPPER(nome) LIKE ?1", "%" + nome.toUpperCase() + "%").list();
    }

    public Fornecedor findByNomeCompleto(String nome) {
        return find("UPPER(nome) = ?1", nome.toUpperCase()).firstResult();
    }

}
