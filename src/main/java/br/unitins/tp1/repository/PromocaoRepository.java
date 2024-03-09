package br.unitins.tp1.repository;

import java.util.List;

import br.unitins.tp1.model.Promocao;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PromocaoRepository implements PanacheRepository<Promocao> {

    public List<Promocao> findByNome(String nomePromocao){
        return find("UPPER(cupomNome) LIKE ?1", "%" + nomePromocao.toUpperCase() + "%").list();
    }

    public List<Promocao> findByDescricao(String descricao){
        return find("UPPER(descricao) LIKE ?1", "%" + descricao.toUpperCase() + "%").list();
    }

    public List<Promocao> findByPorcentual(double porcentual){
        return find("porcentual = ?1", porcentual).list() ;
    }

    
}