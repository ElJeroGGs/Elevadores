package Vista;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Panelsujetos extends JPanel{

int[] recorrido1;
int[] recorrido2;
int[] recorrido3;
int[] recorrido4;

JLabel rec1;

JLabel rec2;

JLabel rec3;

JLabel rec4;


    public Panelsujetos(){
        this.setLayout(null);
         JLabel sujeto1 = new JLabel("verde");
        
        JLabel sujeto2 = new JLabel("amarillo");

        sujeto2.setFont(new Font("Serif", Font.PLAIN, 40));
        sujeto1.setFont(new Font("Serif", Font.PLAIN, 40)); // Cambia el tamaño de la fuente aquí
        add(sujeto1);
        add(sujeto2);
        sujeto1.setBounds(0, 100, 200, 60);
        
        sujeto2.setBounds(0, 300, 200, 60);
        
    }

    public void setRecorrido(int[] recorrido, int id){
        String reco ="["+recorrido[0];
        for (int i = 1; i< recorrido.length; i++){
            reco += ",";
            reco += recorrido[i];

        }
        
        reco += "]";

        switch (id) {
            
    case 1:
        this.recorrido1 = recorrido;
        rec1 = new JLabel(reco);
        rec1.setFont(new Font("Serif", Font.PLAIN, 30));
        rec1.setBounds(0, 150, 200, 60);
        add(rec1);
        break;
    case 2:
        this.recorrido2 = recorrido;
        rec2 = new JLabel(reco);
        rec2.setFont(new Font("Serif", Font.PLAIN, 30));
        rec2.setBounds(0, 350, 200, 60);
        add(rec2);
        break;
    case 3:
        this.recorrido3 = recorrido;
        break;
    case 4:
        this.recorrido4 = recorrido;
        break;
}



    }

    public void pintaRecorrido(String reco,int recorridopintado, int id){

        String firstHalf = reco.substring(0, 1);
        String secondHalf;
        String firstHalf2;
        String firstHalf3;

        if(1+recorridopintado*2 == reco.length()){
            
         secondHalf = reco.substring(1, recorridopintado*2);
        firstHalf2 = reco.substring(recorridopintado*2, reco.length()-1);
         firstHalf3 = reco.substring(reco.length()-1, reco.length());
    
        }else{
             secondHalf = reco.substring(1, 1+recorridopintado*2);
             firstHalf2 = reco.substring(1+recorridopintado*2, reco.length());
             firstHalf3 = reco.substring(reco.length(), reco.length());
        }

        switch (id) {
            
            case 1:
            this.remove(rec1);
                rec1 = new JLabel("<html><font color='black'>" + firstHalf + "</font><font color='green'>" + secondHalf + "</font><font color='black'>" + firstHalf2 +firstHalf3+ "</font></html>");
                rec1.setFont(new Font("Serif", Font.PLAIN, 30));
                rec1.setBounds(0, 150, 200, 60);
                add(rec1);
                this.revalidate();
                this.repaint();
                
                break;
            case 2:
            this.remove(rec2);
            rec2 = new JLabel("<html><font color='black'>" + firstHalf + "</font><font color='yellow'>" + secondHalf + "</font><font color='black'>" + firstHalf2 +firstHalf3+ "</font></html>");
                rec2.setFont(new Font("Serif", Font.PLAIN, 30));
                rec2.setBounds(0, 350, 200, 60);
                add(rec2);
                this.revalidate();
                this.repaint();
                break;
            case 3:
            
                break;
            case 4:
               
                break;

    }
}

}
