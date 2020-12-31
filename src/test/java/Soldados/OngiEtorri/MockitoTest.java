package Soldados.OngiEtorri;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import ClienteLP.vtInicio;
import ServidorLD.Usuario;
import ServidorLN.DAO;



public class MockitoTest {

	@InjectMocks
	Usuario u;
	private DAO dao;
	String email;
	
	@Mock
	Usuario umock;
	@Before
	public void setUp() throws Exception {
		
		umock= mock (Usuario.class);
		email= "a";
		dao = DAO.getInstance();
		u = new Usuario (1,"a","a","a","a", false);
		
		
	}
	
	@Test
	public void test() {
				
		when(umock.nombreApellido("a", "a")).thenReturn("a");		
		assertEquals(umock.nombreApellido("a", "a"), "a");
		verify(umock).nombreApellido("a", "a");
		
	}

}
