package ClienteLN;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ServidorLD.Silla;
import ServidorLD.Usuario;
import ServidorLN.ongiEtorri;

public class Controller {

	private ongiEtorri stub;
	
	public Controller(){
		
		stub = ongiEtorri.getInstance();
	}
	//private ongiEtorri stub = new ongiEtorri();

	public int crearUsuario(int nsocio, String nombre, String apellidos, String email, String contrasenya) {
		
		stub.getUsuarios();
		
		return stub.crearUsuario(nsocio, nombre, apellidos, email, contrasenya);
	}

	public int iniciaSesion(String email, String contrasenya) {
		return stub.iniciaSesion(email, contrasenya);
	}
	
	public int crearReserva(int numSocio, ArrayList<Silla>sillas, Date fecha, int numReserva) {
		return stub.crearReserva(numSocio, sillas, fecha, numReserva);
	}
	public int initContReserva()
	{
		return stub.initContReserva();
	}
	
	public int crearSillas(ArrayList <Silla> sillasGuardadas)
	{	
		
		return stub.crearSillas(sillasGuardadas);
	}
	public List<Usuario> getUsuarios()
	{
		return stub.getUsuarios();
	}
	
	public Usuario getUsuario() {
		return stub.getUsuario();
	}
}
