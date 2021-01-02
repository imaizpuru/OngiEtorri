package ServidorLD;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.jdo.annotations.Element;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@PersistenceCapable

/**
 * 
 * @author Soldados de StackOverflow v2
 * 
 * Clase reserva que contiene la informacion referente a la reserva que se guarda como tabla en la base de datos; numRerva, numSocio, sillas, fecha
 *
 */
public class Reserva implements Serializable {


	private int numSocio;
	//@Element(column = "codigoSilla")
	private ArrayList<Silla> sillas = new ArrayList<Silla>();
	private Cuenta cuenta;
	private boolean bCuenta = false;
	private Date fecha;
	@PrimaryKey
	private int numReserva;
	
}
