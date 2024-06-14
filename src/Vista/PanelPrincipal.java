package Vista;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;

import javax.swing.JFrame;
import javax.swing.JLabel;

import Controlador.control_principal;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelPrincipal extends JFrame implements ActionListener {

    private control_principal ctrl;

    public void setctrl(control_principal contro){

        this.ctrl = contro;
    }

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

        // Crear un nuevo botón
        JButton btnEmpezar = new JButton("Empezar");
        btnEmpezar.setBounds(1200, 750, 200, 50); // Ajusta la posición y el tamaño según tus necesidades

        // Agregar un ActionListener al botón
        btnEmpezar.addActionListener(this);

        // Agregar el botón al panel
        add(btnEmpezar);

        // ...
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        ctrl.empezar();
    }

    

}
