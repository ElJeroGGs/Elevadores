/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.control_principal;
import java.util.Random;

/**
 *
 * @author leledezma
 */
public class Usuario extends Thread {

  // Atributo privado
  private String nombre;
  private int piso;
  private Ascensor ascensor;
  private int[] pisos;
  private control_principal ctrl;
  private int id;

  // Constructor de la clase
  public Usuario(Ascensor a, String n, int id) {
    nombre = n;
    piso = 0;
    ascensor = a;
    this.id = id;
  }

  public void setCtrl(control_principal control) {
    this.ctrl = control;
  }

  // Constructor de la clase
  public Usuario(Ascensor a, String n, int[] lp, int id) {
    nombre = n;
    piso = 0;
    ascensor = a;
    pisos = lp;
    this.id = id;
  }

  public void VerPisos() {
    for (int i = 0; i < pisos.length; ++i)
      System.out.println(nombre + " va al piso " + pisos[i]);
  }

  // Método que llama al ascensor para ir de un piso a otro
  public void llamarAscensor(int destino) {

    // System.out.println("El usuario " + nombre + " está esperando en el piso " +
    // piso + " para ir al piso " + destino);

    String mensaje1 = "El usuario " + nombre + " se ha subido en el ascensor en el piso " + piso;
    ascensor.llamar(piso, this.id);

    String mensaje2 = "El usuario " + nombre + " ha bajado en el piso " + destino;
    ascensor.llamar(destino, this.id);
    piso = destino;

  }

  // Método run
  @Override
  public synchronized void run() {

    String reco = "[" + this.pisos[0];
    for (int i = 1; i < this.pisos.length; i++) {
      reco += ",";
      reco += pisos[i];

    }
    reco += "]";
    
    for(int i = 0; i < pisos.length; ++i) {
    ctrl.pintaRecorrido(reco, i, this.id);
    llamarAscensor(pisos[i]);
    }

    

    for (int i = 0; i < this.pisos.length; i++) {
      ctrl.pintaRecorrido(reco, i, this.id);
      ctrl.moverAscensor(this.pisos[i], this.id);

      try {
        sleep(500);
      } catch (InterruptedException e) {
        return;
      }
      
      
    }

    ctrl.pintaRecorrido(reco, this.pisos.length, this.id);
    

  }
}
