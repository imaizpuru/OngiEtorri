package ServidorLN;

import java.util.Date;
import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;


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
	 * Constrcutor del DAO. Se ejecuta las conexiones de datanucleus abriendo el fichero datanculeus.properties
	 */
	public DAO() {
		super();
		try {
			persistentManagerFactory = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		} catch (Exception ex) {
			System.err.println("* Exception: " + ex.getMessage());
		}
	}
	public static DAO getInstance(){
		return instance;
	}
/*	@Override
	public boolean GuardarMesas(List<Silla> sillas) {
		try {
			persistentManager = persistentManagerFactory.getPersistenceManager();
			transaction = persistentManager.currentTransaction();

			transaction.begin();
			for (Silla m : sillas) {
				persistentManager.makePersistent(m);
			}
			System.out.println("- Inserted into db: " + sillas.size());
			transaction.commit();
		} catch (Exception ex) {
			System.err.println("* Exception inserting flights data into db: " + ex.getMessage());
			return false;
		} finally {
			if (transaction.isActive()) {
				transaction.rollback();
			}

			persistentManager.close();
		}
		return true;
	}
	@Override
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
	@Override
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

	// public Flight GetVuelo(int cod_vuelo) {
	// // TODO Auto-generated method stub
	// return null;
	// }
	@Override
	public Usuario GetUsuario(int numSocio) {
		persistentManager = persistentManagerFactory.getPersistenceManager();
		transaction = persistentManager.currentTransaction();

		try {
			transaction.begin();
			Query<Usuario> query = persistentManager.newQuery(Usuario.class);
			query.setFilter("nsocio == " + numSocio);

			@SuppressWarnings("unchecked")
			List<Usuario> accounts = (List<Usuario>) query.execute();
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
	public Reserva GetReservaUsuario(String numSocio){
		persistentManager = persistentManagerFactory.getPersistenceManager();
		transaction = persistentManager.currentTransaction();
			
		try {
		    transaction.begin();
		    Query<Reserva> query = persistentManager.newQuery(Reserva.class);
			query.setFilter("nsocio == " + numSocio);

			@SuppressWarnings("unchecked")
			List<Reserva> accounts = (List<Reserva>) query.execute();
			if(accounts.size()!=1) return accounts.get(0);
		    transaction.commit();
		} catch(Exception ex) {
			System.err.println("* Exception executing a query: " + ex.getMessage());
			return null;
		} finally {
			if (transaction.isActive()) {
		        transaction.rollback();
		    }

		    persistentManager.close();
		}
		return null;}
	
	@Override
	public Reserva GetReservaFecha(Date fecha){
		persistentManager = persistentManagerFactory.getPersistenceManager();
		transaction = persistentManager.currentTransaction();
			
		try {
		    transaction.begin();
		    Query<Reserva> query = persistentManager.newQuery(Reserva.class);
			query.setFilter("fecha == " + fecha);

			@SuppressWarnings("unchecked")
			List<Reserva> accounts = (List<Reserva>) query.execute();
			if(accounts.size()!=1) return accounts.get(0);
		    transaction.commit();
		} catch(Exception ex) {
			System.err.println("* Exception executing a query: " + ex.getMessage());
			return null;
		} finally {
			if (transaction.isActive()) {
		        transaction.rollback();
		    }

		    persistentManager.close();
		}
		return null;}
	public Inventario GetInventario{
		return null;}
	public boolean GuardarInventario(){
		return true;
	}

	@Override
	public boolean ComprobarUsuario(String email, String contrasena) {
		persistentManager = persistentManagerFactory.getPersistenceManager();
		transaction = persistentManager.currentTransaction();

		try {
			transaction.begin();
			Query<Usuario> query = persistentManager.newQuery(Usuario.class);
			query.setFilter("email == " + email + " && password == " + contrasena);

			@SuppressWarnings("unchecked")
			List<Usuario> accounts = (List<Usuario>) query.execute();
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
	}*/
	public Usuario GetUsuarioEmail(String email) {
		persistentManager = persistentManagerFactory.getPersistenceManager();
		transaction = persistentManager.currentTransaction();
		Usuario user = new Usuario();
		//System.out.println(email);

		try {
			transaction.begin();
			//System.out.println("Hola");
			Query<Usuario> query = persistentManager.newQuery(Usuario.class);
			query.setFilter("email == '"+ email+"'");
			//System.out.println("hOLA");
			@SuppressWarnings("unchecked")
			List<Usuario> accounts = (List<Usuario>) query.execute();
			//System.out.println(accounts.get(0));
			if (accounts.size() == 1)
			{
				user = accounts.get(0);
				//System.out.println(user);
				//System.out.println(1);
				return user;
			}
			transaction.commit();
		} catch (Exception ex) {
			System.err.println("* Exception executing a query: " + ex.getMessage());
			return null;
		} finally {
			if (transaction.isActive()) {
				transaction.rollback();
			System.out.println(user);
			}
			persistentManager.close();
		}
		return null;
	}
	public Usuario GetUsuarioSocio(int nsocio) {
		persistentManager = persistentManagerFactory.getPersistenceManager();
		transaction = persistentManager.currentTransaction();
		Usuario user = new Usuario();
		//System.out.println(nsocio);

		try {
			transaction.begin();
			System.out.println("Hola");
			Query<Usuario> query = persistentManager.newQuery(Usuario.class);
			query.setFilter("nsocio == " + nsocio);
			System.out.println("hOLA");
			@SuppressWarnings("unchecked")
			List<Usuario> accounts = (List<Usuario>) query.execute();
			System.out.println(accounts.size());
			if (accounts.size() == 1)
			{
				user = accounts.get(0);
				return user;
			}

			transaction.commit();
		} catch (Exception ex) {
			System.err.println("* Exception executing a query: " + ex.getMessage());
			return null;
		} finally {
			if (transaction.isActive()) {
				transaction.rollback();
				System.out.println(user);
			}

			persistentManager.close();
		}
		return null;
	}
	public List <Usuario> GetUsuariosList() {
		persistentManager = persistentManagerFactory.getPersistenceManager();
		transaction = persistentManager.currentTransaction();
		//Usuario user = new Usuario();
		//System.out.println(nsocio);

		try {
			transaction.begin();
			Query<Usuario> query = persistentManager.newQuery(Usuario.class);
			//query.setFilter("nsocio == " + nsocio);
			@SuppressWarnings("unchecked")
			List<Usuario> usuarios = (List<Usuario>) query.execute();
			System.out.println(usuarios.size());
			if (usuarios.size() > 0)
			{	
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
				Query<Usuario> query = persistentManager.newQuery(Usuario.class);
				List<Usuario> usuarios = (List<Usuario>) query.execute();
				System.out.println(usuarios);
			}

			persistentManager.close();
		}
		return null;
	}
	public List <Reserva> GetReservasListUser(int numSocio) {
		persistentManager = persistentManagerFactory.getPersistenceManager();
		transaction = persistentManager.currentTransaction();
		//Usuario user = new Usuario();
		//System.out.println(nsocio);

		try {
			transaction.begin();
			Query<Reserva> query = persistentManager.newQuery(Reserva.class);
			query.setFilter("nsocio == '" + numSocio + "'");
			//query.setFilter("nsocio == " + nsocio);
			@SuppressWarnings("unchecked")
			List<Reserva> reservas = (List<Reserva>) query.execute();
			System.out.println(reservas.size());
			if (reservas.size() > 0)
			{	
				System.out.println(reservas);
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
				List<Reserva> reservas = (List<Reserva>) query.execute();
				System.out.println(reservas);
			}

			persistentManager.close();
		}
		return null;
	}
	/*
	public List <Reserva> GetReservasListDate(Date fecha) {
		persistentManager = persistentManagerFactory.getPersistenceManager();
		transaction = persistentManager.currentTransaction();
		//Usuario user = new Usuario();
		//System.out.println(nsocio);

		try {
			transaction.begin();
			Query<Reserva> query = persistentManager.newQuery(Reserva.class);
			query.setFilter("fecha == '" + fecha + "'");
			//query.setFilter("nsocio == " + nsocio);
			@SuppressWarnings("unchecked")
			List<Reserva> reservas = (List<Reserva>) query.execute();
			System.out.println(reservas.size());
			if (reservas.size() > 0)
			{	
				System.out.println(reservas);
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
				List<Reserva> reservas = (List<Reserva>) query.execute();
				System.out.println(reservas);
			}

			persistentManager.close();
		}
		return null;
	}
	*/
	public List <Reserva> GetReservasList() {
		persistentManager = persistentManagerFactory.getPersistenceManager();
		transaction = persistentManager.currentTransaction();
		//Usuario user = new Usuario();
		//System.out.println(nsocio);

		try {
			transaction.begin();
			Query<Reserva> query = persistentManager.newQuery(Reserva.class);
			//query.setFilter("nsocio == " + nsocio);
			@SuppressWarnings("unchecked")
			List<Reserva> reservas = (List<Reserva>) query.execute();
			System.out.println(reservas.size());
			if (reservas.size() > 0)
			{	
				System.out.println(reservas);
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
				List<Reserva> reservas = (List<Reserva>) query.execute();
				System.out.println(reservas);
			}

			persistentManager.close();
		}
		return null;
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
			if(accounts.size()!=1) return accounts.get(0);
		    transaction.commit();
		} catch(Exception ex) {
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
			//query.setFilter("nsocio == '" + numSocio + "'");

			@SuppressWarnings("unchecked")
			List<Reserva> accounts = (List<Reserva>) query.execute();
			if(accounts.size() > 0) return accounts.get(accounts.size()-1).getNumReserva();
		    transaction.commit();
		} catch(Exception ex) {
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
	 * @param usuario
	 * Se le pasa como parametro un objeto usuario y se inserta en la base de datos todos los atributos de ese usuario.
	 *@return devuelve true si el registro se realiza correctamente
	 */
	public boolean GuardarUsuario(Usuario usuario) {
		System.out.println(usuario);
		try {
			persistentManager = persistentManagerFactory.getPersistenceManager();
			transaction = persistentManager.currentTransaction();

			transaction.begin();
			persistentManager.makePersistent(usuario);
			System.out.println(usuario);
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
	 * @param email
	 * @param contrasenya
	 * Se pasa como paramentro el email y contrasenya de un usuario concreto. Para comprobar el inicio de sesion, se crea una query y se filtra el email y la contrasenya.
	 * @return devuelve true si el inicio de sesion se realiza correctamente
	 */
	public boolean ComprobarUsuario(String email, String contrasenya) {
		persistentManager = persistentManagerFactory.getPersistenceManager();
		transaction = persistentManager.currentTransaction();

		try {
			transaction.begin();
			Query<Usuario> query = persistentManager.newQuery(Usuario.class);
			query.setFilter("email == '" + email + "' && contrasenya == '" + contrasenya+ "'");
			@SuppressWarnings("unchecked")
			List<Usuario> accounts = (List<Usuario>) query.execute();
			//System.out.println(accounts.get(0));
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
	 * @param reserva
	 * Se pasa como paramentro un objeto reserva y se inserta en la base de datos todos los atributos de esa reserva.
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
	public Reserva GetReservaFecha(Date fecha) {
		persistentManager = persistentManagerFactory.getPersistenceManager();
		transaction = persistentManager.currentTransaction();
			
		try {
		    transaction.begin();
		    Query<Reserva> query = persistentManager.newQuery(Reserva.class);
			query.setFilter("fecha == '" + fecha + "'");

			@SuppressWarnings("unchecked")
			List<Reserva> accounts = (List<Reserva>) query.execute();
			if(accounts.size()!=1) return accounts.get(0);
		    transaction.commit();
		} catch(Exception ex) {
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
			if(accounts.size()!=1) return accounts.get(0);
		    transaction.commit();
		} catch(Exception ex) {
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
}
