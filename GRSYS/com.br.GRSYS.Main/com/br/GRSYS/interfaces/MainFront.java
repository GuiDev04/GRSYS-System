package com.br.GRSYS.interfaces;

import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import com.br.GRSY.Folders.GerarPastas;
import com.br.GRSYS.Apolice.Front.ApoliceFront;
import com.br.GRSYS.Arquivo.front.ArquivoFront;
import com.br.GRSYS.ArquivoApolice.Interface.ArquivoApoliceFront;
import com.br.GRSYS.AutoNomeia.Interface.AutoNomeiaFront;
import com.br.GRSYS.Beneficio.front.BeneficioFront;
import com.br.GRSYS.Seguradora.front.SeguradoraFront;
import com.br.GRSYS.Selecao.configuracoes.ConfigSelecao;
import com.br.GRSYS.Selecao.configuracoes.ConfigSelecaoFront;
import com.br.GRSYS.Seleção.Selecao;
import com.br.GRSYS.interfaces.sobre.SobreFront;

public class MainFront extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField baixaStatus;
	private JTextField selecaoStatus;
	private JTextField importacaoStatus;
	private JTextField finalizacaoStatus;
	static boolean atualize = true;
	static boolean start = true;
	
	public static void main(String[] args) {
		ConfigSelecao.getInstance().LoadSelecaoConfig();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GerarPastas.gerar();
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
					MainFront frame = new MainFront();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}



	public MainFront() {



		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainFront.class.getResource("/br/com/gms/Interface/logo-header.png")));
		setTitle("GRSYS - Trainer (Gest\u00E3o de Risco)");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 915, 538);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setForeground(UIManager.getColor("InternalFrame.activeTitleGradient"));
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(6, 115, 211, 388);
		contentPane.add(panel);

		JLabel label = new JLabel("1.0");
		label.setForeground(Color.WHITE);
		label.setLabelFor(panel);
		panel.setLayout(null);

		JLabel lblAuxiliares = new JLabel("Modulos");
		lblAuxiliares.setHorizontalAlignment(SwingConstants.CENTER);
		lblAuxiliares.setBounds(71, 0, 68, 22);
		lblAuxiliares.setForeground(Color.BLACK);
		panel.add(lblAuxiliares);
		lblAuxiliares.setFont(new Font("Arial Black", Font.PLAIN, 15));

		JButton btnNewButton_2 = new JButton("AutoNomeia");
		btnNewButton_2.setEnabled(false);
		btnNewButton_2.setBounds(41, 24, 125, 23);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				AutoNomeiaFront.main(null);
			}
		});
		panel.add(btnNewButton_2);

		JPanel panel_10 = new JPanel();
		panel_10.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_10.setBackground(Color.WHITE);
		panel_10.setBounds(0, 59, 211, 329);
		panel.add(panel_10);

		JButton btnSeguradoras = new JButton("Seguradoras");
		btnSeguradoras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				SeguradoraFront.main(null);

			}
		});
		SpringLayout sl_panel_10 = new SpringLayout();
		sl_panel_10.putConstraint(SpringLayout.NORTH, btnSeguradoras, 28, SpringLayout.NORTH, panel_10);
		sl_panel_10.putConstraint(SpringLayout.WEST, btnSeguradoras, 43, SpringLayout.WEST, panel_10);
		sl_panel_10.putConstraint(SpringLayout.SOUTH, btnSeguradoras, 51, SpringLayout.NORTH, panel_10);
		sl_panel_10.putConstraint(SpringLayout.EAST, btnSeguradoras, 167, SpringLayout.WEST, panel_10);
		panel_10.setLayout(sl_panel_10);
		panel_10.add(btnSeguradoras);

		JLabel lblConfigurao = new JLabel("Configura\u00E7\u00F5es");
		sl_panel_10.putConstraint(SpringLayout.NORTH, lblConfigurao, 0, SpringLayout.NORTH, panel_10);
		sl_panel_10.putConstraint(SpringLayout.WEST, lblConfigurao, 52, SpringLayout.WEST, panel_10);
		sl_panel_10.putConstraint(SpringLayout.SOUTH, lblConfigurao, 22, SpringLayout.NORTH, panel_10);
		sl_panel_10.putConstraint(SpringLayout.EAST, lblConfigurao, 158, SpringLayout.WEST, panel_10);
		lblConfigurao.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfigurao.setForeground(Color.BLACK);
		lblConfigurao.setFont(new Font("Arial Black", Font.PLAIN, 12));
		panel_10.add(lblConfigurao);

		JButton btnNewButton_4 = new JButton("Ap\u00F3lices");
		sl_panel_10.putConstraint(SpringLayout.NORTH, btnNewButton_4, 51, SpringLayout.NORTH, panel_10);
		sl_panel_10.putConstraint(SpringLayout.WEST, btnNewButton_4, 43, SpringLayout.WEST, panel_10);
		sl_panel_10.putConstraint(SpringLayout.SOUTH, btnNewButton_4, 74, SpringLayout.NORTH, panel_10);
		sl_panel_10.putConstraint(SpringLayout.EAST, btnNewButton_4, 167, SpringLayout.WEST, panel_10);
		panel_10.add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("Tipo Beneficio");
		sl_panel_10.putConstraint(SpringLayout.NORTH, btnNewButton_5, 74, SpringLayout.NORTH, panel_10);
		sl_panel_10.putConstraint(SpringLayout.WEST, btnNewButton_5, 43, SpringLayout.WEST, panel_10);
		sl_panel_10.putConstraint(SpringLayout.SOUTH, btnNewButton_5, 97, SpringLayout.NORTH, panel_10);
		sl_panel_10.putConstraint(SpringLayout.EAST, btnNewButton_5, 167, SpringLayout.WEST, panel_10);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BeneficioFront.main(null);
			}
		});
		panel_10.add(btnNewButton_5);

		JButton btnNewButton_6 = new JButton("Status Apolice");
		sl_panel_10.putConstraint(SpringLayout.NORTH, btnNewButton_6, 99, SpringLayout.NORTH, panel_10);
		sl_panel_10.putConstraint(SpringLayout.WEST, btnNewButton_6, 43, SpringLayout.WEST, panel_10);
		sl_panel_10.putConstraint(SpringLayout.SOUTH, btnNewButton_6, 122, SpringLayout.NORTH, panel_10);
		sl_panel_10.putConstraint(SpringLayout.EAST, btnNewButton_6, 167, SpringLayout.WEST, panel_10);
		
		panel_10.add(btnNewButton_6);

		JButton btnNewButton_7 = new JButton("Cad. Apolice");
		sl_panel_10.putConstraint(SpringLayout.NORTH, btnNewButton_7, 124, SpringLayout.NORTH, panel_10);
		sl_panel_10.putConstraint(SpringLayout.WEST, btnNewButton_7, 43, SpringLayout.WEST, panel_10);
		sl_panel_10.putConstraint(SpringLayout.SOUTH, btnNewButton_7, 147, SpringLayout.NORTH, panel_10);
		sl_panel_10.putConstraint(SpringLayout.EAST, btnNewButton_7, 167, SpringLayout.WEST, panel_10);
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ApoliceFront.start();

			}
		});
		panel_10.add(btnNewButton_7);

		JButton btnNewButton_3 = new JButton("Sobre");
		sl_panel_10.putConstraint(SpringLayout.NORTH, btnNewButton_3, 300, SpringLayout.NORTH, panel_10);
		sl_panel_10.putConstraint(SpringLayout.WEST, btnNewButton_3, 43, SpringLayout.WEST, panel_10);
		sl_panel_10.putConstraint(SpringLayout.SOUTH, btnNewButton_3, 323, SpringLayout.NORTH, panel_10);
		sl_panel_10.putConstraint(SpringLayout.EAST, btnNewButton_3, 167, SpringLayout.WEST, panel_10);
		panel_10.add(btnNewButton_3);

		JButton btnVincularArquivo = new JButton("Vincular Arquivo");
		sl_panel_10.putConstraint(SpringLayout.NORTH, btnVincularArquivo, 148, SpringLayout.NORTH, panel_10);
		sl_panel_10.putConstraint(SpringLayout.WEST, btnVincularArquivo, 43, SpringLayout.WEST, panel_10);
		sl_panel_10.putConstraint(SpringLayout.SOUTH, btnVincularArquivo, 171, SpringLayout.NORTH, panel_10);
		sl_panel_10.putConstraint(SpringLayout.EAST, btnVincularArquivo, 167, SpringLayout.WEST, panel_10);
		btnVincularArquivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArquivoApoliceFront.start();;
			}
		});
		panel_10.add(btnVincularArquivo);

		JButton btnCriarArquivo = new JButton("Criar Arquivo");
		sl_panel_10.putConstraint(SpringLayout.NORTH, btnCriarArquivo, 170, SpringLayout.NORTH, panel_10);
		sl_panel_10.putConstraint(SpringLayout.WEST, btnCriarArquivo, 43, SpringLayout.WEST, panel_10);
		sl_panel_10.putConstraint(SpringLayout.SOUTH, btnCriarArquivo, 193, SpringLayout.NORTH, panel_10);
		sl_panel_10.putConstraint(SpringLayout.EAST, btnCriarArquivo, 167, SpringLayout.WEST, panel_10);
		btnCriarArquivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ArquivoFront.start();;

			}
		});
		panel_10.add(btnCriarArquivo);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {



				SobreFront.main(null);



			}
		});
		label.setBounds(22, 528, 27, 14);
		contentPane.add(label);



		JLabel lblNewLabel = new JLabel("Lockton Brasil Corretora de Seguros - 2017");
		lblNewLabel.setLabelFor(this);
		lblNewLabel.setForeground(SystemColor.inactiveCaptionBorder);
		lblNewLabel.setBackground(new Color(240, 240, 240));
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 11));
		lblNewLabel.setBounds(514, 510, 266, 20);
		contentPane.add(lblNewLabel);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBounds(218, 6, 684, 497);
		contentPane.add(panel_3);
		panel_3.setLayout(null);

		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.WHITE);
		panel_7.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_7.setBounds(52, 6, 579, 27);
		panel_3.add(panel_7);

		JLabel lblStatus = new JLabel("Main DashBoard");
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		panel_7.add(lblStatus);
		lblStatus.setFont(new Font("Arial Black", Font.PLAIN, 11));

		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(255, 255, 255));
		panel_8.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_8.setBounds(22, 50, 640, 185);
		panel_3.add(panel_8);
		panel_8.setLayout(null);

		baixaStatus = new JTextField();
		baixaStatus.setText("INATIVO");
		baixaStatus.setHorizontalAlignment(SwingConstants.CENTER);
		baixaStatus.setEditable(false);
		baixaStatus.setBounds(32, 122, 109, 24);
		panel_8.add(baixaStatus);
		baixaStatus.setColumns(10);

		selecaoStatus = new JTextField();
		selecaoStatus.setText("INATIVO");
		selecaoStatus.setHorizontalAlignment(SwingConstants.CENTER);
		selecaoStatus.setEditable(false);
		selecaoStatus.setColumns(10);
		selecaoStatus.setBounds(183, 122, 109, 24);
		panel_8.add(selecaoStatus);

		importacaoStatus = new JTextField();
		importacaoStatus.setText("INATIVO");
		importacaoStatus.setHorizontalAlignment(SwingConstants.CENTER);
		importacaoStatus.setEditable(false);
		importacaoStatus.setColumns(10);
		importacaoStatus.setBounds(345, 122, 109, 24);
		panel_8.add(importacaoStatus);

		finalizacaoStatus = new JTextField();
		finalizacaoStatus.setText("INATIVO");
		finalizacaoStatus.setHorizontalAlignment(SwingConstants.CENTER);
		finalizacaoStatus.setEditable(false);
		finalizacaoStatus.setColumns(10);
		finalizacaoStatus.setBounds(499, 122, 109, 24);
		panel_8.add(finalizacaoStatus);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(32, 28, 109, 90);
		panel_8.add(panel_1);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBackground(SystemColor.window);

		JLabel lblBaixaDeArquivos = new JLabel("Baixa de Arquivos");
		lblBaixaDeArquivos.setFont(new Font("Arial", Font.BOLD, 11));
		panel_1.add(lblBaixaDeArquivos);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_3);
		lblNewLabel_3.setIcon(new ImageIcon(MainFront.class.getResource("/br/com/gms/Interface/images.png")));

		JPanel panel_6 = new JPanel();
		panel_6.setBounds(499, 28, 109, 90);
		panel_8.add(panel_6);
		panel_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_6.setBackground(Color.WHITE);

		JLabel lblFinalizao = new JLabel("Finaliza\u00E7\u00E3o");
		lblFinalizao.setFont(new Font("Arial", Font.BOLD, 11));
		panel_6.add(lblFinalizao);

		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(MainFront.class.getResource("/br/com/gms/Interface/Conclusion_icon.png")));
		panel_6.add(lblNewLabel_5);

		JLabel label_4 = new JLabel("");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_6.add(label_4);

		JPanel panel_5 = new JPanel();
		panel_5.setBounds(345, 28, 109, 90);
		panel_8.add(panel_5);
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_5.setBackground(Color.WHITE);

		JLabel label_5 = new JLabel("");
		panel_5.add(label_5);

		JLabel lblImportao = new JLabel("Importa\u00E7\u00E3o");
		panel_5.add(lblImportao);
		lblImportao.setFont(new Font("Arial", Font.BOLD, 11));

		JLabel label_3 = new JLabel("");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_5.add(label_3);

		JLabel lblNewLabel_4 = new JLabel("");
		panel_5.add(lblNewLabel_4);
		lblNewLabel_4.setIcon(new ImageIcon(MainFront.class.getResource("/br/com/gms/Interface/sql-file-format-symbol_318-45406.jpg")));

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(183, 28, 109, 90);
		panel_8.add(panel_4);
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_4.setBackground(Color.WHITE);

		JLabel lblManipulao = new JLabel("Sele\u00E7\u00E3o");
		lblManipulao.setFont(new Font("Arial", Font.BOLD, 11));
		panel_4.add(lblManipulao);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(MainFront.class.getResource("/br/com/gms/Interface/download.png")));
		panel_4.add(label_1);

		JLabel label_2 = new JLabel("");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(label_2);

		JButton btnNewButton = new JButton("ATIVAR");
		btnNewButton.setBounds(42, 151, 90, 28);
		panel_8.add(btnNewButton);


		JLabel lblDetalhes = new JLabel("DETALHES:");
		lblDetalhes.setBounds(293, 222, 59, 14);
		panel_3.add(lblDetalhes);
		lblDetalhes.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDetalhes.setHorizontalAlignment(SwingConstants.LEFT);

		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(22, 467, 626, 19);
		panel_3.add(progressBar);





		JLabel lblGmsdev = new JLabel("GMS");
		lblGmsdev.setForeground(Color.WHITE);
		lblGmsdev.setBounds(1069, 528, 46, 14);
		contentPane.add(lblGmsdev);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(50, 21, 142, 79);
		contentPane.add(lblNewLabel_2);
		lblNewLabel_2.setIcon(new ImageIcon(MainFront.class.getResource("/br/com/gms/Interface/GRSYS-Icon.png")));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel label_7 = new JLabel("New label");
		label_7.setBounds(72, 33, 21, 8);
		contentPane.add(label_7);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{contentPane}));

		Button execucaoAutomatica = new Button("Executar");
		execucaoAutomatica.setActionCommand(" Execu\u00E7\u00E3o Automatica");
		execucaoAutomatica.setEnabled(false);
		execucaoAutomatica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {



			}
		});
		execucaoAutomatica.setBounds(258, 432, 152, 35);
		panel_3.add(execucaoAutomatica);

		JRadioButton tipoExecucao = new JRadioButton("Execu\u00E7\u00E3o Automatica");
		tipoExecucao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {


				if(tipoExecucao.isSelected()){
					execucaoAutomatica.setEnabled(true);
				}else{
					execucaoAutomatica.setEnabled(false);
				}
			}
		});
		tipoExecucao.setBounds(35, 437, 155, 18);
		panel_3.add(tipoExecucao);





		JPanel panel_9 = new JPanel();
		panel_9.setBackground(Color.WHITE);
		panel_9.setBounds(22, 247, 190, 159);
		panel_3.add(panel_9);
		panel_9.setLayout(null);

		JLabel lblInformaes = new JLabel("Informa\u00E7\u00F5es de Execu\u00E7\u00E3o");
		lblInformaes.setBounds(32, 6, 148, 16);
		panel_9.add(lblInformaes);
		lblInformaes.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblInformaes.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel arquivosVerificados = new JLabel("Arquivos Verificados");
		arquivosVerificados.setBounds(18, 57, 111, 16);
		panel_9.add(arquivosVerificados);


		JLabel lblArquivosNaPasta = new JLabel("Arquivos na Pasta");
		lblArquivosNaPasta.setBounds(18, 34, 99, 16);
		panel_9.add(lblArquivosNaPasta);

		JLabel localizaos = new JLabel("Localizados");
		localizaos.setBounds(18, 81, 66, 16);
		panel_9.add(localizaos);

		JLabel qtdArquivosPasta = new JLabel("0");
		qtdArquivosPasta.setHorizontalAlignment(SwingConstants.CENTER);
		qtdArquivosPasta.setBounds(141, 34, 66, 16);
		panel_9.add(qtdArquivosPasta);

		JLabel qtdArquivosVerificados = new JLabel("0");
		qtdArquivosVerificados.setHorizontalAlignment(SwingConstants.CENTER);
		qtdArquivosVerificados.setBounds(141, 57, 66, 16);
		panel_9.add(qtdArquivosVerificados);

		JLabel qtdLocalizados = new JLabel("0");
		qtdLocalizados.setHorizontalAlignment(SwingConstants.CENTER);
		qtdLocalizados.setBounds(141, 81, 66, 16);
		panel_9.add(qtdLocalizados);


		JButton btnAtivar = new JButton("ATIVAR");
		btnAtivar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Selecao s = new Selecao();

				//------  (Faz enquanto) -----


				// Thread de busca

				Runnable selecao = new Runnable(){

					public void run(){
						int t = 1;
						try {
							while(MainFront.start){

								Thread.sleep(1 * 1000);
								selecaoStatus.setText("STAND BY :"+(++t));
								System.out.println(t);
								if(t>=ConfigSelecao.getDalayTime()){
									selecaoStatus.setText("INICIANDO");

									// Inicia atualiza

									btnAtivar.setEnabled(false); // enquanto atianvando br ativar e false
									selecaoStatus.setText("EXECUTANDO"); 
									s.seleciona(); // Inicia selecao
									// finaliza atualização automatica
									MainFront.atualize=false;

									btnAtivar.setEnabled(true); 
									selecaoStatus.setText("STAND BY");
									t=0;
								}
							}
							selecaoStatus.setText("INATIVO");
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

				};



				// Inicia Threadsif
				if(selecaoStatus.getText().equals("INATIVO")){
					Thread tSelecao = new Thread(selecao);
					tSelecao.start();
					MainFront.start=true;
					btnAtivar.setText("Desativar");
				}else{

					MainFront.start=false;
					btnAtivar.setText("Ativar");

				}
			}
		});
		btnAtivar.setBounds(193, 151, 90, 28);
		panel_8.add(btnAtivar);

		JButton btnAtivar_1 = new JButton("ATIVAR");
		btnAtivar_1.setBounds(355, 151, 90, 28);
		panel_8.add(btnAtivar_1);

		JButton btnAtivar_2 = new JButton("ATIVAR");
		btnAtivar_2.setBounds(509, 151, 90, 28);
		panel_8.add(btnAtivar_2);

		JButton btnConfig = new JButton("Config");
		btnConfig.setBounds(591, 427, 64, 28);
		panel_3.add(btnConfig);
		btnConfig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ConfigSelecaoFront.start();
				
			}
		});
		sl_panel_10.putConstraint(SpringLayout.SOUTH, btnConfig, -8, SpringLayout.NORTH, btnNewButton_3);
		sl_panel_10.putConstraint(SpringLayout.EAST, btnConfig, -71, SpringLayout.EAST, panel_10);


	};


}
