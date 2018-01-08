package com.br.GRSYS.MetodosAuxiliares;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Auxiliares {

	public static boolean validaData(String data){

		ArrayList<Character> caracteres = new ArrayList<Character>();

		// Variaveis e instancias
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY/MM/DD");
		String ano = "";
		String mes = "";
		String dia = "";


		// Caracteres que nao pode ter na data
		caracteres.add('a'); caracteres.add('b'); caracteres.add('c');
		caracteres.add('d'); caracteres.add('e'); caracteres.add('f');
		caracteres.add('g'); caracteres.add('h'); caracteres.add('i');
		caracteres.add('j'); caracteres.add('k'); caracteres.add('l');
		caracteres.add('m'); caracteres.add('n'); caracteres.add('o');
		caracteres.add('p'); caracteres.add('q'); caracteres.add('r');
		caracteres.add('s'); caracteres.add('t'); caracteres.add('u');
		caracteres.add('v'); caracteres.add('w'); caracteres.add('x');
		caracteres.add('y'); caracteres.add('z'); caracteres.add(' ');

		//Validando formato


		try {

			if(data.length()==10){
				// 1� Verifica formato
				sdf.parse(data); // tenta converter para data

				//2� Verifica se tem letras

				for(int i = 0 ; i<=data.length()-1 ; i++){

					if(caracteres.contains(data.charAt(i))){
						JOptionPane.showMessageDialog(null,"A data n�o pode conter espa�os e letras.");
						return false;
					}
				}

				//3� Verifica ano
				for(int ii = 0 ; ii <data.length() ; ii++){
					if(ii<=3){
						ano += data.charAt(ii);
					}else{
						if(ii > 4 && ii <=6){
							mes += data.charAt(ii);
						}else{
							if(ii>7 && ii<=9){
								dia += data.charAt(ii);
							}
						}
					}
				}

				// verifica quantidade de carateras (4 para ano 2 para mes 2 para dia

				if(ano.length()== 4 && mes.length()==2 && dia.length() == 2){

					// Verifica m�s (Se � entre 1 e 12)
					if(Integer.parseInt(mes)>=1 && Integer.parseInt(mes) <=12 ){

						// Verifica o dia 
						final Integer []  MAX_MONTH_DAY = {31,29,31,30,31,30,31,31,30,31,30,31}; // maximo dia do ano
						if(Integer.parseInt(dia) >=1 && Integer.parseInt(dia) <= MAX_MONTH_DAY[Integer.parseInt(mes)-1]){
							return true;
						}else{
							JOptionPane.showMessageDialog(null,"Dia invalido.");
							return false;
						}
						// -- Fim verifica dia


					}else{
						JOptionPane.showMessageDialog(null,"M�s invalido.");
						return false;
					}
				}else{
					JOptionPane.showMessageDialog(null,"Formato da data Invalido, Padr�o(AAAA/MM/DD).");
					return false;
				}
			}else{
				JOptionPane.showMessageDialog(null,"Formato da data Invalido, Padr�o(AAAA/MM/DD).");
				return false;
			}
		} catch (Exception e) {			
			System.out.println("Houve um erro na verifica��o da data"+e.getMessage());
			System.out.println("______________STACK TRACE ________________");
			e.printStackTrace();
			return false; // seta retornador falso

		}
	}


}
