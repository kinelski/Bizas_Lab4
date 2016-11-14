package dataBase;
import imposto.*;

class DB_Tax {
	
	private static DB_Tax instance = new DB_Tax();
	
	private DB_Tax(){}
	
	public static DB_Tax getInstanceOf(){
		return instance;
	}
}
