package com.br.GRSYS.Beneficio.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Beneficio {
	
	
	@Id
	@Column(nullable=false,length=20,unique=true)
	private String nome;
	
	public Beneficio() {
		
	}
	
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
}
