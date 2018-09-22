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

public class launcher {

	private JFrame frmMtgTool;
	private JTabbedPane tabbedPane;
	private JPanel Match_panel;
	private JPanel Schedule_panel;
	private JPanel Players_panel;
	private JTable table;
	private Match match = new Match();
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
		initialize();
	}

	private void isStartKnopAction() {
		
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
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		tabbedPane.setBounds(10, 11, 414, 239);
		frmMtgTool.getContentPane().add(tabbedPane);
		
		Match_panel = new JPanel();
		tabbedPane.addTab("Match", null, Match_panel, null);
		tabbedPane.setBackgroundAt(0, Color.WHITE);
		Match_panel.setLayout(null);
		
		JButton btnStartRound = new JButton("Start Round");
		btnStartRound.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				isStartKnopAction();
			}
		});
		btnStartRound.setFont(new Font("Calibri", Font.PLAIN, 11));
		btnStartRound.setToolTipText("Click here to start the next round.");
		btnStartRound.setBounds(158, 173, 91, 23);
		Match_panel.add(btnStartRound);
		
		JLabel timerLaber = new JLabel("Timer");
		timerLaber.setFont(new Font("Calibri Light", Font.PLAIN, 11));
		timerLaber.setBounds(10, 11, 30, 23);
		Match_panel.add(timerLaber);
		
		JLabel timerField = new JLabel("");
		timerField.setBounds(50, 14, 74, 14);
		Match_panel.add(timerField);
		
		Schedule_panel = new JPanel();
		tabbedPane.addTab("Schedule", null, Schedule_panel, null);
		tabbedPane.setEnabledAt(1, true);
		Schedule_panel.setLayout(null);
		
		table = new JTable();
		table.setBounds(10, 11, 385, 185);
		Schedule_panel.add(table);
		
		Players_panel = new JPanel();
		tabbedPane.addTab("Players", null, Players_panel, null);
		tabbedPane.setEnabledAt(2, true);
		Players_panel.setLayout(null);
	}
}
