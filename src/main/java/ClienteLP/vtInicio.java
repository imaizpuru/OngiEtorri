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
	private int pxlHorizontal;
	private int pxlVertical;
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
		pxlHorizontal = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 100);
		pxlVertical = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(pxlHorizontal * 35, pxlVertical * 20, pxlHorizontal * 30, pxlVertical * 60);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		System.out.println(pxlHorizontal);
		System.out.println(pxlVertical);
		this.setIconImage(imageIcon.getImage());
		this.setResizable(false);

		Image image = imageIcon.getImage();
		Image newimg = image.getScaledInstance(pxlHorizontal * 12, pxlHorizontal * 12, java.awt.Image.SCALE_SMOOTH);
		imageIcon = new ImageIcon(newimg);
		Icon Ilogo = imageIcon;
		JLabel logo = new JLabel(Ilogo);
		logo.setBounds(pxlHorizontal * 9, pxlVertical, pxlHorizontal * 12, pxlHorizontal * 12);
		contentPane.add(logo);

		lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setFont(new Font("Serif", Font.PLAIN, 18));
		lblNewLabel.setBounds((int) (pxlHorizontal * 13.52), pxlVertical * 26, (int) (pxlHorizontal * 2.95),
				(int) (pxlVertical * 1.3));
		contentPane.add(lblNewLabel);

		usuario = new JTextField();
		usuario.setBounds((int) (pxlHorizontal * 11), pxlVertical * 28, (int) (pxlHorizontal * 8),
				(int) (pxlVertical * 2.5));
		contentPane.add(usuario);

		lblNewLabel1 = new JLabel("Contraseña");
		lblNewLabel1.setFont(new Font("Serif", Font.PLAIN, 18));
		lblNewLabel1.setBounds((int) (pxlHorizontal * 12.85), pxlVertical * 33, (int) (pxlHorizontal * 4.3),
				(int) (pxlVertical * 1.3));
		contentPane.add(lblNewLabel1);

		contrasenya = new JTextField();
		contrasenya.setBounds((int) (pxlHorizontal * 11), pxlVertical * 35, (int) (pxlHorizontal * 8),
				(int) (pxlVertical * 2.5));
		contentPane.add(contrasenya);

		iniciaSesion = new JButton("Iniciar sesión");
		iniciaSesion.setFont(new Font("Serif", Font.PLAIN, 18));
		iniciaSesion.setBounds((int) (pxlHorizontal * 11), pxlVertical * 43, (int) (pxlHorizontal * 8),
				(int) (pxlVertical * 2.5));
		contentPane.add(iniciaSesion);

	}
}
