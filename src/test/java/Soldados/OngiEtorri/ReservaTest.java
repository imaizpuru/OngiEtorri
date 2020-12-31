package Soldados.OngiEtorri;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import ClienteLP.vtPrincipal;
import ServidorLD.Reserva;
import ServidorLD.Usuario;
import ServidorLN.DAO;

public class ReservaTest {

	Usuario user;
	Reserva reserva;
	vtPrincipal ventana;
	Date data;
	ArrayList<Integer> array;
	int contReserva;
	int contReserva2;

	private DAO dao;

	@Before
	public void setUp() throws Exception {

		user = new Usuario(1, "a", "a", "a", "a", false);
		ventana = new vtPrincipal(user, new ArrayList<Integer>());
		reserva = new Reserva();
		array = new ArrayList<Integer>();
		array.add(1);
		array.add(2);
		array.add(3);
		data = new Date(120, 05, 01);
		contReserva = ventana.getContReserva();
		contReserva2 = ventana.getContReserva();

		dao = DAO.getInstance();

	}

	@Test
	public void test() {
		boolean retorno;

		// System.out.println(dao.GetUsuarioEmail(user.getEmail()));

		ventana.seguirReserva(data, array);
		contReserva2 = ventana.getContReserva();

		if (user == null) {
			// assertNotSame(user.getEmail(), usuario.getEmail());
		} else {

			assertEquals(contReserva + 1, contReserva2);

		}

	}

}
