package ServidorLD;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.jdo.annotations.Element;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@PersistenceCapable
/**
 * 
 * @author Soldados de StackOverflow v2
 * 
 * Clase Silla que contiene la informacion referente a las sillas que se guarda como tabla en la base de datos; codigoSilla, fecha, numMesa
 *
 */
public class Silla implements Serializable {
	
	@PrimaryKey
	private int codigoSilla;
	@PrimaryKey
	private Date fecha;
	private int numMesa;
	
	//Reserva r;
	//@Element(column = "numReserva")
	//private ArrayList<Reserva> reservas = new ArrayList<Reserva>();
	/**
	 * Constructor de la clase Silla donde se asingan las sillas a una mesa concreta
	 * @param silla
	 * Inicialziacion de las claves primaria silla
	 * @param fecha
	 * Inicializacion de la clave primaria fecha
	 * 
	 */
	public Silla(int silla, Date fecha) {
		codigoSilla = silla;
		this.fecha = fecha;
		if ((codigoSilla > 0) && (codigoSilla < 13)) {
			numMesa = 1;
		}
		if ((codigoSilla > 12) && (codigoSilla < 25)) {
			numMesa = 2;
		}
		if ((codigoSilla > 24) && (codigoSilla < 37)) {
			numMesa = 3;
		}
		if ((codigoSilla > 36) && (codigoSilla < 45)) {
			numMesa = 4;
		}
		if ((codigoSilla > 44) && (codigoSilla < 53)) {
			numMesa = 5;
		}
	
		
	}

}
