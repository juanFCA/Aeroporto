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
public class Aeronave extends Thread{
    
    private String nome;
    private Pista pista;
	
    public Aeronave(String nome, Pista pista) {
	this.nome = nome;
        this.pista = pista;
    }
	
    @Override
    public void run() {
		
	System.out.println("Avião " + nome + " solicitando disponibilidade da pista!");
	pista.aguardarPistaDisponivel();
	decolar();
	voar();
	pista.aguardarPistaDisponivel();
        aterrissar();
		
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
