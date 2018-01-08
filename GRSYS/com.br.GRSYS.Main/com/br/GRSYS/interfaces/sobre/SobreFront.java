package com.br.GRSYS.interfaces.sobre;

import java.awt.BorderLayout;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Toolkit;

public class SobreFront extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SobreFront dialog = new SobreFront();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SobreFront() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("R:\\GERENCIAMENTO INFORMACOES\\GESTAO_RISCO\\GUILHERME_SIQUEIRA\\GEST\u00C3O DE RISCO\\Desenvolvimento\\JavaWorkspace\\AutoNomeia\\Icon\\logo-header.png"));
		setResizable(false);
		setTitle("GRSYS - Sobre");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JTextPane textPane = new JTextPane();
			textPane.setBounds(214, 10, 6, 20);
			contentPanel.add(textPane);
		}
		
		JTextPane txtpnOnTheOther = new JTextPane();
		txtpnOnTheOther.setEditable(false);
		txtpnOnTheOther.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtpnOnTheOther.setText("                                                    \r\n\r\n\r\nABOUT THE SYSTEM\r\n\r\n     Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam eget ligula eu lectus lobortis condimentum. Aliquam nonummy auctor massa. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Nulla at risus. Quisque purus magna, auctor et, sagittis ac, posuere eu, lectus. Nam mattis, felis ut adipiscing\r\n\r\n                                                                                                                      GMSDEV");
		txtpnOnTheOther.setBounds(10, 11, 434, 261);
		contentPanel.add(txtpnOnTheOther);
	}
}
