package com.br.GRSYS.AutoNomeia.Operadoras;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.apache.commons.io.FilenameUtils;

import com.br.GRSYS.AutoNomeia.Exception.WebTranException;
import com.br.GRSYS.AutoNomeia.GerenciadorGeral.GerenciadorGeral;

public class WebTran extends GerenciadorGeral{



	// Metodo de nomear Fatura em uma pasta local

	public WebTran(Path local) {
		super(local);
	}

	// Metodos Renomeia

	public File nomeiaFat(File arquivoDaVez) throws WebTranException {

		File contenho = null;
		StringBuilder comp = new StringBuilder("");
		// Verificando arquivo

		// Lendo arquivo
		StringBuilder primeiraLinha = new StringBuilder("");
		try{
			File arq = new File(this.getLocal().toFile().getPath()+"\\"+arquivoDaVez.getName());
			try(BufferedReader lerArq = new BufferedReader(new FileReader(arq))){

				primeiraLinha.append(lerArq.readLine()); // pega as 1 primeiras linhas do arquivo
			}
			// procura apólice e competencia

			if(!primeiraLinha.toString().isEmpty()){



				StringBuilder clearPrimeiraLinha = new  StringBuilder("");

				for(int II = (primeiraLinha.length()/2) ; II < primeiraLinha.length() ; II++){
					clearPrimeiraLinha.append( primeiraLinha.charAt(II));
				}

				// tira letras da primeira linha

				clearPrimeiraLinha = new StringBuilder(excluiLetras(clearPrimeiraLinha.toString()));	


				// pega competencia



				comp.append(clearPrimeiraLinha.charAt(0));
				comp.append(clearPrimeiraLinha.charAt(1));
				comp.append(clearPrimeiraLinha.charAt(2));
				comp.append(clearPrimeiraLinha.charAt(3));
				comp.append(clearPrimeiraLinha.charAt(4));
				comp.append(clearPrimeiraLinha.charAt(5));

				//RENOMEANDO

				File renomeadoDaVez = new File(this.getLocal().toString()+"/"+arquivoDaVez.getName());

				contenho = new File(this.getLocal().toString()+"/FAT_"+excluiLetras(padraoNomeApolice(arquivoDaVez.getName()))+"_"+comp+".txt");

				renomeiaArquivo(renomeadoDaVez.toPath(),contenho.toPath());

			}else{
				arq.delete();
			}
		}catch(IOException e){
			GerenciadorGeral.gerarLogErro(e);
			throw new WebTranException();
		}

		assert(!(contenho == null));
		return contenho;

	}



	public File nomeiaPc(File arquivoDaVez ) throws WebTranException {
		String comp ="";
		File novoNome = null;

		StringBuilder primeiraLinha = new StringBuilder("");

		// Lendo arquivo
		File arq = new File(this.getLocal().toFile().getPath()+"\\"+arquivoDaVez.getName());

		try{
			// Lê Arquivo e fecha
			try(BufferedReader lerArq = new BufferedReader(new FileReader(arq));){

				primeiraLinha.append(lerArq.readLine()); // pega as 1 primeiras linhas do arquivo

			}

			if(!primeiraLinha.toString().isEmpty()){
				primeiraLinha.append(excluiLetras(primeiraLinha.toString()));

				//Procura apólice e competencia

				StringBuilder clearPrimeiraLinha = new StringBuilder("");

				for(int II = (primeiraLinha.length()/3) ; II < primeiraLinha.length() ; II++){
					clearPrimeiraLinha.append(primeiraLinha.charAt(II));
				}

				// tira letras da primeira linha

				clearPrimeiraLinha.append(excluiLetras(clearPrimeiraLinha.toString()));	


				// pega competencia



				comp += clearPrimeiraLinha.charAt(clearPrimeiraLinha.length() - 8 );
				comp += clearPrimeiraLinha.charAt(clearPrimeiraLinha.length() - 7 );
				comp += clearPrimeiraLinha.charAt(clearPrimeiraLinha.length() - 6 );
				comp += clearPrimeiraLinha.charAt(clearPrimeiraLinha.length() - 5 );
				comp += clearPrimeiraLinha.charAt(clearPrimeiraLinha.length() - 4 );
				comp += clearPrimeiraLinha.charAt(clearPrimeiraLinha.length() - 3 );

				// renomeia arquivo


				File renomeadoDaVez = new File(this.getLocal().toString()+"/"+arquivoDaVez.getName());

				novoNome = new File(this.getLocal().toString()+"/PC_"+excluiLetras(padraoNomeApolice(arquivoDaVez.getName()))+"_"+comp+".txt");

				renomeiaArquivo(renomeadoDaVez.toPath(),novoNome.toPath());

			}else{
				arq.delete();
			}

		}catch(IOException e){
			GerenciadorGeral.gerarLogErro(e);
			throw new WebTranException();
		}
		assert(!(novoNome == null));
		return novoNome;
	}



	public File nomeiaPs(File arquivoDaVez) throws WebTranException {
		File novoNome = null;
		StringBuilder comp = new StringBuilder("");

		// Verificando arquivo
		StringBuilder primeiraLinha = new StringBuilder("");

		try{

			File arq = new File(this.getLocal().toFile().getPath()+"\\"+arquivoDaVez.getName());

			// Lendo arquivo
			try(BufferedReader lerArq = new BufferedReader(new FileReader(arq));){
				primeiraLinha.append(lerArq.readLine()); // pega as 1 primeiras linhas do arquivo
			}

			if(!primeiraLinha.toString().isEmpty()){

				primeiraLinha.append(excluiLetras(primeiraLinha.toString()));

				// procura apólice e competencia

				StringBuilder clearPrimeiraLinha = new StringBuilder("");

				for(int II = (primeiraLinha.length()/3) ; II < primeiraLinha.length() ; II++){
					clearPrimeiraLinha.append(primeiraLinha.charAt(II));
				}

				// tira letras da primeira linha

				clearPrimeiraLinha.append(excluiLetras(clearPrimeiraLinha.toString()));	



				// pega competencia



				comp.append(clearPrimeiraLinha.charAt(clearPrimeiraLinha.length() - 8 ));
				comp.append(clearPrimeiraLinha.charAt(clearPrimeiraLinha.length() - 7 ));
				comp.append(clearPrimeiraLinha.charAt(clearPrimeiraLinha.length() - 6 ));
				comp.append(clearPrimeiraLinha.charAt(clearPrimeiraLinha.length() - 5 ));
				comp.append(clearPrimeiraLinha.charAt(clearPrimeiraLinha.length() - 4 ));
				comp.append(clearPrimeiraLinha.charAt(clearPrimeiraLinha.length() - 3 ));


				// renomeia arquivo



				File renomeadoDaVez = new File(this.getLocal().toString()+"/"+arquivoDaVez.getName());
				novoNome = new File(this.getLocal()+"/PS_"+excluiLetras(padraoNomeApolice(arquivoDaVez.getName()))+"_"+comp+".txt");

				
				renomeiaArquivo(renomeadoDaVez.toPath(),novoNome.toPath());

			}else{
				arq.delete();
			}

		}catch(IOException e){
			GerenciadorGeral.gerarLogErro(e);
			throw new WebTranException();
		}

		assert(!(novoNome == null)): "Ps" ;
		return novoNome;


	}


	public File nomeiaSn(File arquivoDaVez) throws WebTranException {

		File novoNome = null;

		StringBuilder comp = new StringBuilder("");

		// Verificando arquivo
		String primeiraLinha = "";
		// Lendo arquivo
		try{
			File arq = new File(this.getLocal().toFile().getPath()+"\\"+arquivoDaVez.getName());
			try(BufferedReader lerArq = new BufferedReader(new FileReader(arq));){

				primeiraLinha += lerArq.readLine(); // pega as 1 primeiras linhas do arquivo
			}

			if(!primeiraLinha.isEmpty()){

				primeiraLinha = primeiraLinha.replaceAll("\\s","");



				// pega competencia 

				// Verifica

				// Arquivo sem espaço
				if(primeiraLinha.charAt(392) == '0'){

					comp.append(primeiraLinha.charAt(393));
					comp.append(primeiraLinha.charAt(394));
					comp.append(primeiraLinha.charAt(395));
					comp.append(primeiraLinha.charAt(396));
					comp.append(primeiraLinha.charAt(397));
					comp.append(primeiraLinha.charAt(398));

				}else{

					// le arquivo com espaço
					comp.append(primeiraLinha.charAt(392));
					comp.append(primeiraLinha.charAt(393));
					comp.append(primeiraLinha.charAt(394));
					comp.append(primeiraLinha.charAt(395));
					comp.append(primeiraLinha.charAt(396));
					comp.append(primeiraLinha.charAt(397));

				}
				// renomeia arquivo



				File renomeadoDaVez = new File(this.getLocal().toString()+"/"+arquivoDaVez.getName());

				novoNome = new File(this.getLocal().toString()+"/SN_"+excluiLetras(padraoNomeApolice(arquivoDaVez.getName()))+"_"+comp+".txt");

				renomeiaArquivo(renomeadoDaVez.toPath(),novoNome.toPath());

			}else{
				arq.delete();
			}
		}catch(IOException e){
			GerenciadorGeral.gerarLogErro(e);
			throw new WebTranException();
		}


		assert(!(novoNome == null)): "SN" ;
		return(novoNome);
	}


	public File nomeiaEx(File arquivoDaVez) throws WebTranException {

		File novoNome = null;
		StringBuilder comp = new StringBuilder("");
		StringBuilder primeiraLinha = new StringBuilder("");

		// Verificando arquivo

		try{
			// Lendo arquivo (Try com recurso)

			File arq = new File(this.getLocal().toFile().getPath()+"\\"+arquivoDaVez.getName());
			try(BufferedReader lerArq = new BufferedReader((new FileReader(arq)))){

				primeiraLinha = new StringBuilder(lerArq.readLine());
			}
			if(!primeiraLinha.toString().isEmpty()){


				// Renomeando e movendo


				// Removendo em branco

				primeiraLinha = new StringBuilder(primeiraLinha.toString().replaceAll("\\s",""));


				// pega competencia 

				// Verifica

				comp.append(primeiraLinha.charAt(3));
				comp.append(primeiraLinha.charAt(4));
				comp.append(primeiraLinha.charAt(5));
				comp.append(primeiraLinha.charAt(6));
				comp.append(primeiraLinha.charAt(7));
				comp.append(primeiraLinha.charAt(8));

				// renomeia arquivo

				File renomeadoDaVez = new File(this.getLocal().toString()+"/"+arquivoDaVez.getName());

				novoNome = new File(this.getLocal()+"/EX_"+excluiLetras(padraoNomeApolice(arquivoDaVez.getName()))+"_"+comp+".txt");

				//RENOMEANDO E MOVENDO
				renomeiaArquivo(renomeadoDaVez.toPath(), novoNome.toPath());

			}else{
				arq.delete();
			}

		}catch(Exception e){
			GerenciadorGeral.gerarLogErro(e);
			throw new WebTranException(e);
		}


		assert(!(novoNome== null)): "EX";
		return novoNome;
	}


	private void renomeiaArquivo(Path renomeadoDaVez,Path novoNome){

		try{
			// VERIFICA SE O NOME JA EXISTE NA PASTA
			if(novoNome.toFile().exists()){

				//COMPARO O TAMANHO DOS ARQUIVOS
				
				//SE MENOR
				if(Files.size(renomeadoDaVez)<Files.size(novoNome)){
					//ADICIONA COMPLEMENTAR
					
					Files.move(renomeadoDaVez,
							Paths.get(FilenameUtils.removeExtension(novoNome.toAbsolutePath().toString())+"_C.txt"),
							   StandardCopyOption.REPLACE_EXISTING);
					
				}else{
					//SE IGUAL
					if(Files.size(renomeadoDaVez)==Files.size(novoNome)){
						
						//DELETO O RENOMEADO DA VEZ POIS JA TENHO
						renomeadoDaVez.toFile().delete();
					}else{
						
						//SE MAIOR
						if(Files.size(renomeadoDaVez)>Files.size(novoNome)){
							//SETANDO O ARQUIVO CONTIDO NA PASTA (NOVONOME) COMO COMPLEMENTAR
							Files.move(novoNome,
									Paths.get(FilenameUtils.removeExtension(novoNome.toAbsolutePath().toString())+"_C.txt"),
									   StandardCopyOption.REPLACE_EXISTING);
							
							//RENOMEANDO RENOMEADO DA VEZ PARA O NOVO NOME
							Files.move(renomeadoDaVez,novoNome);
						}
						
					}
				}
				
			}else{
				//SE NÃO EXISTE
				
				//RENOMEIA
				Files.move(renomeadoDaVez, novoNome);
			}		
		}catch(IOException e){
			// GERA LOG
			GerenciadorGeral.gerarLogErro(e);
		}

	}

}
