/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aeroporto;

import java.util.concurrent.Semaphore;
/**
 *
 * @author juan
 */
public class Aeroporto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int permissoes = 1;
        int numAvioes = 10;

        Semaphore semaforo = new Semaphore(permissoes);
        System.out.println("Log da Torre de controle:\n");
        for (int i = 1; i <= numAvioes; i++) {
            Thread t = new AviaoThread("Avião #"+i, semaforo);
            t.start();
        }
    }
    
}
