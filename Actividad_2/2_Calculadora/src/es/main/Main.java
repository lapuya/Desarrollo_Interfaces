package es.main;


import es.controlador.ControladorCalculadora;
import es.modelo.Calculadora;
import es.vista.VistaCalculadora;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		//Modelo
		Calculadora modelo = new Calculadora();
					
		//vista
		VistaCalculadora vista = new VistaCalculadora();
					
		//Controlador
		ControladorCalculadora controlador = new ControladorCalculadora(vista, modelo);

		vista.setControlador(controlador);
		
		//arrancamos
		vista.init();



	}

}
