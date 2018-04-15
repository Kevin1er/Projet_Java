package interface_jee;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.sql.*;

public class Inscription extends JFrame {

	private JPanel contentPane;
	private JTextField field_pseudo;
	private JLabel lblNewLabel_1;
	private JTextField field_pwd;
	private JButton btnRetour;
	private JButton btnValider;

	/**
	 * Create the frame.
	 */
	public Inscription() {
		Connexion c = new Connexion();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 636, 495);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		this.setTitle("Inscription");
		contentPane.setLayout(null);
		
		field_pseudo = new JTextField();
		field_pseudo.setBounds(320, 131, 152, 38);
		contentPane.add(field_pseudo);
		field_pseudo.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Entrer un pseudo :");
		lblNewLabel.setBounds(77, 131, 152, 38);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Entrer un mot de passe :");
		lblNewLabel_1.setBounds(77, 241, 152, 38);
		contentPane.add(lblNewLabel_1);
		
		field_pwd = new JPasswordField();
		field_pwd.setBounds(320, 241, 152, 38);
		contentPane.add(field_pwd);
		field_pwd.setColumns(10);
		
		btnRetour = new JButton("Retour");
		btnRetour.setBounds(57, 350, 159, 38);
		contentPane.add(btnRetour);
		btnRetour.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				
			}
		});
		
		btnValider = new JButton("Valider");
		btnValider.setBounds(383, 350, 159, 38);
		contentPane.add(btnValider);
		
		btnValider.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (field_pseudo.getText().length()==0 && field_pwd.getText().length()==0){
						JOptionPane.showMessageDialog(null, "Entrer un pseudonyme et un mot de passe valides");
					}
					else if(field_pseudo.getText().length()==0 || field_pwd.getText().length()==0){
						JOptionPane.showMessageDialog(null, "Entrer un pseudonyme ET un mot de passe");
					}
					else if (field_pseudo.getText().length()>0 && field_pwd.getText().length()>0){
						c.register(field_pseudo.getText(), field_pwd.getText());
						setVisible(false);
						Accueil acc = new Accueil();
						acc.setVisible(true);
						c.c.close();
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
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
					Inscription frame = new Inscription();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}