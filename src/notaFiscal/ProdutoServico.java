package notaFiscal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
	
	public double getPrecoUnitario(){
		return precoUnitario;
	}
	
	public List<ProdutoServico> getChildren(){
		return (List<ProdutoServico>) Collections.unmodifiableList(listaProdServ);
	}
	
	public String categoria(){
		return categoriaTributaria;
	}
	
	public String printable (int tab){
		String print = "";
		DecimalFormat df = new DecimalFormat("0.00");
		
		for (int i=0; i<tab; i++)
			print += " ";
		print += nome + " (" + df.format(precoUnitario) + ')' + '\n';
		
		for (ProdutoServico ps : listaProdServ)
			print += ps.printable(tab + 1);
		
		return print;
	}

}
