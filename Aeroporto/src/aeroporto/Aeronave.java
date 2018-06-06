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
            System.out.println("Aeronave Entrando no Espaço Aerio!");
            aeronaves();
            try {
                Thread.sleep(Pista.sleepTime());
            } catch (InterruptedException ex) {
                Logger.getLogger(Aeronave.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
	
    public void decolar() {
	System.out.println("Avião " + nome + " está decolando!");
    }
	
    public void voar() {
	try {
            Thread.sleep(2000);
	} catch (InterruptedException e) {
            e.printStackTrace();
	}
		
	System.out.println("Avião " + nome + " voando!");
    }
	
    public void aterrissar() {
        System.out.println("Avião " + nome + " pousou!");
    }
}
