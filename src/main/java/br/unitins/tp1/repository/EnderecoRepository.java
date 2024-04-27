package br.unitins.tp1.repository;


import java.util.List;

import br.unitins.tp1.model.outros.Endereco;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EnderecoRepository implements PanacheRepository<Endereco> {

    public List<Endereco> findByCep(String cep) {
        return find("UPPER(cep) LIKE ?1", "%" + cep.toUpperCase() + "%").list();
    }

    public List<Endereco> findByCidade(String cidade) {
        return find("UPPER(cidade) LIKE ?1", "%" + cidade.toUpperCase() + "%").list();
    }
    
}
