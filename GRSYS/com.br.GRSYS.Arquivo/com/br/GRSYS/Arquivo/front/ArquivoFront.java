package com.br.GRSYS.Arquivo.front;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class ArquivoFront extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */

	private JPanel contentPane;
	private JTextField novo;

	/**
	 * Launch the application.
	 */
	public static void start() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
					ArquivoFront frame = new ArquivoFront();
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
	public ArquivoFront() {
		setTitle("Cadastro de Tipo de Arquivo");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ArquivoFront.class.getResource("/br/com/gms/Interface/logo-header.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 410, 296);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(50, 16, 294, 69);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JComboBox<String> cbCadastrados = new JComboBox<String>();
		cbCadastrados.setBackground(Color.WHITE);
		cbCadastrados.setBounds(6, 26, 282, 26);
		panel.add(cbCadastrados);
		
		
		JLabel lblVizualizarCadastrados = new JLabel("Vizualizar Cadastrados");
		lblVizualizarCadastrados.setBounds(75, 6, 158, 16);
		panel.add(lblVizualizarCadastrados);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(50, 109, 294, 142);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblCadastrarNovo = new JLabel("Cadastrar Novo");
		lblCadastrarNovo.setBounds(100, 6, 93, 16);
		panel_1.add(lblCadastrarNovo);
		
		novo = new JTextField();
		novo.setBounds(27, 58, 248, 28);
		panel_1.add(novo);
		novo.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(122, 44, 55, 16);
		panel_1.add(lblNome);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnCadastrar.setBounds(100, 108, 90, 28);
		panel_1.add(btnCadastrar);
	
		JLabel lblRefresh = new JLabel("Refresh");
		lblRefresh.setFont(new Font("SansSerif", Font.PLAIN, 8));
		lblRefresh.setBounds(360, 26, 49, 16);
		contentPane.add(lblRefresh);
	}
}
