/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author leledezma
 */
 /**
   * Programa que prueba el funcionamiento de Ascensor.
   * [Ejemplo]
   * 
   * @version 1.0
   */

  class SubirAscensor extends Thread{
    private Ascensor ascensor;

    public SubirAscensor(Ascensor asc) {
      ascensor = asc;
    }

    public void run() {
      for(;;)
        ascensor.subir(ascensor.piso() + 3, "Sube 3 pisos.");
    }
  }

  class BajarAscensor extends Thread{
    private Ascensor ascensor;

    public BajarAscensor(Ascensor asc) {
      ascensor = asc;
    }

    public void run() {
      for(;;)
        ascensor.bajar(ascensor.piso() - 2, "Baja 2 pisos.");
    }
  }

  public class PruebaAscensor {
    //Programa principal
    public static void main (String[] args) {
      Ascensor ascensor;
      ascensor = new Ascensor(1);

      new SubirAscensor(ascensor).start();
      //new SubirAscensor(ascensor).start();
      //new SubirAscensor(ascensor).start();
      new BajarAscensor(ascensor).start();
      //new BajarAscensor(ascensor).start();
    }

  }

