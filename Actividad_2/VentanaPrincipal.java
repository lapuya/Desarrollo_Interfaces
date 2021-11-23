import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	JButton btnNewButton_8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 475);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Normal Version");
		rdbtnNewRadioButton.setSelected(true);
		rdbtnNewRadioButton.setBounds(132, 56, 141, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Puzzle Version");
		rdbtnNewRadioButton_1.setBounds(290, 56, 141, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Troll Version");
		rdbtnNewRadioButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		rdbtnNewRadioButton_2.setBounds(455, 56, 141, 23);
		contentPane.add(rdbtnNewRadioButton_2);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnNewRadioButton);
		group.add(rdbtnNewRadioButton_1);
		group.add(rdbtnNewRadioButton_2);
				
		JLabel lblNewLabel = new JLabel("Just a common Calculator :)");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setBounds(233, 6, 294, 25);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("1");
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		btnNewButton.setBounds(52, 307, 117, 52);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("2");
		btnNewButton_1.setFont(new Font("Lucida Grande", Font.PLAIN, 22));

		btnNewButton_1.setBounds(181, 307, 117, 52);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("3");
		btnNewButton_2.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		btnNewButton_2.setBounds(314, 307, 117, 52);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("4");
		btnNewButton_3.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		btnNewButton_3.setBounds(52, 243, 117, 52);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("5");
		btnNewButton_4.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		btnNewButton_4.setBounds(181, 246, 117, 46);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("6");
		btnNewButton_5.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		btnNewButton_5.setBounds(314, 246, 117, 46);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("7");
		btnNewButton_6.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		btnNewButton_6.setBounds(52, 187, 117, 52);
		contentPane.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("8");
		btnNewButton_7.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		btnNewButton_7.setBounds(181, 187, 117, 52);
		contentPane.add(btnNewButton_7);
		
		btnNewButton_8 = new JButton("9");
		btnNewButton_8.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		btnNewButton_8.setBounds(314, 187, 117, 52);
		contentPane.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("0");
		btnNewButton_9.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		btnNewButton_9.setBounds(52, 371, 117, 52);
		contentPane.add(btnNewButton_9);
		
		rdbtnNewRadioButton_2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				btnNewButton_8.setText("???");
			}
			
		});
		
		JButton btnNewButton_10 = new JButton("+");
		btnNewButton_10.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		btnNewButton_10.setBounds(444, 187, 117, 52);
		contentPane.add(btnNewButton_10);
		
		JButton btnNewButton_11 = new JButton("-");
		btnNewButton_11.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		btnNewButton_11.setBounds(443, 243, 117, 52);
		contentPane.add(btnNewButton_11);
		
		JButton btnNewButton_12 = new JButton("x");
		btnNewButton_12.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		btnNewButton_12.setBounds(444, 307, 117, 52);
		contentPane.add(btnNewButton_12);
		
		JButton btnNewButton_13 = new JButton("/");
		btnNewButton_13.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		btnNewButton_13.setBounds(444, 371, 117, 52);
		contentPane.add(btnNewButton_13);
		
		JButton btnNewButton_14 = new JButton("∛");
		btnNewButton_14.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		btnNewButton_14.setBounds(181, 367, 117, 52);
		contentPane.add(btnNewButton_14);
		
		JButton btnNewButton_15 = new JButton("√");
		btnNewButton_15.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		btnNewButton_15.setBounds(314, 371, 117, 52);
		contentPane.add(btnNewButton_15);
		
		JButton btnNewButton_16 = new JButton("=");
		btnNewButton_16.setBounds(573, 187, 117, 52);
		contentPane.add(btnNewButton_16);
		
		JButton btnNewButton_17 = new JButton("DEL");
		btnNewButton_17.setBounds(573, 307, 117, 52);
		contentPane.add(btnNewButton_17);
		
		JButton btnNewButton_18 = new JButton("Clean");
		btnNewButton_18.setBounds(573, 243, 117, 52);
		contentPane.add(btnNewButton_18);
		
		JButton exit = new JButton("EXIT");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exit.setBounds(573, 367, 117, 52);
		contentPane.add(exit);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(52, 95, 638, 80);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel screen = new JLabel("0");
		screen.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		screen.setHorizontalAlignment(SwingConstants.RIGHT);
		screen.setBounds(6, 5, 626, 69);
		panel.add(screen);
		
	}
}

