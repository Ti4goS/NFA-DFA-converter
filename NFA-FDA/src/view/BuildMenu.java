package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

import controller.ConverteAutomato;
import controller.ReadFile;

public class BuildMenu extends JFrame {
    private int retorno = 1;
    private String path;

    private JFileChooser escolhe = new JFileChooser();
    private FileNameExtensionFilter filter = new FileNameExtensionFilter("Selecione apenas arquivos jff", "jff");

    public BuildMenu() {
        super("Conversor de Autômatos");

        JButton botao = new JButton("Selecionar o local do arquivo do AFN");// selecionar arquivo
        JButton botao1 = new JButton("Iniciar conversão");// converte automato.java
        JButton botao2 = new JButton("Salvar AFD");// salvar na pasta

        escolhe.setFileFilter(filter);
        this.setLocationRelativeTo(null);
        JPanel painel = new JPanel();

        botao.setBounds(90, 20, 100, 30);
        botao1.setBounds(120, 60, 100, 60);
        botao2.setBounds(150, 100, 100, 90);

        painel.add(botao);
        painel.add(botao1);
        painel.add(botao2);
        
        botao.addActionListener(leAfn);
        botao1.addActionListener(converteAfn);
        botao2.addActionListener(salvaAfd);

        
        add(painel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        setSize(240, 160);
    }

    int extracted() {
        return escolhe.showOpenDialog(null);   
    }

    private ActionListener leAfn = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ev) {
            if (retorno == 0)
                JOptionPane.showMessageDialog(null, "Não foi informado nenhum diretório");

            if (retorno == JFileChooser.SAVE_DIALOG){
                retorno = extracted();
                JOptionPane.showMessageDialog(null, escolhe.getSelectedFile().getAbsolutePath());
                path = escolhe.getSelectedFile().getAbsolutePath();
                ReadFile rf = new ReadFile(path);
                rf.read();
            }

        }
    };

    private ActionListener converteAfn = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ev) {
            if (retorno == 0)
                ConverteAutomato.converter();
            else
                JOptionPane.showMessageDialog(null, "É necessário informar o diretório do arquivo .jff");
        }
    };

    private ActionListener salvaAfd = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ev) {

        }
    };
}

