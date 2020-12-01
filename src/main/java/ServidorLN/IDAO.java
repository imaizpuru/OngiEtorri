package ServidorLN;

import java.util.List;

import ServidorLD.Silla;
import ServidorLD.Usuario;
import ServidorLD.Reserva;

public interface IDAO 
{
	public boolean GuardarMesas(List<Silla> sillas);
	public boolean GuardarUsuario(Usuario usuario);
	public boolean ComprobarUsuario(String email, String contrasena);
	public boolean ReservarMesa(Reserva reserva);
	//public Flight GetVuelo(int cod_vuelo);
	public Usuario GetUsuario(String numSocio);
}
