package notaFiscal;
import java.util.ArrayList;

public abstract class ProdutoServico {
	protected ArrayList<ProdutoServico> listaProdServ = new ArrayList<ProdutoServico>();
	protected String nome;
	protected double precoUnitario;
	protected String infoProdServ;
	protected String categoriaTributaria;
	
	public void addComponent(ProdutoServico prodServ){
		listaProdServ.add(prodServ);
	}
	
	public void removeComponent(ProdutoServico prodServ){
		listaProdServ.remove(prodServ);
	}
	
	public double calculateCusto(){
		double custo = precoUnitario;
		
		for (ProdutoServico ps : listaProdServ)
			custo += ps.calculateCusto();
		
		return custo;
	}
}
