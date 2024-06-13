package Vista;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class PanelPrincipal extends JFrame {

    public PanelPrincipal(PanelAscensor panel, Panelsujetos sujetos) {

        //Panel de los ascensores
        this.setLayout(null);
        add(panel);
        panel.setVisible(true);
        panel.setBounds(0, 0, 600, 950);

        //Componentes de los sujetos
       sujetos.setBounds(750,0,450,900);
       add(sujetos);

        setSize(1500, 1000);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

}
