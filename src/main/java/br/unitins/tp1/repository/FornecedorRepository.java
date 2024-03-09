package br.unitins.tp1.repository;

import java.util.List;

import br.unitins.tp1.model.Camisa;
import br.unitins.tp1.model.Fornecedor;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FornecedorRepository implements PanacheRepository<Fornecedor>{

    public List<Fornecedor> findByNomeFornecedor(String nomeFornecedor){
        return find("UPPER(nome) LIKE ?1", "%" + nomeFornecedor.toUpperCase() + "%").list() ;
    }

    public List<Fornecedor> findByGmailFornecedor(String gmailFornecedor){
        return find("UPPER(gmail) LIKE ?1", "%" + gmailFornecedor.toUpperCase() + "%").list() ;
    }
    
    public List <Fornecedor> findByCamisa(Camisa camisa){
        return find("camisa = ?1", camisa).list();
        
    }
}
