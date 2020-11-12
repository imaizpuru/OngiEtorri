package ClienteLP;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import ClienteLN.Controller;

public class vtCrear extends JFrame {

	private JPanel contentPane;
	private ImageIcon imageIcon = new ImageIcon("src/img/logo.png");
	private ImageIcon ojo = new ImageIcon("src/img/ojo.png");
	private ImageIcon ojono = new ImageIcon("src/img/ojono.jpg");
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JPasswordField textField_4;
	private Controller controller;
	private JButton btnNewButton_1;

	/**
	 * Create the frame.
	 */
	public vtCrear(Controller contro) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(665, 200, 570, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		this.setIconImage(imageIcon.getImage());
		setContentPane(contentPane);
		setTitle("Crear usuario");
		controller = contro;

		JLabel lblNewLabel = new JLabel("Nuevo usuario");
		lblNewLabel.setFont(new Font("Serif", Font.PLAIN, 46));
		lblNewLabel.setBounds(149, 28, 266, 60);
		contentPane.add(lblNewLabel);

		JLabel lblNmeroDeSocio = new JLabel("Numero de socio");
		lblNmeroDeSocio.setFont(new Font("Serif", Font.PLAIN, 18));
		lblNmeroDeSocio.setBounds(116, 144, 123, 20);
		contentPane.add(lblNmeroDeSocio);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Serif", Font.PLAIN, 18));
		lblNombre.setBounds(116, 204, 123, 20);
		contentPane.add(lblNombre);

		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setFont(new Font("Serif", Font.PLAIN, 18));
		lblApellidos.setBounds(116, 264, 123, 20);
		contentPane.add(lblApellidos);

		JLabel lblContrasea = new JLabel("Email");
		lblContrasea.setFont(new Font("Serif", Font.PLAIN, 18));
		lblContrasea.setBounds(116, 324, 123, 20);
		contentPane.add(lblContrasea);

		JLabel lblContrasea_1 = new JLabel("Contrasena");
		lblContrasea_1.setFont(new Font("Serif", Font.PLAIN, 18));
		lblContrasea_1.setBounds(116, 384, 123, 20);
		contentPane.add(lblContrasea_1);

		textField = new JTextField();
		textField.setBounds(300, 144, 146, 26);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(300, 204, 146, 26);
		contentPane.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(300, 264, 146, 26);
		contentPane.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(300, 324, 146, 26);
		contentPane.add(textField_3);

		textField_4 = new JPasswordField();
		textField_4.setColumns(10);
		textField_4.setBounds(300, 384, 146, 26);
		contentPane.add(textField_4);
		textField_4.setEchoChar('*');

		JButton btnNewButton = new JButton("Crear usuario");
		btnNewButton.setFont(new Font("Serif", Font.PLAIN, 18));
		btnNewButton.setBounds(206, 447, 151, 29);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				crearUsuario();
			}

		});

		JTextPane textPane = new JTextPane();
		textPane.setBackground(new Color(135, 206, 250));
		textPane.setBounds(129, 104, 305, 4);
		contentPane.add(textPane);
		textPane.setEditable(false);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Serif", Font.PLAIN, 18));
		btnCancelar.setBounds(206, 493, 151, 29);
		btnCancelar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				dispose();
			}

		});
		contentPane.add(btnCancelar);

		btnNewButton_1 = new JButton();
		btnNewButton_1.setBounds(458, 384, 33, 26);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.setIcon(ojo);
		btnNewButton_1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (textField_4.getEchoChar() == '*') {
					textField_4.setEchoChar((char) 0);
					btnNewButton_1.setIcon(ojono);
				} else {
					textField_4.setEchoChar('*');
					btnNewButton_1.setIcon(ojo);

				}

			}

		});

		this.setIconImage(imageIcon.getImage());
		this.setResizable(false);
	}

	private void crearUsuario() {
		int nsocio = Integer.parseInt(textField.getText());
		String nombre = textField_1.getText();
		String apellidos = textField_2.getText();
		String email = textField_3.getText();
		String contrasenya = textField_4.getText();

		int error = controller.crearUsuario(nsocio, nombre, apellidos, email, contrasenya);
		if (error == 0) {
			dispose();
			JOptionPane.showMessageDialog(null, "Usuario creado exitosamente!");
		}
		if (error == 1) {
			JOptionPane.showMessageDialog(null, "Este numero de socio ya tiene cuenta!");
		}

	}
}
