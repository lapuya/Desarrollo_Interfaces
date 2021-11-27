package es.vista;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

import es.controlador.ControladorCalculadora;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.File;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import java.awt.Window.Type;

public class VistaCalculadora extends JFrame {

	private JPanelBackground contentPane;
	private JTextField resultado;
	private JTextField numeroUno;
	private JTextField numeroDos;
	private JButton botonSuma;
	private JButton botonResta;
	private JButton botonRaizCuadrada;
	private JButton botonMultiplicacion;
	private JButton botonDivision;
	private JButton botonRaizCubica;
	private JLabel Titulo;
	private JRadioButton normalVersion;
	private JRadioButton gamingVersion;
	private boolean isGaming = false;
	private JPanel panelBotones;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public VistaCalculadora() {


		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 528, 519);
		setIconImage(Toolkit.getDefaultToolkit().getImage("images/icono_calculadora.png"));
		setTitle("                \t\t       Nuestra humilde calculadora");
		contentPane = new JPanelBackground();
		contentPane.setBackground("images/fondo.png");
		//contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		normalVersion = new JRadioButton("Normal Version");
		normalVersion.setOpaque(false);
		normalVersion.setBackground(SystemColor.activeCaptionBorder);
		normalVersion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Me meto");
				isGaming = false;
				crearBotones();
				generaPantalla();
			}
		});
		normalVersion.setSelected(true);
		normalVersion.setBounds(58, 44, 141, 23);
		contentPane.add(normalVersion);

		gamingVersion = new JRadioButton("Gaming Version");
		gamingVersion.setOpaque(false);
		gamingVersion.setBackground(SystemColor.activeCaptionBorder);
		gamingVersion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setBackground("images/pixel_screen.png");
				isGaming = true;
				crearBotonesGaming();
				JOptionPane.showMessageDialog(null, "Active el sonido para mejorar la experiencia!");

				playSound();



			}
		});
		gamingVersion.setBounds(312, 44, 141, 23);
		contentPane.add(gamingVersion);

		ButtonGroup grupo = new ButtonGroup();
		grupo.add(normalVersion);
		grupo.add(gamingVersion);



		crearBotones();
		generaPantalla();


	}

	private void generaPantalla() {
		JPanel panelPantalla = new JPanel();
		panelPantalla.setBounds(44, 112, 227, 273);
		contentPane.add(panelPantalla);
		panelPantalla.setLayout(null);
		panelPantalla.setOpaque(false);


		resultado = new JTextField("");
		resultado.setFont(new Font("SansSerif", Font.BOLD, 20));
		resultado.setOpaque(false);
		resultado.setEditable(false);
		resultado.setHorizontalAlignment(SwingConstants.CENTER);
		resultado.setBounds(6, 194, 215, 59);
		panelPantalla.add(resultado);
		resultado.setColumns(10);


		numeroUno = new JTextField("Ingrese el numero 1");
		numeroUno.setFont(new Font("Tahoma", Font.PLAIN, 15));

		numeroUno.setHorizontalAlignment(SwingConstants.CENTER);
		numeroUno.setColumns(10);
		numeroUno.setBounds(6, 24, 215, 59);
		panelPantalla.add(numeroUno);
		numeroUno.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (numeroUno.getText().equals("Ingrese el numero 1")) {
					numeroUno.setText("");
					if (isGaming)
						playButton("sound_effects/mouse.wav");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (numeroUno.getText().equals("")) {
					numeroUno.setText("Ingrese el numero 1");
				}
			}
		});
		numeroUno.setOpaque(false);

		numeroDos = new JTextField("Ingrese el numero 2");
		numeroDos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		numeroDos.setOpaque(false);
		numeroDos.setHorizontalAlignment(SwingConstants.CENTER);
		numeroDos.setColumns(10);
		numeroDos.setBounds(6, 111, 215, 59);
		panelPantalla.add(numeroDos);

		Titulo = new JLabel("iCalculadora");
		Titulo.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		Titulo.setHorizontalAlignment(SwingConstants.CENTER);
		Titulo.setBounds(155, 17, 162, 16);
		contentPane.add(Titulo);


		numeroDos.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (numeroDos.getText().equals("Ingrese el numero 2")) {
					numeroDos.setText("");
					if (isGaming)
						playButton("sound_effects/mouse.wav");

				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (numeroDos.getText().equals("")) {
					numeroDos.setText("Ingrese el numero 2");
				}
			}
		});

	}

	private void crearBotones() {
		panelBotones = new JPanel();
		panelBotones.setBounds(295, 112, 176, 273);
		contentPane.add(panelBotones);
		panelBotones.setLayout(null);
		panelBotones.setOpaque(false);


		botonSuma = new JButton("+");
		botonSuma.setFont(new Font("Tahoma", Font.PLAIN, 25));
		botonSuma.setBackground(SystemColor.scrollbar);
		botonSuma.setBounds(6, 20, 75, 71);
		panelBotones.add(botonSuma);
		botonSuma.setActionCommand("+");

		botonResta = new JButton("-");
		botonResta.setFont(new Font("Tahoma", Font.PLAIN, 25));
		botonResta.setBackground(SystemColor.scrollbar);
		botonResta.setBounds(6, 103, 75, 71);
		panelBotones.add(botonResta);
		botonResta.setActionCommand("-");


		botonRaizCuadrada = new JButton("√");
		botonRaizCuadrada.setFont(new Font("Tahoma", Font.PLAIN, 25));
		botonRaizCuadrada.setBackground(SystemColor.scrollbar);
		botonRaizCuadrada.setBounds(6, 186, 75, 71);
		panelBotones.add(botonRaizCuadrada);
		botonRaizCuadrada.setActionCommand("√");


		botonMultiplicacion = new JButton("x");
		botonMultiplicacion.setFont(new Font("Tahoma", Font.PLAIN, 25));
		botonMultiplicacion.setBackground(SystemColor.scrollbar);
		botonMultiplicacion.setBounds(93, 20, 75, 71);
		panelBotones.add(botonMultiplicacion);

		botonMultiplicacion.setActionCommand("x");


		botonDivision = new JButton("/");
		botonDivision.setFont(new Font("Tahoma", Font.PLAIN, 25));
		botonDivision.setBackground(SystemColor.scrollbar);
		botonDivision.setBounds(93, 103, 75, 71);
		panelBotones.add(botonDivision);
		botonDivision.setActionCommand("/");




		botonRaizCubica = new JButton("√³");
		botonRaizCubica.setFont(new Font("Tahoma", Font.PLAIN, 25));
		//setIconImage(Toolkit.getDefaultToolkit().getImage("images/raiz_cubica.png")); intentando poner icono, ya que no coge el símbolo
		botonRaizCubica.setBackground(SystemColor.scrollbar);
		botonRaizCubica.setBounds(93, 186, 78, 71);
		panelBotones.add(botonRaizCubica);
		botonRaizCubica .setActionCommand("∛");
	}

	private void crearBotonesGaming() {
		// TODO Auto-generated method stub

		cambiarBotonAGaming(botonSuma, "images/pocion_suma.png");
		cambiarBotonAGaming(botonResta, "images/daga_resta.png");
		cambiarBotonAGaming(botonMultiplicacion, "images/pocion_mult.png");
		cambiarBotonAGaming(botonDivision, "images/cazuela_division.png");
		cambiarBotonAGaming(botonRaizCuadrada, "images/antorcha_sqrt.png");
		cambiarBotonAGaming(botonRaizCubica, "images/fuego_cubico.png");

	}

	private void cambiarBotonAGaming(JButton b, String path) {
		ImageIcon imageIcon = new ImageIcon(path);
		Image image = imageIcon.getImage(); // transform it
		Image newimg = image.getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		imageIcon = new ImageIcon(newimg);
		b.setText("");
		b.setIcon(imageIcon);
		b.setBorderPainted(false);
	}

	private void crearBotonesNormales() {
		// TODO Auto-generated method stub
		panelBotones = new JPanel();
		panelBotones.setBounds(295, 79, 317, 273);
		contentPane.add(panelBotones);
		panelBotones.setLayout(null);
		panelBotones.setOpaque(false);


		botonSuma = new JButton("+");
		botonSuma.setBounds(6, 20, 145, 71);
		panelBotones.add(botonSuma);
		botonSuma.setActionCommand("+");

		botonResta = new JButton("-");
		botonResta.setBounds(6, 103, 145, 71);
		panelBotones.add(botonResta);
		botonResta.setActionCommand("-");


		botonRaizCuadrada = new JButton("√");
		botonRaizCuadrada.setBounds(6, 186, 145, 71);
		panelBotones.add(botonRaizCuadrada);
		botonRaizCuadrada.setActionCommand("√");


		botonMultiplicacion = new JButton();
		botonMultiplicacion.setText("");
		botonMultiplicacion.setBounds(166, 20, 145, 71);
		panelBotones.add(botonMultiplicacion);
		botonMultiplicacion.setBorderPainted(false);

		botonMultiplicacion.setActionCommand("x");


		botonDivision = new JButton("/");
		botonDivision.setBounds(163, 103, 145, 71);
		panelBotones.add(botonDivision);
		botonDivision.setActionCommand("/");


		botonRaizCubica = new JButton("∛");
		botonRaizCubica.setBounds(163, 186, 145, 71);
		panelBotones.add(botonRaizCubica);
		botonRaizCubica	.setActionCommand("∛");

	}

	public void setControlador(ControladorCalculadora controlador) {
		// TODO Auto-generated method stub
		botonSuma.addActionListener(controlador);
		botonResta.addActionListener(controlador);
		botonMultiplicacion.addActionListener(controlador);
		botonDivision.addActionListener(controlador);
		botonRaizCuadrada.addActionListener(controlador);
		botonRaizCubica.addActionListener(controlador);
	}

	public void init() {
		// TODO Auto-generated method stub
		setLocationRelativeTo(null);
		setVisible(true);

	}

	public String getResultado() {
		return resultado.getText();
	}

	public void setResultado(String resultado) {
		this.resultado.setText(resultado);;
	}

	public String getNumeroUno() {
		return numeroUno.getText();
	}

	public void setNumeroUno(String numeroUno) {
		this.numeroUno.setText(numeroUno);
	}

	public String getNumeroDos() {
		return numeroDos.getText();
	}

	public void setNumeroDos(String numeroDos) {
		this.numeroDos.setText(numeroDos);
	}

	public String getContraseña() {
		// TODO Auto-generated method stub
		return JOptionPane.showInputDialog("Contraseña");
	}

	public void showIncorrectPassword() {
		JOptionPane.showMessageDialog(new JFrame(), "Contraseña incorrecta", "Raiz Cubica",
		        JOptionPane.ERROR_MESSAGE);

	}

	public void showNumberIncorrect() {
		JOptionPane.showMessageDialog(new JFrame(), "Los campos son incorrectos. Por favor, introduzca dos números.", "Error",
		        JOptionPane.ERROR_MESSAGE);
	}

	public void showSqrtError() {
		JOptionPane.showMessageDialog(new JFrame(), "Funcionalidad no disponible", "Raiz Cuadrada",
		        JOptionPane.ERROR_MESSAGE);

	}

	public void playSound() {
	    try {
	        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("sound_effects/8bit_music.wav").getAbsoluteFile());
	        Clip clip = AudioSystem.getClip();
	        clip.open(audioInputStream);
	        clip.start();
	    } catch(Exception ex) {
	        System.out.println("Error with playing sound.");
	        ex.printStackTrace();
	    }
	}
	public void playButton(String path) {
		try {
	        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(path).getAbsoluteFile());
	        Clip clip = AudioSystem.getClip();
	        clip.open(audioInputStream);
	        clip.start();
	    } catch(Exception ex) {
	        System.out.println("Error with playing sound.");
	        ex.printStackTrace();
	    }
	}

	public boolean isGaming() {
		return isGaming;
	}

	public void setGaming(boolean isGaming) {
		this.isGaming = isGaming;
	}


}
