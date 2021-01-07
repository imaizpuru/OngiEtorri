package Soldados.OngiEtorri;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ClienteLP.vtInicio;
import ClienteLP.vtPrincipal;
import ServidorLD.Producto;
import ServidorLD.Usuario;
import ServidorLN.DAO;

public class InventarioTest {
	
	Producto producto;
	private DAO dao;

	@Before
	public void setUp() throws Exception {
		
		dao = DAO.getInstance();
		producto = new Producto(0, "Platos", 2.20, 10);
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
	
		boolean anadir;
		boolean eliminar;
		boolean anadirCantidad;
		
		int cantidadElegida = 3;
		
		anadir = dao.anadirProducto(producto);
		
		assertTrue(anadir);
		
		eliminar = dao.eliminarProducto(producto.getCodigoP());
		
		assertTrue(eliminar);
		
		anadirCantidad = dao.anadirCantidad(producto.getCodigoP(), cantidadElegida);
		
		assertTrue(anadirCantidad);
		
	}

}
