package nl.chrisnet.mtg.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.Insets;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.plaf.TabbedPaneUI;
import javax.swing.JLabel;
import java.awt.Dimension;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;

public class Launcher_v_1_2 {

	private JFrame frame;
	private JTextField AddPlayerField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Launcher_v_1_2 window = new Launcher_v_1_2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Launcher_v_1_2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.setBounds(0, 0, 584, 461);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panelPlayers = new JPanel();
		tabbedPane.addTab("               Players               ", null, panelPlayers, null);
		panelPlayers.setLayout(null);
		
		JButton playerAddButton = new JButton("Add Player");
		playerAddButton.setBounds(165, 62, 89, 23);
		panelPlayers.add(playerAddButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(347, 60, 176, 333);
		panelPlayers.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setEditable(false);
		
		JLabel labelInfoListPlayers = new JLabel("PlayerList :");
		labelInfoListPlayers.setBounds(347, 35, 99, 14);
		panelPlayers.add(labelInfoListPlayers);
		
		AddPlayerField = new JTextField();
		AddPlayerField.setFont(new Font("Calibri", Font.PLAIN, 12));
		AddPlayerField.setColumns(10);
		AddPlayerField.setBounds(10, 63, 145, 22);
		panelPlayers.add(AddPlayerField);
		
		JLabel amountPlayersLabel = new JLabel("Amount of Players :");
		amountPlayersLabel.setBounds(347, 404, 108, 14);
		panelPlayers.add(amountPlayersLabel);
		
		JLabel intPlayersLabel = new JLabel("0");
		intPlayersLabel.setBounds(451, 404, 46, 14);
		panelPlayers.add(intPlayersLabel);
		
		JTextArea txtrInThisTab = new JTextArea();
		txtrInThisTab.setBackground(SystemColor.control);
		txtrInThisTab.setFont(new Font("Monospaced", Font.PLAIN, 10));
		txtrInThisTab.setText("In this tab, you manage your players before \r\nstarting the tournament.\r\nType in a name of a player and use the \r\n\"Add Player\" button to add a player.\r\n\r\nA name must consist only out of \r\nletters or numbers. Name may not \r\nuse spaces or other special characters.\r\nIf succesfull added, the name wil appear\r\nin the playerlist on the right.\r\nIf you have enterd all the players,\r\nyou can start the tournament.\r\nAfther starting you cant add anymore players.\r\n\r\n\r\nThank you for using the ArenaTournament Tool.");
		txtrInThisTab.setEditable(false);
		txtrInThisTab.setBounds(10, 128, 304, 232);
		panelPlayers.add(txtrInThisTab);
		
		JLabel lblNewLabel = new JLabel("Made posible by Chrisnet.nl \u00A9 2019");
		lblNewLabel.setBounds(10, 404, 187, 14);
		panelPlayers.add(lblNewLabel);
		
		JPanel panelSchedule = new JPanel();
		tabbedPane.addTab("               Schedule               ", null, panelSchedule, null);
		tabbedPane.setTabComponentAt(1, panelSchedule);
		UIManager.getLookAndFeelDefaults().put("TabbedPane:TabbedPaneTab.contentMargins", new Insets(10, 100, 0, 0));
	}
}
