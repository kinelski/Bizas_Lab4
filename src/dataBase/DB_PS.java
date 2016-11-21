package dataBase;

import java.util.HashMap;

class DB_PS {
	
	private static DB_PS instance = new DB_PS();
	private HashMap<String, ProdutoServico> mercadorias = new HashMap<String, ProdutoServico>();
	
	private DB_PS(){}
	
	public static DB_PS getInstanceOf(){
		return instance;
	}
	
	public ProdutoServico validaPS (String nome){
		if (mercadorias.containsKey(nome))
			return mercadorias.get(nome);
		
		return null;
	}
	
	public void createProduto (String nome, double precoUnitario, String categoriaTributaria, String infoProduto){
		Produto prod = new Produto (nome, precoUnitario, categoriaTributaria, infoProduto);
		mercadorias.put(nome, prod);
	}
	
	public void createServico (String nome, double precoUnitario, String categoriaTributaria, String infoServico){
		Servico serv = new Servico (nome, precoUnitario, categoriaTributaria, infoServico);
		mercadorias.put(nome, serv);
	}
	
	public void addChild (String parent, String child){
		if (!mercadorias.containsKey(parent) || !mercadorias.containsKey(child))
			return;
		
		mercadorias.get(parent).addComponent(mercadorias.get(child));
	}

}
