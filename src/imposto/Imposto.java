package imposto;

import java.util.ArrayList;

public abstract class Imposto {
	
	private double aliquota;
	private ArrayList<ImpostoStrategy> listaImpostoStrategy = new ArrayList<ImpostoStrategy>();
	private IData data;
}
