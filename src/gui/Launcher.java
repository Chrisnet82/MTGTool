package gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import core.ArenaTournament;
import exceptions.ArenaException;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import java.util.Iterator;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Launcher{
	private JFrame frmMtgTool;
	private ArenaTournament at;
	private JTextField AddPlayerField;
	private JTextArea textArea;
	private JTextField errorLabel;
	
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
		roundActionButton.setEnabled(false);
		roundActionButton.setFont(new Font("Calibri", Font.PLAIN, 11));
		roundActionButton.setBounds(252, 51, 133, 23);
		frmMtgTool.getContentPane().add(roundActionButton);

		JLabel errorInfo = new JLabel("Error Info Field:");
		errorInfo.setBounds(10, 11, 119, 22);
		frmMtgTool.getContentPane().add(errorInfo);

		JButton playerActionButton = new JButton("Add Player");
		playerActionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				errorLabel.setText("");
				if(at.getAllPlayers() == null) {
					roundActionButton.setEnabled(false);
				}else {
					roundActionButton.setEnabled(true);
				}
				try {
				addPlayerActionButton();
				}catch(ArenaException exception) {
					errorLabel.setText(exception.getMessage());
				}
			}
		});
		playerActionButton.setFont(new Font("Calibri", Font.PLAIN, 11));
		playerActionButton.setBounds(153, 50, 89, 23);
		frmMtgTool.getContentPane().add(playerActionButton);

		JButton clearPlayerList = new JButton("Clear List");
		clearPlayerList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				errorLabel.setText("");
				roundActionButton.setEnabled(false);
				clearListActionButton();				
			}
		});
		clearPlayerList.setFont(new Font("Calibri", Font.PLAIN, 11));
		clearPlayerList.setBounds(153, 111, 89, 23);
		frmMtgTool.getContentPane().add(clearPlayerList);
		
		errorLabel = new JTextField();
		errorLabel.setBackground(Color.WHITE);
		errorLabel.setFont(new Font("Calibri", Font.PLAIN, 11));
		errorLabel.setEditable(false);
		errorLabel.setBounds(156, 12, 623, 20);
		frmMtgTool.getContentPane().add(errorLabel);
		errorLabel.setColumns(10);

		frmMtgTool.setTitle("MTG Tool");
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
			frmMtgTool.getContentPane().add(textArea);
		}
		return textArea;
	}

	private void clearListActionButton() {
		at.removeAllPlayers();
		printPlayerList();
	}

	private void addPlayerActionButton() throws ArenaException {
		String playerName = AddPlayerField.getText();
		at.addPlayer(playerName);
		printPlayerList();
		AddPlayerField.setText("");
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