package com.br.GRSYS.Selecao.configuracoes;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

import com.br.GRSY.Folders.GerarPastas;
import com.br.GRSYS.AutoNomeia.GerenciadorGeral.GerenciadorGeral;

public class ConfigSelecao {

	// ----- ATRIBUTOS -----

	private static int dalayTime;
	private static String localExecution;
	private static Path config = Paths.get(GerarPastas.LOCAL_PRINCIPAL.toAbsolutePath()+"/Selecao/Config.properties");


	// ----- ATRIBUTOS ------

	//SINGLETON
	private static ConfigSelecao instance = null;

	// CONSTRUTOR
	protected ConfigSelecao(){

	}

	//METODO GET INSTANCE
	public static ConfigSelecao getInstance(){
		if(instance == null){
			instance = new ConfigSelecao();
		}
		return instance;
	}


	//SALVA AS CONFIGURAÇÕES 
	public void SaveConfigs(){

		try(FileInputStream fis = new FileInputStream(config.toFile());
				OutputStream out = new FileOutputStream(config.toFile()))
		{
			Properties prop = new Properties();
			
			prop.setProperty("DelayExecute",Integer.toString(ConfigSelecao.dalayTime));
			prop.setProperty("LocalExecution",ConfigSelecao.localExecution);
			
			prop.store(out,"Configurações salvas");
			
		}catch(IOException e){
			GerenciadorGeral.gerarLogErro(e);
		}
	}

	//CARREGA CONFIGURAÇÕES DE SELECAO
	public void LoadSelecaoConfig(){

		try(FileInputStream fis = new 
				FileInputStream(config.toFile()))
		{

			Properties prop = new Properties();

			prop.load(fis);
			try{
				dalayTime =Integer.parseInt(prop.getProperty("DelayExecute"));

			}catch(NumberFormatException n){
				throw new RuntimeException("Parametro DelayExcute não é int");
			}

			localExecution = prop.getProperty("LocalExecution");

		}catch(IOException e){
			GerenciadorGeral.gerarLogErro(e);
		}
	}

	//GETTERS AND SETTERS

	public static int getDalayTime() {
		return dalayTime;
	}

	public static void setDalayTime(int dalayTime) {
		ConfigSelecao.dalayTime = dalayTime;
	}

	public static String getLocalExecution() {
		return localExecution;
	}

	public static void setLocalExecution(String localExecution) {
		ConfigSelecao.localExecution = localExecution;
	}




}
