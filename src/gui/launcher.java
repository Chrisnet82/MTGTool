package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JPanel;
import java.awt.Label;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class launcher {

	private JFrame frmMtgTool;
	private JTable scheme;
	private JTabbedPane tabplayers;

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
		
		JTabbedPane tabscheme = new JTabbedPane(JTabbedPane.TOP);
		tabscheme.setToolTipText("");
		tabscheme.setBounds(10, 0, 414, 250);
		frmMtgTool.getContentPane().add(tabscheme);
		
		scheme = new JTable();
		tabscheme.addTab("Scheme Tab", null, scheme, null);
		scheme.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		scheme.setColumnSelectionAllowed(true);
		scheme.setCellSelectionEnabled(true);
		scheme.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		tabplayers = new JTabbedPane(JTabbedPane.TOP);
		tabscheme.addTab("Players Tab", null, tabplayers, null);
	}
}
