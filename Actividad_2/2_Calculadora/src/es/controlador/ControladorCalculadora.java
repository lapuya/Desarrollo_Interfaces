package es.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import es.modelo.Calculadora;
import es.vista.VistaCalculadora;

public class ControladorCalculadora implements ActionListener {

	private VistaCalculadora vista;
	private Calculadora modelo;
	private static final String contraseña = "grupo_9_dam";
	private int vida = 0;
	public ControladorCalculadora(VistaCalculadora vista, Calculadora modelo) {
		// TODO Auto-generated constructor stub
		this.vista = vista;
		this.modelo = modelo;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			Double numero1 = 0.0;
			Double numero2 = 0.0;
			if (e.getActionCommand().equals("∛"))
				numero1 = Double.parseDouble(vista.getNumeroUno());
			else if (e.getActionCommand().equals("√")) {
				if(vista.isGaming())
					vista.playButton("sound_effects/cubic_explosion.wav");
				vista.showSqrtError();
			}
			else  {
				numero1 = Double.parseDouble(vista.getNumeroUno());
				numero2 = Double.parseDouble(vista.getNumeroDos());
			}
			vida = Integer.valueOf(vista.getVidaRestanteValor());
			switch(e.getActionCommand()) {
				case "+":
					if(vista.isGaming()) {
						vista.playButton("sound_effects/8-bit-pop-sound-effect.wav");
						vida += 1;
					}
					vista.setResultado(String.valueOf(modelo.suma(numero1, numero2)));
					break;
				case "-":
					if(vista.isGaming()) {
						vista.playButton("sound_effects/8bit_rest.wav");
						vida -= 1;
					}
					vista.setResultado(String.valueOf(modelo.resta(numero1, numero2)));
					break;
				case "x":
					if(vista.isGaming()) {
						vista.playButton("sound_effects/8bit_mult.wav");
						vida += 2;
					}
					vista.setResultado(String.valueOf(modelo.multiplicacion(numero1, numero2)));
					break;
				case "/":
					if(vista.isGaming()) {
						vista.playButton("sound_effects/8bit_div_2.wav");
						vida -= 2;
					}
					vista.setResultado(String.valueOf(modelo.division(numero1, numero2)));
					break;
				case "∛":
						if(vista.isGaming())
					vista.playButton("sound_effects/cubic_explosion.wav");
					vista.setNumeroDos("");
					try {
						if (vista.getContraseña().equals(contraseña)) {
							if(vista.isGaming()) {
								vista.playButton("sound_effects/8bit_cubic_correct.wav");
								vida -= 3;
							}
							vista.setResultado(String.valueOf(modelo.raizCubica(Double.valueOf(vista.getNumeroUno()))));
						} else {
							if(vista.isGaming())
								vista.playButton("sound_effects/error2.wav");

							vista.showIncorrectPassword();
							limpiar();
						}
					} catch (Exception ex) {
						System.out.println("Ha cancelado la operacion");
					}
					break;
			}
			limpiar();
			if (vida == 0)
			{
				vista.setVidaRestanteValor(String.valueOf(vida));
				vista.endProgram();
			} else {
				vista.setVidaRestanteValor(String.valueOf(vida));
			}

		}  catch (NumberFormatException nbe) {
			if(vista.isGaming())
				vista.playButton("sound_effects/error2.wav");
			vista.showNumberIncorrect();
			limpiar();
		}

	}

	private void limpiar() {
		vista.setNumeroUno("Ingrese el numero 1");
		vista.setNumeroDos("Ingrese el numero 2");
	}


}
