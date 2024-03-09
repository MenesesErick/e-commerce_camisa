package br.unitins.tp1.repository;

import java.util.List;
import br.unitins.tp1.model.Camisa;
import br.unitins.tp1.model.Estilo;
import br.unitins.tp1.model.Material;
import br.unitins.tp1.model.Tamanho;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CamisaRepository implements PanacheRepository<Camisa> {

    public List<Camisa> findByNome(String nomeCamisa) {
        return find("UPPER(nome) LIKE ?1", "%" + nomeCamisa.toUpperCase() + "%").list();
    }

    public List<Camisa> findByMarca(String marca) {
        return find("UPPER(nome) LIKE ?1", "%" + marca.toUpperCase() + "%").list();
    }

    public List<Camisa> findByDescricao(String descricao) {
        return find("UPPER(nome) LIKE ?1", "%" + descricao.toUpperCase() + "%").list();
    }

    public List<Camisa> findByCor(String cor) {
        return find("UPPER(nome) LIKE ?1", "%" + cor.toUpperCase() + "%").list();
    }

    public List<Camisa> findByPreco(double preco) {
        return find("preco = ?1", preco).list();

    }

    public List<Camisa> findByMaterial(Material material) {
        return find("material = ?1", material).list();
    }

        public List<Camisa> findByTamanho(Tamanho tamanho) {
        return find("tamanho = ?1", tamanho).list();
    }

    public List<Camisa> findByEstilo(Estilo estilo) {
        return find("estilo = ?1", estilo).list();
    }

}
