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
    public synchronized void llamar(int p, int ascensor, int id, String accion) {

      //Dependiendo de accion, la bolita se sube o se baja del ascensor


      while(!parado) {
        try {
          wait();
        } catch (InterruptedException e) {
          return ;
        }
      }
      
      if(piso > p) {
        bajar(p, ascensor, id, accion);
        } else if(piso < p) {
          subir(p, ascensor, id, accion);
            } else if(piso==p){
              stay(p, ascensor, id, accion);
                }
      
                
      
    }



    //Método modificador que simula la subida del ascensor. Muestra un mensaje cuando
    //el ascensor ha llegado al destino.
    
    public synchronized void subir(int p, int asc, int id, String accion) {
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
      switch (accion) {
        case "sube":
          ctrl.AscensorIN(this.id, asc, id);
          break;
        case "baja":
        ctrl.AscensorOUT(this.id, asc, id);
          break;
      
        default:
          break;
      }
      notifyAll();
    }

    

    //Método modificador que simula la bajada del ascensor. Muestra un mensaje cuando
    //el ascensor ha llegado al destino.
    public synchronized void bajar(int p, int asc, int id, String accion) {
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
      switch (accion) {
        case "sube":
          ctrl.AscensorIN(this.id, asc, id);
          break;
        case "baja":
        ctrl.AscensorOUT(this.id, asc, id);
          break;
      
        default:
          break;
      }
      notifyAll();
    }

    public synchronized void stay(int p, int asc, int id, String accion) {

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

      switch (accion) {
        case "sube":
          ctrl.AscensorIN(this.id, asc, id);
          
          break;
        case "baja":
        ctrl.AscensorOUT(this.id, asc, id);
          break;
      
        default:
          break;
      }
      
      notifyAll();
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

