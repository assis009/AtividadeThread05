package controller;

import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class ThreadCorrida extends Thread {
	
	JLabel lblcarro;
	int altura=0;
	static int chegada=0;	
	JTextField tfVencedor;
	JTextField tfSegundo;
	String carro="";
	
	public ThreadCorrida(JLabel lblcarro, int altura, JTextField tfVencedor, JTextField tfSegundo, String carro) {
		
		this.lblcarro = lblcarro;
		this.altura = altura;
		this.tfVencedor = tfVencedor;
		this.tfSegundo = tfSegundo;
		this.carro= carro;
		this.chegada=0;//
	}
	
	public void run() {
		
		Random geradorVelo = new Random();//geradorVelo gera a valocidade aleatoria 
		int velocidade =0;
		int auxiliar=0;
		
		
		while(velocidade<390){//enquanto o carro não passar o limite na tela, ira continuar "correndo"
			try {
				Thread.sleep(100);//Deixa a Thread dormindo por 100 mile segundos 
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			auxiliar =geradorVelo.nextInt(50);//pega o valor aleatorio e atribui a variavel auxiliar 
			velocidade +=auxiliar;//soma o valor aleatorio a velocidade 
			
			lblcarro.setBounds(velocidade,altura,46, 14);//movimenta o carro na tela 
			
		}
		
		chegada++;//soma 1 a variavel chegada
		
		if(chegada==1) {// se a variavel for igual 1 o carro foi vencedor 
			tfVencedor.setText(carro);
		}
		else{tfSegundo.setText(carro);// se for igual a 2 ficara em segundo 
		}
	}
}
