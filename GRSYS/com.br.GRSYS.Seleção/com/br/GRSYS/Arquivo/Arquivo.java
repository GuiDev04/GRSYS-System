package com.br.GRSYS.Arquivo;

import java.io.File;
import java.nio.file.Path;

import org.apache.commons.io.FilenameUtils;

public class Arquivo {

	// Atributos
	private String apolice;
	private String tipoArquivo;
	private String competencia;
	private boolean isPending;
	Path local;
	

	public Arquivo(){
		
	}
	
	
	//Metodos
	
	public static Arquivo parseArquivo(File file){

		// Retorna lista de pendentes

		// Criando ArrayList de arquivos
			Arquivo arq = new Arquivo();

			// Removo a extensão
			String nome = FilenameUtils.removeExtension(file.getPath());

			//Separo os os _
			String atributos[] = nome.split("_");


			//Setando valores no Objeto arq
			arq.setTipoArquivo(atributos[0].replaceAll("\\s",""));
			arq.setApolice(atributos[1].replaceAll("\\s",""));
			arq.setCompetencia(atributos[2].replaceAll("\\s",""));


			// RETORNA
			return arq;

	}
	
	
	// Getters and setters
	
	public String getApolice() {
		return apolice;
	}
	public void setApolice(String apolice) {
		this.apolice = apolice;
	}
	public String getTipoArquivo() {
		return tipoArquivo;
	}
	public void setTipoArquivo(String tipoArquivo) {
		this.tipoArquivo = tipoArquivo;
	}
	public String getCompetencia() {
		return competencia;
	}
	public void setCompetencia(String competencia) {
		this.competencia = competencia;
	}
	
	public boolean getIsPending() {
		return isPending;
	}


	public void setIsPending(boolean isPending) {
		this.isPending = isPending;
	}
	public Path getLocal() {
		return local;
	}


	public void setLocal(Path local) {
		this.local = local;
	}


	public void setPending(boolean isPending) {
		this.isPending = isPending;
	}


	
	
	
}
