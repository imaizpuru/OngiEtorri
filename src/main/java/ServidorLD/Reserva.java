package ServidorLD;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@PersistenceCapable
public class Reserva implements Serializable{
	private int numSocio;
	private ArrayList<Silla> sillas = new ArrayList<Silla>();
	private Date fecha;
	@PrimaryKey
	private int numReserva;

}
