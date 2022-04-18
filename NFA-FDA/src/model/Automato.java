package model;

import java.util.ArrayList;

public class Automato {
    private ArrayList<Estado> estados = new ArrayList<Estado>();
    private ArrayList<Transicao> transicoes = new ArrayList<Transicao>();

    
    public Automato() {
    }

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

    public ArrayList<Estado> getEstados() {
        return estados;
    }

    public ArrayList<Transicao> getTransicoes() {
        return transicoes;
    }

    @Override
    public String toString() {
        return "Automato [estados=" + estados + ", transicoes=" + transicoes + "]";
    }




}
