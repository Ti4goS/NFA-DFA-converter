package controller;

import java.util.ArrayList;

import model.Automato;
import model.Estado;
import model.Transicao;

public class ConverteAutomato {
    static public Automato afn = new Automato();
    static public Automato afd = new Automato();
    static private ArrayList<Estado> estados = new ArrayList<Estado>();

    public static boolean converter() {
        Estado inicial = getInicial();

        if (inicial == null)
            throw new StatesException("Nenhum Estado inicial foi encontrado");

        estados.add(inicial);

        for (String letra : afn.getAlfabeto()) {
            getEstados(inicial, letra);

            /*logica para colocar todos os elementos da lista dentro do afd*/

            estados.clear();
        }

        System.out.println(estados.toString());

        return true;
    }

    private static Estado getInicial() {

        try {

            for (Estado estado : afn.getEstados()) {
                if (estado.getInitialState())
                    return estado;

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private static void getEstados(Estado inicial, String letra) {
        for (Transicao transicao : afn.getTransicoes()) {
            if (transicao.getFrom().getId() == inicial.getId() && transicao.getRead() == letra) {
                System.out.println("passou3");
                estados.add(transicao.getTo());
                getEstados(transicao.getTo(), letra);
            }
        }
    }

}
