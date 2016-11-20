package dataBase;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import imposto.*;
import testes.RouboPorParteDoEstado;

class DB_Tax {
	
	private static DB_Tax instance = new DB_Tax();
	private ArrayList<Imposto> impostos;
	
	private DB_Tax(){}
	
	public static DB_Tax getInstanceOf(){
		return instance;
	}
	
	public List<Imposto> getImpostos(){
		impostos = new ArrayList<Imposto>();
		impostos.add(new RouboPorParteDoEstado());
		return (List<Imposto>) Collections.unmodifiableList(impostos);
	}
	
}
