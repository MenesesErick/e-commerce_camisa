package br.unitins.tp1.service;

import java.io.File;

public interface FileService {
    void salvar(Long id, String nomeImagem, byte[] imagem);
    File download (String nomeImagem);
}