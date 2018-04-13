package interface_jee;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class Accueil extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Accueil frame = new Accueil();
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
	public Accueil() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 636, 436);
		this.setTitle("Accueil");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnConnexion = new JButton("Connexion");
		btnConnexion.setBounds(231, 234, 146, 38);
		contentPane.add(btnConnexion);
		btnConnexion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				LoggedIn log = new LoggedIn();
				log.setVisible(true);
			}
		});
		
		JButton btnCreerUnCompte = new JButton("Creer un compte");
		btnCreerUnCompte.setBounds(231, 304, 146, 38);
		contentPane.add(btnCreerUnCompte);
		btnCreerUnCompte.addActionListener(new ActionListener()
				{
				
					@Override
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						Inscription ins = new Inscription();
						ins.setVisible(true);
						
					}
				});
		
		textField = new JTextField();
		textField.setBounds(77, 136, 152, 38);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(411, 136, 152, 38);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblPseudo = new JLabel("Pseudo : ");
		lblPseudo.setBounds(12, 136, 100, 38);
		contentPane.add(lblPseudo);
		
		JLabel lblPassword = new JLabel("Password : ");
		lblPassword.setBounds(328, 136, 100, 38);
		contentPane.add(lblPassword);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(256, 45, 56, 16);
		contentPane.add(lblNewLabel);
		
		
		
	
	}
}
