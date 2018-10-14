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
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import java.awt.TextArea;

public class Launcher {

	private JFrame frmMtgTool;
	private ArenaTournament match;
	private JTextField createGroupNameField;
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
		match = new ArenaTournament();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMtgTool = new JFrame();
		frmMtgTool.getContentPane().setBackground(Color.WHITE);
		frmMtgTool.getContentPane().setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		frmMtgTool.setJMenuBar(menuBar);

		frmMtgTool.setTitle("MTG Tool");
		frmMtgTool.setBackground(new Color(240, 240, 240));
		frmMtgTool.setBounds(450, 100, 450, 300);
		frmMtgTool.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenu gameMenu = new JMenu("Game");
		gameMenu.setHorizontalAlignment(SwingConstants.LEFT);
		menuBar.add(gameMenu);

		JMenuItem gameGroup = new JMenuItem("Group Management");
		gameGroup.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {			
				gameMenuGroupManagementAction();	
			}
		});
		gameMenu.add(gameGroup);

		JSeparator separator = new JSeparator();
		separator.setForeground(Color.DARK_GRAY);
		gameMenu.add(separator);

		JMenuItem gameClose = new JMenuItem("Close");
		gameClose.setHorizontalAlignment(SwingConstants.LEFT);
		gameClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				gameMenuCloseAction();
			}
		});
		gameMenu.add(gameClose);

		JMenu helpMenu = new JMenu("Help");
		menuBar.add(helpMenu);

		JMenuItem help_about = new JMenuItem("About");
		help_about.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				helpMenuAboutAction();
			}
		});
		helpMenu.add(help_about);
	}


	private void helpMenuAboutAction() {
		frmMtgTool.repaint();
		TextArea textArea = new TextArea();
		textArea.setBackground(Color.WHITE);
		textArea.setEditable(false);
		textArea.setText("This Magic The Gathering Tool is brought to you by Chris.\r\n\r\nMagic: The Gathering is both a trading card and digital collectible card game created by Richard Garfield. Released in 1993 by Wizards of the Coast, \r\nMagic was the first trading card game created and it continues to thrive,\r\nwith approximately twenty million players as of 2015,\r\n and over twenty billion Magic cards produced in the period of 2008 to 2016 alone.\r\n\r\nMagic can be played by two or more players in various formats, \r\nwhich fall into two categories: constructed and limited. \r\nLimited formats involve players building a deck spontaneously out of a pool of random cards with a minimum deck size of 40 cards.\r\nIn constructed, players create decks from cards they own, \r\nusually 60 cards with no more than 4 of any given card. \r\nMagic is played in person with printed cards, or using a deck of virtual cards through the Internet-based Magic: \r\nThe Gathering Online, or on a smartphone or tablet, \r\nor through other programs.\r\n\r\nEach game represents a battle between wizards known as \"planeswalkers\", \r\nwho employ spells, artifacts, and creatures depicted on individual \r\nMagic cards to defeat their opponents. Although the original concept of the game drew heavily from the motifs of traditional fantasy role-playing games such as \r\nDungeons & Dragons, the gameplay of Magic bears little similarity to pencil-and-paper adventure games, while having substantially more cards and more complex rules than many other card games.\r\n\r\nNew cards are released on a regular basis through expansion sets. \r\nAn organized tournament system played at an international level and a worldwide community of professional \r\nMagic players has developed, as well as a substantial secondary market for Magic cards.\r\nCertain Magic cards can be valuable due to their rarity and utility in game play, \r\nwith prices ranging from a few cents to thousands of dollars.\r\n\r\ngreetings Chris.");
		textArea.setBounds(33, 20, 380, 192);
		frmMtgTool.getContentPane().add(textArea);
	}

	private void gameMenuGroupManagementAction() {
		frmMtgTool.repaint();
		
		JTextArea groupCreateExplainText = new JTextArea();
		groupCreateExplainText.setBounds(10, 11, 354, 52);
		frmMtgTool.getContentPane().add(groupCreateExplainText);
		groupCreateExplainText.setFont(new Font("Monospaced", Font.PLAIN, 11));
		groupCreateExplainText.setText("Here you can create a new group.\r\nThe group should have a name.\r\nThe name can not have spaces and should be 1 word.");
		groupCreateExplainText.setEditable(false);

		JLabel groupNameLabel = new JLabel("Group Name:");
		groupNameLabel.setBounds(10, 103, 77, 16);
		frmMtgTool.getContentPane().add(groupNameLabel);
		groupNameLabel.setFont(new Font("Monospaced", Font.PLAIN, 11));

		JButton createGroupButton = new JButton("Create Group");
		createGroupButton.setBounds(279, 125, 120, 23);
		frmMtgTool.getContentPane().add(createGroupButton);

		createGroupNameField = new JTextField();
		createGroupNameField.setBounds(10, 125, 250, 20);
		frmMtgTool.getContentPane().add(createGroupNameField);
		createGroupNameField.setBackground(Color.LIGHT_GRAY);
		createGroupNameField.setColumns(10);
		createGroupButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				createGroupActionButton();
			}
		});

	}

	private void createGroupActionButton() {
		String groupName = createGroupNameField.getText();
		match.addGroup(groupName);
		createGroupNameField.setText("");
		frmMtgTool.repaint();
	}

	private void gameMenuCloseAction() {
		System.exit(0);		
	}

	private void textPaneClear() {
		JTextPane textPane = new JTextPane();
		textPane.setBounds(10, 11, 414, 218);
		textPane.setEditable(false);
		textPane.setText("");
		frmMtgTool.getContentPane().add(textPane);
	}
}
