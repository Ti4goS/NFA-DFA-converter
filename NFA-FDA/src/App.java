import controller.ConverteAutomato;
import controller.ReadFile;

public class App {
    public static void main(String[] args) throws Exception {
        //D:/Faculdade/5°periodo/Teoria da Computação/prova.jff
        //String path = "D:/Faculdade/5°periodo/Teoria da Computação/Atividades/Atividade-05/Q01/A-AFN.jff";
        String path = "D:/Faculdade/5°periodo/Teoria da Computação/Atividades/Atividade-05/Q01/B-AFN.jff";
        ReadFile readFile = new ReadFile(path);
        readFile.read();
        //System.out.println(ConverteAutomato.afn.toString());
        ConverteAutomato.converter();
    }
}
