package ServidorLD;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
	private String nombre;
	private String apellido;
	private int nsocio; // Numero de socio
	private String contrasenya;

}
