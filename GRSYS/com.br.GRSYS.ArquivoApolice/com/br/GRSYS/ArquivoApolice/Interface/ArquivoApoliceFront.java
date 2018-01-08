package com.br.GRSYS.ArquivoApolice.Interface;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import org.eclipse.wb.swing.FocusTraversalOnArray;

public class ArquivoApoliceFront extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField url;

	public static void start(){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
					ArquivoApoliceFront frame = new ArquivoApoliceFront();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ArquivoApoliceFront() {
		setResizable(false);
		setTitle("Adicionar Arquivo Apolice");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ArquivoApoliceFront.class.getResource("/br/com/gms/Interface/logo-header.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 418, 396);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(11, 40, 390, 311);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblApolice = new JLabel(" Apolice Estipulante");
		lblApolice.setBounds(137, 75, 115, 16);
		panel.add(lblApolice);
		
		JLabel lblTipoArquivo = new JLabel("Tipo Arquivo");
		lblTipoArquivo.setBounds(150, 202, 89, 16);
		panel.add(lblTipoArquivo);
		lblTipoArquivo.setHorizontalAlignment(SwingConstants.CENTER);
		
		JComboBox<String> cbTipoArquivo = new JComboBox<String>();
		cbTipoArquivo.setBounds(144, 220, 102, 32);
		panel.add(cbTipoArquivo);
		cbTipoArquivo.setEnabled(false);
		
		JButton btnNewButton = new JButton("Adicionar");
		btnNewButton.setBounds(150, 277, 90, 28);
		panel.add(btnNewButton);
		
		url = new JTextField();
		url.setBounds(39, 165, 311, 28);
		panel.add(url);
		url.setColumns(10);
		
		JLabel lblSeguradora = new JLabel("Seguradora");
		lblSeguradora.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeguradora.setBounds(155, 40, 79, 16);
		contentPane.add(lblSeguradora);
		
		JLabel lblLocalDeArmazenamento = new JLabel("Local de Armazenamento");
		lblLocalDeArmazenamento.setBounds(119, 148, 151, 16);
		panel.add(lblLocalDeArmazenamento);
		
		JComboBox<String> cbApolice = new JComboBox<String>();
		cbApolice.setBounds(38, 90, 314, 32);
		panel.add(cbApolice);
		
		cbApolice.setEnabled(false);
		
		JComboBox<String> cbSeguradora = new JComboBox<String>();
		cbSeguradora.setBounds(38, 42, 314, 32);
		panel.add(cbSeguradora);
		
		JLabel lblSeguradora_1 = new JLabel("Seguradora");
		lblSeguradora_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeguradora_1.setBounds(155, 25, 80, 16);
		panel.add(lblSeguradora_1);
		panel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{cbSeguradora, lblSeguradora_1, lblApolice, cbApolice, lblLocalDeArmazenamento, url, lblTipoArquivo, cbTipoArquivo, btnNewButton}));
		
	
		
		// ---------------------------------------------------(Action Seguradora
		cbSeguradora.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Libera edição da cb Apolice
				if(!cbSeguradora.getSelectedItem().toString().isEmpty()){
					cbApolice.setEnabled(true);
					cbTipoArquivo.setEnabled(false);
					
					
					cbApolice.removeAllItems();
					cbApolice.addItem("");
					
				}else{
					// Bloqueia e limpa 
					cbApolice.setEnabled(false);
					cbTipoArquivo.setEnabled(false);
					cbApolice.setSelectedItem(" ");
					cbTipoArquivo.setSelectedItem(" ");
				}
			}
			
			
		});
		//----------------------------------(Action apolice
		cbApolice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbTipoArquivo.setEnabled(true);
							
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//VERIFICANDO SE TODOS OS DADOS FORAM INPUTADOS
				if(cbSeguradora.getSelectedItem().toString().isEmpty() ||
				   cbApolice.getSelectedItem().toString().isEmpty() ||
				   url.getText().isEmpty() ||
				   cbTipoArquivo.getSelectedItem().toString().isEmpty())
				{
					//SE TEM ALGUM VAZIO
					JOptionPane.showMessageDialog(null,"Favor inserir todas as informações solicitadas");
				}else{	
				}
			}
		});
		
		JLabel lblFiltros = new JLabel("Filtros de Sele\u00E7\u00E3o");
		lblFiltros.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblFiltros.setHorizontalAlignment(SwingConstants.CENTER);
		lblFiltros.setBounds(137, 12, 115, 16);
		contentPane.add(lblFiltros);
		
	}
}
