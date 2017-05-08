package GUIManager;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import jdbc.Driver;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewConnectionWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private Driver databaseConnection;

	private JPanel contentPane;
	private JTextField userField;
	private JTextField passField;
	private JTextField hostField;
	private JTextField portField;
	private JTextField nameField;

	/**
	 * Create the frame.
	 */
	public NewConnectionWindow(Driver dbCon) {
		databaseConnection = dbCon;

		setAlwaysOnTop(true);
		setFont(new Font("Dialog", Font.PLAIN, 12));
		setTitle("New connection");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 335, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		userField = new JTextField();
		userField.setBounds(66, 33, 110, 20);
		contentPane.add(userField);
		userField.setColumns(10);
		
		passField = new JTextField();
		passField.setBounds(66, 58, 110, 20);
		contentPane.add(passField);
		passField.setColumns(10);
		
		hostField = new JTextField();
		hostField.setBounds(66, 83, 110, 20);
		contentPane.add(hostField);
		hostField.setColumns(10);
		
		portField = new JTextField();
		portField.setBounds(66, 108, 110, 20);
		contentPane.add(portField);
		portField.setColumns(10);
		
		nameField = new JTextField();
		nameField.setFont(new Font("Tahoma", Font.PLAIN, 11));
		nameField.setBounds(66, 133, 110, 20);
		contentPane.add(nameField);
		nameField.setColumns(10);
		
		JLabel lblUser = new JLabel("User");
		lblUser.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblUser.setBounds(10, 36, 46, 14);
		contentPane.add(lblUser);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPassword.setBounds(10, 61, 46, 14);
		contentPane.add(lblPassword);
		
		JLabel lblHost = new JLabel("Host");
		lblHost.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblHost.setBounds(10, 86, 46, 14);
		contentPane.add(lblHost);
		
		JLabel lblPort = new JLabel("Port");
		lblPort.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPort.setBounds(10, 111, 46, 14);
		contentPane.add(lblPort);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblName.setBounds(10, 136, 46, 14);
		contentPane.add(lblName);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 11, 294, 14);
		contentPane.add(separator);
		
		JSeparator separator2 = new JSeparator();
		separator2.setBounds(10, 166, 299, 7);
		contentPane.add(separator2);
		
		Button connectButton = new Button("connect");
		connectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				databaseConnection.closeConnection();
				String user = userField.getText();
				String password = passField.getText();
				String host = hostField.getText();
				String port = portField.getText();
				String name = nameField.getText();
				Integer portNumber = Integer.parseInt(port);
				if (portNumber < 0 || portNumber > 49151) {
					portField.setText("Error in port");
				}
				@SuppressWarnings("unused")
				Driver newDbConnection = new Driver(user, password, host, portNumber, name);
				setVisible(false);
			}
		});
		connectButton.setBounds(158, 179, 70, 22);
		contentPane.add(connectButton);
		
		Button cancelButton = new Button("cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		cancelButton.setBounds(234, 179, 70, 22);
		contentPane.add(cancelButton);
		
		Button defaultButton = new Button("default");
		defaultButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userField.setText("root");
				passField.setText("");
				hostField.setText("localhost");
				portField.setText("3306");
				nameField.setText("private_sector_schema");
			}
		});
		defaultButton.setBounds(10, 179, 70, 22);
		contentPane.add(defaultButton);
	}

	/**
	 * Auth h methodos epistrefei th kainourgia SQL connection
	 * @return new db connection
	 */
	public Driver getDatabaseConnection() {
		return this.databaseConnection;
	}

}
