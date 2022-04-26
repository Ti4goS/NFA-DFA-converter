package controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import model.Transicao;

public class Xml{

ArrayList<State> estados;
private ArrayList<String> alfabeto;
private ArrayList<Transicao> transicoes;
private State estadoInicial;

public void AFD(){
    estados = new ArrayList<>();
    alfabeto = new ArrayList<>();
    transicoes = new ArrayList<>();
    estadoInicial = new State();	
    new ArrayList<>();
    
    estadoInicial.setID(-1);
    estadoInicial.setName(-1);	
}

public ArrayList<String> getAlfabeto() {
    return alfabeto;
}

public void save() throws IOException {
    JFileChooser file = new JFileChooser();
    FileNameExtensionFilter filter = new FileNameExtensionFilter(".jff", "jff");
    file.setFileFilter(filter);
    
    file.setDialogType(JFileChooser.SAVE_DIALOG);
    int j= file.showSaveDialog(null);
    if (j==1){
        //JtextFieldLocal.setText("");
    } else {
        File arquivo = file.getSelectedFile();			//pega o nome do arquivo
        
        
        //Writer writer = new FileWriter(arquivo + ".jflap");		//abre um arquivo para escrita
        FileWriter arq = new FileWriter(arquivo + ".jff");
        PrintWriter gravarArq = new PrintWriter(arq);

        gravarArq.printf("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><!--Created with JFLAP 6.4.--><structure>\n");
            gravarArq.printf("\t<type>fa</type>\n");
            // grava estados    
            if (estados.size() == 0) {
                gravarArq.printf("\t<automaton/>\n");
            } else {	
                gravarArq.printf("\t<automaton>\n");
                gravarArq.printf("\t\t<!--The list of states.-->\n");
                for (int i = 0; i < estados.size(); i++) {
                    gravarArq.printf("\t\t<state id=\"%d\" name=\"%d\">\n", estados.get(i).getId(), estados.get(i).getName());
                        gravarArq.printf("\t\t\t<x></x>\n");
                        gravarArq.printf("\t\t\t<y></y>\n");
                        if (estados.get(i).isStateFinal()) {
                            gravarArq.printf("\t\t\t<initial/>\n");
                        }
                        if (estados.get(i).isStateFinal()) {
                            gravarArq.printf("\t\t\t<final/>\n");
                        }
                    gravarArq.printf("\t\t</state>\n");
                }
            }
            if (estados.size() != 0 && transicoes.size() == 0) {
                gravarArq.printf("\t</automaton>\n");
            } 
            // grava transicoes
            if (transicoes.size() == 0) {
            } else {
                gravarArq.printf("\t\t<!--The list of transitions.-->\n");
                for (int i = 0; i < transicoes.size(); i++) {
                    gravarArq.printf("\t\t<transition>\n");
                        gravarArq.printf("\t\t\t<from>%d</from>\n", transicoes.get(i).getFrom());
                        gravarArq.printf("\t\t\t<to>%d</to>\n", transicoes.get(i).getTo());
                        gravarArq.printf("\t\t\t<read>%s</read>\n", transicoes.get(i).getRead());
                    gravarArq.printf("\t\t</transition>\n");
                }
                gravarArq.printf("\t</automaton>\n");
            }
                
        gravarArq.printf("</structure>\n");
        gravarArq.close();									//fecha o arquivo
    }
}
}