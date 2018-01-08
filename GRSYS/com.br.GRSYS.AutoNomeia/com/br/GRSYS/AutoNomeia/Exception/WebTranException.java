package com.br.GRSYS.AutoNomeia.Exception;

public class WebTranException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5412454235648887273L;

	public WebTranException(){
		super();
	}
	
	
	
	public WebTranException(Exception e){
		super(e.getMessage());
	}
	
	
}
