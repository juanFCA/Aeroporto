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
       
        Pista p = new Pista();
        Thread tp = new Thread(p);
        
        Aeronave a = new Aeronave();
        Thread ta = new Thread(a);
        
        tp.start();
        ta.start();
    }
      
}
