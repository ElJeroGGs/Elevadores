package Modelo;

import Controlador.control_principal;

public class timer extends Thread{

    control_principal ctrl;
    Usuario user1;
    Usuario user2;
    Usuario user3;
    Usuario user4;
    boolean fin = false;


    public timer(){


    }

    public void setctrl(control_principal control){

        this.ctrl = control;
        this.user1 = ctrl.getuser(1);
        this.user2 = ctrl.getuser(2);
        this.user3 = ctrl.getuser(3);
        this.user4 = ctrl.getuser(4);

    }

    @Override
    public void run()
    {
        long tiempoTranscurrido;
        long inicio = System.currentTimeMillis();

        do {
             tiempoTranscurrido = System.currentTimeMillis() - inicio;
        
            if (tiempoTranscurrido >= 100) {
              ctrl.timer(this.user1,1);
              ctrl.timer(this.user2,2);
              ctrl.timer(this.user3,3);
              ctrl.timer(this.user4,4);
        
                // Reiniciar el contador
                inicio = System.currentTimeMillis();

                if(this.user1.isInterrupted() && this.user2.isInterrupted() && this.user3.isInterrupted() && this.user4.isInterrupted()){
                    fin = true;
                }
            }
        } while (!fin);

    }

    

}
