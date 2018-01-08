package com.br.GRSYS.AutoNomeia.GerenciaOperadora;

import java.io.File;

import com.br.GRSYS.AutoNomeia.Exception.WebTranException;

public abstract class Operadora {
	

	// Metodos padrão das Operadoras
	
	// Metodos de renomear arquivos
	
	public abstract File nomeiaFat(File arquivoDaVez) throws WebTranException;
	
	public abstract File nomeiaPc(File arquivoDaVez) throws WebTranException;
	
	public abstract File nomeiaSn(File arquivoDaVez) throws WebTranException;
	
	public abstract File nomeiaPs(File arquivoDaVez) throws WebTranException;
	
	public abstract File nomeiaEx(File arquivoDaVez) throws WebTranException;
	
}
