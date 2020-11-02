package ClienteLP;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.toedter.calendar.JDateChooser;

public class vtPrincipal extends JFrame {

	private JPanel contentPane;
	private ImageIcon icon = new ImageIcon("src/img/logo.png");
	private ImageIcon imageIcon = new ImageIcon("src/img/beltza.png");
	private ImageIcon gorri = new ImageIcon("src/img/gorri.png");
	private ImageIcon gris = new ImageIcon("src/img/gris.png");
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Create the frame.
	 */
	public vtPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(550, 200, 800, 600);

		JMenuBar menuBar = new JMenuBar();
		JMenu reserva = new JMenu("Reserva");
		reserva.setFont(new Font("Serif", Font.PLAIN, 20));
		JMenu pago = new JMenu("Pago");
		pago.setFont(new Font("Serif", Font.PLAIN, 20));
		menuBar.add(reserva);
		menuBar.add(pago);
		setJMenuBar(menuBar);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		this.setIconImage(icon.getImage());
		this.setResizable(false);

		JDateChooser a = new JDateChooser();
		a.getCalendar();
		a.setBounds(10, 85, 100, 30);
		contentPane.add(a);

		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setFont(new Font("Serif", Font.PLAIN, 18));
		lblFecha.setBounds(10, 55, 69, 20);
		contentPane.add(lblFecha);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(30, 144, 255), 2));
		panel.setBounds(125, 0, 669, 529);
		contentPane.add(panel);
		panel.setLayout(null);

		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBackground(Color.DARK_GRAY);
		textPane.setBounds(77, 55, 190, 75);
		panel.add(textPane);

		JTextPane textPane_1 = new JTextPane();
		textPane_1.setEditable(false);
		textPane_1.setBackground(Color.DARK_GRAY);
		textPane_1.setBounds(77, 205, 190, 75);
		panel.add(textPane_1);

		JTextPane textPane_2 = new JTextPane();
		textPane_2.setEditable(false);
		textPane_2.setBackground(Color.DARK_GRAY);
		textPane_2.setBounds(77, 355, 190, 75);
		panel.add(textPane_2);

		JTextPane textPane_3 = new JTextPane();
		textPane_3.setEditable(false);
		textPane_3.setBackground(Color.DARK_GRAY);
		textPane_3.setBounds(500, 55, 75, 130);
		panel.add(textPane_3);

		JTextPane textPane_4 = new JTextPane();
		textPane_4.setEditable(false);
		textPane_4.setBackground(Color.DARK_GRAY);
		textPane_4.setBounds(500, 265, 75, 130);
		panel.add(textPane_4);

		// Mesa 1
		final JButton b1 = new JButton();
		b1.setBorder(null);
		b1.setIcon(imageIcon);
		b1.setBounds(43, 80, 23, 25);
		panel.add(b1);
		b1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (b1.getIcon() == imageIcon) {
					b1.setIcon(gris);
				} else {
					b1.setIcon(imageIcon);
				}
			}

		});

		final JButton b2 = new JButton();
		b2.setBounds(90, 27, 23, 25);
		b2.setIcon(imageIcon);
		b2.setBorder(null);
		panel.add(b2);
		b2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (b2.getIcon() == imageIcon) {
					b2.setIcon(gris);
				} else {
					b2.setIcon(imageIcon);
				}
			}

		});

		final JButton b3 = new JButton();
		b3.setBorder(null);
		b3.setIcon(imageIcon);
		b3.setBounds(125, 27, 23, 25);
		panel.add(b3);
		b3.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (b3.getIcon() == imageIcon) {
					b3.setIcon(gris);
				} else {
					b3.setIcon(imageIcon);
				}
			}

		});

		final JButton b4 = new JButton();
		b4.setBorder(null);
		b4.setIcon(imageIcon);
		b4.setBounds(160, 27, 23, 25);
		panel.add(b4);
		b4.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (b4.getIcon() == imageIcon) {
					b4.setIcon(gris);
				} else {
					b4.setIcon(imageIcon);
				}
			}

		});

		final JButton b5 = new JButton();
		b5.setBorder(null);
		b5.setIcon(imageIcon);
		b5.setBounds(195, 27, 23, 25);
		panel.add(b5);
		b5.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (b5.getIcon() == imageIcon) {
					b5.setIcon(gris);
				} else {
					b5.setIcon(imageIcon);
				}
			}

		});

		final JButton b6 = new JButton();
		b6.setBorder(null);
		b6.setIcon(imageIcon);
		b6.setBounds(230, 27, 23, 25);
		panel.add(b6);
		b6.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (b6.getIcon() == imageIcon) {
					b6.setIcon(gris);
				} else {
					b6.setIcon(imageIcon);
				}
			}

		});

		final JButton b7 = new JButton();
		b7.setBounds(90, 137, 23, 25);
		b7.setIcon(imageIcon);
		b7.setBorder(null);
		panel.add(b7);
		b7.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (b7.getIcon() == imageIcon) {
					b7.setIcon(gris);
				} else {
					b7.setIcon(imageIcon);
				}
			}

		});

		final JButton b8 = new JButton();
		b8.setBorder(null);
		b8.setIcon(imageIcon);
		b8.setBounds(125, 137, 23, 25);
		panel.add(b8);
		b8.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (b8.getIcon() == imageIcon) {
					b8.setIcon(gris);
				} else {
					b8.setIcon(imageIcon);
				}
			}

		});

		final JButton b9 = new JButton();
		b9.setBorder(null);
		b9.setIcon(imageIcon);
		b9.setBounds(160, 137, 23, 25);
		panel.add(b9);
		b9.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (b9.getIcon() == imageIcon) {
					b9.setIcon(gris);
				} else {
					b9.setIcon(imageIcon);
				}
			}

		});

		final JButton b10 = new JButton();
		b10.setBorder(null);
		b10.setIcon(imageIcon);
		b10.setBounds(195, 137, 23, 25);
		panel.add(b10);
		b10.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (b10.getIcon() == imageIcon) {
					b10.setIcon(gris);
				} else {
					b10.setIcon(imageIcon);
				}
			}

		});

		final JButton b11 = new JButton();
		b11.setBorder(null);
		b11.setIcon(imageIcon);
		b11.setBounds(230, 137, 23, 25);
		panel.add(b11);
		b11.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (b11.getIcon() == imageIcon) {
					b11.setIcon(gris);
				} else {
					b11.setIcon(imageIcon);
				}
			}

		});

		final JButton b12 = new JButton();
		b12.setBorder(null);
		b12.setIcon(imageIcon);
		b12.setBounds(275, 80, 23, 25);
		panel.add(b12);
		b12.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (b12.getIcon() == imageIcon) {
					b12.setIcon(gris);
				} else {
					b12.setIcon(imageIcon);
				}
			}

		});

		// Mesa 2

		final JButton b13 = new JButton();
		b13.setBorder(null);
		b13.setIcon(imageIcon);
		b13.setBounds(43, 230, 23, 25);
		panel.add(b13);
		b13.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (b13.getIcon() == imageIcon) {
					b13.setIcon(gris);
				} else {
					b13.setIcon(imageIcon);
				}
			}

		});

		final JButton b14 = new JButton();
		b14.setBounds(90, 177, 23, 25);
		b14.setIcon(imageIcon);
		b14.setBorder(null);
		panel.add(b14);
		b14.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (b14.getIcon() == imageIcon) {
					b14.setIcon(gris);
				} else {
					b14.setIcon(imageIcon);
				}
			}

		});

		final JButton b15 = new JButton();
		b15.setBorder(null);
		b15.setIcon(imageIcon);
		b15.setBounds(125, 177, 23, 25);
		panel.add(b15);
		b15.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (b15.getIcon() == imageIcon) {
					b15.setIcon(gris);
				} else {
					b15.setIcon(imageIcon);
				}
			}

		});

		final JButton b16 = new JButton();
		b16.setBorder(null);
		b16.setIcon(imageIcon);
		b16.setBounds(160, 177, 23, 25);
		panel.add(b16);
		b16.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (b16.getIcon() == imageIcon) {
					b16.setIcon(gris);
				} else {
					b16.setIcon(imageIcon);
				}
			}

		});

		final JButton b17 = new JButton();
		b17.setBorder(null);
		b17.setIcon(imageIcon);
		b17.setBounds(195, 177, 23, 25);
		panel.add(b17);
		b17.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (b17.getIcon() == imageIcon) {
					b17.setIcon(gris);
				} else {
					b17.setIcon(imageIcon);
				}
			}

		});

		final JButton b18 = new JButton();
		b18.setBorder(null);
		b18.setIcon(imageIcon);
		b18.setBounds(230, 177, 23, 25);
		panel.add(b18);
		b18.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (b18.getIcon() == imageIcon) {
					b18.setIcon(gris);
				} else {
					b18.setIcon(imageIcon);
				}
			}

		});

		final JButton b19 = new JButton();
		b19.setBounds(90, 287, 23, 25);
		b19.setIcon(imageIcon);
		b19.setBorder(null);
		panel.add(b19);
		b19.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (b19.getIcon() == imageIcon) {
					b19.setIcon(gris);
				} else {
					b19.setIcon(imageIcon);
				}
			}

		});

		final JButton b20 = new JButton();
		b20.setBorder(null);
		b20.setIcon(imageIcon);
		b20.setBounds(125, 287, 23, 25);
		panel.add(b20);
		b20.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (b20.getIcon() == imageIcon) {
					b20.setIcon(gris);
				} else {
					b20.setIcon(imageIcon);
				}
			}

		});

		final JButton b21 = new JButton();
		b21.setBorder(null);
		b21.setIcon(imageIcon);
		b21.setBounds(160, 287, 23, 25);
		panel.add(b21);
		b21.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (b21.getIcon() == imageIcon) {
					b21.setIcon(gris);
				} else {
					b21.setIcon(imageIcon);
				}
			}

		});

		final JButton b22 = new JButton();
		b22.setBorder(null);
		b22.setIcon(imageIcon);
		b22.setBounds(195, 287, 23, 25);
		panel.add(b22);
		b22.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (b22.getIcon() == imageIcon) {
					b22.setIcon(gris);
				} else {
					b22.setIcon(imageIcon);
				}
			}

		});

		final JButton b23 = new JButton();
		b23.setBorder(null);
		b23.setIcon(imageIcon);
		b23.setBounds(230, 287, 23, 25);
		panel.add(b23);
		b23.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (b23.getIcon() == imageIcon) {
					b23.setIcon(gris);
				} else {
					b23.setIcon(imageIcon);
				}
			}

		});

		final JButton b24 = new JButton();
		b24.setBorder(null);
		b24.setIcon(imageIcon);
		b24.setBounds(275, 230, 23, 25);
		panel.add(b24);
		b24.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (b24.getIcon() == imageIcon) {
					b24.setIcon(gris);
				} else {
					b24.setIcon(imageIcon);
				}
			}

		});

		// Mesa 3

		final JButton b25 = new JButton();
		b25.setBorder(null);
		b25.setIcon(imageIcon);
		b25.setBounds(43, 380, 23, 25);
		panel.add(b25);
		b25.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (b25.getIcon() == imageIcon) {
					b25.setIcon(gris);
				} else {
					b25.setIcon(imageIcon);
				}
			}

		});

		final JButton b26 = new JButton();
		b26.setBounds(90, 327, 23, 25);
		b26.setIcon(imageIcon);
		b26.setBorder(null);
		panel.add(b26);
		b26.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (b26.getIcon() == imageIcon) {
					b26.setIcon(gris);
				} else {
					b26.setIcon(imageIcon);
				}
			}

		});

		final JButton b27 = new JButton();
		b27.setBorder(null);
		b27.setIcon(imageIcon);
		b27.setBounds(125, 327, 23, 25);
		panel.add(b27);
		b27.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (b27.getIcon() == imageIcon) {
					b27.setIcon(gris);
				} else {
					b27.setIcon(imageIcon);
				}
			}

		});

		final JButton b28 = new JButton();
		b28.setBorder(null);
		b28.setIcon(imageIcon);
		b28.setBounds(160, 327, 23, 25);
		panel.add(b28);
		b28.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (b28.getIcon() == imageIcon) {
					b28.setIcon(gris);
				} else {
					b28.setIcon(imageIcon);
				}
			}

		});

		final JButton b29 = new JButton();
		b29.setBorder(null);
		b29.setIcon(imageIcon);
		b29.setBounds(195, 327, 23, 25);
		panel.add(b29);
		b29.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (b29.getIcon() == imageIcon) {
					b29.setIcon(gris);
				} else {
					b29.setIcon(imageIcon);
				}
			}

		});

		final JButton b30 = new JButton();
		b30.setBorder(null);
		b30.setIcon(imageIcon);
		b30.setBounds(230, 327, 23, 25);
		panel.add(b30);
		b30.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (b30.getIcon() == imageIcon) {
					b30.setIcon(gris);
				} else {
					b30.setIcon(imageIcon);
				}
			}

		});

		final JButton b31 = new JButton();
		b31.setBounds(90, 437, 23, 25);
		b31.setIcon(imageIcon);
		b31.setBorder(null);
		panel.add(b31);
		b31.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (b31.getIcon() == imageIcon) {
					b31.setIcon(gris);
				} else {
					b31.setIcon(imageIcon);
				}
			}

		});

		final JButton b32 = new JButton();
		b32.setBorder(null);
		b32.setIcon(imageIcon);
		b32.setBounds(125, 437, 23, 25);
		panel.add(b32);
		b32.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (b32.getIcon() == imageIcon) {
					b32.setIcon(gris);
				} else {
					b32.setIcon(imageIcon);
				}
			}

		});

		final JButton b33 = new JButton();
		b33.setBorder(null);
		b33.setIcon(imageIcon);
		b33.setBounds(160, 437, 23, 25);
		panel.add(b33);
		b33.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (b33.getIcon() == imageIcon) {
					b33.setIcon(gris);
				} else {
					b33.setIcon(imageIcon);
				}
			}

		});

		final JButton b34 = new JButton();
		b34.setBorder(null);
		b34.setIcon(imageIcon);
		b34.setBounds(195, 437, 23, 25);
		panel.add(b34);
		b34.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (b34.getIcon() == imageIcon) {
					b34.setIcon(gris);
				} else {
					b34.setIcon(imageIcon);
				}
			}

		});

		final JButton b35 = new JButton();
		b35.setBorder(null);
		b35.setIcon(imageIcon);
		b35.setBounds(230, 437, 23, 25);
		panel.add(b35);
		b35.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (b35.getIcon() == imageIcon) {
					b35.setIcon(gris);
				} else {
					b35.setIcon(imageIcon);
				}
			}

		});

		final JButton b36 = new JButton();
		b36.setBorder(null);
		b36.setIcon(imageIcon);
		b36.setBounds(275, 380, 23, 25);
		panel.add(b36);
		b36.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (b36.getIcon() == imageIcon) {
					b36.setIcon(gris);
				} else {
					b36.setIcon(imageIcon);
				}
			}

		});

		// Mesa 4

		final JButton b37 = new JButton();
		b37.setBorder(null);
		b37.setIcon(imageIcon);
		b37.setBounds(525, 27, 23, 25);
		panel.add(b37);
		b37.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (b37.getIcon() == imageIcon) {
					b37.setIcon(gris);
				} else {
					b37.setIcon(imageIcon);
				}
			}

		});

		final JButton b38 = new JButton();
		b38.setBorder(null);
		b38.setIcon(imageIcon);
		b38.setBounds(474, 65, 23, 25);
		panel.add(b38);
		b38.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (b38.getIcon() == imageIcon) {
					b38.setIcon(gris);
				} else {
					b38.setIcon(imageIcon);
				}
			}

		});

		final JButton b39 = new JButton();
		b39.setBorder(null);
		b39.setIcon(imageIcon);
		b39.setBounds(474, 106, 23, 25);
		panel.add(b39);
		b39.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (b39.getIcon() == imageIcon) {
					b39.setIcon(gris);
				} else {
					b39.setIcon(imageIcon);
				}
			}

		});

		final JButton b40 = new JButton();
		b40.setBorder(null);
		b40.setIcon(imageIcon);
		b40.setBounds(474, 147, 23, 25);
		panel.add(b40);
		b40.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (b40.getIcon() == imageIcon) {
					b40.setIcon(gris);
				} else {
					b40.setIcon(imageIcon);
				}
			}

		});

		final JButton b41 = new JButton();
		b41.setBorder(null);
		b41.setIcon(imageIcon);
		b41.setBounds(580, 65, 23, 25);
		panel.add(b41);
		b41.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (b41.getIcon() == imageIcon) {
					b41.setIcon(gris);
				} else {
					b41.setIcon(imageIcon);
				}
			}

		});

		final JButton b42 = new JButton();
		b42.setBorder(null);
		b42.setIcon(imageIcon);
		b42.setBounds(580, 105, 23, 25);
		panel.add(b42);
		b42.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (b42.getIcon() == imageIcon) {
					b42.setIcon(gris);
				} else {
					b42.setIcon(imageIcon);
				}
			}

		});

		final JButton b43 = new JButton();
		b43.setBorder(null);
		b43.setIcon(imageIcon);
		b43.setBounds(580, 147, 23, 25);
		panel.add(b43);
		b43.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (b43.getIcon() == imageIcon) {
					b43.setIcon(gris);
				} else {
					b43.setIcon(imageIcon);
				}
			}

		});

		final JButton b44 = new JButton();
		b44.setBorder(null);
		b44.setIcon(imageIcon);
		b44.setBounds(525, 189, 23, 25);
		panel.add(b44);
		b44.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (b44.getIcon() == imageIcon) {
					b44.setIcon(gris);
				} else {
					b44.setIcon(imageIcon);
				}
			}

		});

		// Mesa 5

		final JButton b45 = new JButton();
		b45.setBorder(null);
		b45.setIcon(imageIcon);
		b45.setBounds(525, 237, 23, 25);
		panel.add(b45);
		b45.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (b45.getIcon() == imageIcon) {
					b45.setIcon(gris);
				} else {
					b45.setIcon(imageIcon);
				}
			}

		});

		final JButton b46 = new JButton();
		b46.setBorder(null);
		b46.setIcon(imageIcon);
		b46.setBounds(474, 275, 23, 25);
		panel.add(b46);
		b46.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (b46.getIcon() == imageIcon) {
					b46.setIcon(gris);
				} else {
					b46.setIcon(imageIcon);
				}
			}

		});

		final JButton b47 = new JButton();
		b47.setBorder(null);
		b47.setIcon(imageIcon);
		b47.setBounds(474, 316, 23, 25);
		panel.add(b47);
		b47.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (b47.getIcon() == imageIcon) {
					b47.setIcon(gris);
				} else {
					b47.setIcon(imageIcon);
				}
			}

		});

		final JButton b48 = new JButton();
		b48.setBorder(null);
		b48.setIcon(imageIcon);
		b48.setBounds(474, 357, 23, 25);
		panel.add(b48);
		b48.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (b48.getIcon() == imageIcon) {
					b48.setIcon(gris);
				} else {
					b48.setIcon(imageIcon);
				}
			}

		});

		final JButton b49 = new JButton();
		b49.setBorder(null);
		b49.setIcon(imageIcon);
		b49.setBounds(580, 275, 23, 25);
		panel.add(b49);
		b49.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (b49.getIcon() == imageIcon) {
					b49.setIcon(gris);
				} else {
					b49.setIcon(imageIcon);
				}
			}

		});

		final JButton b50 = new JButton();
		b50.setBorder(null);
		b50.setIcon(imageIcon);
		b50.setBounds(580, 315, 23, 25);
		panel.add(b50);
		b50.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (b50.getIcon() == imageIcon) {
					b50.setIcon(gris);
				} else {
					b50.setIcon(imageIcon);
				}
			}

		});

		final JButton b51 = new JButton();
		b51.setBorder(null);
		b51.setIcon(imageIcon);
		b51.setBounds(580, 357, 23, 25);
		panel.add(b51);
		b51.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (b51.getIcon() == imageIcon) {
					b51.setIcon(gris);
				} else {
					b51.setIcon(imageIcon);
				}
			}

		});

		final JButton b52 = new JButton();
		b52.setBorder(null);
		b52.setIcon(imageIcon);
		b52.setBounds(525, 399, 23, 25);
		panel.add(b52);
		b52.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (b52.getIcon() == imageIcon) {
					b52.setIcon(gris);
				} else {
					b52.setIcon(imageIcon);
				}
			}

		});

		// Mesa 1
		JButton gb1 = new JButton();
		gb1.setBorder(null);
		gb1.setIcon(gorri);
		gb1.setBounds(43, 80, 23, 25);
		panel.add(gb1);

		JButton gb2 = new JButton();
		gb2.setBounds(90, 27, 23, 25);
		gb2.setIcon(gorri);
		gb2.setBorder(null);
		panel.add(gb2);

		JButton gb3 = new JButton();
		gb3.setBorder(null);
		gb3.setIcon(gorri);
		gb3.setBounds(125, 27, 23, 25);
		panel.add(gb3);

		JButton gb4 = new JButton();
		gb4.setBorder(null);
		gb4.setIcon(gorri);
		gb4.setBounds(160, 27, 23, 25);
		panel.add(gb4);

		JButton gb5 = new JButton();
		gb5.setBorder(null);
		gb5.setIcon(gorri);
		gb5.setBounds(195, 27, 23, 25);
		panel.add(gb5);

		JButton gb6 = new JButton();
		gb6.setBorder(null);
		gb6.setIcon(gorri);
		gb6.setBounds(230, 27, 23, 25);
		panel.add(gb6);

		JButton gb7 = new JButton();
		gb7.setBounds(90, 137, 23, 25);
		gb7.setIcon(gorri);
		gb7.setBorder(null);
		panel.add(gb7);

		JButton gb8 = new JButton();
		gb8.setBorder(null);
		gb8.setIcon(gorri);
		gb8.setBounds(125, 137, 23, 25);
		panel.add(gb8);

		JButton gb9 = new JButton();
		gb9.setBorder(null);
		gb9.setIcon(gorri);
		gb9.setBounds(160, 137, 23, 25);
		panel.add(gb9);

		JButton gb10 = new JButton();
		gb10.setBorder(null);
		gb10.setIcon(gorri);
		gb10.setBounds(195, 137, 23, 25);
		panel.add(gb10);

		JButton gb11 = new JButton();
		gb11.setBorder(null);
		gb11.setIcon(gorri);
		gb11.setBounds(230, 137, 23, 25);
		panel.add(gb11);

		JButton gb12 = new JButton();
		gb12.setBorder(null);
		gb12.setIcon(gorri);
		gb12.setBounds(275, 80, 23, 25);
		panel.add(gb12);

		// Mesa 2

		JButton gb13 = new JButton();
		gb13.setBorder(null);
		gb13.setIcon(gorri);
		gb13.setBounds(43, 230, 23, 25);
		panel.add(gb13);

		JButton gb14 = new JButton();
		gb14.setBounds(90, 177, 23, 25);
		gb14.setIcon(gorri);
		gb14.setBorder(null);
		panel.add(gb14);

		JButton gb15 = new JButton();
		gb15.setBorder(null);
		gb15.setIcon(gorri);
		gb15.setBounds(125, 177, 23, 25);
		panel.add(gb15);

		JButton gb16 = new JButton();
		gb16.setBorder(null);
		gb16.setIcon(gorri);
		gb16.setBounds(160, 177, 23, 25);
		panel.add(gb16);

		JButton gb17 = new JButton();
		gb17.setBorder(null);
		gb17.setIcon(gorri);
		gb17.setBounds(195, 177, 23, 25);
		panel.add(gb17);

		JButton gb18 = new JButton();
		gb18.setBorder(null);
		gb18.setIcon(gorri);
		gb18.setBounds(230, 177, 23, 25);
		panel.add(gb18);

		JButton gb19 = new JButton();
		gb19.setBounds(90, 287, 23, 25);
		gb19.setIcon(gorri);
		gb19.setBorder(null);
		panel.add(gb19);

		JButton gb20 = new JButton();
		gb20.setBorder(null);
		gb20.setIcon(gorri);
		gb20.setBounds(125, 287, 23, 25);
		panel.add(gb20);

		JButton gb21 = new JButton();
		gb21.setBorder(null);
		gb21.setIcon(gorri);
		gb21.setBounds(160, 287, 23, 25);
		panel.add(gb21);

		JButton gb22 = new JButton();
		gb22.setBorder(null);
		gb22.setIcon(gorri);
		gb22.setBounds(195, 287, 23, 25);
		panel.add(gb22);

		JButton gb23 = new JButton();
		gb23.setBorder(null);
		gb23.setIcon(gorri);
		gb23.setBounds(230, 287, 23, 25);
		panel.add(gb23);

		JButton gb24 = new JButton();
		gb24.setBorder(null);
		gb24.setIcon(gorri);
		gb24.setBounds(275, 230, 23, 25);
		panel.add(gb24);

		// Mesa 3

		JButton gb25 = new JButton();
		gb25.setBorder(null);
		gb25.setIcon(gorri);
		gb25.setBounds(43, 380, 23, 25);
		panel.add(gb25);

		JButton gb26 = new JButton();
		gb26.setBounds(90, 327, 23, 25);
		gb26.setIcon(gorri);
		gb26.setBorder(null);
		panel.add(gb26);

		JButton gb27 = new JButton();
		gb27.setBorder(null);
		gb27.setIcon(gorri);
		gb27.setBounds(125, 327, 23, 25);
		panel.add(gb27);

		JButton gb28 = new JButton();
		gb28.setBorder(null);
		gb28.setIcon(gorri);
		gb28.setBounds(160, 327, 23, 25);
		panel.add(gb28);

		JButton gb29 = new JButton();
		gb29.setBorder(null);
		gb29.setIcon(gorri);
		gb29.setBounds(195, 327, 23, 25);
		panel.add(gb29);

		JButton gb30 = new JButton();
		gb30.setBorder(null);
		gb30.setIcon(gorri);
		gb30.setBounds(230, 327, 23, 25);
		panel.add(gb30);

		JButton gb31 = new JButton();
		gb31.setBounds(90, 437, 23, 25);
		gb31.setIcon(gorri);
		gb31.setBorder(null);
		panel.add(gb31);

		JButton gb32 = new JButton();
		gb32.setBorder(null);
		gb32.setIcon(gorri);
		gb32.setBounds(125, 437, 23, 25);
		panel.add(gb32);

		JButton gb33 = new JButton();
		gb33.setBorder(null);
		gb33.setIcon(gorri);
		gb33.setBounds(160, 437, 23, 25);
		panel.add(gb33);

		JButton gb34 = new JButton();
		gb34.setBorder(null);
		gb34.setIcon(gorri);
		gb34.setBounds(195, 437, 23, 25);
		panel.add(gb34);

		JButton gb35 = new JButton();
		gb35.setBorder(null);
		gb35.setIcon(gorri);
		gb35.setBounds(230, 437, 23, 25);
		panel.add(gb35);

		JButton gb36 = new JButton();
		gb36.setBorder(null);
		gb36.setIcon(gorri);
		gb36.setBounds(275, 380, 23, 25);
		panel.add(gb36);

		// Mesa 4

		JButton gb37 = new JButton();
		gb37.setBorder(null);
		gb37.setIcon(gorri);
		gb37.setBounds(525, 27, 23, 25);
		panel.add(gb37);

		JButton gb38 = new JButton();
		gb38.setBorder(null);
		gb38.setIcon(gorri);
		gb38.setBounds(474, 65, 23, 25);
		panel.add(gb38);

		JButton gb39 = new JButton();
		gb39.setBorder(null);
		gb39.setIcon(gorri);
		gb39.setBounds(474, 106, 23, 25);
		panel.add(gb39);

		JButton gb40 = new JButton();
		gb40.setBorder(null);
		gb40.setIcon(gorri);
		gb40.setBounds(474, 147, 23, 25);
		panel.add(gb40);

		JButton gb41 = new JButton();
		gb41.setBorder(null);
		gb41.setIcon(gorri);
		gb41.setBounds(580, 65, 23, 25);
		panel.add(gb41);

		JButton gb42 = new JButton();
		gb42.setBorder(null);
		gb42.setIcon(gorri);
		gb42.setBounds(580, 105, 23, 25);
		panel.add(gb42);

		JButton gb43 = new JButton();
		gb43.setBorder(null);
		gb43.setIcon(gorri);
		gb43.setBounds(580, 147, 23, 25);
		panel.add(gb43);

		JButton gb44 = new JButton();
		gb44.setBorder(null);
		gb44.setIcon(gorri);
		gb44.setBounds(525, 189, 23, 25);
		panel.add(gb44);

		// Mesa 5

		JButton gb45 = new JButton();
		gb45.setBorder(null);
		gb45.setIcon(gorri);
		gb45.setBounds(525, 237, 23, 25);
		panel.add(gb45);

		JButton gb46 = new JButton();
		gb46.setBorder(null);
		gb46.setIcon(gorri);
		gb46.setBounds(474, 275, 23, 25);
		panel.add(gb46);

		JButton gb47 = new JButton();
		gb47.setBorder(null);
		gb47.setIcon(gorri);
		gb47.setBounds(474, 316, 23, 25);
		panel.add(gb47);

		JButton gb48 = new JButton();
		gb48.setBorder(null);
		gb48.setIcon(gorri);
		gb48.setBounds(474, 357, 23, 25);
		panel.add(gb48);

		JButton gb49 = new JButton();
		gb49.setBorder(null);
		gb49.setIcon(gorri);
		gb49.setBounds(580, 275, 23, 25);
		panel.add(gb49);

		JButton gb50 = new JButton();
		gb50.setBorder(null);
		gb50.setIcon(gorri);
		gb50.setBounds(580, 315, 23, 25);
		panel.add(gb50);

		JButton gb51 = new JButton();
		gb51.setBorder(null);
		gb51.setIcon(gorri);
		gb51.setBounds(580, 357, 23, 25);
		panel.add(gb51);

		JButton gb52 = new JButton();
		gb52.setBorder(null);
		gb52.setIcon(gorri);
		gb52.setBounds(525, 399, 23, 25);
		panel.add(gb52);

		JButton button = new JButton();
		button.setBorder(null);
		button.setBounds(500, 437, 23, 25);
		button.setIcon(imageIcon);
		panel.add(button);

		JButton button_1 = new JButton();
		button_1.setBorder(null);
		button_1.setBounds(500, 467, 23, 25);
		button_1.setIcon(gris);
		panel.add(button_1);

		JButton button_2 = new JButton();
		button_2.setBorder(null);
		button_2.setBounds(500, 497, 23, 25);
		button_2.setIcon(gorri);
		panel.add(button_2);

		JLabel lblSillaLibre = new JLabel("Silla libre");
		lblSillaLibre.setFont(new Font("Serif", Font.PLAIN, 16));
		lblSillaLibre.setBounds(535, 439, 69, 20);
		panel.add(lblSillaLibre);

		JLabel lblTuEleccin = new JLabel("Tu elecciÃ³n");
		lblTuEleccin.setFont(new Font("Serif", Font.PLAIN, 16));
		lblTuEleccin.setBounds(534, 469, 69, 20);
		panel.add(lblTuEleccin);

		JLabel lblSillaReservada = new JLabel("Silla reservada");
		lblSillaReservada.setFont(new Font("Serif", Font.PLAIN, 16));
		lblSillaReservada.setBounds(534, 499, 88, 20);
		panel.add(lblSillaReservada);

		JButton btnReservar = new JButton("Reservar");
		btnReservar.setFont(new Font("Serif", Font.PLAIN, 16));
		btnReservar.setBounds(10, 139, 105, 29);
		contentPane.add(btnReservar);

		JButton btnMisReservas = new JButton("Mis reservas");
		btnMisReservas.setFont(new Font("Serif", Font.PLAIN, 16));
		btnMisReservas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMisReservas.setBounds(5, 484, 115, 29);
		contentPane.add(btnMisReservas);

	}

}
