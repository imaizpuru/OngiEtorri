package Soldados.OngiEtorri;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ServidorLD.Usuario;
import ServidorLN.DAO;
import junit.framework.TestCase;

public class crearUsuarioTest extends TestCase {
	
	Usuario user;
	Usuario usuario1;
	Usuario usuario2;
	
	//private Controller controller;
	private DAO dao;

	protected void setUp() throws Exception {
		super.setUp();
		
		usuario1 = new Usuario();
		usuario2 = new Usuario();
		user= new Usuario();
		dao = DAO.getInstance();
		user.setNombre("Dani");
		user.setApellido("Vallejo");
		user.setEmail("danivallejo");
		user.setContrasenya("qwerty");
		user.setAdmin(false);
		user.setNsocio(101);
		
		System.out.println(user.getNsocio());
		System.out.println(user.getNombre());
		System.out.println(user.getApellido());
		System.out.println(user.getEmail());
		System.out.println(user.getContrasenya());
		System.out.println(user.isAdmin());	
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	@Test
	public void test() {
		
		//Prueba de creacion del usuario
		boolean retorno1;
		
		usuario1 = dao.GetUsuarioEmail(user.getEmail());
		usuario2 = dao.GetUsuarioSocio(user.getNsocio());
		
		if(usuario1 != null)
		{
			assertEquals(usuario1.getEmail(), user.getEmail());
		}
		else if(usuario2 != null)
		{
			assertEquals(usuario2.getNsocio(), user.getNsocio());
		}
		else
		{
			retorno1 = dao.GuardarUsuario(user);
			
			assertEquals(retorno1, true);
		}
		
		//retorno1 = controller.crearUsuario(user.getNsocio(), user.getNombre(), user.getApellido(), user.getEmail(), user.getContrasenya());
		
		
		//Prueba inicio sesion
		//int retorno2;
		
		//retorno2 = controller.iniciaSesion(user.getEmail(), user.getContrasenya());
		
		//assertEquals(retorno2, 0);				
		
	}

}
