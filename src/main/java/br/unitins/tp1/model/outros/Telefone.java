package br.unitins.tp1.model.outros;

import br.unitins.tp1.model.DefaultEntity;
import jakarta.persistence.Entity;

@Entity
public class Telefone extends DefaultEntity{
    
    private String codigoArea;
    private String numero;

    public String getCodigoArea() {
        return codigoArea;
    }
    public void setCodigoArea(String codigoArea) {
        this.codigoArea = codigoArea;
    }
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }

}
