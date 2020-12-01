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

public class DAO implements IDAO {

	private PersistenceManagerFactory persistentManagerFactory;
	private PersistenceManager persistentManager;
	private Transaction transaction;
	
	private static DAO instance = new DAO();

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
		System.out.println(email);

		try {
			transaction.begin();
			Query<Usuario> query = persistentManager.newQuery(Usuario.class);
			query.setFilter("email == "+ email);

			@SuppressWarnings("unchecked")
			List<Usuario> accounts = (List<Usuario>) query.execute();
			System.out.println(accounts.size());
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
	
	public Usuario GetUsuarioSocio(int nsocio) {
		persistentManager = persistentManagerFactory.getPersistenceManager();
		transaction = persistentManager.currentTransaction();
		System.out.println(nsocio);

		try {
			transaction.begin();
			Query<Usuario> query = persistentManager.newQuery(Usuario.class);
			query.setFilter("nsocio == " + nsocio);

			@SuppressWarnings("unchecked")
			List<Usuario> accounts = (List<Usuario>) query.execute();
			System.out.println(accounts.size());
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
	public Reserva GetReservaUsuario(int numSocio) {
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
		return null;
	}
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
	public boolean ComprobarUsuario(String email, String contrasena) {
		persistentManager = persistentManagerFactory.getPersistenceManager();
		transaction = persistentManager.currentTransaction();

		try {
			transaction.begin();
			Query<Usuario> query = persistentManager.newQuery(Usuario.class);
			query.setFilter("email == " + email + " && contrasenya == " + contrasena);
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
	}
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
		return null;
	}
}
