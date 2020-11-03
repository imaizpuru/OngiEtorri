package ClienteLP;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.toedter.calendar.JDateChooser;

public class vtPrincipal extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private ImageIcon icon = new ImageIcon("src/img/logo.png");
	private ImageIcon imageIcon = new ImageIcon("src/img/beltza.png");
	private ImageIcon gorri = new ImageIcon("src/img/gorri.png");
	private ImageIcon gris = new ImageIcon("src/img/gris.png");
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private ArrayList<JButton> sillas;
	private ArrayList<Integer> eleccion;
	private JFrame esta;
	private JButton b8;
	private JDateChooser calendario;

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
		esta = this;
		this.setIconImage(icon.getImage());
		this.setResizable(false);

		sillas = new ArrayList<JButton>();
		eleccion = new ArrayList<Integer>();

		Date date = new Date();
		calendario = new JDateChooser();
		calendario.getCalendar();
		calendario.setBounds(10, 85, 100, 30);
		contentPane.add(calendario);
		calendario.setDate(date);
		calendario.addPropertyChangeListener(new PropertyChangeListener() {

			public void propertyChange(PropertyChangeEvent evt) {
				// Cargar rojos
				rojos();
				System.out.println("Cambio rojos");
			}

		});

		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setFont(new Font("Serif", Font.PLAIN, 18));
		lblFecha.setBounds(10, 55, 69, 20);
		contentPane.add(lblFecha);

		panel = new JPanel();
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
				} else if (b1.getIcon() == gris) {
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
				} else if (b2.getIcon() == gris) {
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
				} else if (b3.getIcon() == gris) {
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
				} else if (b4.getIcon() == gris) {
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
				} else if (b5.getIcon() == gris) {
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
				} else if (b6.getIcon() == gris) {
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
				} else if (b7.getIcon() == gris) {
					b7.setIcon(imageIcon);
				}
			}

		});

		b8 = new JButton();
		b8.setBorder(null);
		b8.setIcon(imageIcon);
		b8.setBounds(125, 137, 23, 25);
		panel.add(b8);
		b8.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (b8.getIcon() == imageIcon) {
					b8.setIcon(gris);
				} else if (b8.getIcon() == gris) {
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
				} else if (b9.getIcon() == gris) {
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
				} else if (b10.getIcon() == gris) {
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
				} else if (b11.getIcon() == gris) {
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
				} else if (b12.getIcon() == gris) {
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
				} else if (b13.getIcon() == gris) {
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
				} else if (b14.getIcon() == gris) {
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
				} else if (b15.getIcon() == gris) {
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
				} else if (b16.getIcon() == gris) {
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
				} else if (b17.getIcon() == gris) {
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
				} else if (b18.getIcon() == gris) {
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
				} else if (b19.getIcon() == gris) {
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
				} else if (b20.getIcon() == gris) {
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
				} else if (b21.getIcon() == gris) {
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
				} else if (b22.getIcon() == gris) {
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
				} else if (b23.getIcon() == gris) {
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
				} else if (b24.getIcon() == gris) {
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
				} else if (b25.getIcon() == gris) {
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
				} else if (b26.getIcon() == gris) {
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
				} else if (b27.getIcon() == gris) {
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
				} else if (b28.getIcon() == gris) {
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
				} else if (b29.getIcon() == gris) {
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
				} else if (b30.getIcon() == gris) {
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
				} else if (b31.getIcon() == gris) {
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
				} else if (b32.getIcon() == gris) {
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
				} else if (b33.getIcon() == gris) {
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
				} else if (b34.getIcon() == gris) {
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
				} else if (b35.getIcon() == gris) {
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
				} else if (b36.getIcon() == gris) {
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
				} else if (b37.getIcon() == gris) {
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
				} else if (b38.getIcon() == gris) {
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
				} else if (b39.getIcon() == gris) {
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
				} else if (b40.getIcon() == gris) {
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
				} else if (b41.getIcon() == gris) {
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
				} else if (b42.getIcon() == gris) {
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
				} else if (b43.getIcon() == gris) {
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
				} else if (b44.getIcon() == gris) {
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
				} else if (b45.getIcon() == gris) {
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
				} else if (b46.getIcon() == gris) {
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
				} else if (b47.getIcon() == gris) {
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
				} else if (b48.getIcon() == gris) {
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
				} else if (b49.getIcon() == gris) {
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
				} else if (b50.getIcon() == gris) {
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
				} else if (b51.getIcon() == gris) {
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
				} else if (b52.getIcon() == gris) {
					b52.setIcon(imageIcon);
				}
			}

		});

		// Llenamos el array con los botones de las sillas
		sillas.add(b1);
		sillas.add(b2);
		sillas.add(b3);
		sillas.add(b4);
		sillas.add(b5);
		sillas.add(b6);
		sillas.add(b7);
		sillas.add(b8);
		sillas.add(b9);
		sillas.add(b10);
		sillas.add(b11);
		sillas.add(b12);
		sillas.add(b13);
		sillas.add(b14);
		sillas.add(b15);
		sillas.add(b16);
		sillas.add(b17);
		sillas.add(b18);
		sillas.add(b19);
		sillas.add(b20);
		sillas.add(b21);
		sillas.add(b22);
		sillas.add(b23);
		sillas.add(b24);
		sillas.add(b25);
		sillas.add(b26);
		sillas.add(b27);
		sillas.add(b28);
		sillas.add(b29);
		sillas.add(b30);
		sillas.add(b31);
		sillas.add(b32);
		sillas.add(b33);
		sillas.add(b34);
		sillas.add(b35);
		sillas.add(b36);
		sillas.add(b37);
		sillas.add(b38);
		sillas.add(b39);
		sillas.add(b40);
		sillas.add(b41);
		sillas.add(b42);
		sillas.add(b43);
		sillas.add(b44);
		sillas.add(b45);
		sillas.add(b46);
		sillas.add(b47);
		sillas.add(b48);
		sillas.add(b49);
		sillas.add(b50);
		sillas.add(b51);
		sillas.add(b52);

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

		JLabel lblTuEleccin = new JLabel("Tu eleccion");
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
		btnReservar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				reserva();
			}

		});
		contentPane.add(btnReservar);
		rojos();

		JButton btnMisReservas = new JButton("Mis reservas");
		btnMisReservas.setFont(new Font("Serif", Font.PLAIN, 16));
		btnMisReservas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				vtMisReservas i = new vtMisReservas();
				esta.add(i);
				panel.setVisible(false);
				i.setVisible(true);
				System.out.println("d");
			}
		});
		btnMisReservas.setBounds(5, 484, 115, 29);
		contentPane.add(btnMisReservas);

	}

	private void reserva() {
		eleccion.clear();
		for (int i = 1; i < 53; i++) {
			if (sillas.get(i - 1).getIcon() == gris) {
				eleccion.add(i);
			}
		}
		for (Integer a : eleccion) {
			System.out.println(a);
		}
		Date deleccion = calendario.getDate();
		System.out.println(calendario.getDate());
		String mensaje = "Seguro que quieres hacer la reserva de " + eleccion.size() + " sillas para el "
				+ deleccion.getDate() + " de " + mes(deleccion.getMonth() + 1) + " del " + (1900 + deleccion.getYear());
		if (eleccion.size() != 0) {
			if (JOptionPane.showConfirmDialog(esta, mensaje, "Reserva", JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE) == 0) {
				// Seguir reserva
				System.out.println("Seguimos");
			} else {
				for (JButton a : sillas) {
					a.setIcon(imageIcon);
				}
				rojos();
			}

		} else {
			JOptionPane.showMessageDialog(null, "Escoga las sillas que desee reservar.");
		}
	}

	private void rojos() {
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(1);
		a.add(2);
		a.add(3);
		for (Integer e : a) {
			sillas.get(e - 1).setIcon(gorri);
		}
		for (JButton b : sillas) {
			if (b.getIcon() != gorri) {
				b.setIcon(imageIcon);
			}
		}
	}

	private String mes(int mes) {
		switch (mes) {
		case 1:
			return "enero";
		case 2:
			return "febrero";
		case 3:
			return "marzo";
		case 4:
			return "abril";
		case 5:
			return "mayo";
		case 6:
			return "junio";
		case 7:
			return "julio";
		case 8:
			return "agosto";
		case 9:
			return "septiembre";
		case 10:
			return "octubre";
		case 11:
			return "noviembre";
		case 12:
			return "diciembre";
		default:
			return "no hay mes";
		}
	}
}
