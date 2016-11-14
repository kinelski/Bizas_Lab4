package notaFiscal;

public class Servico extends ProdutoServico {
	
	public Servico(String nome, double precoUnitario, String categoriaTributaria, String infoProduto){
		this.nome = nome;
		this.precoUnitario = precoUnitario;
		this.categoriaTributaria = categoriaTributaria;
		this.infoProdServ = infoProduto;
	}

}
