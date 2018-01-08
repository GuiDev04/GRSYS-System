package com.br.GRSYS.Apolice.Front;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.HierarchyEvent;
import java.awt.event.HierarchyListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import org.eclipse.wb.swing.FocusTraversalOnArray;

public class ApoliceFront extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField numero;
	private JTextField nomeCliente;
	private JTextField dtInicial;
	private JTextField dtFinal;

	public static void start() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");

					ApoliceFront frame = new ApoliceFront();
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ApoliceFront() {
		setResizable(false);
		addHierarchyListener(new HierarchyListener() {
			public void hierarchyChanged(HierarchyEvent arg0) {
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(ApoliceFront.class.getResource("/br/com/gms/Interface/logo-header.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 674, 553);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(15, 47, 638, 471);
		contentPane.add(panel);
		panel.setLayout(null);

		JComboBox<String> cbSeguradora = new JComboBox<String>();

		cbSeguradora.setBackground(SystemColor.menu);
		cbSeguradora.setForeground(SystemColor.activeCaptionText);
		cbSeguradora.setBounds(10, 61, 395, 29);
		panel.add(cbSeguradora);


		JComboBox<String> cbTipoBeneficio = new JComboBox<String>();
		cbTipoBeneficio.setBackground(SystemColor.menu);
		cbTipoBeneficio.setBounds(435, 61, 83, 29);
		panel.add(cbTipoBeneficio);
		

		JLabel lblTipoBenefcio = new JLabel("Tipo Benef\u00EDcio *");
		lblTipoBenefcio.setBounds(435, 45, 100, 14);
		panel.add(lblTipoBenefcio);

		JLabel lblSeguradora = new JLabel("Seguradora *");
		lblSeguradora.setBounds(155, 45, 83, 14);
		panel.add(lblSeguradora);

		numero = new JTextField();
		numero.setBounds(10, 212, 121, 29);
		panel.add(numero);
		numero.setColumns(10);

		JLabel lblNmero = new JLabel("N\u00FAmero *");
		lblNmero.setBounds(12, 199, 67, 14);
		panel.add(lblNmero);

		nomeCliente = new JTextField();
		nomeCliente.setBounds(176, 213, 266, 29);
		panel.add(nomeCliente);
		nomeCliente.setColumns(10);

		JLabel lblNomeCliente = new JLabel("Nome do Cliente *");
		lblNomeCliente.setBounds(175, 199, 182, 14);
		panel.add(lblNomeCliente);

		JComboBox<String> cbStatusApolice = new JComboBox<String>();
		cbStatusApolice.setBackground(SystemColor.menu);
		cbStatusApolice.setBounds(545, 61, 83, 29);
		
		panel.add(cbStatusApolice);

		JLabel lblStatusApolice = new JLabel("Status Ap\u00F3lice *");
		lblStatusApolice.setBounds(545, 45, 93, 14);
		panel.add(lblStatusApolice);

		JLabel lblDataInicialDa = new JLabel("Data Inicial da Ap\u00F3lice *");
		lblDataInicialDa.setBounds(11, 263, 137, 14);
		panel.add(lblDataInicialDa);

		dtInicial = new JTextField();
		dtInicial.setColumns(10);
		dtInicial.setBounds(10, 277, 121, 29);
		panel.add(dtInicial);

		dtFinal = new JTextField();
		dtFinal.setBounds(176, 277, 135, 29);
		panel.add(dtFinal);
		dtFinal.setColumns(10);

		JLabel lblDataFinalDa = new JLabel("Data final da Ap\u00F3lice*");
		lblDataFinalDa.setBounds(176, 263, 277, 14);
		panel.add(lblDataFinalDa);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(10, 370, 618, 54);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblFormatoData = new JLabel("Formato Data: (DD/MM/AAAA)");
		lblFormatoData.setBounds(206, 6, 345, 14);
		panel_1.add(lblFormatoData);

		JLabel lblCamposMarcadosCom = new JLabel("Campos marcados com ( * ) s\u00E3o obrigat\u00F3rios");
		lblCamposMarcadosCom.setBounds(161, 29, 295, 14);
		panel_1.add(lblCamposMarcadosCom);






		JComboBox<String> cbApolicePrincipal = new JComboBox<String>();
		cbApolicePrincipal.setEnabled(false);
		cbApolicePrincipal.setBackground(Color.WHITE);
		cbApolicePrincipal.setBounds(10, 126, 395, 29);
		panel.add(cbApolicePrincipal);


		// Pega as apolices de uma operadora especifica 
		// Metodo Refresh Apolice principal


		JLabel lblApolicePrincipal = new JLabel("Ap\u00F3lice Estipulante");
		lblApolicePrincipal.setBounds(108, 111, 201, 16);
		panel.add(lblApolicePrincipal);

		JLabel lblCadastroDeAplices = new JLabel("Cadastro de Ap\u00F3lices");
		lblCadastroDeAplices.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCadastroDeAplices.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroDeAplices.setBounds(233, 6, 202, 29);
		contentPane.add(lblCadastroDeAplices);

		JRadioButton isSub = new JRadioButton("SUB");
		isSub.setBackground(Color.WHITE);
		isSub.setBounds(10, 6, 93, 25);
		panel.add(isSub);
		isSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if(isSub.isSelected()){
					cbApolicePrincipal.setEnabled(true);
					lblApolicePrincipal.setText(lblApolicePrincipal.getText()+"*");
				}else{
					cbApolicePrincipal.setEnabled(false);
					cbApolicePrincipal.setSelectedItem(" ");
					lblApolicePrincipal.setText("Apolice Principal (Se Sub)");

				}

			}
		});

		cbSeguradora.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {



				//CRIA APOLICE
				if(isSub.isSelected()){



					//SE É SUB

					// VERIFICO SE TUDO ESTA INPUTADO
					if(!cbSeguradora.getSelectedItem().toString().isEmpty() && // SEGURADORA
							!cbTipoBeneficio.getSelectedItem().toString().isEmpty() && // TIPO BENEFICIO
							!cbStatusApolice.getSelectedItem().toString().isEmpty() && // STATUS APOLICE (ATIVO INATIVO)
							!cbApolicePrincipal.getSelectedItem().toString().isEmpty() && // ESTIPULANTE
							!numero.getText().isEmpty() && // NUMERO DA APOLICE
							!nomeCliente.getText().isEmpty() && // NOME APOLICE
							!dtInicial.getText().isEmpty() && //DATA INCIAL APOLICE
							!dtFinal.getText().isEmpty()) //DATA FINAL APOLICE
					{
						
					}else{
						//FALTA ALGUMA INFO INPUTADA
						JOptionPane.showMessageDialog(null,"Favor inserir todas as informações solicitadas!");
					}
				}else{
					//SE ESTIPULANTE


					//VALANDO INFORMAÇÕES INPOTADAS
					if(!cbSeguradora.getSelectedItem().toString().isEmpty() &&
							!cbTipoBeneficio.getSelectedItem().toString().isEmpty() &&
							!cbStatusApolice.getSelectedItem().toString().isEmpty() &&
							!numero.getText().isEmpty() &&
							!nomeCliente.getText().isEmpty() &&
							!dtInicial.getText().isEmpty() &&
							!dtFinal.getText().isEmpty())
					{
						
						
					}else{
						//SE FALTOU INPUT
						JOptionPane.showMessageDialog(null,"Favor inserir todas as informações solicitadas!");
					}
				}

			}
		});
		btnCadastrar.setBounds(200, 436, 242, 29);
		panel.add(btnCadastrar);

		JButton btnNewButton = new JButton("refresh");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
		});
		btnNewButton.setBounds(428, 126, 67, 28);
		panel.add(btnNewButton);

		Box verticalBox = Box.createVerticalBox();
		verticalBox.setBounds(74, 21, 1, 1);
		contentPane.add(verticalBox);
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{dtInicial, dtFinal, btnCadastrar, lblDataFinalDa, lblSeguradora, lblNmero, lblTipoBenefcio, lblNomeCliente, lblStatusApolice, lblDataInicialDa, lblCadastroDeAplices, panel_1, lblFormatoData, lblCamposMarcadosCom, lblApolicePrincipal, panel, isSub, cbSeguradora, cbTipoBeneficio, cbStatusApolice, cbApolicePrincipal, btnNewButton, numero, nomeCliente}));
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{contentPane, isSub, lblTipoBenefcio, panel, cbSeguradora, cbTipoBeneficio, lblSeguradora, numero, lblNmero, nomeCliente, lblNomeCliente, cbStatusApolice, lblStatusApolice, lblDataInicialDa, dtInicial, dtFinal, lblDataFinalDa, panel_1, lblFormatoData, lblCamposMarcadosCom, cbApolicePrincipal, lblApolicePrincipal, btnCadastrar, btnNewButton, lblCadastroDeAplices}));

	}
}
