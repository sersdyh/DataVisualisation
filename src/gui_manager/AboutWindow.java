package gui_manager;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AboutWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public AboutWindow() {
		setAlwaysOnTop(true);
		setTitle("About");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 413, 225);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDataVisualizationApplication = new JLabel("Data Visualization Application\u00AE2017 FSpyNick Corporation. All rights reserved.");
		lblDataVisualizationApplication.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDataVisualizationApplication.setBounds(10, 25, 414, 14);
		contentPane.add(lblDataVisualizationApplication);
		
		JButton btnReleaseHighlights = new JButton("Release highlights");
		btnReleaseHighlights.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnReleaseHighlights.setBounds(10, 50, 165, 23);
		contentPane.add(btnReleaseHighlights);
		
		JButton btnNewButton = new JButton("FAQ");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton.setBounds(10, 84, 165, 23);
		contentPane.add(btnNewButton);
		
		JButton btnViewLicenseAgreement = new JButton("View license agreement");
		btnViewLicenseAgreement.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnViewLicenseAgreement.setBounds(10, 118, 165, 23);
		contentPane.add(btnViewLicenseAgreement);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnClose.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnClose.setBounds(10, 152, 165, 23);
		contentPane.add(btnClose);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 11, 377, 2);
		contentPane.add(separator);
	}
}
