package es.modelo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import es.vista.VistaCalculadora;

public class Calculadora implements ActionListener {
	
	private float num1;
	private float num2;
	private JLabel labelResultado;
	private VistaCalculadora ventana;
	
	public void setNum1 (float num1) {
		this.num1 = num1;
	}
	
	public void setNum2 (float num2) {
		this.num2 = num2;
	}
	
	public float suma() {
		return num1 + num2;
	}
	
	public float resta() {
		return num1 - num2;
	}
	
	public float multiplicacion() {
		return num1 * num2;
	}
	
	public float division() {
		return num1 / num2;
	}

	public double raizCubica() {
		return Math.pow(num1, 1/3);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}