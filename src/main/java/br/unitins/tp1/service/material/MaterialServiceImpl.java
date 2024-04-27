package br.unitins.tp1.service.material;

import java.util.List;

import br.unitins.tp1.dto.material.MaterialDTO;
import br.unitins.tp1.dto.material.MaterialResponseDTO;
import br.unitins.tp1.model.produto.Material;
import br.unitins.tp1.repository.MaterialRepository;
import br.unitins.tp1.validation.ValidationException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.GET;

@ApplicationScoped
public class MaterialServiceImpl implements MaterialService {

    @Inject
    public MaterialRepository materialRepository;

    @Override
    @Transactional
    public MaterialResponseDTO create(@Valid MaterialDTO dto) {
        Material material = new Material();
        material.setNome(dto.nome());
        material.setPorcentagem(dto.porcentagem());

        materialRepository.persist(material);
        return MaterialResponseDTO.valueOf(material);

    }

    public void validarPorcentagem(double porcentagem) {
        Material material = materialRepository.findByPorcentagem(porcentagem);
        if (material != null && porcentagem > 100) {
            throw new ValidationException("porcentagem", "A porcentagem está errada, é maior que 100 :)");        }
    }

    @Override
    @Transactional
    public void update(Long id, MaterialDTO dto) {
        Material material = materialRepository.findById(id);
        material.setNome(dto.nome());
        material.setPorcentagem(dto.porcentagem());
    }

    @Override
    @Transactional
    public void delete(Long id) {
        materialRepository.deleteById(id);
    }

    @Override
    public MaterialResponseDTO findById(Long id) {
        return MaterialResponseDTO.valueOf(materialRepository.findById(id));
    }

    @GET
    public List<MaterialResponseDTO> findAll() {
        return materialRepository
                .listAll()
                .stream()
                .map(e -> MaterialResponseDTO.valueOf(e))
                .toList();
    }

    @Override
    public List<MaterialResponseDTO> findByNome(String nome) {
        return materialRepository.findByNome(nome)
                .stream()
                .map(e -> MaterialResponseDTO.valueOf(e)).toList();

    }
}
