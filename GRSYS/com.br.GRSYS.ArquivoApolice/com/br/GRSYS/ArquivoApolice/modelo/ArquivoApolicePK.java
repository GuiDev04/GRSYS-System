package com.br.GRSYS.ArquivoApolice.modelo;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.OneToOne;

import com.br.GRSYS.Apolice.modelo.Apolice;
import com.br.GRSYS.Apolice.modelo.ApolicePK;
import com.br.GRSYS.Arquivo.modelo.Arquivo;

@Embeddable
public class ArquivoApolicePK implements Serializable{
	
	//MEMBROS
	private ApolicePK apolice;
	@OneToOne
	private Arquivo arquivo;
	
	//GETTERS AND SETTERS
	public Apolice getApolice() {
		return apolice;
	}
	public void setApolice(Apolice apolice) {
		this.apolice = apolice;
	}
	public Arquivo getArquivo() {
		return arquivo;
	}
	public void setArquivo(Arquivo arquivo) {
		this.arquivo = arquivo;
	}
}
