package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import controller.ThreadCorrida;
import javax.swing.JTextField;
import java.awt.Color;

public class Tela extends JFrame {

	private JPanel contentPane;
	private JTextField tfVencedor;
	private JTextField tfSegundo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela frame = new Tela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbli = new JLabel("__________________________________________________________________");
		lbli.setBounds(10, 110, 424, 14);
		contentPane.add(lbli);
		
		JLabel lblCarro01 = new JLabel("Carro01");
		lblCarro01.setForeground(Color.RED);
		lblCarro01.setBounds(10, 85, 46, 14);
		contentPane.add(lblCarro01);
		
		JLabel lblCarro02 = new JLabel("Carro02");
		lblCarro02.setForeground(Color.BLUE);
		lblCarro02.setBounds(10, 151, 46, 14);
		contentPane.add(lblCarro02);
		
		JButton btnJogar = new JButton("Correr");
		btnJogar.setBounds(283, 189, 89, 23);
		contentPane.add(btnJogar);
		
		tfVencedor = new JTextField();
		tfVencedor.setBounds(97, 190, 86, 20);
		contentPane.add(tfVencedor);
		tfVencedor.setColumns(10);
		
		tfSegundo = new JTextField();
		tfSegundo.setColumns(10);
		tfSegundo.setBounds(97, 221, 86, 20);
		contentPane.add(tfSegundo);
		
		JLabel lblPrimeiro = new JLabel("Primeiro ");
		lblPrimeiro.setBounds(10, 193, 66, 14);
		contentPane.add(lblPrimeiro);
		
		JLabel lblSegundo = new JLabel("Segundo ");
		lblSegundo.setBounds(10, 224, 66, 14);
		contentPane.add(lblSegundo);
		
		
		
ActionListener jogar = new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				
				int altura01=85;//altura na posição da  tela do carro01
				int altura02=151;//altura na posição da tela do carro02
				Thread carro01 = new ThreadCorrida(lblCarro01, altura01, tfVencedor, tfSegundo,"Carro01");// thread que controla o carro 01 
				Thread carro02 = new ThreadCorrida(lblCarro02, altura02, tfVencedor, tfSegundo,"Carro02");// thread que controla o carro 02
				
				carro01.start();
				carro02.start();
				
				
			}
			
		};
		
		btnJogar.addActionListener(jogar);
	}
}
