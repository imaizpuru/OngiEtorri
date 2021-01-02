package ServidorLD;

import java.io.Serializable;

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
 * Clase cuenta que contiene la informacion sobre el inventario y pago de una reserva
 *
 */
public class Cuenta implements Serializable {

	private boolean pagado = false;
	private double valor;
	@PrimaryKey
	private int numCuenta;
	
}
