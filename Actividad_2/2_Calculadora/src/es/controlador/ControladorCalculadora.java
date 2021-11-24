package es.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import es.modelo.Calculadora;
import es.vista.VistaCalculadora;

public class ControladorCalculadora implements ActionListener {
	
	private Calculadora calculadora;
	private VistaCalculadora vista;
	private String historialNumeros = "";
	private String resultado = "";
	private String numeroAux = "";


	public ControladorCalculadora(VistaCalculadora vista, Calculadora calculadora) {
		// TODO Auto-generated constructor stub
		this.calculadora = calculadora;
		this.vista = vista;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		System.out.println(e.getActionCommand());
		switch(e.getActionCommand()) {
			case "uno":
				vista.setUltimoNumero("1");
				if (numeroAux.equals(""))
					numeroAux = "1";
				else {
					System.out.println("llego");
					numeroAux +=  "1";
				}
				vista.setPantalla(numeroAux);
				break;
			case "+":
				operar("+");
				vista.setNuevaOperacion(false);
				vista.setOperacion("+");
				numeroAux = "";
				break;
			case "=":
				operar("=");
				break;
				
				
		}
	
	}
	
	private void operar(String c) {
		System.out.println("antes");

		System.out.println("historial: " + historialNumeros);
		System.out.println("resultado: " + resultado);
		System.out.println("aux: " + numeroAux);

		if (historialNumeros.equals("")) {
			historialNumeros = numeroAux;
		}

		if (c.equals("+") && !vista.getNuevaOperacion()) {
			
				
			
				resultado = String.valueOf(Double.valueOf(historialNumeros) + Double.valueOf(numeroAux)); //el resultado es lo que ya tenia antes y el historial
				historialNumeros = resultado;
				vista.setPantalla(resultado);

			
		} else if (c.equals("=")) {
			if (vista.getOperacion().equals("+"))
			{
				if (!historialNumeros.equals(""))
					resultado = String.valueOf(Double.valueOf(numeroAux) + Double.valueOf(historialNumeros));
				else
					resultado = String.valueOf(Double.valueOf(numeroAux) + Double.valueOf(resultado));

				vista.setPantalla(resultado);
				vista.setNuevaOperacion(true);
			}
		}
		//debug
		System.out.println("despues");

		System.out.println("historial: " + historialNumeros);
		System.out.println("resultado: " + resultado);
		System.out.println("aux: " + numeroAux);
		
		
	}

}

