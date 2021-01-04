package ServidorLN;

import java.util.Date;
import java.util.List;

import ServidorLD.Producto;
import ServidorLD.Reserva;
import ServidorLD.Silla;
import ServidorLD.Usuario;

public interface IDAO {
	public boolean GuardarMesas(List<Silla> sillas);

	public boolean GuardarUsuario(Usuario usuario);

	public boolean ComprobarUsuario(String email, String contrasena);

	public boolean ReservarMesa(Reserva reserva);

	// public Flight GetVuelo(int cod_vuelo);
	public Usuario GetUsuarioEmail(String email);

	public Usuario GetUsuarioSocio(int socio);

	public Reserva GetReservaUsuario(int numSocio);

	public int GetLastReservas();

	public Reserva GetReservaFecha(Date fecha);

	public boolean setAdmin(int nsocio);

	public boolean anadirProducto(Producto p);
	
	public List<Producto> getProductos();

	public boolean eliminarProducto(int codigoP);
}
