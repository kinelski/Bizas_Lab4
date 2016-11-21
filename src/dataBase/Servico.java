package dataBase;

class Servico extends ProdutoServico {
	
	Servico(String nome, double precoUnitario, String categoriaTributaria, String infoServico){
		this.nome = nome;
		this.precoUnitario = precoUnitario;
		this.categoriaTributaria = categoriaTributaria;
		this.infoProdServ = infoServico;
	}

}
