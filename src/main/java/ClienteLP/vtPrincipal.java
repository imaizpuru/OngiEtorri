package ClienteLP;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import ClienteLN.Controller;
import ServidorLD.Reserva;
import ServidorLD.Silla;
import ServidorLD.Usuario;

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
	private JPanel panel_1;
	private JMenuItem misReservas;
	private JMenuItem usuarios;
	private JMenuItem inventario;	
	private JMenuItem reserva;
	private JMenuBar menuBar;
	private JList listaReservas;
	private JButton btnReservar;
	private JButton btnPermiso;
	private JButton btnPermiso2;
	private JButton btnPago;
	private JButton btnEliminar;
	private JButton btnQuitarP;
	private JButton btnQuitarP2;
	private JLabel lblFecha;
	private JTable list;
	private JTable listaUsuarios;
	private JTable listainventario;
	private DefaultTableModel table_model;
	private DefaultTableModel table_modelo;
	private Usuario usuario;
	private List<Reserva> reservas = new ArrayList<Reserva>();
	private List<Reserva> reservasUser = new ArrayList<Reserva>();
	private JLabel lblNewLabel;
	private JLabel lblNewLabel1;
	private JLabel lblNewLabell;
	private JLabel lblNewLabell1;
	private JLabel lblNewLabe;

	private JLabel lblNewLabellI;
	private JLabel lblNewLabell1I;
	private JLabel lblNewLabeI;
	private JLabel lblNewLabeII;
	
	private Date deleccion;
	private Controller controller = new Controller();
	private int contReserva;
	private ArrayList<Silla> sillasGuardadas = new ArrayList<Silla>();
	private ArrayList<Integer> permisos;

	public int getContReserva() {
		return contReserva;
	}

	public void setContReserva(int contReserva) {
		this.contReserva = contReserva;
	}

	public JMenuItem getMisReservas() {
		return misReservas;
	}

	public void setMisReservas(JMenuItem misReservas) {
		this.misReservas = misReservas;
	}

	/**
	 * Create the frame.
	 */

	public vtPrincipal(Usuario user, ArrayList<Integer> permiso) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(550, 200, 800, 600);

		this.usuario = user;
		contReserva = controller.initContReserva();

		table_model = new DefaultTableModel();
		String[] col = { "Fecha", "Sillas" };
		table_model.setColumnIdentifiers(col);
		table_modelo = new DefaultTableModel();
		String[] colu = { "Numero de socio", "Nombre", "Admin" };
		table_modelo.setColumnIdentifiers(colu);
		list = new JTable(table_model);
		list.setBackground(new Color(240, 248, 255));
		list.setFont(new Font("Serif", Font.PLAIN, 20));
		list.setRowHeight(25);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setVisible(false);

		listaUsuarios = new JTable(table_modelo);
		listaUsuarios.setBackground(new Color(240, 248, 255));
		listaUsuarios.setFont(new Font("Serif", Font.PLAIN, 20));
		listaUsuarios.setRowHeight(25);
		listaUsuarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaUsuarios.setVisible(false);
		menuBar = new JMenuBar();

		
		listainventario = new JTable(table_modelo);
		listainventario.setBackground(new Color(240, 248, 255));
		listainventario.setFont(new Font("Serif", Font.PLAIN, 20));
		listainventario.setRowHeight(25);
		listainventario.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listainventario.setVisible(false);
		
		menuBar = new JMenuBar();
		reserva = new JMenuItem("Reserva");
		reserva.setFont(new Font("Serif", Font.BOLD, 20));
		reserva.setSelected(true);
		reserva.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				panel_1.setVisible(false);
				reserva.setSelected(true);
				misReservas.setSelected(false);
				panel.setVisible(true);
				calendario.setVisible(true);
				btnReservar.setVisible(true);
				lblFecha.setVisible(true);
				table_model.getDataVector().removeAllElements();
				rojos();
				btnPago.setVisible(false);
				btnEliminar.setVisible(false);
				usuarios.setSelected(false);
				btnPermiso.setVisible(false);
				btnPermiso2.setVisible(false);
				btnQuitarP.setVisible(false);
				btnQuitarP2.setVisible(false);
			}
		});

		misReservas = new JMenuItem("Mis Reservas");
		misReservas.setFont(new Font("Serif", Font.BOLD, 20));

		usuarios = new JMenuItem("Gestion de usuarios");
		usuarios.setFont(new Font("Serif", Font.BOLD, 20));
		usuarios.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				panel_1.setVisible(true);
				reserva.setSelected(false);
				misReservas.setSelected(false);
				usuarios.setSelected(true);
				panel.setVisible(false);
				calendario.setVisible(false);
				btnReservar.setVisible(false);
				lblFecha.setVisible(false);
				// rojos();
				btnPago.setVisible(false);
				btnEliminar.setVisible(false);
				listaUsuarios.setVisible(true);
				listainventario.setVisible(false);
				lblNewLabel.setVisible(false);
				lblNewLabel1.setVisible(false);
				lblNewLabell.setVisible(true);
				lblNewLabell1.setVisible(true);
				lblNewLabe.setVisible(true);
				lblNewLabellI.setVisible(false);
				lblNewLabell1I.setVisible(false);
				lblNewLabeI.setVisible(false);
				lblNewLabeII.setVisible(false);
				btnPermiso.setVisible(true);
				btnPermiso2.setVisible(false);
				btnQuitarP.setVisible(true);
				btnQuitarP2.setVisible(false);

				table_modelo.getDataVector().removeAllElements();

				DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();
				modelocentrar.setHorizontalAlignment(SwingConstants.CENTER);
				listaUsuarios.getColumnModel().getColumn(0).setCellRenderer(modelocentrar);
				listaUsuarios.getColumnModel().getColumn(1).setCellRenderer(modelocentrar);
				listaUsuarios.getColumnModel().getColumn(2).setCellRenderer(modelocentrar);
				// Llenar mis reservas
				for (Usuario r : controller.getUsuarios()) {

					Object[] fila = new Object[3];
					fila[0] = r.getNsocio();
					fila[1] = r.getNombre();

					if (r.isAdmin()) {
						fila[2] = "Si";
					} else {
						fila[2] = "No";
					}
					table_modelo.addRow(fila);
				}

				list.setVisible(false);
				listaUsuarios.setBounds(2, 2, 540, 488);
				listaUsuarios.repaint();

			}
		});
////////////////77
		inventario = new JMenuItem("Gestion de Inventario");
		inventario.setFont(new Font("Serif", Font.BOLD, 20));
		inventario.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				panel_1.setVisible(true);
				reserva.setSelected(false);
				misReservas.setSelected(false);
				usuarios.setSelected(false);
				inventario.setSelected(true);
				panel.setVisible(false);
				calendario.setVisible(false);
				btnReservar.setVisible(false);
				lblFecha.setVisible(false);
				// rojos();
				btnPago.setVisible(false);
				btnEliminar.setVisible(false);
				listaUsuarios.setVisible(false);
				listainventario.setVisible(true);
				lblNewLabel.setVisible(false);
				lblNewLabel1.setVisible(false);
				lblNewLabell.setVisible(false);
				lblNewLabell1.setVisible(false);
				lblNewLabe.setVisible(false);
				lblNewLabellI.setVisible(true);
				lblNewLabell1I.setVisible(true);
				lblNewLabeI.setVisible(true);
				lblNewLabeII.setVisible(true);
				btnPermiso.setVisible(false);
				btnPermiso2.setVisible(true);
				btnQuitarP.setVisible(false);
				btnQuitarP2.setVisible(true);

				table_modelo.getDataVector().removeAllElements();

				DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();
				modelocentrar.setHorizontalAlignment(SwingConstants.CENTER);
				listainventario.getColumnModel().getColumn(0).setCellRenderer(modelocentrar);
				listainventario.getColumnModel().getColumn(1).setCellRenderer(modelocentrar);
				listainventario.getColumnModel().getColumn(2).setCellRenderer(modelocentrar);
				listainventario.getColumnModel().getColumn(3).setCellRenderer(modelocentrar);
				// Llenar mis reservas
				for (Usuario r : controller.getUsuarios()) {

					Object[] fila = new Object[4];
					fila[0] = r.getNsocio();
					fila[1] = r.getNombre();

					if (r.isAdmin()) {
						fila[2] = "Si";
					} else {
						fila[2] = "No";
					}
					table_modelo.addRow(fila);
				}

				list.setVisible(false);
				listainventario.setBounds(2, 2, 540, 488);
				listainventario.repaint();

			}
		});

		
////////////
		menuBar.add(reserva);
		menuBar.add(misReservas);

		if (usuario.isAdmin()) {
			menuBar.add(usuarios);
			menuBar.add(inventario);
		}

		misReservas.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				panel_1.setVisible(true);
				panel.setVisible(false);
				listaUsuarios.setVisible(false);
				misReservas.setSelected(true);
				reserva.setSelected(false);
				calendario.setVisible(false);
				btnReservar.setVisible(false);
				lblFecha.setVisible(false);
				btnPago.setVisible(true);
				btnEliminar.setVisible(true);
				lblNewLabel.setVisible(true);
				lblNewLabel1.setVisible(true);
				lblNewLabell.setVisible(false);
				lblNewLabell1.setVisible(false);
				lblNewLabe.setVisible(false);
				lblNewLabellI.setVisible(false);
				lblNewLabell1I.setVisible(false);
				lblNewLabeI.setVisible(false);
				lblNewLabeII.setVisible(false);
				usuarios.setSelected(false);
				inventario.setSelected(false);
				btnPermiso.setVisible(false);
				btnQuitarP.setVisible(false);
				btnQuitarP2.setVisible(false);
				table_model.getDataVector().removeAllElements();

				DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();
				modelocentrar.setHorizontalAlignment(SwingConstants.CENTER);
				list.getColumnModel().getColumn(0).setCellRenderer(modelocentrar);
				list.getColumnModel().getColumn(1).setCellRenderer(modelocentrar);
				// Llenar mis reservas

				if (reservas != null) {
					reservasUser.clear();
					for (Reserva r : reservas) {
						if (r.getNumSocio() == usuario.getNsocio())// Socio
																	// pasado
																	// por
																	// par�metro
						{
							reservasUser.add(r);
							Object[] fila = new Object[2];
							fila[0] = r.getFecha().getDate() + " de " + mes(r.getFecha().getMonth() + 1);
							fila[1] = r.getSillas().size();
							table_model.addRow(fila);
						}
					}
				}

				list.setVisible(true);
				list.setBounds(2, 2, 540, 488);
				list.repaint();

			}
		});

		setJMenuBar(menuBar);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		esta = this;
		this.setTitle(usuario.getNombre() + " " + usuario.getApellido() + " - " + usuario.getNsocio());

		panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(30, 144, 255), 2));
		panel_1.setBounds(125, 35, 544, 492);
		panel_1.setLayout(null);
		panel_1.setVisible(false);
		contentPane.add(panel_1);
		panel_1.add(listaUsuarios);
		panel_1.add(list);

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
			}

		});

		lblFecha = new JLabel("Fecha:");
		lblFecha.setFont(new Font("Serif", Font.PLAIN, 18));
		lblFecha.setBounds(10, 55, 69, 20);
		contentPane.add(lblFecha);

		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(30, 144, 255), 2));
		panel.setBounds(125, 0, 669, 527);
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

		lblNewLabel = new JLabel("Fecha");
		lblNewLabel.setFont(new Font("Serif", Font.BOLD, 25));
		lblNewLabel.setBounds(230, 10, 69, 20);
		contentPane.add(lblNewLabel);

		lblNewLabel1 = new JLabel("Sillas");
		lblNewLabel1.setFont(new Font("Serif", Font.BOLD, 25));
		lblNewLabel1.setBounds(502, 10, 69, 20);
		contentPane.add(lblNewLabel1);

		lblNewLabell = new JLabel("Nº de socio");
		lblNewLabell.setFont(new Font("Serif", Font.BOLD, 25));
		lblNewLabell.setBounds(155, 10, 170, 20);
		contentPane.add(lblNewLabell);

		lblNewLabe = new JLabel("Nombre");
		lblNewLabe.setFont(new Font("Serif", Font.BOLD, 25));
		lblNewLabe.setBounds(355, 10, 170, 20);
		contentPane.add(lblNewLabe);

		lblNewLabell1 = new JLabel("Administrador");
		lblNewLabell1.setFont(new Font("Serif", Font.BOLD, 25));
		lblNewLabell1.setBounds(500, 10, 170, 20);
		contentPane.add(lblNewLabell1);
		////////////////////////////////////////////////////////////
		lblNewLabellI = new JLabel("Cod. producto");
		lblNewLabellI.setFont(new Font("Serif", Font.BOLD, 15));
		lblNewLabellI.setBounds(155, 10, 170, 20);
		contentPane.add(lblNewLabellI);

		lblNewLabeI = new JLabel("Nom. Producto");
		lblNewLabeI.setFont(new Font("Serif", Font.BOLD, 15));
		lblNewLabeI.setBounds(300, 10, 170, 20);
		contentPane.add(lblNewLabeI);

		lblNewLabell1I = new JLabel("Cantidad");
		lblNewLabell1I.setFont(new Font("Serif", Font.BOLD, 15));
		lblNewLabell1I.setBounds(460, 10, 170, 20);
		contentPane.add(lblNewLabell1I);
		
		lblNewLabeII = new JLabel("Precio");
		lblNewLabeII.setFont(new Font("Serif", Font.BOLD, 15));
		lblNewLabeII.setBounds(580, 10, 170, 20);
		contentPane.add(lblNewLabeII);

		
		btnPermiso = new JButton("<html>" + "Añadir" + "<br>" + "Permiso" + "</html>");
		btnPermiso.setFont(new Font("Serif", Font.PLAIN, 16));
		btnPermiso.setBounds(10, 139, 105, 60);
		btnPermiso.setVisible(false);
		btnPermiso.addActionListener(new ActionListener() {
			
		
			
//Aqui hay que poner la funcionalidad de añadir nuevo producto
			public void actionPerformed(ActionEvent e) {
				int r;
				try {
					r = listaUsuarios.getSelectedRow();
					if (listaUsuarios.getValueAt(r, 2).equals("No")) {
						if (controller.setAdmin((Integer) listaUsuarios.getValueAt(r, 0)) == 0) {
							llenarListaUsuarios();
						} else {
							JOptionPane.showMessageDialog(null, "No se ha podido dar el permiso");
						}
					} else {
						JOptionPane.showMessageDialog(null, "Este usuario ya es administrador");
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "No se ha elegido fila");
				}
			}
		});
		contentPane.add(btnPermiso);

		btnPermiso2 = new JButton("<html>" + "Añadir" + "<br>" + "Productos" + "</html>");
		btnPermiso2.setFont(new Font("Serif", Font.PLAIN, 16));
		btnPermiso2.setBounds(10, 139, 105, 60);
		btnPermiso2.setVisible(false);
		btnPermiso2.addActionListener(new ActionListener() {
			
		
			
//Aqui hay que poner la funcionalidad de añadir nuevo producto
			public void actionPerformed(ActionEvent e) {
				int r;
				try {
					r = listaUsuarios.getSelectedRow();
					if (listaUsuarios.getValueAt(r, 2).equals("No")) {
						if (controller.setAdmin((Integer) listaUsuarios.getValueAt(r, 0)) == 0) {
							llenarListaUsuarios();
						} else {
							JOptionPane.showMessageDialog(null, "No se ha podido dar el permiso");
						}
					} else {
						JOptionPane.showMessageDialog(null, "Este usuario ya es administrador");
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "No se ha elegido fila");
				}
			}
		});
		contentPane.add(btnPermiso2);
		
		btnReservar = new JButton("Reservar");
		btnReservar.setFont(new Font("Serif", Font.PLAIN, 16));
		btnReservar.setBounds(10, 139, 105, 29);
		btnReservar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				reserva();
			}

		});
		contentPane.add(btnReservar);

		btnPago = new JButton("Pagar");
		btnPago.setFont(new Font("Serif", Font.PLAIN, 16));
		btnPago.setBounds(10, 139, 105, 29);
		btnPago.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int r;
				r = list.getSelectedRow();
				Pago();
			}
		});
		btnPago.setVisible(false);
		contentPane.add(btnPago);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Serif", Font.PLAIN, 16));
		btnEliminar.setBounds(677, 139, 105, 29);
		btnEliminar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				eliminarReserva(list.getSelectedRow());

			}
		});
		btnEliminar.setVisible(false);
		contentPane.add(btnEliminar);

		btnQuitarP = new JButton("Quitar");
		btnQuitarP.setFont(new Font("Serif", Font.PLAIN, 16));
		btnQuitarP.setBounds(677, 139, 105, 60);
		btnQuitarP.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int r;
				try {
					r = listaUsuarios.getSelectedRow();
					if (listaUsuarios.getValueAt(r, 2).equals("Si")) {
						if (controller.setAdmin((Integer) listaUsuarios.getValueAt(r, 0)) == 0) {
							llenarListaUsuarios();
						} else {
							JOptionPane.showMessageDialog(null, "No se ha podido dar el permiso.");
						}
					} else {
						JOptionPane.showMessageDialog(null, "Este usuario ya es administrador.");
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "No se ha elegido fila");
				}
			}

		});
		btnQuitarP.setVisible(false);
		contentPane.add(btnQuitarP);
		
		btnQuitarP2 = new JButton("<html>" + "Quitar" + "<br>" + "Productos" + "</html>");
		btnQuitarP2.setFont(new Font("Serif", Font.PLAIN, 16));
		btnQuitarP2.setBounds(677, 139, 105, 60);
		btnQuitarP2.addActionListener(new ActionListener() {
			
			
////////// cambiar esto para la funcionalidad del inventario
			public void actionPerformed(ActionEvent e) {
				int r;
				try {
					r = listaUsuarios.getSelectedRow();
					if (listaUsuarios.getValueAt(r, 2).equals("Si")) {
						if (controller.setAdmin((Integer) listaUsuarios.getValueAt(r, 0)) == 0) {
							llenarListaUsuarios();
						} else {
							JOptionPane.showMessageDialog(null, "No se ha podido eliminar el producto.");
						}
					} else {
						JOptionPane.showMessageDialog(null, "Este usuario ya es administrador.");
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "No se ha elegido fila");
				}
			}

		});
		btnQuitarP2.setVisible(false);
		contentPane.add(btnQuitarP2);
	}

	private void llenarListaUsuarios() {
		table_modelo.getDataVector().removeAllElements();
		DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();
		modelocentrar.setHorizontalAlignment(SwingConstants.CENTER);
		listaUsuarios.getColumnModel().getColumn(0).setCellRenderer(modelocentrar);
		listaUsuarios.getColumnModel().getColumn(1).setCellRenderer(modelocentrar);
		listaUsuarios.getColumnModel().getColumn(2).setCellRenderer(modelocentrar);
		// Llenar mis reservas
		for (Usuario r : controller.getUsuarios()) {

			Object[] fila = new Object[3];
			fila[0] = r.getNsocio();
			fila[1] = r.getNombre();

			if (r.isAdmin()) {
				fila[2] = "Si";
			} else {
				fila[2] = "No";
			}
			table_modelo.addRow(fila);
		}
		listaUsuarios.repaint();
	}

	void eliminarReserva(int rr) {
		int r = rr;
		try {
			if (controller.deleteReserva(reservasUser.get(r).getNumReserva()) == 0) {
				reservasUser.remove(r);
				table_model.removeRow(r);
				list.repaint();
			} else {
				JOptionPane.showMessageDialog(null, "No se ha podido eliminar la reserva.");
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "No se ha elegido fila");
		}
	}

	private void reserva() {
		eleccion.clear();
		for (int i = 1; i < 53; i++) {
			if (sillas.get(i - 1).getIcon() == gris) {
				eleccion.add(i);
			}
		}
		deleccion = new Date();
		deleccion = calendario.getDate();
		String mensaje = "Seguro que quieres hacer la reserva de " + eleccion.size() + " sillas para el "
				+ deleccion.getDate() + " de " + mes(deleccion.getMonth() + 1) + " del " + (1900 + deleccion.getYear());
		if (eleccion.size() != 0) {
			if (diferentesMesas(deleccion, eleccion)) {

				if (JOptionPane.showConfirmDialog(esta, mensaje, "Reserva", JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE) == 0) {

					deleccion.setMonth(deleccion.getMonth());
					seguirReserva(deleccion, eleccion);
				} else {

				}

			}
		} else {
			JOptionPane.showMessageDialog(null, "Escoga las sillas que desee reservar.");
		}
	}

	private void Pago() {
		int r;
		r = list.getSelectedRow();

		try {
			if (!reservasUser.get(r).isBCuenta()) {
				vtPago p = new vtPago(reservas.get(r), r, this);
				p.setVisible(true);

			} else {
				JOptionPane.showMessageDialog(null, "Ya se ha asignado una cuenta a esta reserva");
			}

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "No se ha elegido fila");
		}

	}

	private void rojos() {
		ArrayList<Integer> a = new ArrayList<Integer>();
		reservas = controller.getReservas();
		if (reservas != null) {
			for (Reserva r : reservas) {
				if (r.getFecha().getDate() == calendario.getDate().getDate()) {
					for (Silla s : r.getSillas()) {
						a.add(s.getCodigoSilla());
					}
				}
			}
			for (JButton s : sillas) {
				s.setIcon(imageIcon);
			}
			for (Integer e : a) {
				sillas.get(e - 1).setIcon(gorri);
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

	public void seguirReserva(Date deleccion, ArrayList<Integer> eleccion) {

		ArrayList<Silla> sillas = new ArrayList<Silla>();
		for (Integer i : eleccion) {
			sillas.add(new Silla(i, deleccion));
		}

		// reservas.add(new Reserva(1, sillas, deleccion, 4));

		controller.crearReserva(usuario.getNsocio(), sillas, deleccion, contReserva);

		rojos();

		contReserva++;
	}

	private boolean diferentesMesas(Date deleccion, ArrayList<Integer> eleccion) {
		ArrayList<Silla> sillas = new ArrayList<Silla>();
		boolean sigue = true;
		for (Integer i : eleccion) {
			sillas.add(new Silla(i, deleccion));
		}
		boolean diferentesMesas = false;
		for (int i = 0; i < sillas.size() - 1; i++) {
			if (sillas.get(i + 1) != null) {
				if (sillas.get(i).getNumMesa() != sillas.get(i + 1).getNumMesa()) {
					diferentesMesas = true;
					sigue = false;
				}
			} else {
				break;
			}
		}
		if (diferentesMesas) {
			JOptionPane.showMessageDialog(null, "No se pueden reservar sillas de diferentes mesas.");

		}

		return sigue;

	}
}
