package notaFiscal;

import java.text.DecimalFormat;

import dataBase.ProdutoServico;

public class ItemDeVenda {
	
	private NotaFiscal nota;
	private ProdutoServico mercadoria;
	private int quantidade;
	private double desconto;
	
	public ItemDeVenda(NotaFiscal nota, ProdutoServico prodServ, int quantidade, double desconto) throws Exception{
		this.nota = nota;
		this.mercadoria = prodServ;
		this.quantidade = quantidade;
		this.desconto = desconto;
		
		if (nota == null || prodServ == null || quantidade == 0)
			throw new Exception();
	}
	
	public ProdutoServico getMercadoria(){
		return mercadoria;
	}
	
	public int quant(){
		return quantidade;
	}
	
	public double custoTotal(){
		return quantidade * mercadoria.calculateCusto();
	}
	
	public String printable(){
		String print = "";
		DecimalFormat df = new DecimalFormat("0.00");
		double custo = mercadoria.calculateCusto();
		
		print += "QUANTIDADE: " + quantidade + "\n";
		print += mercadoria.printable(0);
		print += "CUSTO: " + quantidade + " x " + df.format(custo) + " = " + df.format(quantidade * custo) + "\n\n";
		
		return print;
	}
	
}
