package notaFiscal;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dataBase.BancoDeDados;
import imposto.Imposto;

public class NotaFiscal {
	
	private String estado;
	private int id;
	
	private double precoItens;
	private double precoImpostos;
	
	private BancoDeDados dataBase = BancoDeDados.getInstanceOf();
	
	private ArrayList<ItemDeVenda> itensDeVenda;
	private HashMap<String, Double> impostosValue;
	
	public NotaFiscal(){
		estado = "em elaboracao";
		id = -1;
		
		itensDeVenda = new ArrayList<ItemDeVenda>();
		impostosValue = null;
		
		precoItens = 0;
		precoImpostos = 0;
		
		ProdutoServico banana = new Produto("Banana", 0.48, "Delicia", "Macaco Quer Banana");
		ItemDeVenda iv = new ItemDeVenda(this, banana, 2, 0);
		ProdutoServico casca = new Produto("Casca", 0.20, "Lixo", "Nem Macaco Quer");
		banana.addComponent(casca);
		ProdutoServico inseto = new Produto("Inseto", 0.14, "Proteina", "Alguns Macacos Querem");
		banana.addComponent(inseto);
		ProdutoServico insetoDeCasca = new Produto("Inseto de casca", 0.5, "Proteina", "Alguns Macacos Querem");
		casca.addComponent(insetoDeCasca);
		
		ItemDeVenda iv2 = new ItemDeVenda(this, casca, 3, 0);
		
		itensDeVenda.add(iv);
		precoItens += iv.custoTotal();
		itensDeVenda.add(iv);
		precoItens += iv.custoTotal();
		itensDeVenda.add(iv2);
		precoItens += iv2.custoTotal();
	}
	
	public void addItem (String nome, int quant){
		if (!estado.equals("em elaboracao"))
			return;
		
		ProdutoServico ps = dataBase.getProdutoServico(nome);
		
		if (ps != null){
			if (itensDeVenda.contains(ps)){
				int key = itensDeVenda.indexOf(ps);
				ItemDeVenda item = new ItemDeVenda(this, ps, itensDeVenda.get(key).quant() + quant, 0);
				
				precoItens -= itensDeVenda.get(key).custoTotal();
				itensDeVenda.remove(key);
				itensDeVenda.add(item);
				precoItens += item.custoTotal();
			}
			
			else{
				ItemDeVenda item = new ItemDeVenda(this, ps, quant, 0);
				itensDeVenda.add(item);
				precoItens += item.custoTotal();
			}
		}
	}
	
	public void removeItem (String nome, int quant){
		if (!estado.equals("em elaboracao"))
			return;
		
		ProdutoServico ps = dataBase.getProdutoServico(nome);
		
		if (ps != null && itensDeVenda.contains(ps)){
			int key = itensDeVenda.indexOf(ps);
			
			if (quant >= itensDeVenda.get(key).quant()){
				precoItens -= itensDeVenda.get(key).custoTotal();
				itensDeVenda.remove(key);
			}
			
			else{
				ItemDeVenda item = new ItemDeVenda(this, ps, itensDeVenda.get(key).quant() - quant, 0);
				
				precoItens -= itensDeVenda.get(key).custoTotal();
				itensDeVenda.remove(key);
				itensDeVenda.add(item);
				precoItens += item.custoTotal();
			}
		}
	}
	
	public void removeItem (String nome){
		if (!estado.equals("em elaboracao"))
			return;
		
		ProdutoServico ps = dataBase.getProdutoServico(nome);
		
		if (ps != null && itensDeVenda.contains(ps)){
			int key = itensDeVenda.indexOf(ps);
			
			precoItens -= itensDeVenda.get(key).custoTotal();
			itensDeVenda.remove(key);
		}
	}
	
	public void changeItem (String nome, int quant){
		removeItem(nome);
		addItem(nome, quant);
	}
	
	public int numOfItems(){
		return itensDeVenda.size();
	}
	
	public boolean validada(){
		return estado.equals("validada");
	}
	
	public void changeID (int newID){
		if (estado.equals("em elaboracao"))
			id = newID;
	}
	
	public boolean validaNota(){
		if (dataBase.validaNF(this)){
			estado = "validada";
			return true;
		}
		
		return false;
	}
	
	public boolean validavel(){
		if (numOfItems() == 0)
			return false;
		if (validada())
			return false;
		
		return true;
	}
	
	public int getID(){
		return id;
	}
	
	public void aplicaImpostos (List<Imposto> impostos){
		if (estado.equals("validada"))
			return;
		
		impostosValue = new HashMap<String, Double>();
		precoImpostos = 0;
		
		for (Imposto imposto : impostos){
			double preco = imposto.calcularImposto(itensDeVenda);
			impostosValue.put(imposto.getName(), preco);
			precoImpostos += preco;
		}
	}
	
	public String printable(){
		String print = "";
		DecimalFormat df = new DecimalFormat("0.00");
		
		if (estado.equals("em elaboracao"))
			print += "EM ELABORACAO" + "\n\n";
		else{
			print += "VALIDADA" + "\n";
			print += "ID: " + id + "\n\n";
		}
		
		for (ItemDeVenda item : itensDeVenda)
			print += item.printable();
		
		print += "IMPOSTOS" + "\n";
		
		if (impostosValue != null && estado.equals("validada")){
			for (Map.Entry<String, Double> entry : impostosValue.entrySet())
				print += entry.getKey() + ": " + df.format(entry.getValue()) + "\n";
		}
		
		print += "\n" + "TOTAL: " + df.format(precoItens + precoImpostos);
		
		return print;
	}

}
