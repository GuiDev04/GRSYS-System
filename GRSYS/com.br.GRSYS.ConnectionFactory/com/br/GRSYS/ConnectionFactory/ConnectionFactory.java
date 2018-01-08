package com.br.GRSYS.ConnectionFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {
	
	//METODO ABRE CONEXAO
	
	public EntityManager getConnection(){
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("grsys");
		
		return factory.createEntityManager();
		
	}
}








