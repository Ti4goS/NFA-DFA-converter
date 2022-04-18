
import controller.ConverteAutomato;
import controller.ReadFile;

public class App {
    public static void main(String[] args) throws Exception {
        String path = "D:/Faculdade/5°periodo/Teoria da Computação/Atividades/Atividade-04/EX04Q01.jff";
        ReadFile rf = new ReadFile(path);

        rf.read();
        System.out.println(ConverteAutomato.afn.toString());

    }
}
