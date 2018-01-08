package com.br.GRSYS.AutoNomeia.Interface;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Paths;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import com.br.GRSYS.AutoNomeia.GerenciadorGeral.GerenciadorGeral;

@SuppressWarnings("serial")
public class AutoNomeiaFront extends JFrame {

	private JPanel contentPane;
	private JTextField local;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AutoNomeiaFront frame = new AutoNomeiaFront();
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
	public AutoNomeiaFront() {
		setType(Type.POPUP);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(AutoNomeiaFront.class.getResource("/br/com/gms/Interface/logo-header.png")));
		setTitle("GRSYS - AutoNomeia");
		setBounds(100, 100, 404, 226);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setForeground(Color.BLUE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton WebTran = new JButton("WebTran");
		WebTran.setBounds(150, 124, 98, 23);
		WebTran.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {


				if(local.getText().toString().isEmpty()){ // se nao colocarem link

					JOptionPane.showMessageDialog(null,"Favor inserir algum local !.");

				}else{

					File url = new File(local.getText()); // crio o local

					if(url.exists()){ // verifico se ele existir  e se existir
						
						GerenciadorGeral gg = new GerenciadorGeral(Paths.get(local.getText()));
						gg.start();

					}else{ // senao :
						JOptionPane.showMessageDialog(null,"O local informado não existe.");
						local.setText("");
					}

				}



			}
		});
		contentPane.add(WebTran);

		local = new JTextField();
		local.setToolTipText("Ssdasda");
		local.setBounds(23, 43, 345, 23);
		contentPane.add(local);
		local.setColumns(10);
		
		JLabel lblUrl = new JLabel("URL");
		lblUrl.setBounds(184, 22, 30, 23);
		contentPane.add(lblUrl);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{contentPane, WebTran, local}));
	}
}
