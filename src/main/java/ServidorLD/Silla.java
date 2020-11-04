package ServidorLD;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Silla {
	private int codigoSilla;
	private int numMesa;

	public Silla(int silla) {
		codigoSilla = silla;
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
