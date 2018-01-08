package com.br.GRSYS.AutoNomeia.GerenciadorGeral;

public class GerenciadorGeralException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Exception cause;
	
	public GerenciadorGeralException(){
		
	}

	public GerenciadorGeralException(String cause){
		super(cause);
	}
	

	public GerenciadorGeralException(Exception e){
		super(e);
	}
}
