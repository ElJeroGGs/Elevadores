package Vista;

import javax.swing.JPanel;

import Modelo.Usuario;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class PanelAscensor extends JPanel {

    private int piso = 820;
    private int piso2 = 820;
    private Usuario green;
    private Usuario yellow;
    private Usuario red;
    private Usuario white;


    public PanelAscensor() {


    }

    public void setUsuario(Usuario user, String color) {
        switch (color) {
            case "green":
            this.green = user;
                break;
            case "yellow":
            this.yellow = user;
                break;
            case "red":
            this.red = user;
                break;
            case "white":
            this.white = user;
                break;
        
        }
       
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw building
        g.setColor(Color.gray);
        g.fillRect(290, 100, 200, 800);

        // Draw elevator 1 y 2 dependiendo de que planta este
        if (g instanceof Graphics2D) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(Color.BLACK);
            g2.fillRect(320, piso, 40, 70);
            g2.setColor(Color.DARK_GRAY);
            g2.setStroke(new BasicStroke(3));
            g2.drawRect(320, piso, 40, 70);

            // Draw elevator 2
            g2.setColor(Color.BLACK);
            g2.fillRect(410, piso2, 40, 70);
            g2.setColor(Color.DARK_GRAY);
            g2.setStroke(new BasicStroke(3));
            g2.drawRect(410, piso2, 40, 70);
        }

        if (g instanceof Graphics2D) {
            Graphics2D g2 = (Graphics2D) g;
            // Draw floors
            g2.setColor(Color.PINK);
            for (int i = 1; i <= 8; i++) {
                g2.drawLine(290, 100 * i, 490, 100 * i);
            }

            // Set font size
            g2.setFont(new Font("default", Font.BOLD, 20));

            // Draw floors numbers
            g2.setColor(Color.BLACK);
            int contador = 8;
            for (int i = 1; i <= 8; i++) {
                g2.drawString(String.valueOf(contador), 500, 100 * i);
                contador--;
            }

            //Draw people 
            g2.setColor(Color.GREEN);
            g2.fillOval( 335+this.green.getAbordo(),(this.green.getFloor()) + 50, 12, 12);
            g2.setColor(Color.YELLOW);
            g2.fillOval( 425+this.yellow.getAbordo(),(this.yellow.getFloor()) + 50, 12, 12);
            g2.setColor(Color.RED);
            g2.fillOval( 350+this.red.getAbordo(),(this.red.getFloor()) + 50, 12, 12);
            g2.setColor(Color.WHITE);
            g2.fillOval( 440+this.white.getAbordo(),(this.white.getFloor()) + 50, 12, 12);
        }

    }

    //Metodo que mueve el ascensor 1

    public void moverAscensor1(int floor, int id) {

        

        //Cuando se mueva el ascensor, se debe especificar cuantas plantas se va a mover, y en que dirección (arriba o abajo)
        // 820 - 100 * piso
        // 820 - 100 * 8 = 40
        // 820 - 100 * 7 = 140
        // 820 - 100 * 6 = 240
        // 820 - 100 * 5 = 340
        // 820 - 100 * 4 = 440
        // 820 - 100 * 3 = 540
        // 820 - 100 * 2 = 640
        // 820 - 100 * 1 = 740
        // 820 - 100 * 0 = 840
        //Mueve el ascensor gradualmente
       
        Usuario user = null;
        switch(id){
            case 1:
            user = this.green;
            break;
            case 2:
            user = this.yellow;
            break;
            case 3:
            user = this.red;
            break;
            case 4:
            user = this.white;
            break;
        }

//Mueve el ascensor
        while(piso != 820 - 100 * floor) {
            if (piso < 820 - 100 * floor) {
                piso += 1;
                user.setFloor(piso); 
            } else if (piso > 820 - 100 * floor) {
                piso -= 1;
                user.setFloor(piso);
            } else {
                break;
            }
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                return;
            }
            repaint();
            revalidate();
        }
        this.piso = 820 - 100 * floor;
        repaint();
    }

    //Metodo que mueve el ascensor 2

    public void moverAscensor2(int floor, int id){
        Usuario user = null;
        switch(id){
            case 1:
            user = this.green;
            break;
            case 2:
            user = this.yellow;
            break;
            case 3:
            user = this.red;
            break;
            case 4:
            user = this.white;
            break;
        }

        while(piso2 != 820 - 100 * floor) {
            if (piso2 < 820 - 100 * floor) {
                piso2 += 1;
                user.setFloor(piso2);
            } else if (piso > 820 - 100 * floor) {
                piso2 -= 1;
                user.setFloor(piso2);
            } else {
                break;
            }
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                return;
            }
            repaint();
        }
        this.piso2 = 820 - 100 * floor;
        repaint();
        revalidate();


    }

    public void moverSujeto(int floor, int id) {

        int piso = 0;
        
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                return;
            }
            repaint();
        }

       
    

    public void AscensorIN(int asc, int piso, int ide) {

       

        Usuario user = null;
        int numero = 0;
        switch(ide){
            case 1:
            user = this.green;
            break;
            case 2:
            user = this.yellow;
            break;
            case 3:
            user = this.red;
            numero = -15;
            break;
            case 4:
            user = this.white;
            numero = -15;
            break;
        }

        user.setAbordo(numero);
        repaint();
        revalidate();

    
        }
    
        public void AscensorOUT(int asc, int piso, int ide) {
            //aparte de mover al muñequito, debo "lockear" al mono pa que no se mueva
int numero = 35;
            Usuario user = null;
        switch(ide){
            case 1:
            user = this.green;
            break;
            case 2:
            user = this.yellow;
            break;
            case 3:
            user = this.red;
            numero = 20;
            break;
            case 4:
            user = this.white;
            numero = 20;
            break;
        }

        user.setAbordo(numero);
        repaint();
        revalidate();
        
        }

    //Coordenadas de los sujetos
    //Ascensor 1
    //(335,870)
    //Ascensor 2
    //(425,870)
    
 
}
