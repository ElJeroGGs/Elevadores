package Vista;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Controlador.control_principal;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelPrincipal extends JFrame implements ActionListener {

    private control_principal ctrl;
    private Panelsujetos sujetos;

    public void setctrl(control_principal contro){

        this.ctrl = contro;
    }
    

    public PanelPrincipal(PanelAscensor panel, Panelsujetos sujeto) {

        sujetos = sujeto;
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
        JButton btnReiniciar = new JButton("Reiniciar");
        JButton btnGenerar = new JButton("Generar pisos aleatorios");

        btnReiniciar.setToolTipText("Es muy inestable, se recomienda cerrar y volver a ejecutar el programa");
        btnEmpezar.setBounds(1200, 750, 200, 50); // Ajusta la posición y el tamaño según tus necesidades
        btnReiniciar.setBounds(1200, 550, 200, 50);
        btnGenerar.setBounds(1200, 650, 200, 50);
        // Agregar un ActionListener al botón
        btnEmpezar.addActionListener(this);
        btnEmpezar.setActionCommand("empezar");
        btnGenerar.addActionListener(this);
        btnGenerar.setActionCommand("generar");
        btnReiniciar.addActionListener(this);
        btnReiniciar.setActionCommand("reiniciar");

        // Agregar el botón al panel
        add(btnEmpezar);
        add(btnReiniciar);
        add(btnGenerar);

        // ...
    }

    @Override
    public void actionPerformed(ActionEvent e) {

String comand = e.getActionCommand();
switch (comand) {
    case "empezar":
    ctrl.empezar();
        break;
        
    case "reiniciar":
    ctrl.reiniciar();
        break;
    
    case "generar":
    ctrl.generar();
    revalidate();
    repaint();
            break;

    default:
        break;
}
        
    }

    public void reiniciar(Panelsujetos suj) {
        
        remove(this.sujetos);
        this.sujetos = null;
        this.sujetos = suj;
        //Componentes de los sujetos
       sujetos.setBounds(750,0,450,900);
       add(sujetos);
        revalidate();
        repaint();
    }

    

}
