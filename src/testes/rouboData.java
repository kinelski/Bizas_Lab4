package testes;

import imposto.IData;

public class rouboData implements IData{
	
	private double total = 0;
	private final double LIMITE = 20;
	
	public boolean addCusto (double custo){
		total += custo;
		return total > LIMITE;
	}
	
}
