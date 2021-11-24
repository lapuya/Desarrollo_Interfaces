package es.modelo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import es.vista.VistaCalculadora;

public class Calculadora  {
	
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
	
	public Double suma(double num1, double num2) {
		return num1 + num2;
	}
	
	public Double resta() {
		return num1 - num2;
	}
	
	public Double multiplicacion() {
		return num1 * num2;
	}
	
	public Double division() {
		return num1 / num2;
	}

	public double raizCubica() {
		return Math.pow(num1, 1/3);
	}

}
