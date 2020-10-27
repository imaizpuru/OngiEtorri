package ClienteLP;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class vtInicio extends JFrame {

	private JPanel contentPane;
	private final int h;
	private final int v;
	private ImageIcon imageIcon = new ImageIcon("src/img/logo.png");
	private JTextField usuario;
	private JLabel lblNewLabel;
	private JTextField contrasenya;
	private JLabel lblNewLabel1;
	private JButton iniciaSesion;

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
		System.out.println(h);
		System.out.println(v);
		this.setIconImage(imageIcon.getImage());
		this.setResizable(false);

		Image image = imageIcon.getImage();
		Image newimg = image.getScaledInstance(h * 12, h * 12, java.awt.Image.SCALE_SMOOTH);
		imageIcon = new ImageIcon(newimg);
		Icon Ilogo = imageIcon;
		JLabel logo = new JLabel(Ilogo);
		logo.setBounds(h * 9, v, h * 12, h * 12);
		contentPane.add(logo);

		lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setFont(new Font("Serif", Font.PLAIN, 18));
		lblNewLabel.setBounds((int) (h * 13.52), v * 26, (int) (h * 2.95), (int) (v * 1.3));
		contentPane.add(lblNewLabel);

		usuario = new JTextField();
		usuario.setBounds((int) (h * 11), v * 28, (int) (h * 8), (int) (v * 2.5));
		contentPane.add(usuario);

		lblNewLabel1 = new JLabel("Contraseña");
		lblNewLabel1.setFont(new Font("Serif", Font.PLAIN, 18));
		lblNewLabel1.setBounds((int) (h * 12.85), v * 33, (int) (h * 4.3), (int) (v * 1.3));
		contentPane.add(lblNewLabel1);

		contrasenya = new JTextField();
		contrasenya.setBounds((int) (h * 11), v * 35, (int) (h * 8), (int) (v * 2.5));
		contentPane.add(contrasenya);

		iniciaSesion = new JButton("Iniciar sesión");
		iniciaSesion.setFont(new Font("Serif", Font.PLAIN, 18));
		iniciaSesion.setBounds((int) (h * 11), v * 43, (int) (h * 8), (int) (v * 2.5));
		contentPane.add(iniciaSesion);

	}
}
