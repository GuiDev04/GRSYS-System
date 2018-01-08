package br.com.gms.Arquivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Arquivos {

	// METODO QUE CRIA A PASTA XFER

	// -------------------------------------------------------------------

	public static void criaPastaXfer(File url){

		
		Path path = Paths.get(url.getPath()+"/xfer");

		if(Files.exists(path)){
			JOptionPane.showMessageDialog(null,"A Pasta Xfer ja existe.");
		}else{

			try {
				Files.createDirectory(path);
				JOptionPane.showMessageDialog(null,"Foi criada a pasta Xfer"); // Diz se criou
			} catch(FileAlreadyExistsException e){
				// the directory already exists.
			} catch (IOException e) {
				//something else went wrong
				e.printStackTrace();
			}
		}
	}

	// -----------------------------------------------------------------------

	//METODO QUE IMPORTA TXT DE NOME DE ARQUIVOS

	// -----------------------------------------------------------

	public static ArrayList<String> importaListaDeArquivos(String url,String Narquivo){

		ArrayList<String> arquivos = new ArrayList<String>();

		File arquivo = new File(url+"\\"+Narquivo+".TXT");

		if(!arquivo.exists()){ // verifica arquivo base se sim importa senao não

			JOptionPane.showMessageDialog(null,"Local/Arquivo base invalido");

		}else{

			try{	

				String linha = ""; // var controla linha

				FileReader fr = new FileReader(arquivo); // setando o lido
				@SuppressWarnings("resource")
				BufferedReader br = new BufferedReader(fr); // o que vai ler


				while(linha != null){ // add ao arraylist ate importar o arquivo todo
					linha = br.readLine();
					if(linha != null){
						arquivos.add(linha);
					}else{
						break;
					}
				}

			}catch(Exception e ){

				e.printStackTrace();

			}

		}
		return arquivos;
	}

	// --------------------------------------------------------------------------------

	// METODO QUE VERIFICA OS ARQUIVOS DE UMA PASTA E COLOCA EM UM ARRAYLIST<String>

	public static ArrayList<String> verArquivosDaPasta(String url){

		String arquivos[]  = new String[1000];

		ArrayList<String> arquivosArrayList = new ArrayList<String>();

		File arquivo = new File(url); // cria um arquivo que busca local

		if(arquivo.exists()){

			arquivos = arquivo.list();

			for(String arquivoDaVez:arquivos){
				arquivosArrayList.add(arquivoDaVez);
			}

		}else{
			JOptionPane.showMessageDialog(null,"Não é um local valido.");
		}

		return arquivosArrayList;

	}
	
	// METODO QUE REDEFINE BARRA
	

	
	
	// METODO QUE MOVE ARQUIVOS DA LISTA PARA A PASTA XFER

	public static void localizaEmove(String local, ArrayList<String> arquivos){

		ArrayList<String> movidos = new ArrayList<String>(); // arraylist de movidos

		
		ArrayList<String> arquivosPastaDeAcao;

		File pastaDaAcao = new File(local);

		if(!pastaDaAcao.exists() || !pastaDaAcao.isDirectory()){
			JOptionPane.showMessageDialog(null,"Pasta da Ação não existe ou não é pasta");
		}else{

			// Criando file de caminho xfer
			File testeXfer = new File(local+"\\xfer");

			// verificando se a xfer existe
			if(!testeXfer.isDirectory()){
				File xFer = new File(local);
				criaPastaXfer(xFer);
				JOptionPane.showMessageDialog(null,"Xfer criada em /n"+local);
			}else{
				JOptionPane.showMessageDialog(null,"Já existe Xfer criada.");
			}

			// Lista arquivos da pasta de ação
			arquivosPastaDeAcao = verArquivosDaPasta(local);

			// movendo
			for(String arquivoDaVez : arquivos){

				for(int i = 0 ; i < arquivosPastaDeAcao.size() ; i++){
					if(arquivosPastaDeAcao.get(i) == null){
						break;
					}
					if(arquivoDaVez.equalsIgnoreCase(arquivosPastaDeAcao.get(i))){

						
						Path atual; // local raiz do arquivo

						Path destino; // local destino do arquivo

						atual = Paths.get(local+"//"+arquivoDaVez); // setando atual do arquivo

						destino = Paths.get((local+"\\xfer")); // setando destino do arquivo
						
						try{
							Files.copy(atual,destino.resolve(arquivoDaVez),StandardCopyOption.REPLACE_EXISTING); // copia para xfer
						}catch(Exception e){
							JOptionPane.showMessageDialog(null,"Erro ao mover arquivo!");
							e.printStackTrace();
						}
						movidos.add(arquivoDaVez); // seta que o aruqivo da vez foi movido
					}else{
						continue;
					}
				}

			}
			JOptionPane.showMessageDialog(null," ( Foram encontrados "+movidos.size()+ " Arquivos.)");
		}

	}

}




