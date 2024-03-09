package br.unitins.tp1.repository;

import java.util.List;

import br.unitins.tp1.model.Administrador;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AdministradorRepository implements PanacheRepository<Administrador> {

    public List<Administrador>  findByNome(String nomeAdm){
        return find("UPPER(nomeAdm) LIKE ?1", "%" + nomeAdm.toUpperCase() + "%").list();
    }

    public List<Administrador>  findByGmail(String gmail){
        return find("UPPER(gmail) LIKE ?1", "%" + gmail.toUpperCase() + "%").list();
    }

    public List<Administrador>  findBySenha(String senha){
        return find("UPPER(senha) LIKE ?1", "%" + senha.toUpperCase() + "%").list();
    }
    
}
