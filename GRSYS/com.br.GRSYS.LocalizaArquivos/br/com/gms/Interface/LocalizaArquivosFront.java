package br.com.gms.Interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.gms.Arquivos.Arquivos;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Toolkit;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Color;
import java.net.URI;

public class LocalizaArquivosFront extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField local;
	private String arquivoBase;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LocalizaArquivosFront frame = new LocalizaArquivosFront();
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
	public LocalizaArquivosFront() {
		setResizable(false);
		setBackground(SystemColor.desktop);
		setIconImage(Toolkit.getDefaultToolkit().getImage(LocalizaArquivosFront.class.getResource("/br/com/gms/Interface/logo-header.png")));
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setTitle("Busca Arquivos - Lockton");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 545, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.desktop);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLocalFonte = new JLabel("LOCAL FONTE");
		lblLocalFonte.setForeground(Color.WHITE);
		lblLocalFonte.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblLocalFonte.setHorizontalAlignment(SwingConstants.CENTER);
		lblLocalFonte.setBounds(181, 8, 144, 21);
		contentPane.add(lblLocalFonte);
		
		JButton btnExecutar = new JButton("Start");
		btnExecutar.setBackground(Color.WHITE);
		btnExecutar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				File vLocal = new File(local.getText()+"//"+arquivoBase.toString());
				
				
					URI.create(local.getText());
					//if(vLocal.isFile()){
						Arquivos.localizaEmove(local.getText(),Arquivos.importaListaDeArquivos(local.getText(),vLocal.getPath()));
					//}else{
						JOptionPane.showMessageDialog(null,"Arquivo base não localizado");
					//}
					
			}
		});
		btnExecutar.setBounds(186, 194, 149, 23);
		contentPane.add(btnExecutar);
		
		local = new JTextField();
		local.setBackground(SystemColor.text);
		local.setBounds(55, 40, 414, 20);
		contentPane.add(local);
		local.setColumns(10);
		
		JLabel lblLocktonBrasilConsultoria = new JLabel("Lockton Brasil Consultoria e Corretora de Seguros");
		lblLocktonBrasilConsultoria.setForeground(SystemColor.inactiveCaptionBorder);
		lblLocktonBrasilConsultoria.setBounds(104, 239, 314, 21);
		contentPane.add(lblLocktonBrasilConsultoria);
		
		JButton btnListaDeArquivos = new JButton("Lista de Arquivos");
		btnListaDeArquivos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				FileChoose f = new FileChoose(); /// criando instancia do chooser
				
				FileChoose.main(null); // iniciando buscador
				
				arquivoBase = f.getLocalChoose();
				
			}
		});
		btnListaDeArquivos.setBounds(181, 104, 144, 25);
		contentPane.add(btnListaDeArquivos);
		
		JTextPane ArquivoBase = new JTextPane();
		ArquivoBase.setBackground(SystemColor.activeCaption);
		ArquivoBase.setBounds(55, 150, 408, 23);
		contentPane.add(ArquivoBase);
		
		
	}
}
