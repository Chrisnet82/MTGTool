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
		scrollPane.setBounds(347, 60, 176, 362);
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
		
		JPanel panelSchedule = new JPanel();
		tabbedPane.addTab("               Schedule               ", null, panelSchedule, null);
		tabbedPane.setTabComponentAt(1, panelSchedule);
		UIManager.getLookAndFeelDefaults().put("TabbedPane:TabbedPaneTab.contentMargins", new Insets(10, 100, 0, 0));
	}
}
