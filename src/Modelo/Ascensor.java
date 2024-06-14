/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.control_principal;

/**
 *
 * @author leledezma
 */
 public class Ascensor extends Thread{

    //Atributo privado
    private int piso;
    private boolean parado;
    private int id;
    private control_principal ctrl;

    //Constructor de la clase
    public Ascensor(int id) {
      piso = 0;
      parado = true;
      this.id = id;
    }

    public int getid(){
      return this.id;
    }

    public void setCtrl (control_principal contro){
      this.ctrl = contro;
    }

    //Método que si dada la posición del ascensor y el piso desde el que le llaman,
    //controla si el ascensor sube o baja
    public synchronized void llamar(int p, int ascensor, int id) {


      while(!parado) {
        try {
          wait();
        } catch (InterruptedException e) {
          return ;
        }
      }
      
      if(piso > p) {
        bajar(p, ascensor, id);
        } else if(piso < p) {
          subir(p, ascensor, id);
            } else if(piso==p){
              stay(p, ascensor, id);
                }
      
                
      
    }



    //Método modificador que simula la subida del ascensor. Muestra un mensaje cuando
    //el ascensor ha llegado al destino.
    
    public synchronized void subir(int p, int asc, int id) {
      while(!parado) {
        try {
          wait();
        } catch (InterruptedException e) {
          return ;
        }
      }
      parado = false;
      while (piso != p) {
        ctrl.moverAscensor(p, asc, id);
        ++piso;
        System.out.println("Ascensor " + this.id+ " en el piso " + piso);
        
      }
      parado = true;
      notifyAll();
    }

    

    //Método modificador que simula la bajada del ascensor. Muestra un mensaje cuando
    //el ascensor ha llegado al destino.
    public synchronized void bajar(int p, int asc, int id) {
      while(!parado) {
        try {
          wait();
        } catch (InterruptedException e) {
          return ;
        }
      }
      parado = false;
      while (piso != p) {
      ctrl.moverAscensor(p, asc, id);
        --piso;
        System.out.println("Ascensor "+this.id+ " en el piso " + piso);
        
      }
      parado = true;
      notifyAll();
    }

    public synchronized void stay(int p, int asc, int id) {

      while(!parado) {
        try {
          wait();
        } catch (InterruptedException e) {
          return ;
        }
      }
      parado = false;
      ctrl.moverAscensor(p, asc, id);
        
      
      parado = true;
      notifyAll();
    }

    public synchronized void AscensorIN(){
    parado = true;

    }

    public synchronized void AscensorOUT(){

      parado = true;
      int floor = 0;
      int id = 0;
      ctrl.AscensorOUT(this, floor, id);


    }

    //Método observador que muestra el piso
    public synchronized void mostrarPiso() {
      System.out.println("El ascensor "+this.id+ " está en el piso " + piso);
    }

    //Método observador que devuelve el piso
    public synchronized int piso() {
      return piso;
    }

  }

