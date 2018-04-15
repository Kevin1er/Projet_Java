package interface_jee;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

	

	/**
	 * Create the frame.
	 */
	public LoggedIn() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 952, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Connecté");
		
		JTree tree = new JTree();
		tree.setEditable(true);
		tree.setBounds(0, 56, 134, 697);
		contentPane.add(tree);
		
		JPanel chat = new JPanel();
		chat.setBounds(770, 56, 164, 697);
		contentPane.add(chat);
		chat.setBackground(Color.WHITE);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 934, 57);
		contentPane.add(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmNewFile = new JMenuItem("New File");
		mnFile.add(mntmNewFile);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Open File");
		mnFile.add(mntmNewMenuItem);
		
		JMenuItem mntmLogout = new JMenuItem("Log out");
		mnFile.add(mntmLogout);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));
		textArea.setBounds(146, 56, 612, 697);
		contentPane.add(textArea);
		mntmLogout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Accueil acc = new Accueil();
				acc.setVisible(true);
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
					LoggedIn frame = new LoggedIn();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}