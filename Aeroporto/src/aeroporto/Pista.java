/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aeroporto;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jonas
 */
public class Pista extends Thread{
    //Filas na pista:
    static int esperandoDecolar = 0;
    static int esperandoAterrissar = 0;
    static int taxiandoDecolar = 0;
    static int taxiandoAterrissar = 0;
    static int estacionadas = 0;
    //Semaforos:
    static Semaforo semaforoAeronave = new Semaforo(0);
    static Semaforo semaforoPista = new Semaforo(0);
    static Semaforo mutex = new Semaforo(1);
    
    public void decolar(){
       System.out.println("Aeronave pronta para decolar!");
       this.setPriority(5);
        try {
            Thread.sleep(sleepTime());
            System.out.println("Aeronave decolou!");
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Pista.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public void aterrissar(){
        System.out.println("Aeronave pronta para aterrissar!");
        this.setPriority(10);
        try {
            Thread.sleep(sleepTime());
            System.out.println("Aeronave aterrissou!");
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Pista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void taxiarDecolar(){
        System.out.println("Aeronave está taxiando para decolar!");
        this.setPriority(1);
        estacionadas--;
        taxiandoDecolar++;
        try {
            Thread.sleep(sleepTime());
            System.out.println("Aeronave pronta para decolar!");
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Pista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void taxiarAterrissar(){
        System.out.println("Aeronave está taxiando!");
        this.setPriority(10);
        estacionadas++;
        taxiandoAterrissar++;
        try {
            Thread.sleep(sleepTime());
            System.out.println("Aeronave estacionou!");
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Pista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static int sleepTime(){//gera um valor aleatorio para dar o tempo da thread dormir
        return (int) Math.floor(Math.random() * 6000);
    }
    
    @Override
    public void run(){
        while(true){
            if(esperandoAterrissar == 0){
                
            }
        }
    }
}
