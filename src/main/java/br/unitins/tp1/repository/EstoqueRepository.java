package br.unitins.tp1.repository;

import java.util.List;

import br.unitins.tp1.model.Camisa;
import br.unitins.tp1.model.Estoque;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class EstoqueRepository implements PanacheRepository<Estoque> {

    public List <Estoque> findByQuantidade (int quantidade){
        return find("quantidade = ?1", quantidade).list();

    }


    public List <Estoque> findByCamisa(Camisa camisa){
        return find("camisa = ?1", camisa).list();
        
    }
}
    

