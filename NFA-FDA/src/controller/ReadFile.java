package controller;

import java.io.BufferedReader;
import java.io.FileReader;

import model.Estado;

public class ReadFile {
    private String filePath;
    
    public ReadFile(String filePath) {
        this.filePath = filePath;
    }



    public boolean read(){
        String line;


        try(BufferedReader bf = new BufferedReader(new FileReader(filePath))) {

            while((line=bf.readLine())!=null){

                if (line.contains("state id") && !line.contains("</state>&#13;")) {
                    int id = 0;
                    String name = "none";
                    String label = "none";
                    Boolean initialState = false;
                    Boolean finalState = false;

                    if (line.contains("id=")) id = Integer.parseInt(getSubString(line, "id="));

                    if (line.contains("name=")) name = getSubString(line, "name=");

                    if (line.contains("label=")) label = getSubString(line, "label=");
        
                    while ((line=bf.readLine())!=null && !line.contains("</state>&#13;")) {
                        if(line.contains("<initial/>&#13;")) initialState=true;

                        if(line.contains("<final/>&#13;")) finalState=true;
                    }

                    if (line.contains("</state>&#13;")) {
                        Estado estado = new Estado(id,name,label,initialState,finalState);
                        System.out.println(estado.toString());
                        ConverteAutomato.afn.addEstado(estado);
                    }
                }
            }


                

            } catch (Exception e) {
            e.getMessage();
            return false;
        }

        return true;
    }

    private String getSubString(String line,String lookFor) {
        int initial = line.indexOf(lookFor)+lookFor.length();
        Integer end = null;

        for (int i = initial+1; i < line.length(); i++) {
            if (line.charAt(i)=='\"') {
                end = i;
                break;
            }
        }

        if(end==null) end = initial+2;
        //verifica se a busca deu certo, caso contrário ele define que o id possui apenas 1 caractere

        return line.substring(initial+1, end);
    }

}
