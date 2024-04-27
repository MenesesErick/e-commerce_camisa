package br.unitins.tp1.repository;

import java.util.List;

import br.unitins.tp1.model.produto.Material;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MaterialRepository implements PanacheRepository<Material> {

    public List<Material> findByNome(String nome) {
        return find("UPPER(nome) LIKE ?1", "%" + nome.toUpperCase() + "%").list();
    }

    public Material findByPorcentagem(double porcentagem) {
        return find("porcentagem = ?1", porcentagem).firstResult();
    }

}
