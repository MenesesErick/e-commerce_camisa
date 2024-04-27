package br.unitins.tp1.repository;

import java.util.List;

import br.unitins.tp1.model.usuario.Usuario;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UsuarioRepository implements PanacheRepository<Usuario> {

    public List<Usuario> findByNome(String nome) {
        return find("UPPER(nome) LIKE ?1", "%" + nome.toUpperCase() + "%").list();
    }

        public Usuario findByGmail(String gmail) {
        return find("UPPER(gmail) = ?1",  gmail.toUpperCase() ).firstResult();
    }

}
