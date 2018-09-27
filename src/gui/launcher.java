package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import org.eclipse.wb.swing.FocusTraversalOnArray;

import core.Match;

import java.awt.Component;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JPanel;
import java.awt.Label;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.event.ListDataListener;
import javax.swing.table.DefaultTableModel;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JToggleButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;

public class launcher {

	private JFrame frmMtgTool;
	private Match match;
	private JTextField addPlayerTextField;
	private JTextField infoField;
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					launcher window = new launcher();
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
	public launcher() {
		match = new Match();
		initialize();
	}

	private void isAddPlayerKnopAction(){
		String name = addPlayerTextField.getText();
		
		infoField.setText("Welcome player, " + name + " you have been added.");
		addPlayerTextField.setText("");
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMtgTool = new JFrame();
		frmMtgTool.setTitle("MTG Tool");
		frmMtgTool.setForeground(new Color(255, 255, 255));
		frmMtgTool.setBackground(new Color(240, 240, 240));
		frmMtgTool.setBounds(450, 100, 450, 300);
		frmMtgTool.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMtgTool.getContentPane().setLayout(null);

		infoField = new JTextField();
		infoField.setFont(new Font("Arial", Font.PLAIN, 10));
		infoField.setEditable(false);
		infoField.setBounds(14, 240, 410, 20);
		frmMtgTool.getContentPane().add(infoField);
		infoField.setColumns(10);

		JLabel lblCurentPlayers = new JLabel("Curent Players");
		lblCurentPlayers.setBounds(31, 34, 70, 20);
		frmMtgTool.getContentPane().add(lblCurentPlayers);
		lblCurentPlayers.setFont(new Font("Calibri Light", Font.PLAIN, 12));

		addPlayerTextField = new JTextField();
		addPlayerTextField.setBounds(259, 66, 131, 20);
		frmMtgTool.getContentPane().add(addPlayerTextField);
		addPlayerTextField.setColumns(10);

		JButton addPlayerButton = new JButton("Add Player");
		addPlayerButton.setBounds(287, 102, 79, 23);
		frmMtgTool.getContentPane().add(addPlayerButton);
		addPlayerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isAddPlayerKnopAction();
			}

		});
		addPlayerButton.setFont(new Font("Calibri Light", Font.PLAIN, 11));

		JLabel namePlayer = new JLabel("Name:");
		namePlayer.setBounds(260, 37, 29, 14);
		frmMtgTool.getContentPane().add(namePlayer);
		namePlayer.setFont(new Font("Calibri Light", Font.PLAIN, 11));
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"Id", "Name", "Points"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		table.setColumnSelectionAllowed(true);
		table.setBounds(41, 65, 196, 160);
		frmMtgTool.getContentPane().add(table);
	}
}
