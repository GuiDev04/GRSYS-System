package com.br.GRSY.Folders;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Properties;

import com.br.GRSYS.AutoNomeia.GerenciadorGeral.GerenciadorGeral;

public class GerarPastas {

	private static GerarPastas instance = null;

	protected GerarPastas(){

	}

	public static GerarPastas getInstance(){
		if(instance == null){
			instance = new GerarPastas();
		}
		return instance;
	}

	public final static Path LOCAL_PRINCIPAL = Paths.get("C:/GRSYS");
	private static ArrayList<String> locais = new ArrayList<String>();
	
	// MAIN

	public static void gerar(){

		try{
			/*  Add locais para ser criados */
			if(Files.notExists(LOCAL_PRINCIPAL)){
				Files.createDirectory(LOCAL_PRINCIPAL);
			}

			locais.add(LOCAL_PRINCIPAL.toAbsolutePath()+"/Selecao");

			// ------------------------------//

			// criando Locais

			criadorLocais();

			// Cria Arquivos Particulares 
			selecaoConfig();
		}catch(IOException e){
			GerenciadorGeral.gerarLogErro(e);
		}
	}

	/*
	 * CRIA ARQUIVOS EXPECIAIS (METODOS)
	 * 
	 * */

	//CRIA LOCAIS
	private static void criadorLocais(){

		for(String localDaVez: locais){

			File f = new File(localDaVez);

			if(!f.exists()){
				f.mkdirs();
			} 

		}
	}

	//CONFIG DE SELEÇÃO - ARQUIVO
	private static void selecaoConfig(){

		Path selecaoConfig = Paths.get(LOCAL_PRINCIPAL.toAbsolutePath()+"/Selecao/Config.properties");

		if(Files.notExists(selecaoConfig)){

			//SE NÃO EXISTE ELE CRIA
			try{
				Files.createFile(selecaoConfig);

				try(FileWriter fw = new FileWriter(selecaoConfig.toFile());
						BufferedWriter bw = new BufferedWriter(fw))
				{

					//ESCREVENDO ARQUIVO DE CONFIGURAÇÔES DE SELECAO
					bw.write("DelayExecute = 60");
					bw.newLine();
					bw.write("LocalExecution = ");


					bw.flush();

				}


			}catch(IOException e){
				GerenciadorGeral.gerarLogErro(e);
			}
		}

	}

	
}

