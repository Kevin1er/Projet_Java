package interface_jee;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;

public class NewFolder extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JButton btnCrer;
	
	
	/**
	 * Create the frame.
	 */
	public NewFolder(LoggedIn log) {
		setTitle("Nouveau dossier");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 300, 400, 392);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNomDuFichier = new JLabel("Nom du dossier :");
		lblNomDuFichier.setBounds(51, 137, 152, 38);
		contentPane.add(lblNomDuFichier);
		
		textField = new JTextField();
		textField.setBounds(170, 137, 152, 38);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(121, 282, 152, 38);
		contentPane.add(btnAnnuler);
		btnAnnuler.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		
		btnCrer = new JButton("Cr\u00E9er");
		btnCrer.setBounds(121, 206, 152, 38);
		contentPane.add(btnCrer);
		btnCrer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(textField.getText());
				
				log.root.add(new DefaultMutableTreeNode(textField.getText()));
				
				
				NewFile f = new NewFile();
				//f.setVisible(true);
				setVisible(false);
				
			}
		});
		
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
