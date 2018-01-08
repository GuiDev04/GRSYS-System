package com.br.GRSYS.Beneficio.front;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;
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
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class BeneficioFront extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField idBeneficio;
	private JTextField nomeBeneficio;
	
	// --- 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BeneficioFront frame = new BeneficioFront();
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
	public BeneficioFront() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(BeneficioFront.class.getResource("/br/com/gms/Interface/logo-header.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 568, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTiposDeBeneficio = new JLabel("Tipos de Beneficio");
		lblTiposDeBeneficio.setBounds(195, 11, 151, 14);
		contentPane.add(lblTiposDeBeneficio);
		
		JComboBox<String> cbBeneficios = new JComboBox<String>();
		cbBeneficios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		}});
		
		cbBeneficios.setBackground(SystemColor.menu);
		cbBeneficios.setBounds(120, 36, 242, 20);
		contentPane.add(cbBeneficios);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(120, 113, 248, 137);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblInformaes = new JLabel("Informa\u00E7\u00F5es");
		lblInformaes.setBounds(89, 11, 74, 14);
		panel.add(lblInformaes);
		
		idBeneficio = new JTextField();
		idBeneficio.setBackground(Color.WHITE);
		idBeneficio.setEditable(false);
		idBeneficio.setBounds(50, 46, 143, 20);
		panel.add(idBeneficio);
		idBeneficio.setColumns(10);
		
		nomeBeneficio = new JTextField();
		nomeBeneficio.setBackground(Color.WHITE);
		nomeBeneficio.setEditable(false);
		nomeBeneficio.setBounds(50, 88, 143, 20);
		panel.add(nomeBeneficio);
		nomeBeneficio.setColumns(10);
		
		JButton btAdicionar = new JButton("Adicionar");
		btAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btAdicionar.setEnabled(false);
		btAdicionar.setBackground(SystemColor.menu);
		btAdicionar.setBounds(417, 227, 89, 23);
		contentPane.add(btAdicionar);
		
		JLabel lblIdBeneficio = new JLabel("Id Beneficio");
		lblIdBeneficio.setBounds(50, 31, 113, 14);
		panel.add(lblIdBeneficio);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(50, 75, 84, 14);
		panel.add(lblNome);
		
		JRadioButton addBeneficio = new JRadioButton("Adicionar Beneficio");
		addBeneficio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(addBeneficio.isSelected()){
					nomeBeneficio.setEditable(true);
					btAdicionar.setEnabled(true);
					cbBeneficios.setEnabled(false);
					
					idBeneficio.setText("");
					nomeBeneficio.setText("");
					
				}else{
					nomeBeneficio.setEditable(false);
					btAdicionar.setEnabled(false);
					cbBeneficios.setEnabled(true);
				}
				
			}
		});
		addBeneficio.setBackground(Color.WHITE);
		addBeneficio.setBounds(401, 35, 155, 23);
		contentPane.add(addBeneficio);
		
		
	}
}
