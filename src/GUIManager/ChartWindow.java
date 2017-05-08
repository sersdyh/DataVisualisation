package GUIManager;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import java.awt.Button;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChartWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public ChartWindow() {
		setAlwaysOnTop(true);
		setTitle("Create chart window");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 201, 239);
		getContentPane().add(scrollPane);
		
		DefaultListModel<String> chartListModel = new DefaultListModel<>();
		chartListModel.addElement("Line chart");
		chartListModel.addElement("Bar chart");
		chartListModel.addElement("Pie chart");
		chartListModel.addElement("Histogram");
		
		JList<String> chartList = new JList<>(chartListModel);
		chartList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		chartList.setSelectedIndex(0);
		scrollPane.setViewportView(chartList);
		chartList.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		
		Button createButton = new Button("create");
		createButton.setBounds(278, 229, 70, 22);
		contentPane.add(createButton);
		
		Button cancelButton = new Button("cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		cancelButton.setBounds(354, 229, 70, 22);
		contentPane.add(cancelButton);
	}
}
