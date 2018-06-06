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
    static boolean disponipilidadePista;
    
    @Override
    public void run() {
	while(true) {
            pistaDisponivel(false);
			
            try {
		Thread.sleep(3000);
            } catch (InterruptedException e) {
		e.printStackTrace();
            }		
			
            pistaDisponivel(true);						
            try {
		Thread.sleep(3000);
            } catch (InterruptedException e) {
                    e.printStackTrace();
            }
	}
    }
	
    //Este método verifica se a pista esta disponivel se nao faz todos esperarem
    public synchronized void aguardarPistaDisponivel() {
	try {
            wait();
	} catch (InterruptedException e) {
            e.printStackTrace();
        }					
    }
	
    //Este metódo recebe a disponibilidade da pista e então acorda todo mundo
    public synchronized void pistaDisponivel(boolean disponivel) {
	disponipilidadePista = disponivel;				
	notifyAll();
    }
}
