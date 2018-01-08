package com.br.GRSYS.Auth.Usuario;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Usuario {

	// Atributos do usuário
	private String usuario;
	private String senha;
	private String email;
	private String dataCriacao;
	private int situacao;


	// Construtor de usuário

	public Usuario(String usuario,String senha, String email){
		this.usuario=usuario;
		this.senha=senha;
		this.email=email;
		this.setDataCriacao(getDate());
		this.situacao = 1;
	}

	// Metodo pega Data atual

	private static String getDate(){
		String data = null;
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 0);
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		// Output "Wed Sep 26 14:23:28 EST 2012"

		String formatted = format1.format(cal.getTime());
		//System.out.println(formatted);
		// Output "2012-09-26"


		
		data = formatted;
			
		
		return data;

	}

	public static void main(String[] args) {
		
		System.out.println(getDate());
		
	}

	/* GETTERS AND SETTRS 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * */



	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public int getSituacao() {
		return situacao;
	}
	public void setSituacao(int situacao) {
		this.situacao = situacao;
	}

	public String getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(String dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
}