package br.com.etecmam.suaaplicacaotcc;

import java.io.Serializable;

public class ItemMenu implements Serializable {
    int id;
    String imagem;
    String titulo;
    String tipo = "TEXTO";

    public ItemMenu(int id, String imagem, String titulo) {
        this.id = id;
        this.imagem = imagem;
        this.titulo = titulo;
    }

    public String getImagem() {
        return imagem;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
