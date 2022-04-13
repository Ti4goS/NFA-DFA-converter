package model;

import java.util.ArrayList;

public class Automato {
    private ArrayList<Estado> estados = new ArrayList<Estado>();
    private ArrayList<Transicao> transicoes = new ArrayList<Transicao>();

    Automato(Estado estado, Transicao transicao){
        this.estados.add(estado);
        this.transicoes.add(transicao);
    }

    public void addEstado(Estado estado) {
        this.estados.add(estado);  
    }

    public void addTransicao(Transicao transicao) {
        this.transicoes.add(transicao);
    }


}
