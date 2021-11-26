package es.modelo;

public class Calculadora {

	public Double suma(double num1, double num2) {
		// TODO Auto-generated method stub
		return num1 + num2;
	}

	public Double resta(double num1, double num2) {
		return num1 - num2;
	}

	public Double multiplicacion(double num1, double num2) {
		return num1 * num2;
	}

	public Double division(double num1, double num2) {
		return num1 / num2;
	}

	public double raizCubica(double num1) {
		return Math.cbrt(num1);
	}

	public Double raizCuadrada(double num1) {
		return Math.sqrt(num1);
	}

}
