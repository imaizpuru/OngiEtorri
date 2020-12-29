package ClienteLN;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ServidorLD.Reserva;
import ServidorLD.Silla;
import ServidorLD.Usuario;
import ServidorLN.ongiEtorri;

/**
 * 
 * @author Soldados de StackOverflow v2
 *
 * Clase controller que efectua la interaccion entre la logica de presentacion y la logica de datos con las funcionaldiades que va a tener la aplicacion
 */
public class Controller {

	private ongiEtorri stub;
	
	/**
	 * Constructor de la clase. Crea una instancia de la clase OngiEtorri
	 */
	public Controller(){
		
		stub = ongiEtorri.getInstance();
	}
	//private ongiEtorri stub = new ongiEtorri();
	/**
	 * Metodo de registro de un usuario
	 * @param nsocio
	 * identificativo del usuario, clave primaria en la base de datos, tipo int 
	 * @param nombre
	 * nombre del usuario, tipo string
	 * @param apellidos
	 * primer apellido del usuario, tipo string
	 * @param email
	 * correo electronico del usuario, tipo string
	 * @param contrasenya
	 * contrasenya del usuario, tipo string
	 * @return devuelve el retorno del metodo crearUsuario de la clase OngliEtorri, al que se accede con la instancia creada en el constructor
	 */
	public int crearUsuario(int nsocio, String nombre, String apellidos, String email, String contrasenya, boolean admin) {
		
		stub.getUsuarios();
		
		return stub.crearUsuario(nsocio, nombre, apellidos, email, contrasenya, admin);
	}
	/**
	 * Metodo de inicio de sesion de un usuario registrado
	 * @param email
	 * correo electronico del usuario, tipo string
	 * @param contrasenya
	 * contrasenya del usuario, tipo string
	 * @return devuelve el retorno del metodo iniciaSesion de la clase OngliEtorri, al que se accede con la instancia creada en el constructor
	 */
	public int iniciaSesion(String email, String contrasenya) {
		return stub.iniciaSesion(email, contrasenya);
	}
	/**
	 * Metodo de creacion de una reserva
	 * @param numSocio
	 * identificativo del socio que va a efectuar la reserva, tipo int
	 * @param sillas
	 * lista de sillas que se van a registrar, tipo ArrayList
	 * @param fecha
	 * fecha concreta en la que se va a reservar
	 * @param numReserva
	 * identificativo de la reserva
	 * @return devuelve el retorno del metodo crearReserva de la clase OngliEtorri, al que se accede con la instancia creada en el constructor
	 */
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
	/**
	 * Metodo de seleccion de usuarios, que se utiliza para los permisos del administrador
	 * @return devuelve el retorno del metodo getUsuarios de la clase OngliEtorri, al que se accede con la instancia creada en el constructor
	 */
	public List<Usuario> getUsuarios()
	{
		return stub.getUsuarios();
	}
	public List<Reserva> getReservas()
	{
		return stub.getReservas();
	}
	public List<Reserva> getReservasUser(int numSocio)
	{
		return stub.getReservasUser(numSocio);
	}
	/*
	public List<Reserva> getReservasDate(Date fecha)
	{
		return stub.getReservasDate(fecha);
	}
	*/
	public Usuario getUsuario() {
		return stub.getUsuario();
	}
}
