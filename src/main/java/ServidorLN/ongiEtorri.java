package ServidorLN;

import java.util.ArrayList;

import ServidorLD.Usuario;

public class ongiEtorri {

	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	private Usuario usuario = new Usuario();

	public int crearUsuario(int nsocio, String nombre, String apellidos, String email, String contrasenya) {
		int vuelta = 0;
		Usuario u = new Usuario(nombre, apellidos, nsocio, email, contrasenya);
		for (Usuario a : usuarios) {
			if (nsocio == a.getNsocio()) {
				vuelta = 1;// El nsocio ya tiene una cuenta
				System.out.println("wha");
			}
		}
		if (vuelta == 0) {
			usuarios.add(u);
		}
		System.out.println("Usuarios:" + usuarios.size());
		System.out.println(vuelta);
		return vuelta;
	}

	public int iniciaSesion(String email, String contrasenya) {
		int vuelta = 2;
		for (Usuario u : usuarios) {
			if (u.getEmail().equals(email)) {
				if (u.getContrasenya().equals(contrasenya)) {
					vuelta = 0;
					usuario = u;
					break;
				} else {
					vuelta = 1;
					break;
				}
			}
		}
		return vuelta;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
