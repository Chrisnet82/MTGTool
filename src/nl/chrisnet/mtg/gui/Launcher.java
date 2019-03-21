package nl.chrisnet.mtg.gui;

import java.awt.EventQueue;
import javax.swing.JFrame;

import nl.chrisnet.mtg.core.ArenaException;
import nl.chrisnet.mtg.core.ArenaTournament;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Component;
import java.util.Iterator;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.border.EtchedBorder;
import java.awt.Cursor;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import java.awt.Toolkit;

public class Launcher{
	private JTextArea roundGeneratedField;
	private JFrame frmMtgTool;
	private ArenaTournament at;
	private JTextField AddPlayerField;
	private JTextArea textArea;
	private JTextPane errorLabel;
	private JTextField amountPlayersTextField;
	private JTable tablePoints;
	private JTextField textFieldPoints;
	private JComboBox comboBoxPlayers;
	private JButton givePointButton;

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
		frmMtgTool.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\PKchr\\Pictures\\logo_favicon.png"));
		frmMtgTool.getContentPane().setFont(new Font("Calibri", Font.PLAIN, 11));
		frmMtgTool.getContentPane().setForeground(Color.RED);
		frmMtgTool.getContentPane().setBackground(Color.WHITE);
		frmMtgTool.getContentPane().setLayout(null);

		AddPlayerField = new JTextField();
		AddPlayerField.setFont(new Font("Calibri", Font.PLAIN, 12));
		AddPlayerField.setBounds(10, 50, 145, 22);
		frmMtgTool.getContentPane().add(AddPlayerField);
		AddPlayerField.setColumns(10);

		JLabel lblPlayerList = new JLabel("Player List :");
		lblPlayerList.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblPlayerList.setBounds(10, 81, 73, 18);
		frmMtgTool.getContentPane().add(lblPlayerList);

		textArea = getTextArea();

		JButton roundActionButton = new JButton("Start Tournament");
		roundActionButton.setToolTipText("If you start Tournament you cant enter players anymore.");
		roundActionButton.setBounds(10, 412, 145, 23);
		roundActionButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		roundActionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent c) {
				errorLabel.setText("");
				try {
					generateRoundsActionButton();
				} catch (ArenaException e) {
					JOptionPane.showMessageDialog(roundActionButton, e.getMessage());
				}
			}
		});
		roundActionButton.setEnabled(false);
		roundActionButton.setFont(new Font("Calibri", Font.PLAIN, 11));
		frmMtgTool.getContentPane().add(roundActionButton);

		JButton playerActionButton = new JButton("Add Player");
		playerActionButton.setBounds(165, 50, 89, 23);
		playerActionButton.setToolTipText("Fill in a Player name. You can not use spaces or add the same name.");
		playerActionButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		playerActionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				errorLabel.setText("");
				if(at.getAllPlayers().size() < 2) {
					roundActionButton.setEnabled(false);
				}else {
					roundActionButton.setEnabled(true);
				}
				try {
					addPlayerActionButton();
				}catch(ArenaException exception) {
					JOptionPane.showMessageDialog(playerActionButton, exception.getMessage());
				}
			}
		});
		playerActionButton.setFont(new Font("Calibri", Font.PLAIN, 11));
		frmMtgTool.getContentPane().add(playerActionButton);

		JButton clearPlayerList = new JButton("Reset Tournament");
		clearPlayerList.setBounds(10, 466, 145, 23);
		clearPlayerList.setToolTipText("Clear all players and restart tournament.");
		clearPlayerList.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		clearPlayerList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				errorLabel.setText("");
				roundActionButton.setEnabled(false);
				clearListActionButton();				
			}
		});
		clearPlayerList.setFont(new Font("Calibri", Font.PLAIN, 11));
		frmMtgTool.getContentPane().add(clearPlayerList);

		errorLabel = new JTextPane();
		errorLabel.setBounds(10, 12, 769, 20);
		errorLabel.setToolTipText("Error message box.");
		errorLabel.setForeground(Color.RED);
		errorLabel.setBackground(Color.WHITE);
		errorLabel.setFont(new Font("Calibri", Font.PLAIN, 11));
		errorLabel.setEditable(false);

		tablePoints = new JTable();
		tablePoints.setBounds(709, 110, 145, 260);
		frmMtgTool.getContentPane().add(tablePoints);
		tablePoints.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Player", "Points"
				}
				) {
			Class[] columnTypes = new Class[] {
					String.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tablePoints.setCellSelectionEnabled(true);
		tablePoints.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.CYAN, null));
		tablePoints.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		tablePoints.setFont(new Font("Times New Roman", Font.PLAIN, 12));

		JLabel copyRightLabel = new JLabel("Made posible by Chrisnet.nl \u00A9 2019");
		copyRightLabel.setBounds(280, 528, 193, 22);
		copyRightLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		frmMtgTool.getContentPane().add(copyRightLabel);

		JLabel lblNewLabel = new JLabel("Total Players:");
		lblNewLabel.setBounds(10, 381, 81, 14);
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 12));
		frmMtgTool.getContentPane().add(lblNewLabel);

		amountPlayersTextField = new JTextField();
		amountPlayersTextField.setBounds(96, 378, 47, 20);
		amountPlayersTextField.setText("0");
		amountPlayersTextField.setBackground(Color.WHITE);
		amountPlayersTextField.setBorder(null);
		amountPlayersTextField.setEditable(false);
		amountPlayersTextField.setFont(new Font("Calibri", Font.PLAIN, 12));
		frmMtgTool.getContentPane().add(amountPlayersTextField);
		amountPlayersTextField.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(265, 110, 418, 260);
		frmMtgTool.getContentPane().add(scrollPane);

		roundGeneratedField = new JTextArea();
		scrollPane.setViewportView(roundGeneratedField);
		roundGeneratedField.setFont(new Font("Verdana", Font.PLAIN, 12));
		roundGeneratedField.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		roundGeneratedField.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.CYAN, null));
		roundGeneratedField.setBackground(Color.WHITE);
		roundGeneratedField.setEditable(false);
		roundGeneratedField.setColumns(10);

		textFieldPoints = new JTextField();
		textFieldPoints.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.CYAN, null));
		textFieldPoints.setToolTipText("Set whole positive amount of Points");
		textFieldPoints.setFont(new Font("Times New Roman", Font.BOLD, 12));
		textFieldPoints.setBounds(482, 412, 86, 20);
		frmMtgTool.getContentPane().add(textFieldPoints);
		textFieldPoints.setColumns(10);

		givePointButton = new JButton("Save Points");
		givePointButton.setEnabled(false);
		givePointButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					try {
						addPointsButtonActions();
					} catch (ArenaException e) {
						JOptionPane.showMessageDialog(givePointButton, e.getMessage());
					}
			}
		});
		givePointButton.setFont(new Font("Calibri", Font.PLAIN, 11));
		givePointButton.setBounds(578, 412, 105, 23);
		frmMtgTool.getContentPane().add(givePointButton);

		JLabel lblTournamentSchedule = new JLabel("Tournament Schedule :");
		lblTournamentSchedule.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblTournamentSchedule.setBounds(264, 83, 138, 14);
		frmMtgTool.getContentPane().add(lblTournamentSchedule);

		JLabel lblPlayersScore = new JLabel("Players Score :");
		lblPlayersScore.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblPlayersScore.setBounds(709, 82, 81, 14);
		frmMtgTool.getContentPane().add(lblPlayersScore);

		comboBoxPlayers = new JComboBox();
		comboBoxPlayers.setBounds(264, 412, 209, 20);
		frmMtgTool.getContentPane().add(comboBoxPlayers);
		frmMtgTool.setTitle("Chrisnet - MTG Tool");
		frmMtgTool.setBackground(new Color(240, 240, 240));
		frmMtgTool.setBounds(450, 100, 900, 600);
		frmMtgTool.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * This method initializes TextArea
	 * 
	 * @return javax.swing.JTextArea
	 */
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
			textArea.setFont(new Font("Times New Roman", Font.PLAIN, 13));
			textArea.setBounds(10, 110, 145, 260);
			textArea.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			textArea.setEditable(false);
			textArea.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.CYAN, null));
			frmMtgTool.getContentPane().add(textArea);
		}
		return textArea;
	}

	private void clearListActionButton() {
		at.openInscription();
		printPlayerList();
		roundGeneratedField.setText("");
		AddPlayerField.setText("");
		amountPlayersTextField.setText(at.amountOfPlayers()+"");
		DefaultTableModel model = (DefaultTableModel) tablePoints.getModel();
		model.setRowCount(0);
		fillComboBoxPlayers();
		givePointButton.setEnabled(false);
	}

	private void genTablePoints() {
		DefaultTableModel model = (DefaultTableModel) tablePoints.getModel();
		model.setRowCount(0);

		for(int i=0;i<=at.amountOfPlayers()-1;i++) {
			String playerName = at.getAllPlayers().get(i);
			int playerPloints = at.getPlayerPoints(playerName);
			if(playerName != "Bye") {
				model.addRow(new Object[]{playerName, playerPloints+""});
			}
		}
	}				

	private void generateRoundsActionButton() throws ArenaException {
		roundGeneratedField.setText("");
		at.closeInscription();
		printSchedual();
		AddPlayerField.setText("");
		genTablePoints();
		fillComboBoxPlayers();
		givePointButton.setEnabled(true);
	}

	private void addPlayerActionButton() throws ArenaException {
		String playerName = AddPlayerField.getText();
		amountPlayersTextField.setText("");
		at.addPlayer(playerName);
		printPlayerList();
		AddPlayerField.setText("");
		amountPlayersTextField.setText(at.amountOfPlayers()+"");
	}

	private void fillComboBoxPlayers() {
		comboBoxPlayers.removeAllItems();
		for(String p : at.getAllPlayers()) {
			if(p != "Bye") {
				comboBoxPlayers.addItem(p);			
			}
		}
	}

	private void printSchedual() {
		for(int i=1;i<=at.getRounds().size();i++) {
			if(i==1) {
				roundGeneratedField.append("Round : " + i + "\n");
			}else {
				roundGeneratedField.append("\n" + "Round : " + i + "\n");
			}
			Iterator<String> it = at.getMatches(i).iterator();
			while(it.hasNext()){
				String element = it.next();
				roundGeneratedField.append(element + "\n");
			}
		}
	}

	private void addPointsButtonActions() throws ArenaException{
		String player = (String) comboBoxPlayers.getSelectedItem();
		String points = textFieldPoints.getText();
		at.setPointsToPlayer(player, points);
		textFieldPoints.setText("");
		genTablePoints();
	}

	private void printPlayerList() {
		Iterator<String> it = at.getAllPlayers().iterator();
		textArea.setText("");
		while(it.hasNext()){
			String element = it.next();
			textArea.append(element + "\n");
		}
	}
}