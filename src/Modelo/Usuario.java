/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Random;

import Controlador.control_principal;

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
  private int floor;
  private int abordo;
  private long tiempoinicio = 0;
  private long tiempofinal = 0;
  boolean fin = false;


  // Constructor de la clase
  public Usuario(Ascensor a, String n, int id) {
    nombre = n;
    piso = 0;
    ascensor = a;
    this.id = id;
    abordo = 35;
    this.floor = 820 - 100*piso;
  }


  public int getAbordo(){

    return this.abordo;
  }

  public void setAbordo(int num){

    this.abordo=num;
  }

  public int getPiso() {
    return piso;
  }

  public void setFloor(int flor){
    this.floor = flor;
  }

  public int getFloor(){
    return this.floor;
  }

  public void setCtrl(control_principal control) {
    this.ctrl = control;
  }

  // Constructor de la clase
  public Usuario(Ascensor a, String n, int[] lp, int id, int abordo) {
    nombre = n;
    piso = 0;
    ascensor = a;
    pisos = lp;
    this.id = id;
    this.floor = 820 - 100*piso;
    this.abordo = abordo;
  }

  public void VerPisos() {
    for (int i = 0; i < pisos.length; ++i)
      System.out.println(nombre + " va al piso " + pisos[i]);
  }

  // Método que llama al ascensor para ir de un piso a otro
  public  synchronized void llamarAscensor(int destino) {

    // System.out.println("El usuario " + nombre + " está esperando en el piso " +
    // piso + " para ir al piso " + destino);

    
    String mensaje1 = "El usuario " + nombre + " se ha subido en el ascensor en el piso " + piso;
    //Metodo que simula que sube el sujeto


    System.out.println(mensaje1);
    
    //Que aqui la bandera sea true
    ascensor.setFin(true);
    ascensor.llamar(this.piso, this.ascensor.getid(),this.id,"viene");
    ascensor.llamar(destino, this.ascensor.getid(),this.id,"sube");
    ascensor.llamar(destino, this.ascensor.getid(),this.id,"baja");

   
    

    String mensaje2 = "El usuario " + nombre + " ha bajado en el piso " + destino;
 
 
//Que aqui la bandera sea false
    
    ascensor.setFin(false);
    piso = destino;
    System.out.println(mensaje2);
    
    

  }

  // Método run
  @Override
  public  void run() {
    this.tiempoinicio = System.currentTimeMillis();

    
    
      String reco = "[" + this.pisos[0];
    for (int i = 1; i < this.pisos.length; i++) {
      reco += ",";
      reco += pisos[i];

    }
    reco += "]";
    
    for(int i = 0; i < pisos.length; ++i) {
      //metodo que pinta si ya recorrió un piso
      
      ctrl.pintaRecorrido(reco, i, this.id);
      llamarAscensor(pisos[i]);
      
      

      
      
    }

    ctrl.pintaRecorrido(reco, this.pisos.length, this.id);

    

    
    
      
      
  
this.tiempofinal = System.currentTimeMillis();

fin = true;
this.interrupt();

    
  }

  public long getTiempoFinal(){
    return tiempofinal-tiempoinicio;
  }

  public long getTiempo(){
if(fin==false){
  return System.currentTimeMillis() - tiempoinicio;
}else{
  return tiempofinal - tiempoinicio;
}
    
  }

  public Ascensor getAscensor() {
    return this.ascensor;
  }


  
}


