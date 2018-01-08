package com.br.GRSYS.Seguradora.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.br.GRSYS.Apolice.status.Status;

@Entity
public class Seguradora {
	
	@Id
	private String cnpj;
	private String  nomeFantasia;
	private String razaoSocial;
	private Status status;
	
	//GETTERS AND SETTERS
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getNomeFantasia() {
		return nomeFantasia;
	}
	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
	
	
}
