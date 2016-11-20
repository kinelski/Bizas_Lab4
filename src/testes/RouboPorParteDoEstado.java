package testes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import imposto.Imposto;
import notaFiscal.ItemDeVenda;
import notaFiscal.ProdutoServico;

public class RouboPorParteDoEstado extends Imposto{

	public RouboPorParteDoEstado(){
		name_ = "Roubo por parte do estado";
		strategy_ = new RouboStrategy();
		aliquotaDefault_ = 0.3;
		aliquotaPorCategoria_ = new HashMap<String, Double>();
	}
	
	public double applyStrategy (ProdutoServico ps, int quant){
		double precoUnitario = ps.getPrecoUnitario();
		String categoria = ps.categoria();
		double aliquota = aliquotaDefault_;
		
		if (aliquotaPorCategoria_.containsKey(categoria))
			aliquota = aliquotaPorCategoria_.get(categoria);
		
		double valor = strategy_.calcularImposto(precoUnitario, quant, aliquota);
		
		List<ProdutoServico> children = ps.getChildren();
		
		for (ProdutoServico child : children)
			valor += applyStrategy(child, quant);
		
		return valor;
	}

	@Override
	public double calcularImposto(ArrayList<ItemDeVenda> itens) {
		double valor = 0;
		
		for (ItemDeVenda item : itens)
			valor += applyStrategy(item.getMercadoria(), item.quant());
		
		return valor;
	}

}
