package com.br.GRSYS.ArquivoApolice.modelo;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class ArquivoApolice {
	
	//MEMBROS
	@EmbeddedId
	private ArquivoApolicePK arquivo_pk;
	private String url;
	
	//GETTERS ANDS SETTERS
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public ArquivoApolicePK getArquivo_pk() {
		return arquivo_pk;
	}

	public void setArquivo_pk(ArquivoApolicePK arquivo_pk) {
		this.arquivo_pk = arquivo_pk;
	}

	public String getUrl() {
		return url;
	}
}
