package interface_jee;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class NewFile extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Create the frame.
	 */
	public NewFile() {
		setTitle("Nouveau fichier");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 300, 400, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNomDuFichier = new JLabel("Nom du fichier :");
		lblNomDuFichier.setBounds(51, 137, 152, 38);
		contentPane.add(lblNomDuFichier);
		
		textField = new JTextField();
		textField.setBounds(170, 137, 152, 38);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnCrer = new JButton("Cr\u00E9er");
		btnCrer.setBounds(121, 206, 152, 38);
		contentPane.add(btnCrer);
		btnCrer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(121, 287, 152, 38);
		contentPane.add(btnAnnuler);
		btnAnnuler.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
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
					NewFile frame = new NewFile();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}	
}