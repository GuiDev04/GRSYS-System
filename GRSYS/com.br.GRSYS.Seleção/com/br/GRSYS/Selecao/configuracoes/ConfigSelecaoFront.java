package com.br.GRSYS.Selecao.configuracoes;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class ConfigSelecaoFront extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField local;
	private JTextField delay;
	private static ConfigSelecaoFront front = null;

	/**
	 * Launch the application.
	 */
	public static void start(){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
					ConfigSelecaoFront frame = new ConfigSelecaoFront();
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
	public ConfigSelecaoFront() {
		
		front = this;
		
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ConfigSelecaoFront.class.getResource("/br/com/gms/Interface/logo-header.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 297, 323);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		local = new JTextField();
		local.setEnabled(false);
		local.setBounds(10, 182, 271, 23);
		contentPane.add(local);
		local.setColumns(10);
		
		JButton salvar = new JButton("Salvar");
		salvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//VERIFICAÇÕES PARA SALVAR
				
				//VERIFICANDO DELAY
				try{
					//TENTANDO CONVERTER DELAY
					int delayTime = Integer.parseInt(delay.getText());
					
					
					//VERIFICANDO LOCAL
					if(Files.isDirectory(Paths.get(local.getText()))){
						//SE O LOCAL E VALIDO
						
						ConfigSelecao.setDalayTime(delayTime);
						ConfigSelecao.setLocalExecution(local.getText());
						
						ConfigSelecao.getInstance().SaveConfigs();
						
						front.dispose();
						
						JOptionPane.showMessageDialog(null,"Configurações salvas com sucesso.");
						
					}else{
						JOptionPane.showMessageDialog(null,"O local de varredura selecionado não é valido.");
					}
				}catch(NumberFormatException e){
					JOptionPane.showMessageDialog(null,"Favor selecionar um delay valido");
				}
			}
		});
		salvar.setBackground(Color.WHITE);
		salvar.setBounds(192, 260, 89, 23);
		contentPane.add(salvar);
		
		JLabel lblLocalDaVarredura = new JLabel("Local da Varredura");
		lblLocalDaVarredura.setBounds(89, 165, 112, 16);
		contentPane.add(lblLocalDaVarredura);
		
		delay = new JTextField();
		delay.setEnabled(false);
		delay.setHorizontalAlignment(SwingConstants.CENTER);
		delay.setColumns(10);
		delay.setBounds(106, 119, 75, 23);
		contentPane.add(delay);
		
		JLabel lblDelayDeExecuo = new JLabel("Delay de Execu\u00E7\u00E3o em Segundos");
		lblDelayDeExecuo.setBounds(55, 92, 197, 16);
		contentPane.add(lblDelayDeExecuo);
		
		JLabel lblNewLabel = new JLabel("Configura\u00E7\u00F5es de Sele\u00E7\u00E3o");
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(36, 33, 210, 16);
		contentPane.add(lblNewLabel);
		
		//SETANDO VALORES DEFAULT
		ConfigSelecao.getInstance().LoadSelecaoConfig();
		local.setText(ConfigSelecao.getLocalExecution());
		delay.setText(Integer.toString(ConfigSelecao.getDalayTime()));
		JRadioButton editar = new JRadioButton("Editar");
		editar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				//
				if(editar.isSelected()){
					//QUER EDITAR
					
					//ATIVA CAIXAS DE TEXTO
					local.setEnabled(true);
					delay.setEnabled(true);
				}else{
					//NÃO QUER EDITAR
					
					//BLOQUEIA CAIXA DE TEXTO E 
					local.setEnabled(false);
					delay.setEnabled(false);
					
					//DEFINE PADRAO ANTERIOR
					local.setText(ConfigSelecao.getLocalExecution());
					delay.setText(Integer.toString(ConfigSelecao.getDalayTime()));
				}
				
			}
			
		});
		editar.setBounds(16, 262, 115, 18);
		contentPane.add(editar);
		
		
		
	}
	
	
}
