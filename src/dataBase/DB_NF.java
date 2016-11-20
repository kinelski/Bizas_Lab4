package dataBase;

import java.util.ArrayList;
import java.util.List;

import imposto.Imposto;
import notaFiscal.NotaFiscal;

class DB_NF {
	
	private static DB_NF instance = new DB_NF();
	private static int id_nota = 0;
	private DB_Tax instanceOfDB_Tax = DB_Tax.getInstanceOf();
	private ArrayList<NotaFiscal> data = new ArrayList<NotaFiscal>();
	
	private DB_NF(){}
	
	public static DB_NF getInstanceOf(){
		return instance;
	}
	
	public void submeteNF (NotaFiscal nota){
		//SUBMETE A NOTA
	}
	
	public boolean validaNF (NotaFiscal nota){
		if (!nota.validavel())
			return false;
		
		nota.changeID(id_nota++);
		aplicaImpostos(nota);
		
		submeteNF(nota);
		data.add(nota);
		
		return true;
	}
	
	private void aplicaImpostos (NotaFiscal nota){
		List<Imposto> impostos = instanceOfDB_Tax.getImpostos();
		nota.aplicaImpostos(impostos);
	}
}
