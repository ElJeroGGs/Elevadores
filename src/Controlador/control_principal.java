package Controlador;

import java.util.Timer;
import java.util.TimerTask;

import Modelo.Ascensor;
import Modelo.Usuario;
import Modelo.timer;
import Vista.PanelAscensor;
import Vista.PanelPrincipal;
import Vista.Panelsujetos;

public class control_principal {

    private PanelPrincipal ventana;
    private PanelAscensor PanelAscensor;
    private Panelsujetos sujetos;
    private Usuario user1;
    private Usuario user2;
    private Usuario user3;
    private Usuario user4;
    private Ascensor ascensor1;
    private Ascensor ascensor2;
    timer time;
    boolean fin = false;
    
    

    public void setPanelPrincipal (PanelPrincipal window) {
        this.ventana = window;
    }
    
    public void setTimer(timer tim){
        this.time = tim;

    }

    public void setPanelAscensor(PanelAscensor panel){

        this.PanelAscensor = panel;
    }

    public void setPanelSujetos(Panelsujetos suj){

        this.sujetos = suj;
    }

    public void moverAscensor(int floor, int ascensor, int id){

        
        switch (ascensor) {
            case 1:
                moverAscensor1(floor, id);
                this.ascensor1.setPiso(floor);
                break;
        
           case 2:
                moverAscensor2(floor, id);
                this.ascensor2.setPiso(floor);
                break;
        }
    }

    public void moverAscensor1(int floor, int id){

        this.PanelAscensor.moverAscensor1(floor, id);

    }

    public void moverAscensor2(int floor, int id){

        this.PanelAscensor.moverAscensor2(floor, id);
    }

    public void setRecorrido(int[] recorrido, int id){

        sujetos.setRecorrido(recorrido, id);
    }

    public void pintaRecorrido(String reco, int recorridopintado, int id){

        sujetos.pintaRecorrido(reco, recorridopintado, id);

    }

    public void AscensorOUT(int ascensor, int floor, int id) {
      
        this.PanelAscensor.AscensorOUT( ascensor,  floor, id);
    }

    public void AscensorIN(int ascensor, int floor, int id) {
       
        this.PanelAscensor.AscensorIN( ascensor,  floor, id);
    }

    public void setUsuario(Usuario user, int i) {
        switch(i){
            case 1:
            PanelAscensor.setUsuario(user, "green");
            this.ascensor1 = user.getAscensor();
            
            this.user1 = user;
            break;
            case 2:
            
            PanelAscensor.setUsuario(user, "yellow");
            this.ascensor2 = user.getAscensor();
            this.user2 = user;
            break;
            case 3:
            PanelAscensor.setUsuario(user, "red");
            this.user3 = user;
            this.ascensor1 = user.getAscensor();
            break;
            case 4:
            PanelAscensor.setUsuario(user, "white");
            this.user4 = user;
            this.ascensor2 = user.getAscensor();
            break;

        }
       

    }

    public void moverSujeto( int i, int id) {

        this.PanelAscensor.moverSujeto(i, id);
    }

    public void empezar() {

        this.user1.start();
        this.user2.start();
        this.user3.start();
        this.user4.start();

        this.time.start();

    }


    public void timer(Usuario u, int id){

        this.sujetos.pintatiempo(u.getTiempo(), id);
    }


    public void reiniciar() {
    // Interrumpir los hilos actuales
    this.user1.interrupt();
    this.user2.interrupt();
    this.user3.interrupt();
    this.user4.interrupt();

    this.user1=null;
    this.user2=null;
    this.user3=null;
    this.user4=null;

    this.ascensor1=null;
    this.ascensor2=null;
  

    int[] numeros = {5, 0, 3, 6};
        int[] numeros2 = {1, 7, 3, 4, 8};
        int[] numeros3 = {2, 5, 6, 7, 8};
        int[] numeros4 = {1, 2, 3, 4, 5, 6, 7, 8};

    Ascensor asc = new Ascensor(1);

    Ascensor asc2 = new Ascensor(2);
       
    Usuario useri1 = new Usuario(asc, "Verde",numeros, 1, 35);
    useri1.setCtrl(this);
    

        Usuario useri2 = new Usuario(asc2, "Amarillo",numeros2,2, 35);
        useri2.setCtrl(this);

        Usuario useri3 = new Usuario(asc, "Rojo",numeros3, 3, 35);
        useri3.setCtrl(this);

        Usuario useri4 = new Usuario(asc2, "Blanco",numeros4, 4, 35);
        useri4.setCtrl(this);
        
        Panelsujetos suj = new Panelsujetos();
        
        this.sujetos = null;
        this.sujetos = suj;


        this.setRecorrido(numeros, 1);
        this.setRecorrido(numeros2, 2);
        this.setRecorrido(numeros3, 3);
        this.setRecorrido(numeros4, 4);



        asc.setCtrl(this);
        asc2.setCtrl(this);

        
        this.setUsuario(useri1, 1);
        this.setUsuario(useri2, 2);
        this.setUsuario(useri3, 3);
        this.setUsuario(useri4, 4);

        this.PanelAscensor.reiniciar();
        this.ventana.reiniciar(suj);
       
        

        this.ascensor1= asc;
        this.ascensor2 = asc;
        
    
    // Iniciar los nuevos hilos
    this.user1.start();
    this.user2.start();
    this.user3.start();
    this.user4.start();

    


    }

    public void setfin(boolean bandera){

        this.fin = bandera;
    }

    public Usuario getuser(int id) {
        switch (id) {
            case 1:
            return this.user1;
            
           
            case 2:
            return this.user2;
            
            case 3:
            return this.user3;
            
            case 4:
            return this.user4;
            
        
          default:
          return null;
        }
          }

    public boolean getfin() {

       return fin;
    
    }


}
