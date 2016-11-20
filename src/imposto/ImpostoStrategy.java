package imposto;

public interface ImpostoStrategy {
	public double calcularImposto(double custo, int quant, double aliquota);
}
