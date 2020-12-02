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
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class vtPago extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblRefrescos;
	private JLabel lblLicores;
	private JSpinner spinner;
	private JSpinner spinner_1;
	private JLabel ttlLicores;
	private JLabel ttlRefrescos;
	private JButton btnNewButton;
	private JButton btnCocina;
	private JButton button_1;
	private JButton btnServicio;
	private double ref;
	private double lic;
	private double tot;
	private JLabel label;
	private JButton btnNewButton_1;
	private DecimalFormat df;

	/**
	 * Create the frame.
	 */
	public vtPago() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(665, 200, 570, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(240, 248, 255));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		df = new DecimalFormat("0.00");
		ref = 0;
		lic = 0;
		tot = 0;

		btnNewButton = new JButton("Bebidas");
		btnNewButton.setBounds(76, 85, 139, 48);
		btnNewButton.addActionListener(this);
		btnNewButton.setActionCommand("bebidas");
		contentPane.add(btnNewButton);

		btnCocina = new JButton("Cocina");
		btnCocina.setBounds(324, 85, 139, 48);
		btnCocina.addActionListener(this);
		contentPane.add(btnCocina);

		button_1 = new JButton("New button");
		button_1.setBounds(324, 149, 139, 48);
		button_1.addActionListener(this);
		contentPane.add(button_1);

		btnServicio = new JButton("Servicio");
		btnServicio.setBounds(76, 149, 139, 48);
		btnServicio.addActionListener(this);
		contentPane.add(btnServicio);

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
				tot = ref + lic;
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
				tot = ref + lic;
				label.setText(df.format(tot) + "€");

			}

		});

		ttlRefrescos = new JLabel();
		ttlRefrescos.setFont(new Font("Serif", Font.PLAIN, 18));
		ttlRefrescos.setBounds(372, 50, 91, 20);
		contentPane.add(ttlRefrescos);
		ttlRefrescos.setVisible(false);

		ttlLicores = new JLabel();
		ttlLicores.setFont(new Font("Serif", Font.PLAIN, 18));
		ttlLicores.setBounds(372, 86, 91, 20);
		contentPane.add(ttlLicores);
		ttlLicores.setVisible(false);

		btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(
				vtPago.class.getResource("/com/sun/javafx/scene/control/skin/caspian/fxvk-backspace-button.png")));
		btnNewButton_1.setBounds(15, 16, 54, 29);
		btnNewButton_1.setVisible(false);
		btnNewButton_1.addActionListener(this);
		btnNewButton_1.setActionCommand("atras");
		contentPane.add(btnNewButton_1);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "bebidas") {
			lblRefrescos.setVisible(true);
			lblLicores.setVisible(true);
			spinner.setVisible(true);
			spinner_1.setVisible(true);
			ttlRefrescos.setVisible(true);
			ttlLicores.setVisible(true);
			btnServicio.setVisible(false);
			btnCocina.setVisible(false);
			button_1.setVisible(false);
			btnNewButton.setVisible(false);
			btnNewButton_1.setVisible(true);
		}
		if (e.getActionCommand() == "atras") {
			lblRefrescos.setVisible(false);
			lblLicores.setVisible(false);
			spinner.setVisible(false);
			spinner_1.setVisible(false);
			ttlRefrescos.setVisible(false);
			ttlLicores.setVisible(false);
			btnServicio.setVisible(true);
			btnCocina.setVisible(true);
			button_1.setVisible(true);
			btnNewButton.setVisible(true);
			btnNewButton_1.setVisible(false);
		}

	}
}
