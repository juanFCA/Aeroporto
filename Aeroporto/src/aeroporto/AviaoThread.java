/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aeroporto;

import static java.lang.Thread.MAX_PRIORITY;
import static java.lang.Thread.MIN_PRIORITY;
import static java.lang.Thread.NORM_PRIORITY;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juan
 */
public class AviaoThread extends Thread implements Runnable {

    private String nome;
    private Semaphore semaforo;
    private String estado;
        SimpleDateFormat d =  new SimpleDateFormat("mm:ss.SSS");
    
    public AviaoThread( String nome, Semaphore semaforo) {
        //this.nome = nome;
        this.semaforo = semaforo;
        
        this.setName(nome);
    }

    private synchronized void aviaoAterrissando() {
    
        int tempo = (int) ((Math.random() * 300) + 3000);
        try {
            this.setPriority(MAX_PRIORITY);
            this.sleep(tempo);
            semaforo.release();
            System.out.println(this.getName()+ " está Aterrissando "+ d.format(new Date()));
        } catch (InterruptedException ex) {
            Logger.getLogger(AviaoThread.class.getName()).log(Level.SEVERE, null, ex);
        }
       // aviaoTaxiandoChegada();
        //this.estado = "TaxiandoChegada";
        this.setPriority(6);
    }

     private synchronized void aviaoTaxiandoChegada() {
      // System.out.println(this.getName() + " está taxiando(Chegada)"+ d.format(new Date()));
        int tempo = (int) ((Math.random() * 200) + 2000);
        try {
            this.setPriority(NORM_PRIORITY);
            
            this.sleep(tempo);
              System.out.println(this.getName() + " está taxiando(Chegada)"+ d.format(new Date()));
        } catch (InterruptedException ex) {
            Logger.getLogger(AviaoThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        //aviaoEstacionado();
        // this.estado = "Estacionado";
        this.setPriority(5);
    }
    private synchronized void aviaoDecolando() {
        
        int tempo = (int) ((Math.random() * 300) + 2000);
        try {
           this.setPriority(MAX_PRIORITY); 
            this.sleep(tempo);
            System.out.println(this.getName()+ " está Decolando "+ d.format(new Date()));
            semaforo.release();
            
           //semaforo.notifyAll();
        } catch (InterruptedException ex) {
            Logger.getLogger(AviaoThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        // this.estado = null;
     
        this.setPriority(4);
    }

   

    private synchronized void aviaoTaxiandoSaida() {
       
        int tempo = (int) ((Math.random() * 200) + 2000);
        try {
            this.setPriority(NORM_PRIORITY);
            this.sleep(tempo);
             System.out.println(this.getName()+ " está taxiando(Saida)"+ d.format(new Date()));
        } catch (InterruptedException ex) {
            Logger.getLogger(AviaoThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        //aviaoDecolando();
        //  this.estado = "Decolando";
        this.setPriority(3);
    }

    private synchronized void aviaoEstacionado() {
        
        int tempo = (int) ((Math.random() * 300) + 500);
        try {
            this.setPriority(MIN_PRIORITY);
            this.sleep(tempo);
            System.out.println(this.getName()+" está Estacionado"+ d.format(new Date()));
        } catch (InterruptedException ex) {
            Logger.getLogger(AviaoThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        //aviaoTaxiandoSaida();
        //this.estado = "TaxiandoSaida";
        this.setPriority(1);
    }
    
 
    
    @Override

    public void run() {



        try {
            
            semaforo.acquire();
            aviaoAterrissando();
            aviaoTaxiandoChegada();
            aviaoEstacionado();
            aviaoTaxiandoSaida();
            aviaoDecolando();       
            
          
        } catch (InterruptedException ex) {
            Logger.getLogger(AviaoThread.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
