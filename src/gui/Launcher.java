package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import core.ArenaTournament;

import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JTextField;
import java.awt.Color;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import java.awt.TextArea;

public class Launcher {

	private JFrame frmMtgTool;
	private ArenaTournament at;
	private JTextField createGroupNameField;
	private JTextField AddPlayerField;
	private JTextField listPlayer;
	private JTextField listPlayer2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Launcher window = new Launcher();
					window.frmMtgTool.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Launcher() {
		at = new ArenaTournament();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMtgTool = new JFrame();
		frmMtgTool.getContentPane().setBackground(Color.WHITE);
		frmMtgTool.getContentPane().setLayout(null);

		JButton addPlayerButton = new JButton("Add Player");
		addPlayerButton.setEnabled(true);
		addPlayerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addPlayerActionButton();
			}
		});
		addPlayerButton.setBounds(210, 49, 119, 23);
		frmMtgTool.getContentPane().add(addPlayerButton);

		AddPlayerField = new JTextField();
		AddPlayerField.setBounds(10, 50, 179, 20);
		frmMtgTool.getContentPane().add(AddPlayerField);
		AddPlayerField.setColumns(10);

		JLabel lblPlayerList = new JLabel("Player List :");
		lblPlayerList.setBounds(10, 81, 73, 18);
		frmMtgTool.getContentPane().add(lblPlayerList);

		listPlayer = new JTextField();
		listPlayer.setEditable(false);
		listPlayer.setBounds(10, 110, 319, 124);
		frmMtgTool.getContentPane().add(listPlayer);
		listPlayer.setColumns(10);
		
		listPlayer2 = new JTextField();
		listPlayer2.setEditable(false);
		listPlayer2.setColumns(10);
		listPlayer2.setBounds(10, 245, 319, 124);
		frmMtgTool.getContentPane().add(listPlayer2);

		frmMtgTool.setTitle("MTG Tool");
		frmMtgTool.setBackground(new Color(240, 240, 240));
		frmMtgTool.setBounds(450, 100, 900, 600);
		frmMtgTool.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void addPlayerActionButton() {
		String playerName = AddPlayerField.getText();
		at.addPlayer(playerName);
		AddPlayerField.setText("");	
	    for(String s : at.getAllPlayers()){
	    	listPlayer2.setText(at.getAllPlayers().toString());
	    	listPlayer.setText(s);
	    }
	}
}
