package com.br.GRSYS.Login.main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.br.GRSYS.Auth.Usuario.Usuario;
import com.br.GRSYS.DAO.LoginDao;
import com.br.GRSYS.DAO.RegistroDao;
import com.br.GRSYS.Security.Seguranca;

import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroFront extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usuario;
	private JPasswordField senha;
	private JPasswordField resenha;
	private JTextField email;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroFront frame = new CadastroFront();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	
	/**
	 * Create the frame.
	 */
	public CadastroFront() {
		
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(CadastroFront.class.getResource("/br/com/gms/Interface/logo-header.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 306, 373);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		usuario = new JTextField();
		usuario.setBounds(36, 90, 124, 20);
		contentPane.add(usuario);
		usuario.setColumns(10);

		senha = new JPasswordField();
		senha.setBounds(36, 145, 124, 20);
		contentPane.add(senha);

		resenha = new JPasswordField();
		resenha.setBounds(36, 192, 124, 20);
		contentPane.add(resenha);

		email = new JTextField();
		email.setBounds(36, 241, 205, 20);
		contentPane.add(email);
		email.setColumns(10);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(36, 223, 71, 14);
		contentPane.add(lblEmail);

		JLabel lblRepetirSenha = new JLabel("Repetir Senha");
		lblRepetirSenha.setBounds(36, 178, 88, 14);
		contentPane.add(lblRepetirSenha);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(36, 131, 88, 14);
		contentPane.add(lblSenha);

		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				String	strSenha = MetodosAuxiliares.parsePassword(senha.getPassword());
				String  strResenha = MetodosAuxiliares.parsePassword(resenha.getPassword());
				// Verifica se todos os campos estão preenchidos
				if((usuario.getText().toString().isEmpty() || strSenha.isEmpty() ||
						strResenha.toString().isEmpty() || email.getText().toString().isEmpty())){
					JOptionPane.showMessageDialog(null, "Favor inserir todas as informações solicitadas.");
				}else{
					// Verifica Quantidade De caractares

					if(usuario.getText().toString().length() < 8 || usuario.getText().toString().length()>14){ // Verifica quantidade de caracteres do usuario
						JOptionPane.showMessageDialog(null,"O usuário precisa estar entre 8 a 15 Caracteres.");
						usuario.setText("");
					}else{
						if(strSenha.toString().length()<8 || strSenha.length() >19){ // Verifica Quantidade de caracteres da senha
							JOptionPane.showMessageDialog(null,"A senha precisa estar entre 8 e 20 Caracteres.");
							senha.setText("");
							resenha.setText("");
						}else{
							if(strSenha.toString().equals(strResenha.toString())){ // compara senhas coincidindo
								// Verifica se o usuario ja existe
								if(LoginDao.usuarioExists(usuario.getText().toString())){
									JOptionPane.showMessageDialog(null,"O usuário Já existe !");
									usuario.setText("");
									senha.setText("");
									resenha.setText("");
									email.setText("");
								}else{
									Usuario user = new Usuario(usuario.getText().toString(),Seguranca.hashPassword(senha.getText().toString()),email.getText().toString());
									if(RegistroDao.criarUsuario(user)){
										JOptionPane.showMessageDialog(null,"Usuario criado com sucesso !");
									}
								}
							}else{
								JOptionPane.showMessageDialog(null,"As senhas não concidem.");
								senha.setText(null);
								resenha.setText("");
							}
							
						}
					}


				}


			}
		});
		btnRegistrar.setBounds(89, 300, 89, 23);
		contentPane.add(btnRegistrar);

		JLabel lblRegistrar = new JLabel("Registrar");
		lblRegistrar.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRegistrar.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistrar.setBounds(89, 25, 97, 20);
		contentPane.add(lblRegistrar);

		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(36, 72, 88, 14);
		contentPane.add(lblUsuario);
	}

}
