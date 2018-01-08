package com.br.GRSYS.Apolice.Front;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ApoliceAuxiliares {

	protected static boolean validaData(String data){

		//VERIFICA O TAMANHO (MIN 9)
		
		if(data.length()!=10){
			return false;
		}
		
		// PEGA INFORMAÇÕES DA DATA
		String[] infoData = data.split("/");
		
		//VALIDANDO DIA
		if(infoData[0].length()==2){
			
			//VALINDANDO MES
			if(infoData[1].length()==2){
				
				//VALIDANDO ANO
				if(infoData[2].length()==4){
					
					//COMEÇO A VERIFICAR O PARSE
					
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					
					//TENTA CONVERTER A DATA EM DT
					try {
						sdf.parse(data);
						//SE A CONVERSÃO FOR BEM SUCEDIDA
						return true;
					} catch (ParseException e) {
						//SE HAVER ERRO NA CONVESAO
						return false;
					}
					
					
				}else{
					//RETORNA DATA INVALIDA
					return false;
				}
				
			}else{
				//RETORNA DATA INVALIDA
				return false;
			}
		}else{
			//RETORNA DATA INVALIDA
			return false;
		}
		
	}
	
	public static String parseSqlFormat(String dtteste){
		
		String data_adesao = dtteste.split("/")[2]+"/"+
				dtteste.split("/")[1]+"/"+
				dtteste.split("/")[0];
		
		return data_adesao;
		
	}
	
	
	
}
