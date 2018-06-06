/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aeroporto;

/**
 *
 * @author jonas
 */
public class Aeroporto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Primeiro instanciamos uma pista
        Pista pista = new Pista();
        
        Aeronave a1 = new Aeronave("VOO 1", pista);
        Aeronave a2 = new Aeronave("VOO 2", pista);
        Aeronave a3 = new Aeronave("VOO 3", pista);
        Aeronave a4 = new Aeronave("VOO 4", pista);
        Aeronave a5 = new Aeronave("VOO 5", pista);
		
        pista.start();
        a1.start();
        a2.start();
        a3.start();
        a4.start();
        a5.start();
    }
    
}
