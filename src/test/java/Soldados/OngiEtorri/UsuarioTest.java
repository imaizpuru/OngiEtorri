package Soldados.OngiEtorri;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ClienteLN.Controller;
import ServidorLD.Usuario;
import junit.framework.TestCase;

public class UsuarioTest extends TestCase {
	
	Usuario user;
	private Controller controller;

	protected void setUp() throws Exception {
		super.setUp();
		
		user= new Usuario();
		user.setNombre("Dani");
		user.setApellido("Vallejo");
		user.setEmail("danivallejo");
		user.setContrasenya("qwerty");
		user.setNsocio(101);
		
		System.out.println(user.getNsocio());
		System.out.println(user.getNombre());
		System.out.println(user.getApellido());
		System.out.println(user.getEmail());
		System.out.println(user.getContrasenya());	
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	@Test
	public void test() {
		
		//Prueba de creacion del usuario
		int retorno1;
		
		retorno1 = controller.crearUsuario(user.getNsocio(), user.getNombre(), user.getApellido(), user.getEmail(), user.getContrasenya());
		assertEquals(retorno1, 0);
		//Prueba inicio sesion
		int retorno2;
		
		retorno2 = controller.iniciaSesion(user.getEmail(), user.getContrasenya());
		
		assertEquals(retorno2, 0);				
		
	}

}
