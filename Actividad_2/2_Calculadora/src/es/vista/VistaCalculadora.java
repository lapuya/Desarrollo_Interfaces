package es.vista;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import es.controlador.ControladorCalculadora;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VistaCalculadora extends JFrame {
	
	private JPanel contentPane;
	
	private JButton boton0;
	private JButton boton1;
	private JButton boton2;
	private JButton boton3;
	private JButton boton4;
	private JButton boton5;
	private JButton boton6;
	private JButton boton7;
	private JButton boton8;
	private JButton boton9;
	private JButton botonPunto;
	private JButton botonResultado;
	private JButton botonCubica;
	private JButton botonCuadrada;
	private JButton botonSuma;
	private JButton botonResta;
	private JButton botonMultiplicar;
	private JButton botonDividir;
	private JButton botonBorrar;
	private JButton botonLimpiar;
	private JLabel titulo;
	private JRadioButton botonRadioNormal;
	private JRadioButton botonRadioGaming;
	private JRadioButton botonRadioTroll;
	private JPanel panelPantalla;
	private JLabel pantalla;
	
	private String resultado = "0";
	private String operacion = "";
	private String ultimoNumero = "";
	private boolean nuevaOperacion = true;

	/**
	 * Create the panel.
	 */
	public VistaCalculadora() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 471);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		boton0 = new JButton("0");
		boton0.setBounds(17, 385, 117, 29);
		getContentPane().add(boton0);
		boton0.setActionCommand("ceri");

		
		boton1 = new JButton("1");
		boton1.setActionCommand("uno");
		boton1.setBounds(17, 344, 117, 29);
		getContentPane().add(boton1);
		
		boton2 = new JButton("2");
		boton2.setBounds(149, 344, 117, 29);
		getContentPane().add(boton2);
		boton2.setActionCommand("dos");

		
		boton3 = new JButton("3");
		boton3.setBounds(278, 344, 117, 29);
		getContentPane().add(boton3);
		boton3.setActionCommand("tres");

		
		boton4 = new JButton("4");
		boton4.setBounds(17, 303, 117, 29);
		getContentPane().add(boton4);
		boton4.setActionCommand("cuatro");

		
		boton5 = new JButton("5");
		boton5.setBounds(149, 303, 117, 29);
		getContentPane().add(boton5);
		boton5.setActionCommand("cinco");

		
		boton6 = new JButton("6");
		boton6.setBounds(278, 303, 117, 29);
		getContentPane().add(boton6);
		boton6.setActionCommand("seis");

		
		boton7 = new JButton("7");
		boton7.setBounds(17, 262, 117, 29);
		getContentPane().add(boton7);
		boton7.setActionCommand("siete");

		
		boton8 = new JButton("8");
		boton8.setBounds(149, 262, 117, 29);
		getContentPane().add(boton8);
		boton8.setActionCommand("ocho");

		
		boton9 = new JButton("9");
		boton9.setBounds(278, 262, 117, 29);
		getContentPane().add(boton9);
		boton9.setActionCommand("nueve");

		
		botonPunto = new JButton(".");
		botonPunto.setBounds(525, 385, 117, 29);
		getContentPane().add(botonPunto);
		botonPunto.setActionCommand(".");

		
		botonResultado = new JButton("=");
		botonResultado.setBounds(525, 262, 117, 29);
		getContentPane().add(botonResultado);
		botonResultado.setActionCommand("=");

		
		
		botonCubica = new JButton("∛");
		botonCubica.setBounds(146, 385, 117, 29);
		getContentPane().add(botonCubica);
		botonCubica.setActionCommand("∛");

		
		botonCuadrada = new JButton("√");
		botonCuadrada.setBounds(278, 385, 117, 29);
		getContentPane().add(botonCuadrada);
		botonCuadrada.setActionCommand("√");

		
		botonSuma = new JButton("+");
		botonSuma.setBounds(406, 262, 117, 29);
		getContentPane().add(botonSuma);
		botonSuma.setActionCommand("+");

		
		botonResta = new JButton("-");
		botonResta.setBounds(407, 303, 117, 29);
		getContentPane().add(botonResta);
		botonResta.setActionCommand("-");

		
		botonMultiplicar = new JButton("x");
		botonMultiplicar.setBounds(407, 344, 117, 29);
		getContentPane().add(botonMultiplicar);
		botonMultiplicar.setActionCommand("x");

		
		botonDividir = new JButton("/");
		botonDividir.setBounds(406, 385, 117, 29);
		getContentPane().add(botonDividir);
		botonDividir.setActionCommand("/");

		
		botonBorrar = new JButton("DEL");
		botonBorrar.setBounds(525, 303, 117, 29);
		getContentPane().add(botonBorrar);
		botonBorrar.setActionCommand("delete");

		
		botonLimpiar = new JButton("CLEAN");
		botonLimpiar.setBounds(525, 344, 117, 29);
		getContentPane().add(botonLimpiar);
		botonLimpiar.setActionCommand("clean");

		
		titulo = new JLabel("Just a Normal Calculator :)");
		titulo.setBounds(237, 18, 176, 42);
		getContentPane().add(titulo);
		
		botonRadioNormal = new JRadioButton("Normal Version");
		botonRadioNormal.setSelected(true);
		botonRadioNormal.setBounds(41, 59, 141, 23);
		getContentPane().add(botonRadioNormal);
		
		botonRadioGaming = new JRadioButton("Gaming Version");
		botonRadioGaming.setBounds(261, 59, 141, 23);
		getContentPane().add(botonRadioGaming);
		
		botonRadioTroll = new JRadioButton("TrollVersion");
		botonRadioTroll.setBounds(508, 59, 141, 23);
		getContentPane().add(botonRadioTroll);
		
		panelPantalla = new JPanel();
		panelPantalla.setBackground(Color.WHITE);
		panelPantalla.setBounds(22, 110, 620, 88);
		getContentPane().add(panelPantalla);
		panelPantalla.setLayout(null);
		
		pantalla = new JLabel(resultado);
		pantalla.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		pantalla.setHorizontalAlignment(SwingConstants.RIGHT);
		pantalla.setBounds(6, 6, 608, 74);
		panelPantalla.add(pantalla);

	}

	public void init() {
		// TODO Auto-generated method stub
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
	
	public void setControlador(ControladorCalculadora c) {
		boton0.addActionListener(c);
		boton1.addActionListener(c);
		boton2.addActionListener(c);
		boton3.addActionListener(c);
		boton4.addActionListener(c);
		boton5.addActionListener(c);
		boton6.addActionListener(c);
		boton7.addActionListener(c);
		boton8.addActionListener(c);
		boton9.addActionListener(c);
		botonPunto.addActionListener(c);
		botonResultado.addActionListener(c);
		botonCubica.addActionListener(c);
		botonCuadrada.addActionListener(c);
		botonSuma.addActionListener(c);
		botonResta.addActionListener(c);
		botonMultiplicar.addActionListener(c);
		botonDividir.addActionListener(c);
		botonBorrar.addActionListener(c);
		botonLimpiar.addActionListener(c);
		botonResultado.addActionListener(c);
	}

	public void setPantalla(String value) {
		// TODO Auto-generated method stub
		pantalla.setText(value);
	}

	public void setUltimoNumero(String numero) {
		ultimoNumero = numero;
		
	}

	public String getUltimoNumero() {
		// TODO Auto-generated method stub
		return ultimoNumero;
	}

	public void setOperacion(String op) {
		// TODO Auto-generated method stub
		operacion = op;
		
	}

	public void setNuevaOperacion(boolean b) {
		nuevaOperacion =  b;
		
	}

	public boolean getNuevaOperacion() {
		// TODO Auto-generated method stub
		return nuevaOperacion;
	}

	public String getOperacion() {
		// TODO Auto-generated method stub
		return operacion;
	}

}

