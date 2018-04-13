package interface_jee;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Inscription extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblNewLabel_1;
	private JTextField textField_1;
	private JButton btnRetour;
	private JButton btnValider;

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

	/**
	 * Create the frame.
	 */
	public Inscription() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 636, 495);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		this.setTitle("Inscription");
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(320, 131, 152, 38);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Entrer un pseudo :");
		lblNewLabel.setBounds(77, 131, 152, 38);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Entrer un mot de passe :");
		lblNewLabel_1.setBounds(77, 241, 152, 38);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(320, 241, 152, 38);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		btnRetour = new JButton("Retour");
		btnRetour.setBounds(57, 350, 159, 38);
		contentPane.add(btnRetour);
		btnRetour.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Accueil acc = new Accueil();
				acc.setVisible(true);
			}
		});
		
		btnValider = new JButton("Valider");
		btnValider.setBounds(383, 350, 159, 38);
		contentPane.add(btnValider);
		
		btnValider.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				Accueil acc = new Accueil();
				acc.setVisible(true);
			}
			
			
		});
		
	}

}
