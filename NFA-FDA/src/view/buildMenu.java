package view;

import javax.swing.*;

public class BuildMenu extends JFrame {
    JButton botao1 = new JButton("Iniciar conversão");//converte automato.java
    JButton botao = new JButton("Selecionar o local do arquivo do AFN");//
    JButton botao2 = new JButton("Salvar AFD");

    public BuildMenu() {
        super("Conversor de Autômatos");
        this.setLocationRelativeTo(null);
        JPanel painel = new JPanel();
        botao.setBounds(90, 20, 100, 30);
        botao1.setBounds(120, 60, 100, 60);
        botao2.setBounds(150, 100, 100, 90);
        painel.add(botao);
        painel.add(botao1);
        painel.add(botao2);
        add(painel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        setSize(240, 160);
    }
}
