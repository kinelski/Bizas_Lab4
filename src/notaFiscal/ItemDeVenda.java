package notaFiscal;
public class ItemDeVenda {
	private NotaFiscal nota;
	private ProdutoServico mercadoria;
	private int quantidade;
	private double desconto;
	
	public ItemDeVenda(NotaFiscal nota, ProdutoServico prodServ, int quantidade, double desconto){
		this.nota = nota;
		this.mercadoria = prodServ;
		this.quantidade = quantidade;
		this.desconto = desconto;
	}
	
	
	
}
