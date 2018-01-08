package com.br.GRSYS.Arquivo.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Arquivo {

	//MEMBROS
	@Id
	@Column(nullable=false,length=20)
	private String nome;

	//GETTERS AND SETTERS
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
