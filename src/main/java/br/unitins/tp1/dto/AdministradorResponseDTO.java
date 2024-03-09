package br.unitins.tp1.dto;

import br.unitins.tp1.model.Administrador;

public record AdministradorResponseDTO(
        Long id,
        String nomeAdm,
        String gmail,
        String senha

) {

    public static AdministradorResponseDTO valueOf(Administrador adm) {

        return new AdministradorResponseDTO(
            adm.getId(),
            adm.getNomeAdm(),
            adm.getGmail(),
            adm.getSenha());

    }

}
