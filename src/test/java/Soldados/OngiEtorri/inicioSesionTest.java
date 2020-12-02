package Soldados.OngiEtorri;

import org.junit.Before;
import org.junit.Test;

import ServidorLD.Usuario;
import ServidorLN.DAO;
import junit.framework.TestCase;

public class inicioSesionTest extends TestCase{
	
	Usuario user;
	Usuario usuario;
	
	//private Controller controller;
	private DAO dao;


	@Before
	public void setUp() throws Exception {
		
		usuario = new Usuario();
		user= new Usuario();
		dao = DAO.getInstance();
		user.setNombre("Dani");
		user.setApellido("Vallejo");
		user.setEmail("danivallejo");
		user.setContrasenya("qwerty");
		user.setNsocio(101);
	}


	@Test
	public void test() {
		boolean retorno;
		
		//System.out.println(dao.GetUsuarioEmail(user.getEmail()));
		
		usuario = dao.GetUsuarioEmail(user.getEmail());
		
		
		
		if(usuario == null)
		{
			//assertNotSame(user.getEmail(), usuario.getEmail());
		}
		else
		{
			//System.out.println(usuario);
			retorno = dao.ComprobarUsuario(user.getEmail(), user.getContrasenya());
			
			//System.out.println();
			
			if(usuario.getContrasenya().equals(user.getContrasenya()))
			{
				assertEquals(retorno, true);
			}
			else
			{
				assertEquals(retorno, false);
			}
			
		}
		
	}

}
