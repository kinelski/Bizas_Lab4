package notaFiscal;

public class Produto extends ProdutoServico{
	
	public Produto(String nome, double precoUnitario, String categoriaTributaria, String infoProduto){
		this.nome = nome;
		this.precoUnitario = precoUnitario;
		this.categoriaTributaria = categoriaTributaria;
		this.infoProdServ = infoProduto;
	}
	
}
