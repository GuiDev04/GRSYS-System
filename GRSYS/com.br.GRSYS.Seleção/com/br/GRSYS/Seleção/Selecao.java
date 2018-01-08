package com.br.GRSYS.Seleção;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Calendar;

import org.apache.commons.io.FilenameUtils;

import com.br.GRSYS.Arquivo.Arquivo;
import com.br.GRSYS.AutoNomeia.GerenciadorGeral.GerenciadorGeral;
import com.br.GRSYS.Selecao.configuracoes.ConfigSelecao;
import com.br.GRSYS.SelecaoDAO.SelecaoDAO;
import com.br.GRSYS.SelecaoDAO.SelecaoException;

public class Selecao {

	public Selecao(){

	}

	// Metodo GetLocalRaiz

	File localRaiz = (new File (ConfigSelecao.getLocalExecution()));


	//Metodo get Qtd

	public static int getQtdNaPasta(){

		File localRaiz = (new File (ConfigSelecao.getLocalExecution()));
		int cont = 0;
		new StringBuilder("");

		for(File arquivo : localRaiz.listFiles()){
			if(arquivo.isFile()){
				cont++;
			}
		}

		return cont;

	}

	// Metodo Cria Locais

	private void criaLocais(){

		File local = localRaiz;

		// -- Criando Estrutura

		ArrayList<File> pastas = new ArrayList<File>();
		ArrayList<File> arquivos = new ArrayList<File>();

		//(Pastas a Criar)
		int ano = Calendar.getInstance().get(Calendar.YEAR);
		int mes = (Calendar.getInstance().get(Calendar.MONTH)+1);
		int dia = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);

		String hoje = "/"+ano+"/Mes-"+mes+"/Dia-"+dia+"/";

		// Arquivos
		File locaisVarredura = new File("C:/GRSYS/Selecao/locaisVarredura.txt");

		//Adiocionando arquivos
		arquivos.add(locaisVarredura);

		// Diretorios
		File pendente = new File(local.getAbsolutePath()+"/Pendente"+hoje);
		File naoCadastrado = new File(local.getAbsolutePath()+"/NaoCadastrado"+hoje);
		File naoPendente = new File(local.getAbsolutePath()+"/NaoPendente"+hoje);
		File outrosArquivos = new File(local.getAbsolutePath()+"/Outros_Arquivos"+hoje);
		File log = new File(local.getAbsolutePath()+"/LogsDeExecucao"+hoje);
		File renomeados = new File(local.getAbsolutePath()+"/Renomeados");
		//(Adicionando no arrayList)

		pastas.add(pendente);
		pastas.add(locaisVarredura);
		pastas.add(naoPendente);
		pastas.add(log);
		pastas.add(outrosArquivos);
		pastas.add(renomeados);
		pastas.add(naoCadastrado);

		// Criando diretorios
		for(File localDaVez : pastas){

			if(!localDaVez.exists()){
				try{
					localDaVez.mkdirs();
				}catch(SecurityException e){
					System.err.println("Erro ao criar o local."+localDaVez.getAbsolutePath());
					System.out.println("Erro"+e.getMessage());
					e.printStackTrace();
				}
			}
		}

		// Criando arquivos
		for(File arquivoDaVez : arquivos ){
			if(!arquivoDaVez.exists()){
				try{
					arquivoDaVez.createNewFile();
				}catch(IOException e){
					System.err.println("Erro ao criar arquivo"+arquivoDaVez.getAbsolutePath());
					System.out.println("Erro"+e.getMessage());
					e.printStackTrace();
				}
			}
		}

	}


	// Metodo localiza arquivos

	public void seleciona(){

		//INSTANCIA DA EXECUCAO
		Selecao s = new Selecao();


		//SETANDO LOCAL DA BUSCA
		File local = localRaiz;

		//CRIA PASTAS (RENOMEADOS, ENCONTRADOS, ETC)
		s.criaLocais();


		//CRIA UMA INSTANCIA DO GERENCIADOR GERAL PARA RENOMEAR
		GerenciadorGeral gg = new GerenciadorGeral(local.toPath());


		//RENOMEIA ARQUIVOS E COLHE RENOMEADOS
		ArrayList<File> arquivos = gg.start();


		
		//CRIANDO PADRAO DE PASTAS (HOJE)
		int ano = Calendar.getInstance().get(Calendar.YEAR);
		int mes = (Calendar.getInstance().get(Calendar.MONTH)+1);
		int dia = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);

		String hoje = "/"+ano+"/Mes-"+mes+"/Dia-"+dia+"/";
		
		//VERIFICANDO OUTROS ARQUIVOS (QUE NAO FORAM RENOMEADOS)
		for(String arq :local.list()){ // Foreach
			
			//CRIA CAMINHO DO ARQUIVO
			File antigo = new File(local.getAbsolutePath()+"/"+arq);
			
			//SE O ARQUIVO NAO FOI RENOMEADO
			if(!arquivos.contains(antigo)){
				//VERIFICO SE O É UM ARQUIVO
				if(antigo.isFile()){ 
					//MOVE ARQUIVO PARA A PASTA (OUTROS_ARQUIVOS)
					File novo = new File(local.getAbsolutePath()+"/Outros_Arquivos/"+hoje);
					try{
						//MOVE ARQUIVO PARA A PASTA
						if(!novo.exists()){ // faz so mover o que nao existe
							Files.move(antigo.toPath(),novo.toPath());
						}else{
							antigo.delete();
						}
					}catch(IOException e){
						GerenciadorGeral.gerarLogErro(e);
					}
				}

			}else{
				//SE FOI RENOMEADO
				try{

					//Converte file em Arquivo e valida os pendentes
					ArrayList<Arquivo> arqs = findPending(arquivos);
					// Itera por cada arquivo do array
					for(Arquivo arqDaVez : arqs){	
						// Se Foi criado a apolice e o arquivo
						if(SelecaoDAO.typeIsCreated(arqDaVez)){ 
							System.out.println("O arquivo existe");
							// Verifico se esta pendente o arquivo
							if(arqDaVez.getIsPending()){
								System.out.println("ele esta pendente");
								Files.move(arqDaVez.getLocal(),Paths.get(localRaiz+"/Pendente/"+hoje+arqDaVez.getLocal().getFileName()),StandardCopyOption.REPLACE_EXISTING);
							}else{
								System.out.println("ele não esta pendente");
								Files.move(arqDaVez.getLocal(),Paths.get(localRaiz+"/NaoPendente"+hoje+arqDaVez.getLocal().getFileName()),StandardCopyOption.REPLACE_EXISTING);
							}
						}else{// Se nao foi criado move para NãoCadastrado
							System.out.println("Não é um arquivo cadastrado");
							Files.move(arqDaVez.getLocal(),Paths.get(localRaiz+"/NaoCadastrado"+hoje+arqDaVez.getLocal().getFileName()),StandardCopyOption.REPLACE_EXISTING);
						}
					}
				}catch(IOException e){
					GerenciadorGeral.gerarLogErro(e);
				}
			}
		} // Fim Forech
	}

	// Encontra pendenetes
	private ArrayList<Arquivo> findPending(ArrayList<File> local){

		// Retorna lista de pendentes


		ArrayList<Arquivo> arquivos = new ArrayList<Arquivo>();

		// Criando ArrayList de arquivos
		for(File arquivoDaVez : local){

			Arquivo arq = new Arquivo();

			arq.setLocal(arquivoDaVez.toPath());

			// Removo a extensão
			String nome = FilenameUtils.removeExtension(arquivoDaVez.getName());

			//Separo os os _
			String atributos[] = nome.split("_");


			//Setando valores no Objeto arq
			arq.setTipoArquivo(atributos[0].replaceAll("\\s",""));
			arq.setApolice(atributos[1].replaceAll("\\s",""));
			arq.setCompetencia(atributos[2].replaceAll("\\s",""));


			// Adicionando ao array
			arquivos.add(arq);

		}


	}
}




