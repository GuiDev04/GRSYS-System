package com.br.GRSYS.Login.main;

public class MetodosAuxiliares {

	protected static String parsePassword(char[] array){
		
		StringBuilder  senha = new StringBuilder("");
		for(int i = 0; i <= array.length-1 ; i++){
			senha.append(array[i]);
		}
		return senha.toString();
	}
	
}
