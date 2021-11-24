package es.controlador;

import es.modelo.Calculadora;
import es.vista.VistaCalculadora;

public class ControladorCalculadora {



	public static void main(String[] args) {
		
		VistaCalculadora miCalculadora = new VistaCalculadora();
		ControladorCalculadora miControlador = new ControladorCalculadora(miCalculadora, null);
		
	}
	public ControladorCalculadora(VistaCalculadora vista, Calculadora modelo) {
		// TODO Auto-generated constructor stub
	}
}
