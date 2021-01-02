package ClienteLP;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import ClienteLN.Controller;
import ServidorLD.Reserva;

public class vtPago extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblRefrescos;
	private JLabel lblLicores;
	private JLabel lblcerveza;
	private JLabel lblchampagne;
	private JLabel lblcebolla;
	private JLabel lblpatatas;
	private JLabel lblaceitunas;
	private JLabel lblAjo;
	private JLabel lblservilletas;
	private JLabel lblvasos;
	private JLabel lblproductoslimpieza;
	private JSpinner spinner;
	private JSpinner spinner2;
	private JSpinner spinner3;
	private JSpinner spinner_1;
	private JSpinner spinner4;
	private JSpinner spinner5;
	private JSpinner spinner6;
	private JSpinner spinner_7;
	private JSpinner spinner8;
	private JSpinner spinner9;
	private JSpinner spinner10;
	private JLabel ttlLicores;
	private JLabel ttlRefrescos;
	private JLabel ttlcerveza;
	private JLabel ttlchampagne;
	private JLabel ttlcebolla;
	private JLabel ttlpatatas;
	private JLabel ttlaceitunas;
	private JLabel ttlajo;
	private JLabel ttlservilletas;
	private JLabel ttlvasos;
	private JLabel ttlproductolimpieza;
	private JButton btnNewButton;
	private JButton btnCocina;
	private JButton button_1;
	private JLabel btnNewButton2;
	private JLabel btnNewButton3;
	private JLabel btnNewButton4;
	private JLabel btnNewButton5;
	private double ref;
	private double cer;
	private double cham;
	private double lic;
	private double ceb;
	private double pat;
	private double ace;
	private double ajo;
	private double ser;
	private double vas;
	private double prod;
	private double tot = 0;
	private Controller controller = new Controller();

	private JLabel label;
	private JButton btnNewButton_1;
	private DecimalFormat df;
	private JButton btnNewButton_2;
	private ImageIcon imageIcon = new ImageIcon("src/img/logo.png");
	private Reserva reserva;
	private final int rrr;

	/**
	 * Create the frame.
	 */
	public vtPago(Reserva r, int rr, final vtPrincipal vt) {
		this.rrr = rr;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(665, 200, 570, 600);
		setTitle("Pago");
		this.reserva = r;
		this.setIconImage(imageIcon.getImage());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(240, 248, 255));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		df = new DecimalFormat("0.00");
		ref = 0;
		lic = 0;
		cer = 0;
		cham = 0;

		btnNewButton = new JButton("Bebidas");
		btnNewButton.setBounds(30, 85, 139, 48);
		btnNewButton.addActionListener(this);
		btnNewButton.setActionCommand("bebidas");
		contentPane.add(btnNewButton);

		btnCocina = new JButton("Comida");
		btnCocina.setBounds(200, 85, 139, 48);
		btnCocina.addActionListener(this);
		btnCocina.setActionCommand("Comida");
		contentPane.add(btnCocina);

		button_1 = new JButton("Cocina");
		button_1.setBounds(370, 85, 139, 48);
		button_1.addActionListener(this);
		button_1.setActionCommand("Cocina");
		contentPane.add(button_1);

		JLabel lblTotal = new JLabel("Total a pagar:");
		lblTotal.setFont(new Font("Serif", Font.PLAIN, 30));
		lblTotal.setBounds(51, 354, 177, 54);
		contentPane.add(lblTotal);

		label = new JLabel("");
		label.setFont(new Font("Serif", Font.PLAIN, 30));
		label.setBounds(253, 354, 177, 54);
		contentPane.add(label);

		lblRefrescos = new JLabel("Refrescos:");
		lblRefrescos.setFont(new Font("Serif", Font.PLAIN, 18));
		lblRefrescos.setBounds(86, 49, 83, 20);
		contentPane.add(lblRefrescos);
		lblRefrescos.setVisible(false);

		lblLicores = new JLabel("Licores:");
		lblLicores.setFont(new Font("Serif", Font.PLAIN, 18));
		lblLicores.setBounds(86, 85, 83, 20);
		contentPane.add(lblLicores);
		lblLicores.setVisible(false);

		lblcerveza = new JLabel("Cerveza:");
		lblcerveza.setFont(new Font("Serif", Font.PLAIN, 18));
		lblcerveza.setBounds(86, 125, 83, 20);
		contentPane.add(lblcerveza);
		lblcerveza.setVisible(false);

		lblchampagne = new JLabel("Champagne:");
		lblchampagne.setFont(new Font("Serif", Font.PLAIN, 18));
		lblchampagne.setBounds(86, 166, 113, 20);
		contentPane.add(lblchampagne);
		lblchampagne.setVisible(false);

		spinner2 = new JSpinner();
		spinner2.setBounds(253, 115, 54, 29);
		contentPane.add(spinner2);
		spinner2.setVisible(false);
		spinner2.getEditor().getComponent(0).setBackground(new Color(240, 248, 255));
		spinner2.setFont(new Font("Serif", Font.PLAIN, 28));
		spinner2.addChangeListener(new ChangeListener() {

			public void stateChanged(ChangeEvent e) {
				cer = (Double.valueOf((Integer) spinner2.getValue()) * 1.3);
				ttlcerveza.setText(df.format(cer) + "€");
				tot = ref + cer + cham + lic + ceb + pat + ace + ajo;
				label.setText(df.format(tot) + "€");
			}

		});

		spinner3 = new JSpinner();
		spinner3.setBounds(253, 155, 54, 29);
		contentPane.add(spinner3);
		spinner3.setVisible(false);
		spinner3.getEditor().getComponent(0).setBackground(new Color(240, 248, 255));
		spinner3.setFont(new Font("Serif", Font.PLAIN, 28));
		spinner3.addChangeListener(new ChangeListener() {

			public void stateChanged(ChangeEvent e) {
				cham = (Double.valueOf((Integer) spinner3.getValue()) * 3.5);
				ttlchampagne.setText(df.format(cham) + "€");
				tot = ref + cer + cham + lic + ceb + pat + ace + ajo;
				label.setText(df.format(tot) + "€");
			}

		});

		spinner = new JSpinner();
		spinner.setBounds(253, 47, 54, 29);
		contentPane.add(spinner);
		spinner.setVisible(false);
		spinner.getEditor().getComponent(0).setBackground(new Color(240, 248, 255));
		spinner.setFont(new Font("Serif", Font.PLAIN, 28));
		spinner.addChangeListener(new ChangeListener() {

			public void stateChanged(ChangeEvent e) {
				ref = (Double.valueOf((Integer) spinner.getValue()) * 1.2);
				ttlRefrescos.setText(df.format(ref) + "€");
				tot = ref + cer + cham + lic + ceb + pat + ace + ajo;
				label.setText(df.format(tot) + "€");
			}

		});

		spinner_1 = new JSpinner();
		spinner_1.setBounds(253, 82, 54, 29);
		contentPane.add(spinner_1);
		spinner_1.getEditor().getComponent(0).setBackground(new Color(240, 248, 255));
		spinner_1.setFont(new Font("Serif", Font.PLAIN, 28));
		spinner_1.setVisible(false);
		spinner_1.addChangeListener(new ChangeListener() {

			public void stateChanged(ChangeEvent e) {
				lic = (Double.valueOf((Integer) spinner_1.getValue()) * 1.8);
				ttlLicores.setText(df.format(lic) + "€");
				tot = ref + cer + cham + lic + ceb + pat + ace + ajo;
				label.setText(df.format(tot) + "€");

			}

		});

		ttlRefrescos = new JLabel();
		ttlRefrescos.setFont(new Font("Serif", Font.PLAIN, 18));
		ttlRefrescos.setBounds(372, 50, 91, 20);
		contentPane.add(ttlRefrescos);
		ttlRefrescos.setVisible(false);

		ttlcerveza = new JLabel();
		ttlcerveza.setFont(new Font("Serif", Font.PLAIN, 18));
		ttlcerveza.setBounds(372, 124, 91, 20);
		contentPane.add(ttlcerveza);
		ttlcerveza.setVisible(false);

		ttlchampagne = new JLabel();
		ttlchampagne.setFont(new Font("Serif", Font.PLAIN, 18));
		ttlchampagne.setBounds(372, 164, 91, 20);
		contentPane.add(ttlchampagne);
		ttlchampagne.setVisible(false);

		ttlLicores = new JLabel();
		ttlLicores.setFont(new Font("Serif", Font.PLAIN, 18));
		ttlLicores.setBounds(372, 86, 91, 20);
		contentPane.add(ttlLicores);
		ttlLicores.setVisible(false);

		lblcebolla = new JLabel("Cebolla:");
		lblcebolla.setFont(new Font("Serif", Font.PLAIN, 18));
		lblcebolla.setBounds(86, 49, 83, 20);
		contentPane.add(lblcebolla);
		lblcebolla.setVisible(false);

		lblpatatas = new JLabel("Patatas:");
		lblpatatas.setFont(new Font("Serif", Font.PLAIN, 18));
		lblpatatas.setBounds(86, 85, 83, 20);
		contentPane.add(lblpatatas);
		lblpatatas.setVisible(false);

		lblaceitunas = new JLabel("Aceitunas:");
		lblaceitunas.setFont(new Font("Serif", Font.PLAIN, 18));
		lblaceitunas.setBounds(86, 125, 83, 20);
		contentPane.add(lblaceitunas);
		lblaceitunas.setVisible(false);

		lblAjo = new JLabel("Ajo:");
		lblAjo.setFont(new Font("Serif", Font.PLAIN, 18));
		lblAjo.setBounds(86, 166, 113, 20);
		contentPane.add(lblAjo);
		lblAjo.setVisible(false);

		spinner4 = new JSpinner();
		spinner4.setBounds(253, 115, 54, 29);
		contentPane.add(spinner4);
		spinner4.setVisible(false);
		spinner4.getEditor().getComponent(0).setBackground(new Color(240, 248, 255));
		spinner4.setFont(new Font("Serif", Font.PLAIN, 28));
		spinner4.addChangeListener(new ChangeListener() {

			public void stateChanged(ChangeEvent e) {
				ace = (Double.valueOf((Integer) spinner4.getValue()) * 2);
				ttlaceitunas.setText(df.format(ace) + "€");
				tot = ref + cer + cham + lic + ceb + pat + ace + ajo;
				label.setText(df.format(tot) + "€");
			}

		});

		spinner5 = new JSpinner();
		spinner5.setBounds(253, 155, 54, 29);
		contentPane.add(spinner5);
		spinner5.setVisible(false);
		spinner5.getEditor().getComponent(0).setBackground(new Color(240, 248, 255));
		spinner5.setFont(new Font("Serif", Font.PLAIN, 28));
		spinner5.addChangeListener(new ChangeListener() {

			public void stateChanged(ChangeEvent e) {
				ajo = (Double.valueOf((Integer) spinner5.getValue()) * 0.8);
				ttlajo.setText(df.format(ajo) + "€");
				tot = ref + cer + cham + lic + ceb + pat + ace + ajo;
				label.setText(df.format(tot) + "€");
			}

		});

		spinner6 = new JSpinner();
		spinner6.setBounds(253, 47, 54, 29);
		contentPane.add(spinner6);
		spinner6.setVisible(false);
		spinner6.getEditor().getComponent(0).setBackground(new Color(240, 248, 255));
		spinner6.setFont(new Font("Serif", Font.PLAIN, 28));
		spinner6.addChangeListener(new ChangeListener() {

			public void stateChanged(ChangeEvent e) {
				ceb = (Double.valueOf((Integer) spinner6.getValue()) * 1);
				ttlcebolla.setText(df.format(ceb) + "€");
				tot = ref + cer + cham + lic + ceb + pat + ace + ajo;
				label.setText(df.format(tot) + "€");
			}

		});

		spinner_7 = new JSpinner();
		spinner_7.setBounds(253, 82, 54, 29);
		contentPane.add(spinner_7);
		spinner_7.getEditor().getComponent(0).setBackground(new Color(240, 248, 255));
		spinner_7.setFont(new Font("Serif", Font.PLAIN, 28));
		spinner_7.setVisible(false);
		spinner_7.addChangeListener(new ChangeListener() {

			public void stateChanged(ChangeEvent e) {
				pat = (Double.valueOf((Integer) spinner_7.getValue()) * 2);
				ttlpatatas.setText(df.format(pat) + "€");
				tot = ref + cer + cham + lic + ceb + pat + ace + ajo;
				label.setText(df.format(tot) + "€");

			}

		});

		ttlcebolla = new JLabel();
		ttlcebolla.setFont(new Font("Serif", Font.PLAIN, 18));
		ttlcebolla.setBounds(372, 50, 91, 20);
		contentPane.add(ttlcebolla);
		ttlcebolla.setVisible(false);

		ttlpatatas = new JLabel();
		ttlpatatas.setFont(new Font("Serif", Font.PLAIN, 18));
		ttlpatatas.setBounds(372, 86, 91, 20);
		contentPane.add(ttlpatatas);
		ttlpatatas.setVisible(false);

		ttlaceitunas = new JLabel();
		ttlaceitunas.setFont(new Font("Serif", Font.PLAIN, 18));
		ttlaceitunas.setBounds(372, 124, 91, 20);
		contentPane.add(ttlaceitunas);
		ttlaceitunas.setVisible(false);

		ttlajo = new JLabel();
		ttlajo.setFont(new Font("Serif", Font.PLAIN, 18));
		ttlajo.setBounds(372, 164, 91, 20);
		contentPane.add(ttlajo);
		ttlajo.setVisible(false);

		lblcebolla = new JLabel("Cebolla:");
		lblcebolla.setFont(new Font("Serif", Font.PLAIN, 18));
		lblcebolla.setBounds(86, 49, 83, 20);
		contentPane.add(lblcebolla);
		lblcebolla.setVisible(false);

		lblpatatas = new JLabel("Patatas:");
		lblpatatas.setFont(new Font("Serif", Font.PLAIN, 18));
		lblpatatas.setBounds(86, 85, 83, 20);
		contentPane.add(lblpatatas);
		lblpatatas.setVisible(false);

		lblaceitunas = new JLabel("Aceitunas:");
		lblaceitunas.setFont(new Font("Serif", Font.PLAIN, 18));
		lblaceitunas.setBounds(86, 125, 83, 20);
		contentPane.add(lblaceitunas);
		lblaceitunas.setVisible(false);

		lblAjo = new JLabel("Ajo:");
		lblAjo.setFont(new Font("Serif", Font.PLAIN, 18));
		lblAjo.setBounds(86, 166, 113, 20);
		contentPane.add(lblAjo);
		lblAjo.setVisible(false);

		spinner4 = new JSpinner();
		spinner4.setBounds(253, 115, 54, 29);
		contentPane.add(spinner4);
		spinner4.setVisible(false);
		spinner4.getEditor().getComponent(0).setBackground(new Color(240, 248, 255));
		spinner4.setFont(new Font("Serif", Font.PLAIN, 28));
		spinner4.addChangeListener(new ChangeListener() {

			public void stateChanged(ChangeEvent e) {
				ace = (Double.valueOf((Integer) spinner4.getValue()) * 2);
				ttlaceitunas.setText(df.format(ace) + "€");
				tot = ref + cer + cham + lic + ceb + pat + ace + ajo;
				label.setText(df.format(tot) + "€");
			}

		});

		spinner5 = new JSpinner();
		spinner5.setBounds(253, 155, 54, 29);
		contentPane.add(spinner5);
		spinner5.setVisible(false);
		spinner5.getEditor().getComponent(0).setBackground(new Color(240, 248, 255));
		spinner5.setFont(new Font("Serif", Font.PLAIN, 28));
		spinner5.addChangeListener(new ChangeListener() {

			public void stateChanged(ChangeEvent e) {
				ajo = (Double.valueOf((Integer) spinner5.getValue()) * 0.8);
				ttlajo.setText(df.format(ajo) + "€");
				tot = ref + cer + cham + lic + ceb + pat + ace + ajo;
				label.setText(df.format(tot) + "€");
			}

		});

		spinner6 = new JSpinner();
		spinner6.setBounds(253, 47, 54, 29);
		contentPane.add(spinner6);
		spinner6.setVisible(false);
		spinner6.getEditor().getComponent(0).setBackground(new Color(240, 248, 255));
		spinner6.setFont(new Font("Serif", Font.PLAIN, 28));
		spinner6.addChangeListener(new ChangeListener() {

			public void stateChanged(ChangeEvent e) {
				ceb = (Double.valueOf((Integer) spinner6.getValue()) * 1);
				ttlcebolla.setText(df.format(ceb) + "€");
				tot = ref + cer + cham + lic + ceb + pat + ace + ajo;
				label.setText(df.format(tot) + "€");
			}

		});

		spinner_7 = new JSpinner();
		spinner_7.setBounds(253, 82, 54, 29);
		contentPane.add(spinner_7);
		spinner_7.getEditor().getComponent(0).setBackground(new Color(240, 248, 255));
		spinner_7.setFont(new Font("Serif", Font.PLAIN, 28));
		spinner_7.setVisible(false);
		spinner_7.addChangeListener(new ChangeListener() {

			public void stateChanged(ChangeEvent e) {
				pat = (Double.valueOf((Integer) spinner_7.getValue()) * 2);
				ttlpatatas.setText(df.format(pat) + "€");
				tot = ref + cer + cham + lic + ceb + pat + ace + ajo;
				label.setText(df.format(tot) + "€");

			}

		});

		ttlcebolla = new JLabel();
		ttlcebolla.setFont(new Font("Serif", Font.PLAIN, 18));
		ttlcebolla.setBounds(372, 50, 91, 20);
		contentPane.add(ttlcebolla);
		ttlcebolla.setVisible(false);

		ttlpatatas = new JLabel();
		ttlpatatas.setFont(new Font("Serif", Font.PLAIN, 18));
		ttlpatatas.setBounds(372, 86, 91, 20);
		contentPane.add(ttlpatatas);
		ttlpatatas.setVisible(false);

		ttlaceitunas = new JLabel();
		ttlaceitunas.setFont(new Font("Serif", Font.PLAIN, 18));
		ttlaceitunas.setBounds(372, 124, 91, 20);
		contentPane.add(ttlaceitunas);
		ttlaceitunas.setVisible(false);

		ttlajo = new JLabel();
		ttlajo.setFont(new Font("Serif", Font.PLAIN, 18));
		ttlajo.setBounds(372, 164, 91, 20);
		contentPane.add(ttlajo);
		ttlajo.setVisible(false);

		lblservilletas = new JLabel("Servilletas:");
		lblservilletas.setFont(new Font("Serif", Font.PLAIN, 18));
		lblservilletas.setBounds(86, 49, 83, 20);
		contentPane.add(lblservilletas);
		lblservilletas.setVisible(false);

		lblvasos = new JLabel("Vasos:");
		lblvasos.setFont(new Font("Serif", Font.PLAIN, 18));
		lblvasos.setBounds(86, 85, 83, 20);
		contentPane.add(lblvasos);
		lblvasos.setVisible(false);

		lblproductoslimpieza = new JLabel("Productos Limpieza:");
		lblproductoslimpieza.setFont(new Font("Serif", Font.PLAIN, 18));
		lblproductoslimpieza.setBounds(86, 125, 170, 20);
		contentPane.add(lblproductoslimpieza);
		lblproductoslimpieza.setVisible(false);

		spinner8 = new JSpinner();
		spinner8.setBounds(253, 80, 54, 29);
		contentPane.add(spinner8);
		spinner8.setVisible(false);
		spinner8.getEditor().getComponent(0).setBackground(new Color(240, 248, 255));
		spinner8.setFont(new Font("Serif", Font.PLAIN, 28));
		spinner8.addChangeListener(new ChangeListener() {

			public void stateChanged(ChangeEvent e) {
				vas = (Double.valueOf((Integer) spinner8.getValue()) * 0.5);
				ttlvasos.setText(df.format(vas) + "€");
				tot = ref + cer + cham + lic + ceb + pat + ace + ajo + vas + ser + prod;
				label.setText(df.format(tot) + "€");
			}

		});

		spinner9 = new JSpinner();
		spinner9.setBounds(253, 115, 54, 29);
		contentPane.add(spinner9);
		spinner9.setVisible(false);
		spinner9.getEditor().getComponent(0).setBackground(new Color(240, 248, 255));
		spinner9.setFont(new Font("Serif", Font.PLAIN, 28));
		spinner9.addChangeListener(new ChangeListener() {

			public void stateChanged(ChangeEvent e) {
				prod = (Double.valueOf((Integer) spinner9.getValue()) * 0.7);
				ttlproductolimpieza.setText(df.format(prod) + "€");
				tot = ref + cer + cham + lic + ceb + pat + ace + ajo + vas + ser + prod;
				label.setText(df.format(tot) + "€");
			}

		});

		spinner10 = new JSpinner();
		spinner10.setBounds(253, 47, 54, 29);
		contentPane.add(spinner10);
		spinner10.setVisible(false);
		spinner10.getEditor().getComponent(0).setBackground(new Color(240, 248, 255));
		spinner10.setFont(new Font("Serif", Font.PLAIN, 28));
		spinner10.addChangeListener(new ChangeListener() {

			public void stateChanged(ChangeEvent e) {
				ser = (Double.valueOf((Integer) spinner10.getValue()) * 0.2);
				ttlservilletas.setText(df.format(ser) + "€");
				tot = ref + cer + cham + lic + ceb + pat + ace + ajo + vas + ser + prod;
				label.setText(df.format(tot) + "€");
			}

		});

		ttlservilletas = new JLabel();
		ttlservilletas.setFont(new Font("Serif", Font.PLAIN, 18));
		ttlservilletas.setBounds(372, 50, 91, 20);
		contentPane.add(ttlservilletas);
		ttlservilletas.setVisible(false);

		ttlvasos = new JLabel();
		ttlvasos.setFont(new Font("Serif", Font.PLAIN, 18));
		ttlvasos.setBounds(372, 86, 91, 20);
		contentPane.add(ttlvasos);
		ttlvasos.setVisible(false);

		ttlproductolimpieza = new JLabel();
		ttlproductolimpieza.setFont(new Font("Serif", Font.PLAIN, 18));
		ttlproductolimpieza.setBounds(372, 124, 91, 20);
		contentPane.add(ttlproductolimpieza);
		ttlproductolimpieza.setVisible(false);

		btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(
				vtPago.class.getResource("/com/sun/javafx/scene/control/skin/caspian/fxvk-backspace-button.png")));
		btnNewButton_1.setBounds(15, 16, 54, 29);
		btnNewButton_1.setVisible(false);
		btnNewButton_1.addActionListener(this);
		btnNewButton_1.setActionCommand("atras");
		contentPane.add(btnNewButton_1);

		btnNewButton2 = new JLabel("");
		btnNewButton2.setIcon(new ImageIcon(("src/img/bebida.png")));
		btnNewButton2.setBounds(75, 150, 54, 29);
		btnNewButton2.setVisible(true);
		contentPane.add(btnNewButton2);

		btnNewButton3 = new JLabel("");
		btnNewButton3.setIcon(new ImageIcon(("src/img/comida.png")));
		btnNewButton3.setBounds(250, 150, 54, 29);
		btnNewButton3.setVisible(true);
		contentPane.add(btnNewButton3);

		btnNewButton4 = new JLabel("");
		btnNewButton4.setIcon(new ImageIcon(("src/img/cocina.jpg")));
		btnNewButton4.setBounds(420, 150, 54, 29);
		btnNewButton4.setVisible(true);
		contentPane.add(btnNewButton4);

		btnNewButton_2 = new JButton("Pagar");
		btnNewButton_2.setBounds(208, 454, 115, 29);
		contentPane.add(btnNewButton_2);

		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int n2 = JOptionPane.showConfirmDialog(null,
						"¿Estás seguro que quieres efectuar el pago de  " + tot + " euros ahora?", " ",
						JOptionPane.YES_NO_OPTION);

				if (n2 == JOptionPane.YES_OPTION) {
					if (controller.anadirCuenta(reserva, tot) == 0) {
						JOptionPane.showMessageDialog(null, "Pago realizado con exito. Muchas gracias");

						vt.eliminarReserva(rrr);
					} else {
						JOptionPane.showMessageDialog(null, "Error al realizar la cuenta.");
					}
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Se ha cancelado el pago");
				}
			}

		});

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "bebidas") {
			lblRefrescos.setVisible(true);
			lblLicores.setVisible(true);
			lblcerveza.setVisible(true);
			lblchampagne.setVisible(true);
			spinner.setVisible(true);
			spinner2.setVisible(true);
			spinner3.setVisible(true);
			spinner_1.setVisible(true);
			ttlRefrescos.setVisible(true);
			ttlchampagne.setVisible(true);
			ttlcerveza.setVisible(true);
			ttlLicores.setVisible(true);

			lblcebolla.setVisible(false);
			lblpatatas.setVisible(false);
			lblaceitunas.setVisible(false);
			lblAjo.setVisible(false);
			spinner4.setVisible(false);
			spinner5.setVisible(false);
			spinner6.setVisible(false);
			spinner_7.setVisible(false);
			ttlcebolla.setVisible(false);
			ttlpatatas.setVisible(false);
			ttlaceitunas.setVisible(false);
			ttlajo.setVisible(false);

			btnCocina.setVisible(false);
			button_1.setVisible(false);
			btnNewButton.setVisible(false);
			btnNewButton_1.setVisible(true);
			btnNewButton_2.setVisible(false);
			btnNewButton2.setVisible(false);
			btnNewButton3.setVisible(false);
			btnNewButton4.setVisible(false);

			lblservilletas.setVisible(false);
			lblvasos.setVisible(false);
			lblproductoslimpieza.setVisible(false);
			spinner8.setVisible(false);
			spinner9.setVisible(false);
			spinner10.setVisible(false);
			ttlservilletas.setVisible(false);
			ttlvasos.setVisible(false);
			ttlproductolimpieza.setVisible(false);

		}
		if (e.getActionCommand() == "atras") {
			lblRefrescos.setVisible(false);
			lblLicores.setVisible(false);
			lblcerveza.setVisible(false);
			lblchampagne.setVisible(false);
			spinner.setVisible(false);
			spinner2.setVisible(false);
			spinner3.setVisible(false);
			spinner_1.setVisible(false);
			ttlRefrescos.setVisible(false);
			ttlcerveza.setVisible(false);
			ttlLicores.setVisible(false);
			ttlchampagne.setVisible(false);

			lblcebolla.setVisible(false);
			lblpatatas.setVisible(false);
			lblaceitunas.setVisible(false);
			lblAjo.setVisible(false);
			spinner4.setVisible(false);
			spinner5.setVisible(false);
			spinner6.setVisible(false);
			spinner_7.setVisible(false);
			ttlcebolla.setVisible(false);
			ttlpatatas.setVisible(false);
			ttlaceitunas.setVisible(false);
			ttlajo.setVisible(false);

			btnCocina.setVisible(true);
			button_1.setVisible(true);
			btnNewButton.setVisible(true);
			btnNewButton_1.setVisible(false);
			btnNewButton_2.setVisible(true);
			btnNewButton2.setVisible(true);
			btnNewButton3.setVisible(true);
			btnNewButton4.setVisible(true);

			lblservilletas.setVisible(false);
			lblvasos.setVisible(false);
			lblproductoslimpieza.setVisible(false);
			spinner8.setVisible(false);
			spinner9.setVisible(false);
			spinner10.setVisible(false);
			ttlservilletas.setVisible(false);
			ttlvasos.setVisible(false);
			ttlproductolimpieza.setVisible(false);

		}

		if (e.getActionCommand() == "Comida") {
			lblRefrescos.setVisible(false);
			lblLicores.setVisible(false);
			lblcerveza.setVisible(false);
			lblchampagne.setVisible(false);
			spinner.setVisible(false);
			spinner2.setVisible(false);
			spinner3.setVisible(false);
			spinner_1.setVisible(false);
			ttlRefrescos.setVisible(false);
			ttlchampagne.setVisible(false);
			ttlcerveza.setVisible(false);
			ttlLicores.setVisible(false);
			btnCocina.setVisible(false);
			button_1.setVisible(false);
			btnNewButton.setVisible(false);
			btnNewButton_1.setVisible(true);
			btnNewButton_2.setVisible(false);
			btnNewButton2.setVisible(false);
			btnNewButton3.setVisible(false);
			btnNewButton4.setVisible(false);

			lblcebolla.setVisible(true);
			lblpatatas.setVisible(true);
			lblaceitunas.setVisible(true);
			lblAjo.setVisible(true);
			spinner4.setVisible(true);
			spinner5.setVisible(true);
			spinner6.setVisible(true);
			spinner_7.setVisible(true);
			ttlcebolla.setVisible(true);
			ttlpatatas.setVisible(true);
			ttlaceitunas.setVisible(true);
			ttlajo.setVisible(true);

			lblservilletas.setVisible(false);
			lblvasos.setVisible(false);
			lblproductoslimpieza.setVisible(false);
			spinner8.setVisible(false);
			spinner9.setVisible(false);
			spinner10.setVisible(false);
			ttlservilletas.setVisible(false);
			ttlvasos.setVisible(false);
			ttlproductolimpieza.setVisible(false);
		}
		if (e.getActionCommand() == "Cocina") {
			lblRefrescos.setVisible(false);
			lblLicores.setVisible(false);
			lblcerveza.setVisible(false);
			lblchampagne.setVisible(false);
			spinner.setVisible(false);
			spinner2.setVisible(false);
			spinner3.setVisible(false);
			spinner_1.setVisible(false);
			ttlRefrescos.setVisible(false);
			ttlchampagne.setVisible(false);
			ttlcerveza.setVisible(false);
			ttlLicores.setVisible(false);
			btnCocina.setVisible(false);
			button_1.setVisible(false);
			btnNewButton.setVisible(false);
			btnNewButton_1.setVisible(true);
			btnNewButton_2.setVisible(false);
			btnNewButton2.setVisible(false);
			btnNewButton3.setVisible(false);
			btnNewButton4.setVisible(false);

			lblcebolla.setVisible(false);
			lblpatatas.setVisible(false);
			lblaceitunas.setVisible(false);
			lblAjo.setVisible(false);
			spinner4.setVisible(false);
			spinner5.setVisible(false);
			spinner6.setVisible(false);
			spinner_7.setVisible(false);
			ttlcebolla.setVisible(false);
			ttlpatatas.setVisible(false);
			ttlaceitunas.setVisible(false);
			ttlajo.setVisible(false);

			lblservilletas.setVisible(true);
			lblvasos.setVisible(true);
			lblproductoslimpieza.setVisible(true);
			spinner8.setVisible(true);
			spinner9.setVisible(true);
			spinner10.setVisible(true);
			ttlservilletas.setVisible(true);
			ttlvasos.setVisible(true);
			ttlproductolimpieza.setVisible(true);
		}

	}
}
