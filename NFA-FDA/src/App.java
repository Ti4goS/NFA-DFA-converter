import controller.ConverteAutomato;
import controller.ReadFile;
import view.BuildMenu;

public class App {
    public static void main(String[] args) throws Exception {
        String path = "D:/Faculdade/5°periodo/Teoria da Computação/Atividades/Atividade-04/EX04Q01.jff";
        ReadFile rf = new ReadFile(path);
        BuildMenu tela = new BuildMenu();
        rf.read();
        tela.setVisible(true);

    }
}
