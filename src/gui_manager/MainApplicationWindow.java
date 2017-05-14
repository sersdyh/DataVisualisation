/**
 * 2355 Sehai Fation
 * 2343 Rentas Nikolaoas
 * 2359 Spyrakhs Kwnstantinos
 */

package gui_manager;

import jdbc.Driver;

import javax.swing.JFrame;
import javax.swing.JEditorPane;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;

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
		editorPane.setBounds(10, 32, 564, 290);
		editorPane.setEditable(false);
		mainFrame.getContentPane().add(editorPane);
		editorPane.setText("Welcome to Data Visualisation using Data Driver Documents.\n\nTo get started, click chart list from charts tab and select data.");
		
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
		
		JMenu mnCharts = new JMenu("Charts");
		mnCharts.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		menuBar.add(mnCharts);
		
		JMenuItem mntmChartList = new JMenuItem("Chart list");
		mntmChartList.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mntmChartList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChartWindow newChartWindow = new ChartWindow(databaseConnection);
				newChartWindow.setVisible(true);
			}
		});
		mnCharts.add(mntmChartList);
		
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
		
		JLabel lblFspynick = DefaultComponentFactory.getInstance().createLabel("FSpyNick©");
		lblFspynick.setFont(new Font("Yu Gothic", Font.BOLD | Font.ITALIC, 13));
		lblFspynick.setBounds(493, 333, 81, 14);
		mainFrame.getContentPane().add(lblFspynick);
	}
}
