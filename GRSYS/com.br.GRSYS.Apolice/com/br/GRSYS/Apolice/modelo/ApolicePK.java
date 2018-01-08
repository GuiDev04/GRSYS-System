package com.br.GRSYS.Apolice.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.OneToOne;

import com.br.GRSYS.Seguradora.modelo.Seguradora;


public class ApolicePK implements Serializable{
	
	@OneToOne
	private Seguradora seguradora;
	@Column(length=30)
	private String numero;
	
	//GETTERS AND SETTERS 
	
	public Seguradora getSeguradora() {
		return seguradora;
	}
	public void setSeguradora(Seguradora seguradora) {
		this.seguradora = seguradora;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	
}
