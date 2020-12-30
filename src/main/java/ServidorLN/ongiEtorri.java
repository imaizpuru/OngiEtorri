package ServidorLN;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import ServidorLD.Reserva;
import ServidorLD.Silla;
import ServidorLD.Usuario;

/**
 * 
 * @author Soldados de StackOverflow v2
 * 
 * Clase que interactua entre el controller y la clase DAO
 *
 */
public class ongiEtorri {

	private static ongiEtorri instance = new ongiEtorri();
	private List<Usuario> usuarios = new ArrayList<Usuario>();
	private List<Reserva> reservas = new ArrayList<Reserva>();
	private Usuario usuario = new Usuario();
	private DAO dao;
	//private static ongiEtorri
	private Usuario u  = new Usuario();
	private Usuario user1  = new Usuario();
	private Usuario user2  = new Usuario();
	
	/**
	 * Constructor de la clase. Se crea una instancia de la clase DAO
	 */
	private ongiEtorri()
	{
		dao = DAO.getInstance();
	}
	/**
	 * Metodo getter para que desde el controller se pueda acceder a un objeto ongiEtorri
	 * @return devuelve el objeto instace de tipo ongiEtorri
	 */
	public static ongiEtorri getInstance() {
		return instance;
	}
	
	/**
	 * Metodo de creacion de usuario al que se le llama desde el controller. Se llama al metodo del DAO de creacion de usuario  y en el se comprueba si el usuario se puede crear
	 * @param nsocio
	 * @param nombre
	 * @param apellidos
	 * @param email
	 * @param contrasenya
	 * @return devuelve 0 solo en caso de que el usuario se haya registrado correctamente
	 */
	public int crearUsuario(int nsocio, String nombre, String apellidos, String email, String contrasenya, boolean admin) {
		int vuelta = 0;
		
		Usuario u = new Usuario(nsocio, nombre,apellidos , email, contrasenya, admin);
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
	/**
	 * Metodo de inicio de sesion al que se le llama desde el controller. Se llama al metodo del DAO de inicio de sesion y en el se comprueba si el usuario es correcto.
	 * @param email
	 * @param contrasenya
	 * @return devuelve 0 solo en caso de que el usuario haya iniciado sesion correctamente
	 */
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
	/**
	 * Metodo de crear reserva al que se le llama desde el controller. Se llama al metodo del DAO de crear reserva y en el se prueba si se puede realziar la reserva.
	 * @param numSocio
	 * @param sillas
	 * @param fecha
	 * @param numReserva
	 * @return devuelve 0 solo en caso de que la reserva se haya realizado correctamente
	 */
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
	public List<Usuario> getUsuarios()
	{
		usuarios = dao.GetUsuariosList();
		System.out.println(usuarios);
		
		return usuarios;
	}
	public List<Reserva> getReservas()
	{
		reservas = dao.GetReservasList();
		System.out.println(reservas);
		
		return reservas;
	}
	public List<Reserva> getReservasUser(int numSocio)
	{
		reservas = dao.GetReservasListUser(numSocio);
		System.out.println(reservas);
		
		return reservas;
	}
	/*
	public List<Reserva> getReservasDate(Date fecha)
	{
		reservas = dao.GetReservasListDate(fecha);
		System.out.println(reservas);
		
		return reservas;
	}
	*/
}
