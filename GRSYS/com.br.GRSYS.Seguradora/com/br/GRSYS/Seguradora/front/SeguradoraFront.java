package com.br.GRSYS.Seguradora.front;


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
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class SeguradoraFront extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField idseguradora;
	private JTextField nomeFantasia;
	private JTextField cnpj;
	private JTextField razaoSocial;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SeguradoraFront frame = new SeguradoraFront();
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
	public SeguradoraFront() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(SeguradoraFront.class.getResource("/br/com/gms/Interface/logo-header.png")));
		setResizable(false);
		setBounds(100, 100, 709, 512);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		DefaultTableModel model = new DefaultTableModel();

		// add column
		model.addColumn("Nome");
		model.addColumn("Sobrenome");
		model.addRow((new Object[]{"Guilherme","Maciel"}));
		contentPane.setLayout(null);



		JLabel lblSeguradoras = new JLabel("Seguradoras");
		lblSeguradoras.setBounds(260, 38, 158, 14);
		contentPane.add(lblSeguradoras);

		cnpj = new JTextField();
		cnpj.setBackground(Color.WHITE);
		cnpj.setEditable(false);
		cnpj.setBounds(197, 320, 225, 20);
		contentPane.add(cnpj);
		cnpj.setColumns(10);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(144, 194, 325, 252);
		contentPane.add(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);

		idseguradora = new JTextField();
		idseguradora.setBackground(Color.WHITE);
		sl_panel.putConstraint(SpringLayout.EAST, idseguradora, -47, SpringLayout.EAST, panel);
		idseguradora.setEditable(false);
		panel.add(idseguradora);
		idseguradora.setColumns(10);

		nomeFantasia = new JTextField();
		sl_panel.putConstraint(SpringLayout.WEST, idseguradora, 0, SpringLayout.WEST, nomeFantasia);
		nomeFantasia.setBackground(Color.WHITE);
		sl_panel.putConstraint(SpringLayout.WEST, nomeFantasia, -272, SpringLayout.EAST, panel);
		nomeFantasia.setEditable(false);
		sl_panel.putConstraint(SpringLayout.EAST, nomeFantasia, -47, SpringLayout.EAST, panel);
		panel.add(nomeFantasia);
		nomeFantasia.setColumns(10);

		JLabel lblNomeFantasia = new JLabel("Nome Fantasia");
		sl_panel.putConstraint(SpringLayout.WEST, lblNomeFantasia, 53, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblNomeFantasia, -162, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, nomeFantasia, 0, SpringLayout.SOUTH, lblNomeFantasia);
		sl_panel.putConstraint(SpringLayout.NORTH, lblNomeFantasia, 72, SpringLayout.NORTH, panel);
		panel.add(lblNomeFantasia);

		JLabel lblRazaoSocial = new JLabel("Razao Social");
		sl_panel.putConstraint(SpringLayout.WEST, lblRazaoSocial, 0, SpringLayout.WEST, idseguradora);
		sl_panel.putConstraint(SpringLayout.EAST, lblRazaoSocial, -154, SpringLayout.EAST, panel);
		panel.add(lblRazaoSocial);

		razaoSocial = new JTextField();
		sl_panel.putConstraint(SpringLayout.SOUTH, lblRazaoSocial, -6, SpringLayout.NORTH, razaoSocial);
		sl_panel.putConstraint(SpringLayout.WEST, razaoSocial, 0, SpringLayout.WEST, idseguradora);
		razaoSocial.setBackground(Color.WHITE);
		sl_panel.putConstraint(SpringLayout.EAST, razaoSocial, -47, SpringLayout.EAST, panel);
		razaoSocial.setEditable(false);
		sl_panel.putConstraint(SpringLayout.NORTH, razaoSocial, 167, SpringLayout.NORTH, panel);
		panel.add(razaoSocial);
		razaoSocial.setColumns(10);

		JLabel lblCnpj = new JLabel("CNPJ");
		sl_panel.putConstraint(SpringLayout.NORTH, lblCnpj, 20, SpringLayout.SOUTH, lblNomeFantasia);
		sl_panel.putConstraint(SpringLayout.WEST, lblCnpj, 53, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblCnpj, -212, SpringLayout.EAST, panel);
		panel.add(lblCnpj);

		JLabel lblIdSeguradora = new JLabel("ID Seguradora");
		sl_panel.putConstraint(SpringLayout.WEST, lblIdSeguradora, 37, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblIdSeguradora, -207, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblIdSeguradora, -178, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, idseguradora, 1, SpringLayout.SOUTH, lblIdSeguradora);
		panel.add(lblIdSeguradora);
		lblIdSeguradora.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblStatus = new JLabel("Status");
		sl_panel.putConstraint(SpringLayout.SOUTH, lblStatus, -43, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblStatus, 53, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblStatus, 96, SpringLayout.WEST, panel);
		panel.add(lblStatus);

		JComboBox<String> status = new JComboBox<String>();
		sl_panel.putConstraint(SpringLayout.NORTH, status, 1, SpringLayout.SOUTH, lblStatus);
		sl_panel.putConstraint(SpringLayout.WEST, status, 0, SpringLayout.WEST, idseguradora);
		sl_panel.putConstraint(SpringLayout.EAST, status, -1, SpringLayout.EAST, idseguradora);
		panel.add(status);
		
		JLabel lblInformaes = new JLabel("Informa\u00E7\u00F5es");
		sl_panel.putConstraint(SpringLayout.WEST, lblInformaes, 126, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblInformaes, -5, SpringLayout.NORTH, lblIdSeguradora);
		panel.add(lblInformaes);


		JButton adicionar = new JButton("Adicionar");
		adicionar.setEnabled(false);
		adicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		adicionar.setBounds(586, 435, 89, 23);
		contentPane.add(adicionar);

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
		});
		comboBox.setMaximumRowCount(99999999);
		comboBox.setBounds(161, 58, 293, 27);
		comboBox.addItem(" ");
		
		contentPane.add(comboBox);

		JRadioButton acao = new JRadioButton("Adicionar Nova Seguradora");
		acao.setBackground(Color.WHITE);
		acao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if(acao.isSelected()){ // Vou add Seguradora
					
					idseguradora.setText("");
					cnpj.setText("");
					razaoSocial.setText("");
					nomeFantasia.setText("");
					
					// libera edição
					idseguradora.setEditable(false);
					cnpj.setEditable(true);
					razaoSocial.setEditable(true);
					nomeFantasia.setEditable(true);
					status.setEditable(false);
					idseguradora.setEnabled(false);
					status.setEnabled(true);
					comboBox.setEnabled(false);


					// Seta tipos 
					status.removeAllItems();
					status.addItem("Ativo");
					status.addItem("Inativo");

					// ativa botao que add
					adicionar.setEnabled(true);



				}else{
					
					
					
					// bloqueia edição
					comboBox.setEnabled(true);
					idseguradora.setEditable(false);
					cnpj.setEditable(false);
					razaoSocial.setEditable(false);
					nomeFantasia.setEditable(false);
					status.removeAllItems();
					status.setSelectedItem(" ");
					status.setEnabled(false);

					// desativa botao

					adicionar.setEnabled(false);

					// limpa variaveis
					idseguradora.setText("");
					cnpj.setText("");
					razaoSocial.setText("");
					nomeFantasia.setText("");



				}

			}
		});
		acao.setBounds(500, 60, 197, 23);
		contentPane.add(acao);







		model.addRow(new Object[]{"Column 1", "Column 2", "Column 3"});

	}	
}
