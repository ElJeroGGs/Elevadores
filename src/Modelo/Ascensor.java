/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author leledezma
 */
 public class Ascensor extends Thread{

    //Atributo privado
    private int piso;
    private boolean parado;
    private int id;

    //Constructor de la clase
    public Ascensor(int id) {
      piso = 0;
      parado = true;
      this.id = id;
    }

    //Método que si dada la posición del ascensor y el piso desde el que le llaman,
    //controla si el ascensor sube o baja
    public synchronized void llamar(int p, String mensaje) {


      while(!parado) {
        try {
          wait();
        } catch (InterruptedException e) {
          return ;
        }
      }
      
      if(piso > p) {
        bajar(p, mensaje);
        } else if(piso < p) {
          subir(p, mensaje);
            } else if(piso==p){
              stay(p, mensaje);
                }

      
    }

    //Método modificador que simula la subida del ascensor. Muestra un mensaje cuando
    //el ascensor ha llegado al destino.
    
    public synchronized void subir(int p, String mensaje) {
      while(!parado) {
        try {
          wait();
        } catch (InterruptedException e) {
          return ;
        }
      }
      parado = false;
      while (piso != p) {
        ++piso;
        System.out.println("Ascensor " + this.id+ " en el piso " + piso);
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          return ;
        }
      }
      parado = true;
      System.out.println(mensaje);
      notifyAll();
    }

    

    //Método modificador que simula la bajada del ascensor. Muestra un mensaje cuando
    //el ascensor ha llegado al destino.
    public synchronized void bajar(int p, String mensaje) {
      while(!parado) {
        try {
          wait();
        } catch (InterruptedException e) {
          return ;
        }
      }
      parado = false;
      while (piso != p) {
        --piso;
        System.out.println("Ascensor "+this.id+ " en el piso " + piso);
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          return ;
        }
      }
      parado = true;
      System.out.println(mensaje);
      notifyAll();
    }

    public synchronized void stay(int p, String mensaje) {

      while(!parado) {
        try {
          wait();
        } catch (InterruptedException e) {
          return ;
        }
      }
      parado = false;

        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          return ;
        }
      
      parado = true;
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

