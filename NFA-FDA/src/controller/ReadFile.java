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

            //Lê o arquivo até o final do mesmo
            while((line=bf.readLine())!=null){

                //condição para ler os estados
                if (line.contains("state id") && !line.contains("</state>&#13;")) {

                    /*atributos do objeto estado que serão 
                    alterados a medida que o arquivo for lido*/
                    int id = 0;
                    String name = "none";
                    String label = "none";
                    Boolean initialState = false;
                    Boolean finalState = false;
                    //-----------------------------

                    //procura pelo id do estado e altera a variavel id
                    if (line.contains("id=")) id = Integer.parseInt(getSubString(line, "id="));

                    //procura pelo nome do estado e altera a variavel nome
                    if (line.contains("name=")) name = getSubString(line, "name=");

                    //procura pelo label do estado e altera a variavel label
                    if (line.contains("label=")) label = getSubString(line, "label=");
        
                    /*
                        Após o programa verificar que existe um estado o loop a seguir
                        vai verificar se esse estado é final/inicial ou as duas condições
                    */
                    while ((line=bf.readLine())!=null && !line.contains("</state>&#13;")) {
                        if(line.contains("<initial/>&#13;")) initialState=true;

                        if(line.contains("<final/>&#13;")) finalState=true;
                    }

                    /*
                        ao encontrar a tag de fechamento o metodo 
                        cria um novo estado e adiciona na lista de estado do automato
                        Posteriormente, se algum valor foi lido incorretamente será tratado
                    */
                    if (line.contains("</state>&#13;")) {
                        Estado estado = new Estado(id,name,label,initialState,finalState);
                        System.out.println(estado.toString());
                        ConverteAutomato.afn.addEstado(estado);
                    }
                }
            }
            return true;

        } catch (Exception e) {
            e.getMessage();
            return false;
        }
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

        //verifica se a busca deu certo, caso contrário ele define que o id possui apenas 1 caractere
        if(end==null) end = initial+2;

        return line.substring(initial+1, end);
    }

}
