package com.br.GRSYS.Login.main;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JPasswordField;
import javax.swing.JTextPane;
import javax.swing.DropMode;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Font;

import com.br.GRSYS.ConnectionFactory.ConnectionFactory;
import com.br.GRSYS.DAO.LoginDao;
import com.br.GRSYS.Selecao.configuracoes.ConfigSelecao;
import com.br.GRSYS.interfaces.MainFront;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

public class LoginFront extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4702286137418651621L;
	private JPanel contentPane;
	private JPasswordField senha;
	private JTextField usuario;
	private int control;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		ConnectionFactory.loadConfig();
	
		try {
			
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
			LoginFront frame = new LoginFront();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Create the frame.
	 */
	public LoginFront() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginFront.class.getResource("/br/com/gms/Interface/logo-header.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 262, 339);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(55, 6, 146, 87);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(LoginFront.class.getResource("/br/com/gms/Interface/logo-header.png")));

		JLabel lblLogin_1 = new JLabel("LOGIN");
		lblLogin_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin_1.setBounds(96, 105, 64, 20);
		contentPane.add(lblLogin_1);
		lblLogin_1.setFont(new Font("Tahoma", Font.BOLD, 16));

		usuario = new JTextField();
		usuario.setBounds(49, 181, 157, 28);
		contentPane.add(usuario);
		usuario.setColumns(10);

		senha = new JPasswordField();
		senha.setBounds(49, 232, 157, 28);
		contentPane.add(senha);
		senha.setBackground(Color.WHITE);
		senha.setDropMode(DropMode.INSERT);

		JButton btnLogiar = new JButton("Logar");
		btnLogiar.setBounds(83, 272, 89, 23);
		contentPane.add(btnLogiar);

		JLabel lblNewLabel = new JLabel("Senha");
		lblNewLabel.setBounds(93, 218, 70, 14);
		contentPane.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblLogin = new JLabel("Usu\u00E1rio");
		lblLogin.setBounds(93, 166, 70, 14);
		contentPane.add(lblLogin);
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);

		JTextPane verificando = new JTextPane();
		verificando.setEditable(false);
		verificando.setText("      ");
		verificando.setBounds(65, 105, 133, 25);
		contentPane.add(verificando);

		JTextPane verifica = new JTextPane();
		verifica.setEditable(false);
		verifica.setBounds(43, 137, 169, 22);
		contentPane.add(verifica);
		btnLogiar.addActionListener(new ActionListener() {
			//AÇÃO DO BOTAO DE LOGAR

			public void actionPerformed(ActionEvent arg0) {	
				String strSenha = MetodosAuxiliares.parsePassword(senha.getPassword());
				if(!usuario.getText().toString().isEmpty() || !strSenha.isEmpty()){
					
					// VERIFICA QUE FOI INSERIDO ALGUM VALOR 

					if(LoginDao.logar(usuario.getText().toString(),strSenha)){ // TENTA LOGAR
						MainFront.main(null);
						fechaFrame();
					}else{
						verifica.setText("Usuário ou senha invalidos");
						addControl(1);
						usuario.setText("");
						senha.setText("");	
					}
				}else{
					JOptionPane.showMessageDialog(null,"Favor inserir Usuario e senha. ");
				}
			}
		});
	}

	public void fechaFrame(){

		this.dispose();


	}

	public int getControl() {
		return control;
	}

	public void addControl(int control) {
		this.control += control;
	}
}
