package dataBase;

class DB_PS {
	
	private static DB_PS instance = new DB_PS();
	
	private DB_PS(){}
	
	public static DB_PS getInstanceOf(){
		return instance;
	}

}
