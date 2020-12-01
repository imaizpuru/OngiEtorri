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
public class Usuario implements Serializable {
	
	@PrimaryKey
	private int nsocio; // Numero de socio
	private String nombre;
	private String apellido;
	private String email;
	private String contrasenya;

	
}
