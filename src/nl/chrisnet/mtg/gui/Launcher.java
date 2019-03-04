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
import java.util.Iterator;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextPane;
import javax.swing.border.EtchedBorder;
import java.awt.Cursor;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Launcher{
	private JFrame frmMtgTool;
	private ArenaTournament at;
	private JTextField AddPlayerField;
	private JTextArea textArea;
	private JTextPane errorLabel;
	private JTextArea RoundGeneratedField;
	private JTextField amountPlayersTextField;
	private JTable tablePoints;
	private JTable tableMatches;

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
		frmMtgTool.getContentPane().setForeground(Color.RED);
		frmMtgTool.getContentPane().setBackground(Color.WHITE);
		frmMtgTool.getContentPane().setLayout(null);

		AddPlayerField = new JTextField();
		AddPlayerField.setBounds(10, 50, 133, 22);
		frmMtgTool.getContentPane().add(AddPlayerField);
		AddPlayerField.setColumns(10);

		JLabel lblPlayerList = new JLabel("Player List :");
		lblPlayerList.setBounds(10, 81, 73, 18);
		frmMtgTool.getContentPane().add(lblPlayerList);

		textArea = getTextArea();

		JButton roundActionButton = new JButton("Generate Rounds");
		roundActionButton.setBounds(252, 51, 133, 23);
		roundActionButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		roundActionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent c) {
				errorLabel.setText("");
				try {
					generateRoundsActionButton();
				} catch (ArenaException e) {
					JOptionPane.showMessageDialog(roundActionButton, e.getMessage());
					//errorLabel.setText(e.getMessage());
				}
			}
		});
		roundActionButton.setEnabled(false);
		roundActionButton.setFont(new Font("Calibri", Font.PLAIN, 11));
		frmMtgTool.getContentPane().add(roundActionButton);

		JButton playerActionButton = new JButton("Add Player");
		playerActionButton.setBounds(153, 50, 89, 23);
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
					//errorLabel.setText(exception.getMessage());
				}
			}
		});
		playerActionButton.setFont(new Font("Calibri", Font.PLAIN, 11));
		frmMtgTool.getContentPane().add(playerActionButton);

		JButton clearPlayerList = new JButton("Clear All");
		clearPlayerList.setBounds(153, 111, 89, 23);
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
		frmMtgTool.getContentPane().add(errorLabel);
		
				RoundGeneratedField = new JTextArea();
				RoundGeneratedField.setBounds(252, 102, 418, 351);
				frmMtgTool.getContentPane().add(RoundGeneratedField);
				RoundGeneratedField.setFont(new Font("Times New Roman", Font.PLAIN, 11));
				RoundGeneratedField.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				RoundGeneratedField.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.CYAN, null));
				RoundGeneratedField.setBackground(Color.WHITE);
				RoundGeneratedField.setEditable(false);
				RoundGeneratedField.setColumns(10);
		
		tablePoints = new JTable();
		tablePoints.setBounds(722, 100, 152, 350);
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
		tablePoints.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		
		tableMatches = new JTable();
		tableMatches.setRowSelectionAllowed(false);
		tableMatches.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Round#", "Player 1", "Player 2", "Score"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tableMatches.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		tableMatches.setBounds(252, 138, 417, 350);
		frmMtgTool.getContentPane().add(tableMatches);
		
		JLabel copyRightLabel = new JLabel("Made posible by Chrisnet.nl \u00A9 2019");
		copyRightLabel.setBounds(280, 528, 305, 22);
		copyRightLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		frmMtgTool.getContentPane().add(copyRightLabel);
		
		JLabel lblNewLabel = new JLabel("Total Players:");
		lblNewLabel.setBounds(10, 381, 81, 14);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		frmMtgTool.getContentPane().add(lblNewLabel);
		
		amountPlayersTextField = new JTextField();
		amountPlayersTextField.setBounds(84, 378, 59, 20);
		amountPlayersTextField.setText("0");
		amountPlayersTextField.setBackground(Color.WHITE);
		amountPlayersTextField.setBorder(null);
		amountPlayersTextField.setEditable(false);
		amountPlayersTextField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		frmMtgTool.getContentPane().add(amountPlayersTextField);
		amountPlayersTextField.setColumns(10);
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
			textArea.setBounds(10, 110, 133, 260);
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
		RoundGeneratedField.setText("");
		AddPlayerField.setText("");
		amountPlayersTextField.setText(at.amountOfPlayers()+"");
	}

	private void genTablePoints() {
		int x = at.amountOfPlayers();
		int selectedRowIndex = tablePoints.getSelectedRow();
		
		Object[][] data = new Object[x][x];
		DefaultTableModel model = (DefaultTableModel) tablePoints.getModel();
		
		for(int i=0;i<=x;i++) {
			String playerName = at.getAllPlayers().get(i);
			int playerPloints = at.getPlayerPoints(playerName);
			model.addRow(new Object[]{playerName, playerPloints+""});
		}
		model.addRow(data);
	}						
	
	private void generateRoundsActionButton() throws ArenaException {
		RoundGeneratedField.setText("");
		at.closeInscription();
		printSchedual();
		AddPlayerField.setText("");
		genTablePoints();
	}

	private void addPlayerActionButton() throws ArenaException {
		String playerName = AddPlayerField.getText();
		amountPlayersTextField.setText("");
		at.addPlayer(playerName);
		printPlayerList();
		AddPlayerField.setText("");
		amountPlayersTextField.setText(at.amountOfPlayers()+"");
	}

	private void printSchedual() {
		Iterator<String> it = at.getRounds().iterator();
		RoundGeneratedField.setText("");
		while(it.hasNext()){
			String element = it.next();
			RoundGeneratedField.append(element + "\n");
		}
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