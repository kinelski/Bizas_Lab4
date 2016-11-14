package dataBase;

import notaFiscal.NotaFiscal;

class DB_NF {
	
	private static DB_NF instance = new DB_NF();
	
	private DB_NF(){}
	
	public static DB_NF getInstanceOf(){
		return instance;
	}
	
	public boolean validaNF (NotaFiscal nota){
		return true;
	}
}
