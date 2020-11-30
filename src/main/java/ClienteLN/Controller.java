package ClienteLN;

import ServidorLD.Usuario;
import ServidorLN.ongiEtorri;

public class Controller {

	private ongiEtorri stub;
	
	public Controller(){
		
		stub = ongiEtorri.getInstance();
	}
	//private ongiEtorri stub = new ongiEtorri();

	public int crearUsuario(int nsocio, String nombre, String apellidos, String email, String contrasenya) {
		return stub.crearUsuario(nsocio, nombre, apellidos, email, contrasenya);
	}

	public int iniciaSesion(String email, String contrasenya) {
		return stub.iniciaSesion(email, contrasenya);
	}

	public Usuario getUsuario() {
		return stub.getUsuario();
	}
}
