package view;

import javax.swing.*;

public class buildMenu extends JFrame {
    public buildMenu() {
        super("Conversor de Autômatos");
        final JLabel label = new JLabel("Conversor AFN em AFD");
        getContentPane().add(label);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
}
