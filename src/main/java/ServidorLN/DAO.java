package ServidorLN;

import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import ServidorLD.Silla;
import ServidorLD.Reserva;
import ServidorLD.Usuario;

public class DAO implements IDAO {

	private PersistenceManagerFactory persistentManagerFactory;
	private PersistenceManager persistentManager;
	private Transaction transaction;
	public DAO() {
		super();
		try
		{
			persistentManagerFactory=JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		}
		catch (Exception ex) {
		System.err.println("* Exception: " + ex.getMessage());
		}
	}
			

	public boolean GuardarMesas(List<Silla> sillas) {
		try {
			persistentManager = persistentManagerFactory.getPersistenceManager();
			transaction = persistentManager.currentTransaction();
			
		    transaction.begin();
		    for(Silla m:sillas)
		    {
		    	persistentManager.makePersistent(m);
		    }
		    System.out.println("- Inserted into db: " + sillas.size());
		    transaction.commit();
		} catch(Exception ex) {
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
		try {
			persistentManager = persistentManagerFactory.getPersistenceManager();
			transaction = persistentManager.currentTransaction();
			
		    transaction.begin();
		    persistentManager.makePersistent(usuario);
		    System.out.println("- Inserted into db: " + usuario.getNsocio());
		    transaction.commit();
		} catch(Exception ex) {
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

	public boolean ReservarMesa(Reserva reserva) {
		
		try {
			persistentManager = persistentManagerFactory.getPersistenceManager();
			transaction = persistentManager.currentTransaction();
			
		    transaction.begin();
		    persistentManager.makePersistent(reserva);
		    System.out.println("- Inserted into db: " + reserva.getNumReserva());
		    transaction.commit();
		} catch(Exception ex) {
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

//	public Flight GetVuelo(int cod_vuelo) {
//		// TODO Auto-generated method stub
//		return null;
//	}


	public Usuario GetUsuario(String numSocio) {
		persistentManager = persistentManagerFactory.getPersistenceManager();
		transaction = persistentManager.currentTransaction();
			
		try {
		    transaction.begin();
		    Query<Usuario> query = persistentManager.newQuery(Usuario.class);
			query.setFilter("nsocio == " + numSocio);

			@SuppressWarnings("unchecked")
			List<Usuario> accounts = (List<Usuario>) query.execute();
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


	public boolean ComprobarUsuario(String email, String contrasena) {
		persistentManager = persistentManagerFactory.getPersistenceManager();
		transaction = persistentManager.currentTransaction();
			
		try {
		    transaction.begin();
		    Query<Usuario> query = persistentManager.newQuery(Usuario.class);
			query.setFilter("email == " + email + " && password == " + contrasena );

			@SuppressWarnings("unchecked")
			List<Usuario> accounts = (List<Usuario>) query.execute();
			if(accounts.size()!=1)throw new Exception();

		    transaction.commit();
		} catch(Exception ex) {
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

}
