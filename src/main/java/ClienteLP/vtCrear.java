package ClienteLP;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class vtCrear extends JFrame {

	private JPanel contentPane;
	private ImageIcon imageIcon = new ImageIcon("src/img/logo.png");
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Create the frame.
	 */
	public vtCrear() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(665, 200, 570, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		this.setIconImage(imageIcon.getImage());
		setContentPane(contentPane);

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

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(300, 384, 146, 26);
		contentPane.add(textField_4);

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
		contentPane.add(btnCancelar);
		btnCancelar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				dispose();
			}

		});

		this.setIconImage(imageIcon.getImage());
		this.setResizable(false);
	}

	private boolean crearUsuario() {
		int nsocio = Integer.parseInt(textField.getText());
		String nombre = textField_1.getText();
		String apellidos = textField_2.getText();
		String email = textField_3.getText();
		String contrasenya = textField_4.getText();

		return rootPaneCheckingEnabled;
	}
}
