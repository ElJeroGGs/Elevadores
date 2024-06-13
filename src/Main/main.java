package Main;

import Controlador.control_principal;
import Modelo.Ascensor;
import Modelo.Usuario;
import Vista.PanelAscensor;
import Vista.PanelPrincipal;
import Vista.Panelsujetos;

public class main {
    public static void main(String[] args)  {
        //Instanciamos lo que necesitemos
        PanelAscensor panelAscensor = new PanelAscensor();
        Panelsujetos panelsujetos = new Panelsujetos();
        PanelPrincipal ventana = new PanelPrincipal(panelAscensor, panelsujetos);
        control_principal ctrl = new control_principal();
       
       
        ctrl.setPanelAscensor(panelAscensor);
        ctrl.setPanelPrincipal(ventana);
        ctrl.setPanelSujetos(panelsujetos);

        int[] numeros = {5, 0, 3, 6};
        int[] numeros2 = {1, 7, 3, 4, 8};

        Ascensor asc = new Ascensor(0);
        Usuario user1 = new Usuario(asc, "Ledezma",numeros, 1);

        user1.setCtrl(ctrl);
        Usuario user2 = new Usuario(asc, "Generico",numeros2,2);
        user2.setCtrl(ctrl);

        ctrl.setRecorrido(numeros, 1);
        ctrl.setRecorrido(numeros2, 2);

        //user1.llamarAscensor(5);
        //user1.llamarAscensor(0);
        //user2.llamarAscensor(3);
        //user2.llamarAscensor(6);

        user1.start();
        user2.start();






    }
}
