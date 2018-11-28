package br.com.etecmam.suaaplicacaotcc;

import java.io.Serializable;
import java.util.List;

public class ListaDePerguntas implements Serializable {

    private List<Pergunta> perguntas;

    public ListaDePerguntas(List<Pergunta> perguntas) {
        this.perguntas = perguntas;
    }

    public List<Pergunta> getPerguntas() {
        return perguntas;
    }

    public void setPerguntas(List<Pergunta> perguntas) {
        this.perguntas = perguntas;
    }
}
