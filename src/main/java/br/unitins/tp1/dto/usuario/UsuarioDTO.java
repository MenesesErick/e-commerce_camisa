package br.unitins.tp1.dto.usuario;

public record UsuarioDTO(
    String nome, 
    String gmail,  
    String senha,
    Integer idSexo,
    Long idEndereco,
    Long  idTelefone) 
    
{
    
}
