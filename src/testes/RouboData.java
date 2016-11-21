package testes;

import imposto.IData;

public class RouboData implements IData{
	
	private double total = 0;
	private final double LIMITE = 20;
	private static RouboData instance = new RouboData();
	
	private RouboData(){}
	
	public static RouboData getInstance(){
		return instance;
	}
	
	public void addCusto (double custo){
		total += custo;
	}
	
	public boolean exceedsLimit(){
		return total > LIMITE;
	}
	
}
