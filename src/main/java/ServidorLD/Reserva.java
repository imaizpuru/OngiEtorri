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
	private int numSocio;
	private ArrayList<Silla> sillas = new ArrayList<Silla>();
	private Date fecha;
	private int numReserva;

}
