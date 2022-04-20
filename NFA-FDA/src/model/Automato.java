package model;

import java.util.ArrayList;

public class Automato {
    private ArrayList<Estado> estados = new ArrayList<Estado>();
    private ArrayList<Transicao> transicoes = new ArrayList<Transicao>();
    private ArrayList<String> alfabeto = new ArrayList<String>();
    
    public Automato() {
    }

    Automato(Estado estado, Transicao transicao){
        this.estados.add(estado);
        this.transicoes.add(transicao);
        if (!this.alfabeto.contains(transicao.getRead())) this.alfabeto.add(transicao.getRead());
        
    }

    public void addEstado(Estado estado) {
        this.estados.add(estado);  
    }

    public void addTransicao(Transicao transicao) {
        this.transicoes.add(transicao);
        if (!this.alfabeto.contains(transicao.getRead())) this.alfabeto.add(transicao.getRead());
    }

    public ArrayList<Estado> getEstados() {
        return estados;
    }

    public ArrayList<Transicao> getTransicoes() {
        return transicoes;
    }

    public ArrayList<String> getAlfabeto() {
        return alfabeto;
    }
    
    @Override
    public String toString() {
        return "Automato [alfabeto=" + alfabeto + ", estados=" + estados + ", transicoes=" + transicoes + "]";
    }





}
