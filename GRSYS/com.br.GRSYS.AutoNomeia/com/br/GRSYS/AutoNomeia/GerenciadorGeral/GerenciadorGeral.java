package com.br.GRSYS.AutoNomeia.GerenciadorGeral;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.Inet4Address;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import com.br.GRSYS.AutoNomeia.Exception.WebTranException;
import com.br.GRSYS.AutoNomeia.Operadoras.WebTran;

public class GerenciadorGeral  {

	// Variaveis
	private  ArrayList<File> arquivosLocal = new ArrayList<File>();
	private  Path local = null;


	// Construtor

	public GerenciadorGeral(Path local){
		this.local=local;
	}

	//Metodos

	public ArrayList<File> start(){
		try {
			if(!(this.getLocal()==null)){
				//Arquivos renomeados
				ArrayList<File> renomeados = new ArrayList<File>();

				// Setando local da execução
				this.setLocal(local);;

				//Renomeia arquivos
				renomeados.addAll(startWebTran());
				return renomeados;
			}else{

				throw new GerenciadorGeralException("Local default não inserido");

			}
		}catch (GerenciadorGeralException e) {
			GerenciadorGeral.gerarLogErro(e);

		}
		return null;
	}




	private ArrayList<File> startWebTran(){

		verArquivosLocal();

		ArrayList<File> arquivosRenomeados = new ArrayList<File>();

		ArrayList<File> arquivos = getArquivosLocal();

		// Var recebe qtd ações
		StringBuilder tipo = new StringBuilder("");
		// Operadoras
		WebTran wt = new WebTran(getLocal());

		// execução
		for(int i = 0 ; i < arquivos.size() ; i++){

			File arquivoDaVez = new File(getLocal()+"//"+arquivos.get(i).getName());

			tipo.append(arquivoDaVez.getName().charAt(0));
			tipo.append(arquivoDaVez.getName().charAt(1));

			// se nao for de nenhum tipo configurado ele limpa a variavel
			if(tipo.toString().equalsIgnoreCase("PC") ||
					tipo.toString().equalsIgnoreCase("PS") ||
					tipo.toString().equalsIgnoreCase("FM") ||
					tipo.toString().equalsIgnoreCase("SN") ||
					tipo.toString().equalsIgnoreCase("EX")){



				switch (tipo.toString().toUpperCase())
				{
				// ----- PS ----- 
				case "PS" : 
					try {
						arquivosRenomeados.add(wt.nomeiaPs(arquivoDaVez));
					} catch (WebTranException e) {
						GerenciadorGeral.gerarLogErro(e);
					} tipo.setLength(0);; break;

					// ------   PC  -------
				case "PC" : 
					try {
						arquivosRenomeados.add(wt.nomeiaPc(arquivoDaVez));
					} catch (WebTranException e) {
						GerenciadorGeral.gerarLogErro(e);
					}tipo.setLength(0); break;	
					// ------ FM ------

				case "FM" : 

					try {
						arquivosRenomeados.add(wt.nomeiaFat(arquivoDaVez));
					} catch (WebTranException e) {
						GerenciadorGeral.gerarLogErro(e);
					} 

					tipo.setLength(0); break;

					// SN

				case "SN" : try {
					arquivosRenomeados.add(wt.nomeiaSn(arquivoDaVez));
				} catch (WebTranException e) {
					GerenciadorGeral.gerarLogErro(e);
					
				} tipo.setLength(0); break;

				// EX
				case "EX" : try {
					arquivosRenomeados.add(wt.nomeiaEx(arquivoDaVez));
				} catch (WebTranException e) {
					GerenciadorGeral.gerarLogErro(e);
					
				} tipo.setLength(0); break;
				}	
			}else{
				tipo.setLength(0);
			}


		}

		return arquivosRenomeados;
	}


	private String getApolice(String nomeAntes){


		// Criando variaveis auxiliares
		StringBuilder nome = new StringBuilder(nomeAntes);

		StringBuilder tipo = new StringBuilder("");

		// Pega Tipo
		tipo.append(nome.charAt(0));
		tipo.append(nome.charAt(1));


		// PEGANDO NOME
		if(tipo.toString().equalsIgnoreCase("PS") |
				tipo.toString().equalsIgnoreCase("EX") | 
				tipo.toString().equalsIgnoreCase("SN")){

			nome.setLength(0);
			nome.append(nomeAntes.replaceAll("[A-Za-z]","").replaceAll("[\\s.]",""));
			return nome.toString();

		}else{
			if(tipo.toString().equalsIgnoreCase("PC") | tipo.toString().equals("FM")){
				StringBuilder nomeNovo = new StringBuilder();

				for(int cont = 0 ;nome.charAt(cont)!='_' ; cont++){
					nomeNovo.append(nome.charAt(cont));
				}
				nomeNovo = new StringBuilder(nomeNovo.toString().replaceAll("[A-Za-z]",""));
				return nomeNovo.toString();	
			}else{
				assert(false): "tipo de arquivo para pegar o nome nao foi desenvolvido :"+tipo;
			}
		}
		return null;
	}


	protected String padraoNomeApolice(String nome){

		String nomeCerto = removeZeros(this.getApolice(nome));
		String concatZero = "";
		try{
		if(nomeCerto.charAt(0)!='0' & nomeCerto.length()>4){
			return(nomeCerto);
		}else{
			if(nomeCerto.length()<=4){
				for(int ii = 0; ii<=(4-nomeCerto.length()); ii++){
					concatZero +=0;
				}
				nomeCerto = concatZero+nomeCerto;
			}
			return(nomeCerto);
		}
		}catch(Throwable e){
			GerenciadorGeral.gerarLogErro(e);
		}
		return concatZero;
	}


	protected String excluiLetras(String palavra){

		// Criando base de letras
		assert((palavra.length()!=0)):"Palavra mandada para excluirLetras tem tamanho 0";

		palavra = palavra.replaceAll("[^\\d.]", "");
		palavra = palavra.replaceAll("\\s","");
		palavra = palavra.replaceAll("[\\s.]","");

		return palavra;
	}


	private void verArquivosLocal(){

		arquivosLocal.clear();

		File[] arquivos = getLocal().toFile().listFiles();

		getArquivosLocal().addAll(Arrays.asList(arquivos));

		//setArquivosLocal(Arrays.asList(getLocal())); // setando lista de arquivos

	}


	public static void gerarLogErro(Throwable e){

		/*       Coletando informações         */
		// local padrao de log 
		final Path LOCAL = Paths.get("R:/GERENCIAMENTO INFORMACOES/GESTAO_RISCO/GUILHERME_SIQUEIRA/GESTÃO DE RISCO/Desenvolvimento/ERROS");

		// COLETANDO INFORMAÇÔES
		// USUARIO
		String user = System.getProperty("user.name");

		//SETANDO LOCAL -> BRASIL
		Locale localidade = new Locale("pt", "BR"); 
		Calendar c = Calendar.getInstance(localidade); 

		//SETANDO PADRÃO DE DATA
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

		Date data = new Date(Calendar.getInstance().getTimeInMillis());

		Calendar cal = Calendar.getInstance();

		cal.setTime(data);
		
		int dia = c.get(Calendar.DAY_OF_MONTH);
		int mes = c.get(Calendar.MONTH)+1;
		int ano = c.get(Calendar.YEAR);
		//CRIANDO SUB PASAS DA DATA DE HOJE 
		String hoje = "/"+ano+"/"+mes+"/"+dia+"/"+user;
		
		File localLog = new File(LOCAL.toAbsolutePath()+"/LOGS DO SISTEMA"+hoje);
		File arquivoLog = new File(localLog.getAbsolutePath()+"/LOG_"+cal.get(Calendar.HOUR_OF_DAY)+"_"+cal.get(Calendar.MINUTE)+"_"+cal.get(Calendar.MILLISECOND)+""+".Txt");
		//CRIA DIRETORIOS
		if(!localLog.isDirectory()){
			try{
				localLog.mkdirs();
				arquivoLog.createNewFile();
			}catch(IOException ee){
				GerenciadorGeral.gerarLogErro(e);
			}
		}
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivoLog))){

			bw.write("Data/Hora do incidente: "+sdf.format(c.getTime()));
			bw.newLine();
			bw.write("IP:"+Inet4Address.getLocalHost().getHostAddress());
			bw.newLine();
			bw.write("Usuário:"+user);
			bw.newLine();
			bw.write("Exception: "+e.toString());
			bw.newLine();
			bw.write("ERRO  ----- STACKTRACE ABAIXO _------ GMS DEV ---------------------------------------------------------------");
			bw.newLine();
			StackTraceElement[] erros  = e.getStackTrace();
			for(StackTraceElement erroDaVez : erros){
				bw.write(erroDaVez.toString());
				bw.newLine();
			}
			System.err.println("LOG GERADO.");
		} catch (IOException e1){
			GerenciadorGeral.gerarLogErro(e1);
		}

	}


	private static String removeZeros(String apolice){


		assert(!(apolice.isEmpty())): "Inserido é vazio";

		String apoliceNova = "";
		boolean encontrou = false;

		for(int i = 0; i<= apolice.length()-1 ; i++ ){

			// se for igual a 0 continue;
			if(apolice.charAt(i)=='0' && encontrou == false && i < apolice.length()-1){
				//Verifico se o proximo é igual a 0;
				if(apolice.charAt(i+1)!='0'){

					encontrou = true;
				}

			}else{
				apoliceNova += apolice.charAt(i);
			}

		}
		return (apoliceNova);
	}


	public ArrayList<File> getArquivosLocal() {
		return arquivosLocal;
	}


	public void setArquivosLocal(ArrayList<File> arquivosLocal) {
		this.arquivosLocal = arquivosLocal;
	}


	public Path getLocal() {
		return local;
	}


	public void setLocal(Path local) {
		this.local = local;
	}



	/* GETTERS 
	 *  	   AND  
	 *               SETTERS
	 *               			ABAIXO !
	 *               
	 *   
	 *  
	 *  */



}




