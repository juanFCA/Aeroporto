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
public class Aeronave extends Thread{
        
    public void aeronaves(){
        Pista.mutex.P();
        Pista.esperandoAterrissar++;
        Pista.semaforoAeronave.V();
        Pista.semaforoPista.V();
    }
    
    @Override
    public void run(){
        while(true){
            aeronaves();
            System.out.println("Aeronave Entrando no Espaço Aerio!");
            try {
                Thread.sleep(Pista.sleepTime());
            } catch (InterruptedException ex) {
                Logger.getLogger(Aeronave.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
