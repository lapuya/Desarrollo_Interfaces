package es.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import es.modelo.Calculadora;
import es.vista.VistaCalculadora;

public class ControladorCalculadora implements ActionListener {

	private Calculadora calculadora;
	private VistaCalculadora vista;
	private String resultado = "";
	private String primerNumero = "";
	private String segundoNumero ="";
	private boolean esSegundoNumero = false;
	private String operacionAnterior = "";
	private boolean nuevaOperacion = false;

	public ControladorCalculadora(VistaCalculadora vista, Calculadora calculadora) {
		// TODO Auto-generated constructor stub
		this.calculadora = calculadora;
		this.vista = vista;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//cogemos el boton del usuario
		try {
			switch(e.getActionCommand()) {
				case "+":
					operar("+");
					break;
				case "-":
					operar("-");
					break;
				case "x":
					operar("x");
					break;
				case "/":
					operar("/");
					break;
				case "∛":
					operar("∛");
					break;
				case "√":
					operar("√");
					break;
				case ".":
					if(!esSegundoNumero) {
						if (primerNumero.length() > 0 && !primerNumero.equals("0")) {
							primerNumero += ".";
							vista.setPantalla(primerNumero);
						}
					} else {
						if (segundoNumero.length() > 0 && !segundoNumero.equals("0")) {
							segundoNumero += ".";
							vista.setPantalla(segundoNumero);
						}
					}
					break;
				case "delete":
					if(!esSegundoNumero) {
						if (!primerNumero.equals("0")) {
							if (primerNumero.length() == 1) {
								primerNumero = "";
								vista.setPantalla("0");

							}else {
								if (primerNumero.length() == 0) {
									primerNumero = "";
									vista.setPantalla("0");
								} else {
									primerNumero = primerNumero.substring(0, primerNumero.length() - 1);
									vista.setPantalla(primerNumero);
								}
							}
						}
					}
					vista.setOperacion("delete");
					operacionAnterior = "delete";
					break;
				case "clean":
					reiniciarCalculadora();
					vista.setOperacion("clean");
					break;

				case "=":
					if (vista.getOperacion().equals("+"))
						resultado = String.valueOf(calculadora.suma(Double.valueOf(primerNumero), Double.valueOf(segundoNumero)));
					else if (vista.getOperacion().equals("-"))
						resultado = String.valueOf(calculadora.resta(Double.valueOf(primerNumero), Double.valueOf(segundoNumero)));
					else if (vista.getOperacion().equals("x"))
						resultado = String.valueOf(calculadora.multiplicacion(Double.valueOf(primerNumero), Double.valueOf(segundoNumero)));
					else if (vista.getOperacion().equals("/"))
						resultado = String.valueOf(calculadora.division(Double.valueOf(primerNumero), Double.valueOf(segundoNumero)));

					vista.setOperacion("=");
					operacionAnterior = "=";
					vista.setPantalla(resultado);
					break;
				case "uno":
					botonNumero("1");
					break;
				case "dos":
					botonNumero("2");

					break;
				case "tres":
					botonNumero("3");

					break;
				case "cuatro":
					botonNumero("4");

					break;
				case "cinco":
					botonNumero("5");

					break;
				case "seis":
					botonNumero("6");


					break;
				case "siete":
					botonNumero("7");

					break;
				case "ocho":
					botonNumero("8");

					break;
				case "nueve":
					botonNumero("9");
					break;
				case "cero":
					botonNumero("0");
					break;


			}
		} catch (IllegalArgumentException iae) {
			resultado = "ERROR. REINICIANCO CALCULADORA....";
			reiniciarCalculadora();

		}

	}


	private void reiniciarCalculadora() {
		vista.setPantalla("0");
		primerNumero = "";
		segundoNumero = "";
		esSegundoNumero = false;
		nuevaOperacion = false;
	}

	private void botonNumero(String numero) {
		System.out.println(vista.getOperacion());
		if (!vista.getOperacion().equals("=") && !vista.getOperacion().equals("clean") && !vista.getOperacion().equals("delete")) {
			System.out.println("aqui");
			if (!esSegundoNumero) { //primer numero
				if (!numero.equals("0")) {
					primerNumero += numero;
					vista.setPantalla(primerNumero);
				} else if (numero.equals("0")) {
					if (!primerNumero.equals("")) { //solo añadimos ceros en caso de que haya ya numeros para no tener 000000
						primerNumero += numero;
						vista.setPantalla(primerNumero);

					}
				}
			} else { //para el segundo numero
				segundoNumero += numero;
				vista.setPantalla(segundoNumero);
			}
			nuevaOperacion = true;
		} else {
			//si despues de = viene un numero, empezamos la calculadora
			reiniciarCalculadora();
			System.out.println("reiniciamos");
			System.out.println(primerNumero);
			System.out.println(segundoNumero);
			System.out.println(numero);

			if (!numero.equals("0")) {
				primerNumero += numero;
				vista.setPantalla(primerNumero);
			} else if (numero.equals("0")) {
				System.out.println("es cero");
				if (!primerNumero.equals("")) {
					primerNumero += numero;
					vista.setPantalla(primerNumero);
				}
			}
			vista.setOperacion("");
		}

	}

	private void operar(String c) {

		//realizara pa operacion anterior antes de seguir con la nueva operacion
		realizarOperacionAnterior();

		vista.setOperacion(c);
		if (c.equals("+")) {
			if (segundoNumero.equals(""))
				esSegundoNumero = true;
			else {
				resultado = String.valueOf(calculadora.suma(Double.valueOf(primerNumero), Double.valueOf(segundoNumero)));
				primerNumero = resultado;
				segundoNumero = "";
				vista.setPantalla(resultado);
			}
		} else if (c.equals("-") ) {
			if (segundoNumero.equals(""))
				esSegundoNumero = true;
			else {
				resultado = String.valueOf(calculadora.resta(Double.valueOf(primerNumero), Double.valueOf(segundoNumero)));
				primerNumero = resultado;
				segundoNumero = "";
				vista.setPantalla(resultado);
			}
		} else if (c.equals("x")) {
			if (segundoNumero.equals(""))
				esSegundoNumero = true;
			else {
				resultado = String.valueOf(calculadora.multiplicacion(Double.valueOf(primerNumero), Double.valueOf(segundoNumero)));
				primerNumero = resultado;
				segundoNumero = "";
				vista.setPantalla(resultado);
			}
		} else if (c.equals("/")) {
			if (segundoNumero.equals(""))
				esSegundoNumero = true;
			else {
				resultado = String.valueOf(calculadora.division(Double.valueOf(primerNumero), Double.valueOf(segundoNumero)));
				primerNumero = resultado;
				segundoNumero = "";
				vista.setPantalla(resultado);
			}
		} else if (c.equals("∛")) {
			if (!primerNumero.equals("")) {
				resultado = String.valueOf(calculadora.raizCubica(Double.valueOf(primerNumero)));
				primerNumero = resultado;
				vista.setPantalla(resultado);
			}
		} else if (c.equals("√")) {
			if (!primerNumero.equals("")) {
				resultado = String.valueOf(calculadora.raizCuadrada(Double.valueOf(primerNumero)));
				primerNumero = resultado;
				vista.setPantalla(resultado);
			}
		}
		operacionAnterior = vista.getOperacion();
		nuevaOperacion = false;
	}

	private void realizarOperacionAnterior() {
		if (nuevaOperacion && !segundoNumero.equals("")) {
			if (operacionAnterior.equals("+"))
				resultado = String.valueOf(calculadora.suma(Double.valueOf(primerNumero), Double.valueOf(segundoNumero)));
			else if (operacionAnterior.equals("-"))
				resultado = String.valueOf(calculadora.resta(Double.valueOf(primerNumero), Double.valueOf(segundoNumero)));
			else if ( operacionAnterior.equals("x"))
				resultado = String.valueOf(calculadora.multiplicacion(Double.valueOf(primerNumero), Double.valueOf(segundoNumero)));
			else if ( operacionAnterior.equals("/"))
				resultado = String.valueOf(calculadora.division(Double.valueOf(primerNumero), Double.valueOf(segundoNumero)));
			else if ( operacionAnterior.equals("∛"))
				resultado = String.valueOf(calculadora.raizCubica(Double.valueOf(primerNumero)));
			else if ( operacionAnterior.equals("√"))
				resultado = String.valueOf(calculadora.raizCuadrada(Double.valueOf(primerNumero)));
			primerNumero = resultado;
			segundoNumero = "";
			vista.setPantalla(resultado);
		}

	}



}
