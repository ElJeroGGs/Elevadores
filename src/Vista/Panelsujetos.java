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
JLabel time1;

JLabel rec2;
JLabel time2;

JLabel rec3;
JLabel time3;

JLabel rec4;
JLabel time4;


    public Panelsujetos(){
        this.setLayout(null);
         JLabel sujeto1 = new JLabel("verde");
        
        JLabel sujeto2 = new JLabel("amarillo");

        JLabel sujeto3 = new JLabel("rojo");

        JLabel sujeto4 = new JLabel("blanco");

        sujeto1.setFont(new Font("Serif", Font.PLAIN, 40));
        sujeto2.setFont(new Font("Serif", Font.PLAIN, 40));
        sujeto3.setFont(new Font("Serif", Font.PLAIN, 40));
        sujeto4.setFont(new Font("Serif", Font.PLAIN, 40));
         
        // Cambia el tamaño de la fuente aquí
        add(sujeto1);
        add(sujeto2);
        add(sujeto3);
        add(sujeto4);
        sujeto1.setBounds(0, 100, 200, 60);
        
        sujeto2.setBounds(0, 300, 200, 60);

        sujeto3.setBounds(0, 500, 200, 60);

        sujeto4.setBounds(0, 700, 200, 60);
        
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
    if(rec1!=null && time1!=null){
        remove(rec1);
        remove(time1);
    }
        this.recorrido1 = recorrido;
        rec1 = new JLabel(reco);
        time1= new JLabel("0 ms");
        rec1.setFont(new Font("Serif", Font.PLAIN, 30));
        time1.setBounds(30, 190, 200, 60);
        time1.setFont(new Font("Serif", Font.PLAIN, 20));
        rec1.setBounds(0, 150, 200, 60);
        add(rec1);
        add(time1);
        this.pintaRecorrido(reco, 0, id);
        break;
    case 2:
        this.recorrido2 = recorrido;
        if(rec2!=null && time2!=null){
            remove(rec2);
            remove(time2);
        }
        rec2 = new JLabel(reco);
        time2= new JLabel("0 ms");
        rec2.setFont(new Font("Serif", Font.PLAIN, 30));
        rec2.setBounds(0, 350, 200, 60);
        time2.setBounds(30, 390, 200, 60);
        time2.setFont(new Font("Serif", Font.PLAIN, 20));
        add(rec2);
        add(time2);
        this.pintaRecorrido(reco, 0, id);
        break;
    case 3:
        this.recorrido3 = recorrido;
        if(rec3!=null && time3!=null){
            remove(rec3);
            remove(time3);
        }
        rec3 = new JLabel(reco);
        time3= new JLabel("0 ms");
        rec3.setFont(new Font("Serif", Font.PLAIN, 30));
        rec3.setBounds(0, 550, 200, 60);
        time3.setBounds(30, 590, 200, 60);
        time3.setFont(new Font("Serif", Font.PLAIN, 20));
        add(rec3);
        add(time3);
        this.pintaRecorrido(reco, 0, id);
        break;
    case 4:
        this.recorrido4 = recorrido;
        if(rec4!=null && time4!=null){
            remove(rec4);
            remove(time4);
        }
        rec4 = new JLabel(reco);
        time4= new JLabel("0 ms");
        rec4.setFont(new Font("Serif", Font.PLAIN, 30));
        rec4.setBounds(0, 750, 200, 60);
        time4.setBounds(30, 790, 200, 60);
        time4.setFont(new Font("Serif", Font.PLAIN, 20));
        add(rec4);
        add(time4);
        this.pintaRecorrido(reco, 0, id);
        break;

        
}

        revalidate();
        repaint();

    }

public void pintatiempo(long tiempo, int id){

    switch (id) {
        case 1:
        this.time1.setText(tiempo+" ms");
        break;
        case 2:
        this.time2.setText(tiempo+" ms");
        break;
        case 3:
        this.time3.setText(tiempo+" ms");
        break;
        case 4:
        this.time4.setText(tiempo+" ms");
        break;

    
        default:
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
            this.remove(rec3);
            rec3 = new JLabel("<html><font color='black'>" + firstHalf + "</font><font color='red'>" + secondHalf + "</font><font color='black'>" + firstHalf2 +firstHalf3+ "</font></html>");
                rec3.setFont(new Font("Serif", Font.PLAIN, 30));
                rec3.setBounds(0, 550, 200, 60);
                add(rec3);
                this.revalidate();
                this.repaint();
                break;
            case 4:
            this.remove(rec4);
            rec4 = new JLabel("<html><font color='black'>" + firstHalf + "</font><font color='white'>" + secondHalf + "</font><font color='black'>" + firstHalf2 +firstHalf3+ "</font></html>");
                rec4.setFont(new Font("Serif", Font.PLAIN, 30));
                rec4.setBounds(0, 750, 200, 60);
                add(rec4);
                this.revalidate();
                this.repaint();
                break;
    }

                this.revalidate();
                this.repaint();
}

    
}
