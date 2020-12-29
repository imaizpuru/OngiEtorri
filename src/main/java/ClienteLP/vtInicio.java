package ClienteLP;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import ClienteLN.Controller;
import ServidorLD.Reserva;
import ServidorLD.Usuario;

public class vtInicio extends JFrame {

	private JPanel contentPane;
	private final int h;
	private final int v;
	private ImageIcon imageIcon = new ImageIcon("src/img/logo.png");
	private ImageIcon ojo = new ImageIcon("src/img/ojo.png");
	private ImageIcon ojono = new ImageIcon("src/img/ojono.jpg");
	private JTextField usuario;
	private JLabel lblNewLabel;

	private JPasswordField contrasenya;
	private JButton iniciaSesion;

	public void setIniciaSesion(JButton iniciaSesion) {
		this.iniciaSesion = iniciaSesion;
	}

	private JLabel lblNewLabel1;

	private JButton crear;
	private JButton btnNewButton;
	private Controller controller = new Controller();
	private ArrayList<Integer> permisos = new ArrayList<Integer>();
	private List<Usuario> usuarios = new ArrayList<Usuario>();

	/**
	 * Create the frame.
	 */
	public vtInicio() {

		h = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 100);
		v = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(h * 35, v * 20, h * 30, v * 60);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		setTitle("Iniciar sesion");
		this.setIconImage(imageIcon.getImage());
		this.setResizable(false);
		boolean admin = false;

		usuarios = controller.getUsuarios();
		
		if(usuarios != null)
		{
			admin = true;
		}
		
		if (admin == false) {
			controller.crearUsuario(0, "Admin", "Admin", "admin", "admin", true);
		}

		Image image = imageIcon.getImage();
		Image newimg = image.getScaledInstance(h * 12, h * 12, java.awt.Image.SCALE_SMOOTH);
		imageIcon = new ImageIcon(newimg);
		Icon Ilogo = imageIcon;
		JLabel logo = new JLabel(Ilogo);
		logo.setBounds(h * 9, v, h * 12, h * 12);
		contentPane.add(logo);

		lblNewLabel = new JLabel("Email");
		lblNewLabel.setFont(new Font("Serif", Font.PLAIN, 18));
		lblNewLabel.setBounds((int) (h * 13.52), v * 26, (int) (h * 2.95), (int) (v * 1.3));
		contentPane.add(lblNewLabel);

		usuario = new JTextField();
		usuario.setBounds((int) (h * 11), v * 28, (int) (h * 8), (int) (v * 2.5));
		contentPane.add(usuario);

		lblNewLabel1 = new JLabel("Contrasena");
		lblNewLabel1.setFont(new Font("Serif", Font.PLAIN, 18));
		lblNewLabel1.setBounds((int) (h * 12.85), v * 33, (int) (h * 4.3), (int) (v * 1.3));
		contentPane.add(lblNewLabel1);

		contrasenya = new JPasswordField();
		contrasenya.setBounds((int) (h * 11), v * 35, (int) (h * 8), (int) (v * 2.5));
		contrasenya.setEchoChar('*');
		contentPane.add(contrasenya);
		contrasenya.setEchoChar('*');

		iniciaSesion = new JButton("Iniciar sesion");
		iniciaSesion.setFont(new Font("Serif", Font.PLAIN, 18));
		iniciaSesion.setBounds((int) (h * 11), v * 43, (int) (h * 8), (int) (v * 2.5));
		contentPane.add(iniciaSesion);
		iniciaSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int error = controller.iniciaSesion(usuario.getText(), contrasenya.getText());
				if (error == 0) {
					vtPrincipal vt = new vtPrincipal(controller.getUsuario(), permisos);
					vt.setVisible(true);
				}
				if (error == 1) {
					JOptionPane.showMessageDialog(null, "Contrasena incorrecta!");
				}
				if (error == 2) {
					JOptionPane.showMessageDialog(null, "No existe ninguna cuenta con este email!");
				}
				// vtPrincipal vt = new vtPrincipal(controller.getUsuario());
				// vt.setVisible(true);

			}

		});

		crear = new JButton("Crear usuario");
		crear.setFont(new Font("Serif", Font.PLAIN, 18));
		crear.setBounds((int) (h * 11), v * 47, (int) (h * 8), (int) (v * 2.5));
		contentPane.add(crear);
		crear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vtCrear vt = new vtCrear(controller);
				vt.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				vt.setVisible(true);

			}

		});
		btnNewButton = new JButton();
		btnNewButton.setBounds(367, 349, 33, 26);
		contentPane.add(btnNewButton);
		btnNewButton.setIcon(ojo);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (contrasenya.getEchoChar() == '*') {
					contrasenya.setEchoChar((char) 0);
					btnNewButton.setIcon(ojono);
				} else {
					contrasenya.setEchoChar('*');
					btnNewButton.setIcon(ojo);

				}

			}

		});

		btnNewButton = new JButton();
		btnNewButton.setBounds(367, 349, 33, 26);
		contentPane.add(btnNewButton);
		btnNewButton.setIcon(ojo);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (contrasenya.getEchoChar() == '*') {
					contrasenya.setEchoChar((char) 0);
					btnNewButton.setIcon(ojono);
				} else {
					contrasenya.setEchoChar('*');
					btnNewButton.setIcon(ojo);

				}

			}

		});

	}

	public JTextField getUsuario() {
		return usuario;
	}

	public void setUsuario(JTextField usuario) {
		this.usuario = usuario;
	}

	public JPasswordField getContrasenya() {
		return contrasenya;
	}

	public void setContrasenya(JPasswordField contrasenya) {
		this.contrasenya = contrasenya;
	}

	public JButton getIniciaSesion() {
		return iniciaSesion;
	}
}
