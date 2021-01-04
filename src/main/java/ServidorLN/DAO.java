package ServidorLN;

import java.util.Date;
import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import ServidorLD.Cuenta;
import ServidorLD.Producto;
import ServidorLD.Reserva;
import ServidorLD.Silla;
import ServidorLD.Usuario;

/**
 * 
 * @author Soldados de StackOverflow v2
 *
 */
public class DAO implements IDAO {

	private PersistenceManagerFactory persistentManagerFactory;
	private PersistenceManager persistentManager;
	private Transaction transaction;

	private static DAO instance = new DAO();

	/**
	 * Constrcutor del DAO. Se ejecuta las conexiones de datanucleus abriendo el
	 * fichero datanculeus.properties
	 */
	public DAO() {
		super();
		try {
			persistentManagerFactory = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		} catch (Exception ex) {
			System.err.println("* Exception: " + ex.getMessage());
		}
	}

	public static DAO getInstance() {
		return instance;
	}

	public Usuario GetUsuarioEmail(String email) {
		persistentManager = persistentManagerFactory.getPersistenceManager();
		transaction = persistentManager.currentTransaction();
		Usuario user = new Usuario();

		try {
			transaction.begin();
			Query<Usuario> query = persistentManager.newQuery(Usuario.class);
			query.setFilter("email == '" + email + "'");
			@SuppressWarnings("unchecked")
			List<Usuario> accounts = (List<Usuario>) query.execute();
			if (accounts.size() == 1) {
				user = accounts.get(0);
				transaction.commit();
				System.out.println(user);
				return user;
			}

		} catch (Exception ex) {
			System.err.println("* Exception executing a query: " + ex.getMessage());
			return null;
		} finally {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			persistentManager.close();
		}
		return null;
	}

	public Usuario GetUsuarioSocio(int nsocio) {
		persistentManager = persistentManagerFactory.getPersistenceManager();
		transaction = persistentManager.currentTransaction();
		Usuario user = new Usuario();
		try {
			transaction.begin();
			Query<Usuario> query = persistentManager.newQuery(Usuario.class);
			query.setFilter("nsocio == " + nsocio);
			@SuppressWarnings("unchecked")
			List<Usuario> accounts = (List<Usuario>) query.execute();
			if (accounts.size() == 1) {
				user = accounts.get(0);
				transaction.commit();
				return user;
			}
		} catch (Exception ex) {
			System.err.println("* Exception executing a query: " + ex.getMessage());
			return null;
		} finally {
			if (transaction.isActive()) {
				transaction.rollback();
			}

			persistentManager.close();
		}
		return null;
	}

	public List<Usuario> GetUsuariosList() {
		persistentManager = persistentManagerFactory.getPersistenceManager();
		transaction = persistentManager.currentTransaction();

		try {
			transaction.begin();
			Query<Usuario> query = persistentManager.newQuery(Usuario.class);
			@SuppressWarnings("unchecked")
			List<Usuario> usuarios = (List<Usuario>) query.execute();
			if (usuarios.size() > 0) {
				transaction.commit();
				System.out.println(usuarios);
				return usuarios;
			}
			transaction.commit();
		} catch (Exception ex) {
			System.err.println("* Exception executing a query: " + ex.getMessage());
			return null;
		} finally {
			if (transaction.isActive()) {
				transaction.rollback();
			}

			persistentManager.close();
		}
		return null;
	}

	public List<Reserva> GetReservasListUser(int numSocio) {
		persistentManager = persistentManagerFactory.getPersistenceManager();
		transaction = persistentManager.currentTransaction();
		// Usuario user = new Usuario();
		// System.out.println(nsocio);

		try {
			transaction.begin();
			Query<Reserva> query = persistentManager.newQuery(Reserva.class);
			query.setFilter("nsocio == '" + numSocio + "'");
			// query.setFilter("nsocio == " + nsocio);
			@SuppressWarnings("unchecked")
			List<Reserva> reservas = (List<Reserva>) query.execute();
			if (reservas.size() > 0) {
				return reservas;

			}
			transaction.commit();
		} catch (Exception ex) {
			System.err.println("* Exception executing a query: " + ex.getMessage());
			return null;
		} finally {
			if (transaction.isActive()) {
				transaction.rollback();
				Query<Reserva> query = persistentManager.newQuery(Reserva.class);
				@SuppressWarnings("unchecked")
				List<Reserva> reservas = (List<Reserva>) query.execute();
			}

			persistentManager.close();
		}
		return null;
	}

	public boolean GetReservasList(List<Reserva> res) {
		persistentManager = persistentManagerFactory.getPersistenceManager();
		transaction = persistentManager.currentTransaction();
		try {
			transaction.begin();
			Query<Reserva> query = persistentManager.newQuery(Reserva.class);
			@SuppressWarnings("unchecked")
			List<Reserva> reservas = (List<Reserva>) query.execute();
			if (reservas.size() > 0) {
				for (int i = 0; i < reservas.size(); i++) {
					res.add(reservas.get(i));
				}
			}
			transaction.commit();
			System.out.println(reservas);
		} catch (Exception ex) {
			System.err.println("* Exception executing a query: " + ex.getMessage());
			return false;
		} finally {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			persistentManager.close();
		}
		return true;
	}

	public Reserva GetReservaUsuario(int numSocio) {
		persistentManager = persistentManagerFactory.getPersistenceManager();
		transaction = persistentManager.currentTransaction();

		try {
			transaction.begin();
			Query<Reserva> query = persistentManager.newQuery(Reserva.class);
			query.setFilter("nsocio == '" + numSocio + "'");

			@SuppressWarnings("unchecked")
			List<Reserva> accounts = (List<Reserva>) query.execute();
			if (accounts.size() != 1)
				return accounts.get(0);
			transaction.commit();
		} catch (Exception ex) {
			System.err.println("* Exception executing a query: " + ex.getMessage());
			return null;
		} finally {
			if (transaction.isActive()) {
				transaction.rollback();
			}

			persistentManager.close();
		}
		return null;
	}

	public int GetLastReservas() {
		persistentManager = persistentManagerFactory.getPersistenceManager();
		transaction = persistentManager.currentTransaction();

		try {
			transaction.begin();
			Query<Reserva> query = persistentManager.newQuery(Reserva.class);
			// query.setFilter("nsocio == '" + numSocio + "'");

			@SuppressWarnings("unchecked")
			List<Reserva> accounts = (List<Reserva>) query.execute();
			if (accounts.size() > 0)
				return accounts.get(accounts.size() - 1).getNumReserva();
			transaction.commit();
		} catch (Exception ex) {
			System.err.println("* Exception executing a query: " + ex.getMessage());
			return 0;
		} finally {
			if (transaction.isActive()) {
				transaction.rollback();
			}

			persistentManager.close();
		}
		return 0;
	}

	public boolean GuardarMesas(List<Silla> sillas) {
		try {
			persistentManager = persistentManagerFactory.getPersistenceManager();
			transaction = persistentManager.currentTransaction();
			System.out.println(sillas.get(0));
			transaction.begin();
			for (Silla m : sillas) {
				persistentManager.makePersistent(m);
			}
			System.out.println("- Inserted into db: " + sillas.size());
			transaction.commit();
		} catch (Exception ex) {
			System.err.println("* Exception inserting sillas data into db: " + ex.getMessage());
			return false;
		} finally {
			if (transaction.isActive()) {
				transaction.rollback();
			}

			persistentManager.close();
		}
		return true;
	}

	/**
	 * Metod del DAO de registro de usuario.
	 * 
	 * @param usuario
	 *            Se le pasa como parametro un objeto usuario y se inserta en la
	 *            base de datos todos los atributos de ese usuario.
	 * @return devuelve true si el registro se realiza correctamente
	 */
	public boolean GuardarUsuario(Usuario usuario) {
		try {
			persistentManager = persistentManagerFactory.getPersistenceManager();
			transaction = persistentManager.currentTransaction();

			transaction.begin();
			persistentManager.makePersistent(usuario);
			System.out.println("- Inserted into db: " + usuario.getNsocio());
			transaction.commit();
		} catch (Exception ex) {
			System.err.println("* Exception inserting usuario data into db: " + ex.getMessage());
			return false;
		} finally {
			if (transaction.isActive()) {
				transaction.rollback();
			}

			persistentManager.close();
		}
		return true;
	}

	/**
	 * Metodo de inicio de sesion de un usuario
	 * 
	 * @param email
	 * @param contrasenya
	 *            Se pasa como paramentro el email y contrasenya de un usuario
	 *            concreto. Para comprobar el inicio de sesion, se crea una
	 *            query y se filtra el email y la contrasenya.
	 * @return devuelve true si el inicio de sesion se realiza correctamente
	 */
	public boolean ComprobarUsuario(String email, String contrasenya) {
		persistentManager = persistentManagerFactory.getPersistenceManager();
		transaction = persistentManager.currentTransaction();

		try {
			transaction.begin();
			Query<Usuario> query = persistentManager.newQuery(Usuario.class);
			query.setFilter("email == '" + email + "' && contrasenya == '" + contrasenya + "'");
			@SuppressWarnings("unchecked")
			List<Usuario> accounts = (List<Usuario>) query.execute();
			// System.out.println(accounts.get(0));
			if (accounts.size() != 1)

				throw new Exception();

			transaction.commit();
		} catch (Exception ex) {
			System.err.println("* Exception executing a query: " + ex.getMessage());
			return false;
		} finally {
			if (transaction.isActive()) {
				transaction.rollback();
			}

			persistentManager.close();
		}
		return true;
	}

	/**
	 * Metodo de reserva
	 * 
	 * @param reserva
	 *            Se pasa como paramentro un objeto reserva y se inserta en la
	 *            base de datos todos los atributos de esa reserva.
	 * @return devuelve true si la reserva se realiza correctamente
	 */
	public boolean ReservarMesa(Reserva reserva) {
		try {
			persistentManager = persistentManagerFactory.getPersistenceManager();
			transaction = persistentManager.currentTransaction();

			transaction.begin();
			persistentManager.makePersistent(reserva);
			System.out.println("- Inserted into db: " + reserva.getNumReserva());
			transaction.commit();
		} catch (Exception ex) {
			System.err.println("* Exception inserting reservation data into db: " + ex.getMessage());
			return false;
		} finally {
			if (transaction.isActive()) {
				transaction.rollback();
			}

			persistentManager.close();
		}
		return true;
	}

	public boolean deleteReserva(int numReserva) {
		try {
			persistentManager = persistentManagerFactory.getPersistenceManager();
			transaction = persistentManager.currentTransaction();
			transaction.begin();
			Query<Reserva> query = persistentManager.newQuery(Reserva.class, "numReserva ==" + numReserva);
			@SuppressWarnings("unchecked")
			List<Reserva> result = (List<Reserva>) query.execute();
			persistentManager.deletePersistent(result.get(0));
			transaction.commit();
		} catch (Exception ex) {
			System.err.println("* Exception deleting reservation data from db: " + ex.getMessage());
			return false;
		} finally {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			persistentManager.close();
		}
		return true;
	}

	public Reserva GetReservaFecha(Date fecha) {
		persistentManager = persistentManagerFactory.getPersistenceManager();
		transaction = persistentManager.currentTransaction();

		try {
			transaction.begin();
			Query<Reserva> query = persistentManager.newQuery(Reserva.class);
			query.setFilter("fecha == '" + fecha + "'");

			@SuppressWarnings("unchecked")
			List<Reserva> accounts = (List<Reserva>) query.execute();
			if (accounts.size() != 1)
				return accounts.get(0);
			transaction.commit();
		} catch (Exception ex) {
			System.err.println("* Exception executing a query: " + ex.getMessage());
			return null;
		} finally {
			if (transaction.isActive()) {
				transaction.rollback();
			}

			persistentManager.close();
		}
		return null;
	}

	public Reserva GetSillaFecha(Date fecha) {
		persistentManager = persistentManagerFactory.getPersistenceManager();
		transaction = persistentManager.currentTransaction();

		try {
			transaction.begin();
			Query<Reserva> query = persistentManager.newQuery(Reserva.class);
			query.setFilter("fecha == '" + fecha + "'");

			@SuppressWarnings("unchecked")
			List<Reserva> accounts = (List<Reserva>) query.execute();
			if (accounts.size() != 1)
				return accounts.get(0);
			transaction.commit();
		} catch (Exception ex) {
			System.err.println("* Exception executing a query: " + ex.getMessage());
			return null;
		} finally {
			if (transaction.isActive()) {
				transaction.rollback();
			}

			persistentManager.close();
		}
		return null;
	}

	public boolean setAdmin(int nsocio) {
		persistentManager = persistentManagerFactory.getPersistenceManager();
		transaction = persistentManager.currentTransaction();

		try {
			transaction.begin();
			Query<Usuario> query = persistentManager.newQuery(Usuario.class);
			query.setFilter("nsocio == " + nsocio);
			@SuppressWarnings("unchecked")
			List<Usuario> usuarios = (List<Usuario>) query.execute();

			if (usuarios.size() == 1) {
				usuarios.get(0).setAdmin(!usuarios.get(0).isAdmin());
				transaction.commit();
			}
		} catch (Exception ex) {
			System.err.println("* Exception executing a query: " + ex.getMessage());
			return false;
		} finally {
			if (transaction.isActive()) {
				transaction.rollback();
			}

			persistentManager.close();
		}
		return true;
	}

	public boolean anadirCuenta(Reserva r, Cuenta c) {
		persistentManager = persistentManagerFactory.getPersistenceManager();
		transaction = persistentManager.currentTransaction();

		try {
			transaction.begin();
			Query<Reserva> query = persistentManager.newQuery(Reserva.class);
			query.setFilter("numReserva == " + r.getNumReserva());
			@SuppressWarnings("unchecked")
			List<Reserva> reservas = (List<Reserva>) query.execute();

			if (reservas.size() == 1) {
				r.setCuenta(c);
				r.setBCuenta(true);
				transaction.commit();
			}
		} catch (Exception ex) {
			System.err.println("* Exception executing a query: " + ex.getMessage());
			return false;
		} finally {
			if (transaction.isActive()) {
				transaction.rollback();
			}

			persistentManager.close();
		}
		return true;
	}

	public boolean anadirProducto(Producto p) {
		persistentManager = persistentManagerFactory.getPersistenceManager();
		transaction = persistentManager.currentTransaction();

		try {
			transaction.begin();
			Query<Producto> query = persistentManager.newQuery(Producto.class);
			query.setFilter("codigoP == " + p.getCodigoP());

			@SuppressWarnings("unchecked")
			List<Producto> producto = (List<Producto>) query.execute();
			if (producto.size() == 0) {
				persistentManager.makePersistent(p);
				transaction.commit();
			} else if (producto.size() == 1) {
				producto.get(0).setCantidad(producto.get(0).getCantidad() + p.getCantidad());
				if (p.getPrecio() != 0)
					producto.get(0).setPrecio(p.getPrecio());
				transaction.commit();
			}
		} catch (Exception ex) {
			System.err.println("* Exception executing a query: " + ex.getMessage());
			return false;
		} finally {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			persistentManager.close();
		}
		return true;
	}

	public boolean anadirCantidad(int codigoP, int cantidad) {
		persistentManager = persistentManagerFactory.getPersistenceManager();
		transaction = persistentManager.currentTransaction();

		try {
			transaction.begin();
			Query<Producto> query = persistentManager.newQuery(Producto.class);
			query.setFilter("codigoP == " + codigoP);
			@SuppressWarnings("unchecked")
			List<Producto> producto = (List<Producto>) query.execute();
			if (producto.size() == 1) {
				producto.get(0).setCantidad(producto.get(0).getCantidad() + cantidad);
				transaction.commit();
			}
		} catch (Exception ex) {
			System.err.println("* Exception executing a query: " + ex.getMessage());
			return false;
		} finally {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			persistentManager.close();
		}
		return true;
	}

	public List<Producto> getProductos() {

		persistentManager = persistentManagerFactory.getPersistenceManager();
		transaction = persistentManager.currentTransaction();

		try {
			transaction.begin();
			Query<Producto> query = persistentManager.newQuery(Producto.class);
			@SuppressWarnings("unchecked")
			List<Producto> productos = (List<Producto>) query.execute();
			if (productos.size() > 0) {
				transaction.commit();
				System.out.println(productos);
				return productos;
			}
		} catch (Exception ex) {
			System.err.println("* Exception executing a query: " + ex.getMessage());
			return null;
		} finally {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			persistentManager.close();
		}
		return null;
	}

	public boolean eliminarProducto(int codigoP) {

		try {
			persistentManager = persistentManagerFactory.getPersistenceManager();
			transaction = persistentManager.currentTransaction();
			transaction.begin();
			Query<Producto> query = persistentManager.newQuery(Producto.class, "codigoP ==" + codigoP);
			@SuppressWarnings("unchecked")
			List<Producto> result = (List<Producto>) query.execute();
			persistentManager.deletePersistent(result.get(0));
			transaction.commit();
		} catch (Exception ex) {
			System.err.println("* Exception deleting reservation data from db: " + ex.getMessage());
			return false;
		} finally {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			persistentManager.close();
		}
		return true;
	}
}
