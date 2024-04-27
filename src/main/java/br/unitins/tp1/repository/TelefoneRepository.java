package br.unitins.tp1.repository;

import java.util.List;

import br.unitins.tp1.model.outros.Telefone;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TelefoneRepository implements PanacheRepository<Telefone> {
    public List<Telefone> findByCodigoArea(String codigoArea) {
        return find("UPPER(codigoArea) LIKE ?1", "%" + codigoArea.toUpperCase() + "%").list();
    }

    public List<Telefone> findByNumero(String numero) {
        return find("UPPER(numero) LIKE ?1", "%" + numero.toUpperCase() + "%").list();
    }
}
