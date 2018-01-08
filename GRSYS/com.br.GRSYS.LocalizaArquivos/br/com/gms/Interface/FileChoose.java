package br.com.gms.Interface;

import java.awt.BorderLayout;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JFileChooser;
import java.awt.CardLayout;

public class FileChoose extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	
	private String localChoose;
	private final JFileChooser fileChooser = new JFileChooser();
	
	public static void main(String[] args) {
		try {
			FileChoose dialog = new FileChoose();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FileChoose() {
		setResizable(false);
		setBounds(100, 100, 708, 444);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new CardLayout(0, 0));
		fileChooser.setControlButtonsAreShown(false);
		fileChooser.setDialogTitle("ASDASd");
		contentPanel.add(fileChooser, "name_1718573900198684");
	}

	public String getLocalChoose() {
		return localChoose;
	}

	public void setLocalChoose(String localChoose) {
		this.localChoose = localChoose;
	}

}
