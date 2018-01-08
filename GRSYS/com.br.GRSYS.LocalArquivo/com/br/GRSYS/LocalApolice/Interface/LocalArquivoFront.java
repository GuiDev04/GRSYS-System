package com.br.GRSYS.LocalApolice.Interface;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class LocalArquivoFront extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField url;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
					LocalArquivoFront frame = new LocalArquivoFront();
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
	public LocalArquivoFront() {
		
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(LocalArquivoFront.class.getResource("/br/com/gms/Interface/logo-header.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 481, 349);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(16, 11, 442, 298);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JComboBox cbTipoArquivo = new JComboBox();
		cbTipoArquivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		cbTipoArquivo.setBounds(175, 139, 92, 27);
		panel.add(cbTipoArquivo);
		
		
		JLabel lblLocalAtual = new JLabel("Local Setado");
		lblLocalAtual.setHorizontalAlignment(SwingConstants.CENTER);
		lblLocalAtual.setBounds(179, 209, 84, 16);
		panel.add(lblLocalAtual);

		JComboBox<String> cbApolice = new JComboBox<String>();
		cbApolice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
			}
		});
		cbApolice.setBounds(76, 87, 290, 26);
		panel.add(cbApolice);

		JLabel lblApolice = new JLabel("Apolice");
		lblApolice.setBounds(193, 71, 55, 16);
		panel.add(lblApolice);
		lblApolice.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		JLabel lblArquivosConfigurados = new JLabel("Arquivos Configurados");
		lblArquivosConfigurados.setBounds(154, 124, 134, 14);
		panel.add(lblArquivosConfigurados);
		
		
		JLabel lblSeguradora = new JLabel("Seguradora");
		lblSeguradora.setBounds(184, 30, 74, 16);
		panel.add(lblSeguradora);
		lblSeguradora.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblFiltrosDeSeleo = new JLabel("Filtros de Sele\u00E7\u00E3o ");
		lblFiltrosDeSeleo.setBounds(170, 11, 102, 16);
		panel.add(lblFiltrosDeSeleo);
		
		JComboBox<String> cbSeguradora = new JComboBox<String>();
		cbSeguradora.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
			
				
				
					
			}
		});
		
		cbSeguradora.setBounds(76, 45, 290, 26);
		panel.add(cbSeguradora);
		
		
		url = new JTextField();
		url.setHorizontalAlignment(SwingConstants.CENTER);
		url.setBounds(6, 225, 429, 28);
		panel.add(url);
		url.setEditable(false);
		url.setColumns(10);

		JButton setar = new JButton("Setar");
		setar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				

			}
		});
		setar.setEnabled(false);
		setar.setBounds(176, 264, 90, 28);
		panel.add(setar);

		JRadioButton isAlterar = new JRadioButton("Apontar Local");
		isAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// se estiver selecionado libera a url
				if(isAlterar.isSelected()){
					url.setEditable(true);
					setar.setEnabled(true);
				}else{
					url.setEditable(false);
					setar.setEnabled(false);
					
					url.setText("");
				}
			}
		});
		isAlterar.setBounds(163, 173, 115, 18);
		panel.add(isAlterar);
		
		
	}
}
