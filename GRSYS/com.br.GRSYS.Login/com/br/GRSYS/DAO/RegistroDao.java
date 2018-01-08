package com.br.GRSYS.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import com.br.GRSYS.Auth.Usuario.Usuario;
import com.br.GRSYS.ConnectionFactory.ConnectionFactory;

public class RegistroDao {

	public static boolean criarUsuario(Usuario user){
		
		// criando vars
		Connection con;
		String insereUsuario;
		String insereSenha;
		try{
			// criando conexao
			con = ConnectionFactory.abreConnection("grsys");
			
			insereUsuario = "insert into authusuario (usuario,email) values (?,?)";
			
			insereSenha = "insert into authsenha (Situacao,usuario,Dt_criacao,senha) values (1,?,?,?)";
			
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(insereUsuario);
			
			stmt.setString(1,user.getUsuario());
			stmt.setString(2,user.getEmail());
			
			stmt.executeUpdate();
			
			stmt = (PreparedStatement) con.prepareStatement(insereSenha);
			
			stmt.setString(1,user.getUsuario());
			stmt.setString(2,user.getDataCriacao());
			stmt.setString(3,user.getSenha());
			
			stmt.executeUpdate();
			
			
			stmt.close();
			con.close();
			
		}catch(Exception e ){
			JOptionPane.showMessageDialog(null,"Erro no metodo de criar usuario criarUsuario class DAO");
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
}
