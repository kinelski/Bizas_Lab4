package dataBase;

import notaFiscal.NotaFiscal;

public class BancoDeDados {
	
	private static DB_PS instanceOfDB_PS = DB_PS.getInstanceOf();
	private static DB_NF instanceOfDB_NF = DB_NF.getInstanceOf();
	private static DB_Tax instanceOfDB_Tax = DB_Tax.getInstanceOf();
	private static BancoDeDados instanceOfBancoDeDados = new BancoDeDados();
	
	private BancoDeDados(){};
	
	public static BancoDeDados getInstanceOf(){
		return instanceOfBancoDeDados;
	}
	
	public ProdutoServico getProdutoServico (String nome){
		return instanceOfDB_PS.validaPS(nome);
	}
	
	public boolean validaNF (NotaFiscal nota){
		return instanceOfDB_NF.validaNF(nota);
	}
	
	public void createProduto (String nome, double precoUnitario, String categoriaTributaria, String infoProduto){
		instanceOfDB_PS.createProduto (nome, precoUnitario, categoriaTributaria, infoProduto);
	}
	
	public void createServico (String nome, double precoUnitario, String categoriaTributaria, String infoServico){
		instanceOfDB_PS.createServico (nome, precoUnitario, categoriaTributaria, infoServico);
	}
	
	public void addChild (String parent, String child){
		instanceOfDB_PS.addChild(parent, child);
	}
	
}
