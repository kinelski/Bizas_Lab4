package imposto;
import java.util.ArrayList;

import notaFiscal.*;

public interface ImpostoStrategy {
	public float calcularImposto(ArrayList<ItemDeVenda> itens);
}
