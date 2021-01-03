package ServidorLD;

import java.io.Serializable;

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
 *         Clase Producto que contiene la informacion referente a los productos
 *         que se guardan en el inventario y sus precios y cantidades de las que
 *         se dispone; codigoP, precio, cantidad
 *
 */
public class Producto implements Serializable {

	@PrimaryKey
	private int codigoP;
	private String nombre;
	private double precio;
	private int cantidad;

}
