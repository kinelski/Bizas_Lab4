package testes;

import imposto.ImpostoStrategy;

public class RouboStrategy implements ImpostoStrategy{

	@Override
	public double calcularImposto(double custo, int quant, double aliquota) {
		return custo*quant*aliquota;
	}

}
