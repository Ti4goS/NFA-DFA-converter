package controller;

import java.util.ArrayList;

import model.Automato;
import model.Estado;
import model.Transicao;

public class ConverteAutomato {
    static public Automato afn = new Automato();
    static public Automato afd = new Automato();
    static private ArrayList<ArrayList<Estado>> estadosAFD = new ArrayList<ArrayList<Estado>>();

    static private ArrayList<Estado> estados = new ArrayList<Estado>();

    public static boolean converter() {
        Estado inicial = getInicial();
        int id = 0;
        int estadosGerados = 0;
        int i = 0;
        int passou = 0;


        if (inicial == null)
            throw new StatesException("Nenhum Estado inicial foi encontrado");

        estados.add(inicial);
        getEstados(inicial, "lambda");
        estadosAFD.add(i, new ArrayList<Estado>(estados));
        addEstadoAFD(i);
        i++;
        estados.clear();

        //System.out.println(estadosAFD);


        do {
            estadosGerados=0;

                for (String letra : afn.getAlfabeto()) {
                    
                    for (Estado e : estadosAFD.get(id)) getEstados(e, letra);
                    
                    passou++;
                    //System.out.println(passou);

                    if(estados.size()>0){
                        ArrayList<Estado> auxArrayList = new ArrayList<Estado>(estados);

                        for (Estado e : auxArrayList) getEstados(e, "lambda");

                        //System.out.println("\n\nLambda:\n\n" + estados.toString());
                        auxArrayList.clear();

                        boolean contains = false;

                        for (ArrayList<Estado> lista : estadosAFD){
                            /*if (lista.equals(estados)) {
                                contains = true;
                                addTransicaoAFD(id, estadosAFD.indexOf(lista), letra);
                                break;
                            }*/
                         if (lista.containsAll(estados) && lista.size()==estados.size()){
                                contains = true;
                                addTransicaoAFD(id, estadosAFD.indexOf(lista), letra);
                             } 
                        }
                           
                            //System.out.println(estados);
                        if (!contains) {
                            //System.out.println("não tem");
                            estadosAFD.add(i,new ArrayList<Estado>(estados));
                            addEstadoAFD(i);
                            estadosGerados++;
                            addTransicaoAFD(id, i, letra);
                            i++;

                        }
                        //adiciona transicao no afd
                    }
                    estados.clear();
                    

                }    

                id++;


                if (estadosGerados==0 && id<estadosAFD.size()) {
                    System.out.println("passou");
                    for (String letra : afn.getAlfabeto()) {
                    
                        for (Estado e : estadosAFD.get(id)) getEstados(e, letra);
                        
                        passou++;
                        //System.out.println(passou);
    
                        if(estados.size()>0){
                            ArrayList<Estado> auxArrayList = new ArrayList<Estado>(estados);
    
                            for (Estado e : auxArrayList) getEstados(e, "lambda");
    
                            //System.out.println("\n\nLambda:\n\n" + estados.toString());
                            auxArrayList.clear();
    
                            boolean contains = false;
    
                            for (ArrayList<Estado> lista : estadosAFD){
                                /*if (lista.equals(estados)) {
                                    contains = true;
                                    addTransicaoAFD(id, estadosAFD.indexOf(lista), letra);
                                    break;
                                }*/

                                if (lista.containsAll(estados) && lista.size()==estados.size()){
                                    contains = true;
                                    addTransicaoAFD(id, estadosAFD.indexOf(lista), letra);
                                 } 
                            }
                               
            
                            if (!contains) {
                                //System.out.println("não tem");
                                estadosAFD.add(i,new ArrayList<Estado>(estados));
                                addEstadoAFD(i);
                                estadosGerados++;
                                addTransicaoAFD(id, i, letra);
                                i++;
    
                            }
                            //adiciona transicao no afd
                        }
                        estados.clear();
                        
    
                    } 
                    id++;
                }
        }while(estadosGerados!=0);

        //System.out.println(id);



       // System.out.println(estadosAFD.get(2).containsAll(estadosAFD.get(4)));
        //System.out.println(estadosAFD.toString());
        //System.out.println(afd.toString());

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
            if (inicial.getId().equals(transicao.getFrom().getId())
                    && transicao.getRead().equals(letra) 
                    && !estados.contains(transicao.getTo())) {
                estados.add(transicao.getTo());

               if (letra.equals("lambda")) getEstados(transicao.getTo(), letra);              
            }
        }
    }

    private static void addEstadoAFD(int id) {
        String label ="";
        String name = "q";
        boolean initialState = false;
        boolean finalState = false;

        for (Estado estado : estadosAFD.get(id)) {
            if (estado.getInitialState()) initialState = true;

            if (estado.getFinalState()) finalState = true;

            label += estado.getName(); 
        }

        afd.addEstado(new Estado(id, name+id, label, initialState, finalState));
    }

    private static void addTransicaoAFD(int from, int to,String read) {
        Estado eFrom = null;
        Estado eTo = null;

        
        for (Estado e : afd.getEstados()) {
            if (e.getId().equals(from)) {
                eFrom = e;
            }

            if (e.getId().equals(to)) {
                eTo=e;
            }
        }
        afd.addTransicao(new Transicao(eFrom, eTo, read));
    }

    private static int procuraID(ArrayList<Estado> lista) {
        int id  = 0;

        for (id = 0; id < estadosAFD.size(); id++) {
           if (estadosAFD.get(id).equals(lista)) {
               return id;
           }
        }
    
        return -1;
    }


}
