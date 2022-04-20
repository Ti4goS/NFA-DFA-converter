import controller.ConverteAutomato;
import controller.ReadFile;
import view.buildMenu;

public class App {
    public static void main(String[] args) throws Exception {
        String path = "D:/Faculdade/5°periodo/Teoria da Computação/prova.jff";
        ReadFile readFile = new ReadFile(path);
        readFile.read();
        ConverteAutomato.converter();
        //buildMenu tela = new buildMenu();
        //tela.setVisible(true);
    }
}
