package interface_jee;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;
import javax.swing.JTree;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.sql.*;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Scrollbar;

public class LoggedIn extends JFrame {

	private JPanel contentPane;
	DefaultMutableTreeNode root;
	JTree tree;
	DefaultMutableTreeNode rootNode;
	DefaultTreeModel treeModel;
	JTextArea textArea2;
	
	/**
	 * Create the frame.
	 */
	public LoggedIn() {
		Connexion c = new Connexion();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 952, 714);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//contentPane.setLayout(null);
		TreePanel p = new TreePanel();
		p.setBounds(0, 65, 199, 602);
		getContentPane().add(p);
		setTitle("Connecté");
		
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.setBounds(795, 0, 139, 66);
		contentPane.add(btnLogOut);
		btnLogOut.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Accueil acc = new Accueil();
				acc.setVisible(true);
			}
		});		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));
		scrollPane.setBounds(187, 56, 571, 697);
		//contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Lucida Sans", Font.PLAIN, 20));
		scrollPane.setViewportView(textArea);
		
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));
		scrollPane2.setBounds(199, 65, 559, 602);
		contentPane.add(scrollPane2);
		
		textArea2 = new JTextArea();
		textArea2.setFont(new Font("Lucida Sans", Font.PLAIN, 20));
		scrollPane2.setViewportView(textArea2);
		
		JButton btnSaveFile = new JButton("Save File");
		btnSaveFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					c.saveFile("fichier1", textArea2.getText());
					c.c.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnSaveFile.setBounds(0, 0, 139, 66);
		contentPane.add(btnSaveFile);
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoggedIn frame = new LoggedIn();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}