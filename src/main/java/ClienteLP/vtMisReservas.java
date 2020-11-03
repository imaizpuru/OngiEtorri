package ClienteLP;

import javax.swing.JInternalFrame;
import javax.swing.JList;

public class vtMisReservas extends JInternalFrame {

	/**
	 * Create the frame.
	 */
	public vtMisReservas() {
		setBounds(0, 0, 450, 300);
		getContentPane().setLayout(null);

		JList list = new JList();
		list.setBounds(15, 0, 404, 259);
		getContentPane().add(list);

	}
}
