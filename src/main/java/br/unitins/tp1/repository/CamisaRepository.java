package br.unitins.tp1.repository;

import java.util.List;

import br.unitins.tp1.model.produto.Camisa;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CamisaRepository implements PanacheRepository<Camisa> {

    public List<Camisa> findByNome(String nome) {
        return find("UPPER(nome) LIKE ?1", "%" + nome.toUpperCase() + "%").list();
    }

    public List<Camisa> findByDescricao(String descricao) {
        return find("UPPER(descricao) LIKE ?1", "%" + descricao.toUpperCase() + "%").list();
    }

        public Camisa findByNomeCompleto(String nome) {
        return find("UPPER(nome) = ?1",  nome.toUpperCase() ).firstResult();
    }

}
