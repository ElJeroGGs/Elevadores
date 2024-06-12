package Vista;

import javax.swing.JPanel;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class PanelAscensor extends JPanel {

    public PanelAscensor() {

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw building
        g.setColor(Color.RED);
        g.fillRect(290, 100, 200, 800);

        // Draw elevator 1
        if (g instanceof Graphics2D) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(Color.BLACK);
            g2.fillRect(320, 820, 40, 70);
            g2.setColor(Color.DARK_GRAY);
            g2.setStroke(new BasicStroke(3));
            g2.drawRect(320, 820, 40, 70);

            // Draw elevator 2
            g2.setColor(Color.BLACK);
            g2.fillRect(410, 820, 40, 70);
            g2.setColor(Color.DARK_GRAY);
            g2.setStroke(new BasicStroke(3));
            g2.drawRect(410, 820, 40, 70);
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
            g2.setColor(Color.DARK_GRAY);
            for (int i = 1; i <= 8; i++) {
                g2.drawString(String.valueOf(i), 500, 100 * i);
            }

            //Draw people 
            g2.setColor(Color.GREEN);
            g2.fillOval( 335,870 , 12, 12);
            g2.setColor(Color.YELLOW);
            g2.fillOval( 425,870 , 12, 12);
        }

    }

    //Coordenadas de los sujetos
    //Ascensor 1
    //(335,870)
    //Ascensor 2
    //(425,870)
    
}
