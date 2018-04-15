package interface_jee;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.sql.*;

public class Accueil extends JFrame {

	private JPanel contentPane;
	private JTextField field_pseudo;
	private JTextField field_pwd;
	
	
	/**
	 * Create the frame.
	 */
	public Accueil() {
		Connexion c = new Connexion();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 300, 636, 436);
		this.setTitle("Accueil");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));		
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		field_pseudo = new JTextField();
		field_pseudo.setBounds(77, 136, 152, 38);
		contentPane.add(field_pseudo);
		field_pseudo.setColumns(10);
		
		field_pwd = new JPasswordField();
		field_pwd.setBounds(411, 136, 152, 38);
		contentPane.add(field_pwd);
		field_pwd.setColumns(10);
		
		JButton btnConnexion = new JButton("Connexion");
		btnConnexion.setBounds(231, 234, 146, 38);
		contentPane.add(btnConnexion);
		btnConnexion.addActionListener(new ActionListener() 
		{	
			@Override
			public void actionPerformed(ActionEvent e) 
			{				
						try {
							if (field_pseudo.getText().length()==0 && field_pwd.getText().length()==0){
								JOptionPane.showMessageDialog(null, "Entrer un pseudonyme et un mot de passe valides");
							}
							else if(c.connect(field_pseudo.getText(), field_pwd.getText())){
								setVisible(false);
								LoggedIn log = new LoggedIn();
								log.setVisible(true);
								c.c.close();
							}
							else if(field_pseudo.getText().equals("") || field_pwd.getText().equals("")){
								JOptionPane.showMessageDialog(null, "Entrer un pseudonyme et un mot de passe valides");
							}
							else if (c.connect(field_pseudo.getText(), field_pwd.getText())==false){
								JOptionPane.showMessageDialog(null, "Pseudonyme et mot de passe invalides");
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
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
}