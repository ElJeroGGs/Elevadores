package Controlador;

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

    public void moverAscensor(int floor, int ascensor){

        switch (ascensor) {
            case 1:
                moverAscensor1(floor);
                break;
        
           case 2:
                moverAscensor2(floor);
                break;
        }
    }

    public void moverAscensor1(int floor){

        this.PanelAscensor.moverAscensor1(floor);

    }

    public void moverAscensor2(int floor){

        this.PanelAscensor.moverAscensor2(floor);
    }

    public void setRecorrido(int[] recorrido, int id){

        sujetos.setRecorrido(recorrido, id);
    }

    public void pintaRecorrido(String reco, int recorridopintado, int id){

        sujetos.pintaRecorrido(reco, recorridopintado, id);

    }


}
