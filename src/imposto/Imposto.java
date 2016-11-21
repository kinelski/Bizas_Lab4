package imposto;

import java.util.ArrayList;
import java.util.HashMap;

import notaFiscal.ItemDeVenda;

public abstract class Imposto {
	
	protected ImpostoStrategy strategy_;
	
	protected double aliquotaDefault_;
	protected HashMap<String, Double> aliquotaPorCategoria_;
	
	protected String name_;
	
	public abstract double calcularImposto (ArrayList<ItemDeVenda> itens);
	
	public String getName(){
		return name_;
	}
}
