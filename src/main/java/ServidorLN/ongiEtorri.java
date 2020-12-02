package ServidorLN;

import java.util.ArrayList;
import java.util.Date;

import ServidorLD.Reserva;
import ServidorLD.Silla;
import ServidorLD.Usuario;

public class ongiEtorri {

	private static ongiEtorri instance = new ongiEtorri();
	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	private Usuario usuario = new Usuario();
	private DAO dao;
	//private static ongiEtorri
	private Usuario u  = new Usuario();
	private Usuario user1  = new Usuario();
	private Usuario user2  = new Usuario();
	
	private ongiEtorri()
	{
		dao = DAO.getInstance();
	}
	public static ongiEtorri getInstance() {
		return instance;
	}
	
	
	public int crearUsuario(int nsocio, String nombre, String apellidos, String email, String contrasenya) {
		int vuelta = 0;
		
		Usuario u = new Usuario(nsocio, nombre,apellidos , email, contrasenya);
/*		u.setNsocio(nsocio);
		u.setNombre(nombre);
		u.setApellido(apellidos);
		u.setEmail(email);
		u.setContrasenya(contrasenya);
*/		
/*		for (Usuario a : usuarios) {
			if (nsocio == a.getNsocio() || email.equals(a.getEmail())) {
				vuelta = 1;// El nsocio ya tiene una cuenta
				System.out.println("Socio o email repetido");
			}
		
		}*/
		user1 = dao.GetUsuarioEmail(email);
		user2 = dao.GetUsuarioSocio(nsocio);
		
		//System.out.println(user1);
		//System.out.println(user2);
		
		if(user2 != null)
		{
			vuelta = 1;// El nsocio ya tiene una cuenta
			System.out.println("Socio repetido");
		}
		else if(user1 != null)
		{
			vuelta = 1;// El correo esta registrado
			System.out.println("email repetido");
		}
		else
		{
			vuelta = 0;
			dao.GuardarUsuario(u);
		}
		
/*		if (vuelta == 0) {
			usuarios.add(u);
			System.out.println(u);
			dao.GuardarUsuario(u);
		}*/
		//System.out.println("Usuarios:" + usuarios.size());
		System.out.println(vuelta);
		//System.out.println(usuarios);
		return vuelta;
	}

	public int iniciaSesion(String email, String contrasenya) {
		int vuelta = 2;
		boolean inicioSesion;
		
		usuario = dao.GetUsuarioEmail(email);
		
		if(usuario == null)
		{
			return vuelta;
		}
		//System.out.println(usuario.getContrasenya().equals(contrasenya));
		
		inicioSesion = dao.ComprobarUsuario(email, contrasenya);
		
		if(inicioSesion == true)
		{	
			vuelta = 0;
			
		}
		else
		{
			vuelta = 1;
		}
/*//		usuario = dao.GetUsuario(email);
//		System.out.println(usuario);
		for (Usuario us : usuarios) {
			//System.out.println(usuarios);
			if (us.getEmail().equals(email)) {
				System.out.println("Holaa");
				if (us.getContrasenya().equals(contrasenya)) 
				{
						//vuelta = 0;
						//usuario = us;
					
					System.out.println(inicioSesion);
					if(inicioSesion == true)
					{	
						vuelta = 0;
						
					}
					else{	
				
						vuelta = 1;
						
					}
				}
			}
		}*/
		return vuelta;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public int crearReserva(int numSocio, ArrayList<Silla>sillas, Date fecha, int numReserva)
	{
		int retorno = 1;
		boolean anadir;
		
		Reserva r = new Reserva(numSocio, sillas, fecha, numReserva);
		
		 anadir = dao.ReservarMesa(r);
		
		if(anadir = true)
		{
			retorno = 0;
		}
		
		return retorno;
		
	}
	public int initContReserva()
	{
		int contRes;
		
		contRes = dao.GetLastReservas() + 1;
		
		return contRes;
	}
	public int crearSillas(ArrayList <Silla> sillasGuardadas)
	{
		boolean contRes;
		int retorno = 0;
		
		contRes = dao.GuardarMesas(sillasGuardadas);
		
		if(contRes == true)
		{
			return retorno;
		}
		else
		{
			retorno = 1;
			return retorno;
		}
		
	}
}
