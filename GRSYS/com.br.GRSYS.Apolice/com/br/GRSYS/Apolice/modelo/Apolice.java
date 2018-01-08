package com.br.GRSYS.Apolice.modelo;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;

import com.br.GRSYS.Apolice.status.Status;
import com.br.GRSYS.Beneficio.modelo.Beneficio;

@Entity
public class Apolice {

	//MEMBROS DE CLASSE
	
	//DEFININDO CHAVE
	@EmbeddedId
	private ApolicePK apolicePK;
	
	//NOME DA APOLICE
	@Column(nullable=false,length=100)
	private String nome;
	
	// ATIVA OU INATIVA
	@Enumerated(EnumType.ORDINAL)
	private Status Status;
	
	//SE SUB TEM ESTIPULANTE
	@OneToOne
	private Apolice estipulante;
	
	//SAUDE DENTAL VIDA ETC
	@OneToOne
	private Beneficio beneficio;
	
	
	//GETTERS AND SETTERS
	public ApolicePK getApolicePK() {
		return apolicePK;
	}

	public void setApolicePK(ApolicePK apolicePK) {
		this.apolicePK = apolicePK;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Status getStatus() {
		return Status;
	}

	public void setStatus(Status status) {
		Status = status;
	}

	public Apolice getEstipulante() {
		return estipulante;
	}

	public void setEstipulante(Apolice estipulante) {
		this.estipulante = estipulante;
	}

	public Beneficio getBeneficio() {
		return beneficio;
	}

	public void setBeneficio(Beneficio beneficio) {
		this.beneficio = beneficio;
	}
}
