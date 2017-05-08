/**
 * 2355 Sehai Fation
 * 2343 Rentas Nikolaoas
 * 2359 Spyrakhs Kwnstantinos
 */

package GUIManager;

import jdbc.Driver;

import javax.swing.JFrame;
import javax.swing.JEditorPane;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class MainApplicationWindow {

	private static Driver databaseConnection;
	private JFrame mainFrame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		databaseConnection = new Driver();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainApplicationWindow window = new MainApplicationWindow();
					window.mainFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainApplicationWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		mainFrame = new JFrame();
		mainFrame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 11));
		mainFrame.setTitle("Data Visualization Application");
		mainFrame.setBounds(100, 100, 600, 400);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.getContentPane().setLayout(null);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setForeground(Color.BLACK);
		editorPane.setBackground(Color.LIGHT_GRAY);
		editorPane.setBounds(10, 55, 564, 295);
		mainFrame.getContentPane().add(editorPane);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 584, 21);
		mainFrame.getContentPane().add(menuBar);
		
		JMenu mnConnection = new JMenu("Connection");
		mnConnection.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		menuBar.add(mnConnection);
		
		JMenuItem mntmNew = new JMenuItem("New");
		mntmNew.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				NewConnectionWindow newWindow = new NewConnectionWindow(databaseConnection);
				databaseConnection = newWindow.getDatabaseConnection();
				newWindow.setVisible(true);
			}
		});
		mntmNew.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mnConnection.add(mntmNew);
		
		JMenuItem mntmClose = new JMenuItem("Close");
		mntmClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				databaseConnection.closeConnection();
				editorPane.setText("Warning: no SQL connection found!");
			}
		});
		mntmClose.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mnConnection.add(mntmClose);
		
		JMenu mnEdit = new JMenu("Edit");
		mnEdit.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		menuBar.add(mnEdit);
		
		JMenuItem mntmRun = new JMenuItem("Run");
		mntmRun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String query = editorPane.getText();
				int requestQuery = databaseConnection.executeQuerry(query);
				if (requestQuery == 1) { // all good
					//editorPane.setText("Querry succesful!");
				} else if (requestQuery == -1) { // kati phge lathos
					editorPane.setText("Error in SQL statement.");
				} else { // unknown error
					System.exit(-666);
				}
			}
		});
		mntmRun.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mnEdit.add(mntmRun);
		
		JMenuItem mntmClear = new JMenuItem("Clear");
		mntmClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editorPane.setText("");
			}
		});
		mntmClear.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mnEdit.add(mntmClear);
		
		JMenu mnCharts = new JMenu("Charts");
		mnCharts.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		menuBar.add(mnCharts);
		
		JMenuItem mntmChartsList = new JMenuItem("Charts list");
		mntmChartsList.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mntmChartsList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChartWindow newChartWindow = new ChartWindow();
				newChartWindow.setVisible(true);
			}
		});
		mnCharts.add(mntmChartsList);
		
		JMenu mnHelp = new JMenu("Help");
		mnHelp.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AboutWindow newAboutWindow = new AboutWindow();
				newAboutWindow.setVisible(true);
			}
		});
		mntmAbout.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mnHelp.add(mntmAbout);
		
		Button executeButton = new Button("execute");
		executeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String query = editorPane.getText();
				int requestQuery = databaseConnection.executeQuerry(query);
				if (requestQuery == 1) { // all good
					//editorPane.setText("Querry succesful!");
				} else if (requestQuery == -1) { // kati phge lathos
					editorPane.setText("Error in SQL statement.");
				} else { // unknown error
					System.exit(-666);
				}
			}
		});
		executeButton.setBounds(10, 27, 70, 22);
		mainFrame.getContentPane().add(executeButton);
	}
}
