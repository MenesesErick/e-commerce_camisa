package br.unitins.tp1.service;

public interface HashService {

    String getHashSenha(String senha);

    boolean verificar(String senha, String hash);

}
