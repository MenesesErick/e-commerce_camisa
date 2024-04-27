package br.unitins.tp1.repository;

import java.util.List;

import br.unitins.tp1.model.produto.Estilo;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EstiloRepository implements PanacheRepository<Estilo> {

    public List<Estilo> findByNome(String nome) {
        return find("UPPER(nome) LIKE ?1", "%" + nome.toUpperCase() + "%").list();
    }

    public Estilo findByNomeCompleto(String nome) {
        return find("UPPER(nome) = ?1",  nome.toUpperCase() ).firstResult();
    }

}
