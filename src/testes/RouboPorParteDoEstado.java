package testes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import dataBase.ProdutoServico;
import imposto.Imposto;
import notaFiscal.ItemDeVenda;

public class RouboPorParteDoEstado extends Imposto{
	
	private RouboData data_;

	public RouboPorParteDoEstado(){
		name_ = "Roubo por parte do estado";
		strategy_ = new RouboStrategy();
		aliquotaPorCategoria_ = new HashMap<String, Double>();
		data_ = RouboData.getInstance();
		
		if (data_.exceedsLimit())
			aliquotaDefault_ = 0.2;
		else
			aliquotaDefault_ = 0.3;
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
		
		data_.addCusto(valor);
		
		return valor;
	}

}
