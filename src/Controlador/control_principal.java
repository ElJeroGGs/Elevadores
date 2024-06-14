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
                break;
        
           case 2:
                moverAscensor2(floor, id);
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

    public void AscensorOUT(Ascensor ascensor, int floor, int id) {
        int asc = 1;
        int piso = 0;
        int ide = 1;
        this.PanelAscensor.AscensorOUT( asc,  piso, ide);
    }

    public void AscensorIN(Ascensor ascensor, int floor, int id) {
        int asc = 1;
        int piso = 0;
        int ide = 1;
        this.PanelAscensor.AscensorIN( asc,  piso, ide);
    }

    public void setUsuario(Usuario user1, int i) {
        switch(i){
            case 1:
            PanelAscensor.setUsuario(user1, "green");
            break;
            case 2:
            PanelAscensor.setUsuario(user1, "yellow");
            break;
            case 3:
            PanelAscensor.setUsuario(user1, "red");
            break;
            case 4:
            PanelAscensor.setUsuario(user1, "black");
            break;

        }
       

    }

    public void moverSujeto( int i, int id) {

        this.PanelAscensor.moverSujeto(i, id);
    }


}
