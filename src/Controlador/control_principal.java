package Controlador;

import Modelo.Ascensor;
import Modelo.Usuario;
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
    

    public void setPanelPrincipal (PanelPrincipal window){
        this.ventana = window;
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
            this.user2 = user;
            this.ascensor2 = user.getAscensor();
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
    }


    public void reiniciar() {
          // Interrumpir los hilos actuales
    this.user1.interrupt();
    this.user2.interrupt();
    this.user3.interrupt();
    this.user4.interrupt();


    // Iniciar los nuevos hilos
    this.user1.start();
    this.user2.start();
    this.user3.start();
    this.user4.start();
    }


}
