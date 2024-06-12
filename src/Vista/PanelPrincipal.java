package Vista;

import java.awt.GridLayout;
import java.awt.Panel;

import javax.swing.JFrame;

public class PanelPrincipal extends JFrame {

    public PanelPrincipal() {
        this.setLayout(new GridLayout(1, 1));
        PanelAscensor panel = new PanelAscensor();
        add(panel);
        panel.setVisible(true);






     
        setSize(1500, 1000);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

}
