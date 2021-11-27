package es.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import es.modelo.Calculadora;
import es.vista.VistaCalculadora;

public class ControladorCalculadora implements ActionListener {

	private VistaCalculadora vista;
	private Calculadora modelo;
	private Double resultado;
	private static final String contraseña = "grupo_9_dam";
	public ControladorCalculadora(VistaCalculadora vista, Calculadora modelo) {
		// TODO Auto-generated constructor stub
		this.vista = vista;
		this.modelo = modelo;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		try {
			Double numero1 = Double.parseDouble(vista.getNumeroUno());
			Double numero2 = Double.parseDouble(vista.getNumeroDos());
			switch(e.getActionCommand()) {
				case "+":
					if(vista.isGaming())
						vista.playButton("sound_effects/8-bit-pop-sound-effect.wav");
					vista.setResultado(String.valueOf(modelo.suma(numero1, numero2)));
					break;
				case "-":
					if(vista.isGaming())
						vista.playButton("sound_effects/8bit_rest.wav");
					vista.setResultado(String.valueOf(modelo.resta(numero1, numero2)));
					break;
				case "x":
					if(vista.isGaming())
						vista.playButton("sound_effects/8bit_mult.wav");
					vista.setResultado(String.valueOf(modelo.multiplicacion(numero1, numero2)));
					break;
				case "/":
					if(vista.isGaming())
						vista.playButton("sound_effects/8bit_div_2.wav");
					vista.setResultado(String.valueOf(modelo.division(numero1, numero2)));
					break;
				case "√":
					if(vista.isGaming())
						vista.playButton("sound_effects/8bit_sqrt_2.wav");
					vista.showSqrtError();
					break;
				case "∛":
						if(vista.isGaming())
					vista.playButton("sound_effects/cubic_explosion.wav");
					vista.setNumeroDos("");
					if (vista.getContraseña().equals(contraseña)) {
						if(vista.isGaming())
							vista.playButton("sound_effects/8bit_cubic_correct.wav");
						vista.setResultado(String.valueOf(modelo.raizCubica(Double.valueOf(vista.getNumeroUno()))));
					} else {
						if(vista.isGaming())
							vista.playButton("sound_effects/error.wav");

						vista.showIncorrectPassword();
						limpiar();
					}
					break;
			}
			limpiar();
		}  catch (NumberFormatException nbe) {
			if(vista.isGaming())
				vista.playButton("sound_effects/error.wav");
			vista.showNumberIncorrect();
			limpiar();
		}

	}



	private void limpiar() {
		vista.setNumeroUno("Ingrese el numero 1");
		vista.setNumeroDos("Ingrese el numero 2");
	}


}
