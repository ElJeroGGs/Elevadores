package Vista;

import javax.swing.JPanel;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class PanelAscensor extends JPanel {

    private int piso = 820;
    private int piso2 = 820;

    public PanelAscensor() {


    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw building
        g.setColor(Color.RED);
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
            g2.fillOval( 335,piso + 50, 12, 12);
            g2.setColor(Color.YELLOW);
            g2.fillOval( 425,piso2 + 50 , 12, 12);
        }

    }

    //Metodo que mueve el ascensor 1

    public void moverAscensor1(int floor) {

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

        while(piso != 820 - 100 * floor) {
            if (piso < 820 - 100 * floor) {
                piso += 1;
            } else if (piso > 820 - 100 * floor) {
                piso -= 1;
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

    public void moverAscensor2(int floor){

        while(piso2 != 820 - 100 * floor) {
            if (piso2 < 820 - 100 * floor) {
                piso2 += 1;
            } else if (piso > 820 - 100 * floor) {
                piso2 -= 1;
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

    //Coordenadas de los sujetos
    //Ascensor 1
    //(335,870)
    //Ascensor 2
    //(425,870)
    
 
}
