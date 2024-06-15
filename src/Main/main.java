package Main;

import Controlador.control_principal;
import Modelo.Ascensor;
import Modelo.Usuario;
import Modelo.timer;
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

        ventana.setctrl(ctrl);

        int[] numeros =  {5, 0, 3, 6, 7, 8, 1};
        int[] numeros2 = {1, 7, 3, 4, 8, 6, 5};
        int[] numeros3 = {2, 5, 6, 7, 8, 1, 2};
        int[] numeros4 = {1, 2, 3, 4, 5, 6, 8};

        Ascensor asc = new Ascensor(1);
        Ascensor asc2 = new Ascensor(2);
       
        Usuario user1 = new Usuario(asc, "Verde",numeros, 1, 35);
        user1.setCtrl(ctrl);

        Usuario user2 = new Usuario(asc2, "Amarillo",numeros2,2, 35);
        user2.setCtrl(ctrl);

        Usuario user3 = new Usuario(asc, "Rojo",numeros3, 3, 35);
        user3.setCtrl(ctrl);

        Usuario user4 = new Usuario(asc2, "Blanco",numeros4, 4, 35);
        user4.setCtrl(ctrl);
        

        ctrl.setRecorrido(numeros, 1);
        ctrl.setRecorrido(numeros2, 2);
        ctrl.setRecorrido(numeros3, 3);
        ctrl.setRecorrido(numeros4, 4);



        asc.setCtrl(ctrl);
        asc2.setCtrl(ctrl);

        ctrl.setUsuario(user1, 1);
        ctrl.setUsuario(user2, 2);
        ctrl.setUsuario(user3, 3);
        ctrl.setUsuario(user4, 4);

        timer time = new timer();
        time.setctrl(ctrl);
        ctrl.setTimer(time);
        

        //user1.llamarAscensor(5);
        //user1.llamarAscensor(0);
        //user2.llamarAscensor(3);
        //user2.llamarAscensor(6);






    }
}
