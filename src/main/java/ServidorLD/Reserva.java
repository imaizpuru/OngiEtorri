package ServidorLD;

import java.util.ArrayList;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reserva {
	private Usuario numSocio;
	private ArrayList<Silla> mesas = new ArrayList<Silla>();
	private Date fecha;
	private String numReserva;
	
}
