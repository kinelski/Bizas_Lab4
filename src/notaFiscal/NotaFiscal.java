package notaFiscal;

import java.util.ArrayList;
import dataBase.BancoDeDados;

public class NotaFiscal {
	
	private String estado;
	
	BancoDeDados dataBase = BancoDeDados.getInstanceOf();
	
	private ArrayList<ItemDeVenda> itensDeVenda = new ArrayList<ItemDeVenda>();
	
	public void addItem (String nome, int quant){
		ProdutoServico ps = dataBase.getProdutoServico(nome);
		
		if (ps != null){
			ItemDeVenda item = new ItemDeVenda(this, ps, quant, 0);
			itensDeVenda.add(item);
		}
	}
	
	public int 

}
