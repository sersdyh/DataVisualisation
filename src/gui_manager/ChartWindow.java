package gui_manager;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.JComboBox;

import com.mysql.jdbc.ResultSetMetaData;

import file_manager.FileHandler;

import jdbc.Driver;

import web_manager.D3View;

import javafx.application.Application;

import java.awt.Button;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChartWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private List<String> countries;
	private List<String> indicators;

	/**
	 * Create the frame.
	 */
	public ChartWindow(Driver databaseConnection) {
		ResultSet rs = null;
		countries = new ArrayList<>();
		indicators = new ArrayList<>();
		setTitle("Create chart window");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 890, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 201, 239);
		getContentPane().add(scrollPane);
		
		DefaultListModel<String> chartListModel = new DefaultListModel<>();
		chartListModel.addElement("Timeline/Trendline");
		chartListModel.addElement("Bar chart");
		chartListModel.addElement("Scatter Plot");
		
		JList<String> chartList = new JList<>(chartListModel);
		chartList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		chartList.setSelectedIndex(0);
		scrollPane.setViewportView(chartList);
		chartList.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		
		Button cancelButton = new Button("cancel");
		cancelButton.setBounds(358, 229, 70, 22);
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		contentPane.add(cancelButton);
		
		JLabel lblCountry = new JLabel("Country");
		lblCountry.setBounds(221, 15, 46, 14);
		lblCountry.setFont(new Font("Tahoma", Font.PLAIN, 11));
		contentPane.add(lblCountry);
		
		JLabel lblIndicator = new JLabel("Indicator");
		lblIndicator.setBounds(221, 40, 46, 14);
		lblIndicator.setFont(new Font("Tahoma", Font.PLAIN, 11));
		contentPane.add(lblIndicator);
		
		JLabel lblFrom = new JLabel("From");
		lblFrom.setBounds(221, 65, 46, 14);
		lblFrom.setFont(new Font("Tahoma", Font.PLAIN, 11));
		contentPane.add(lblFrom);
		
		JLabel labelTo = new JLabel("To");
		labelTo.setBounds(221, 90, 46, 14);
		labelTo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		contentPane.add(labelTo);
		
		JLabel lblRange = new JLabel("Range");
		lblRange.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblRange.setBounds(221, 120, 46, 14);
		contentPane.add(lblRange);
		
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(434, 11, 201, 239);
		contentPane.add(scrollPane2);
		DefaultListModel<String> countryListModel = new DefaultListModel<>();
		JList<String> countryList = new JList<>(countryListModel);
		countryList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		scrollPane2.setViewportView(countryList);
		countryList.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		
		JScrollPane scrollPane3 = new JScrollPane();
		scrollPane3.setBounds(663, 11, 201, 239);
		contentPane.add(scrollPane3);
		DefaultListModel<String> indicatorListModel = new DefaultListModel<>();
		JList<String> indicatorList = new JList<>(indicatorListModel);
		indicatorList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		scrollPane3.setViewportView(indicatorList);
		indicatorList.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		
		try {
			rs = databaseConnection.executeQuerry("select CountryName from countries;");
			while (rs.next()) {
				countries.add(rs.getString(1));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		DefaultComboBoxModel<String> countryModel = new DefaultComboBoxModel<>();
		for (String country: countries) {
			countryModel.addElement(country);
		}
		JComboBox<String> countryComboBox = new JComboBox<>(countryModel);
		countryComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item = (String) countryComboBox.getSelectedItem();
				if (!(countryListModel.contains(item))) {
					countryListModel.addElement(item);
				}
			}
		});
		countryComboBox.setBounds(278, 12, 146, 17);
		countryComboBox.setFont(new Font("Tahoma", Font.PLAIN, 11));
		contentPane.add(countryComboBox);
		
		try {
			rs = databaseConnection.executeQuerry("select SeriesName from series;");
			while (rs.next()) {
				indicators.add(rs.getString(1));
			}
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		DefaultComboBoxModel<String> indicatorModel = new DefaultComboBoxModel<>();
		for (String indicator: indicators) {
			indicatorModel.addElement(indicator);
		}
		JComboBox<String> indicatorComboBox = new JComboBox<>(indicatorModel);
		indicatorComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String item = (String) indicatorComboBox.getSelectedItem();
				if (!(indicatorListModel.contains(item))) {
					indicatorListModel.addElement(item);
				}
			}
		});
		indicatorComboBox.setBounds(278, 37, 146, 20);
		indicatorComboBox.setFont(new Font("Tahoma", Font.PLAIN, 11));
		contentPane.add(indicatorComboBox);
		
		DefaultComboBoxModel<Integer> yearModelFrom = new DefaultComboBoxModel<>();
		for (int i = 1967; i < 2017; i++) {
			yearModelFrom.addElement(i);
		}
		JComboBox<Integer> fromComboBox = new JComboBox<>(yearModelFrom);
		fromComboBox.setBounds(278, 62, 146, 20);
		fromComboBox.setFont(new Font("Tahoma", Font.PLAIN, 11));
		fromComboBox.setSelectedIndex(0);
		contentPane.add(fromComboBox);
		
		DefaultComboBoxModel<Integer> yearModelTo = new DefaultComboBoxModel<>();
		for (int i = 1967; i < 2017; i++) {
			yearModelTo.addElement(i);
		}
		JComboBox<Integer> toComboBox = new JComboBox<>(yearModelTo);
		toComboBox.setBounds(278, 87, 146, 20);
		toComboBox.setFont(new Font("Tahoma", Font.PLAIN, 11));
		toComboBox.setSelectedIndex(0);
		contentPane.add(toComboBox);
		
		DefaultComboBoxModel<Integer> rangeModel = new DefaultComboBoxModel<>();
		rangeModel.addElement(1); rangeModel.addElement(5); rangeModel.addElement(10);
		JComboBox<Integer> rangeComboBox = new JComboBox<>(rangeModel);
		rangeComboBox.setBounds(278, 118, 146, 18);
		rangeComboBox.setFont(new Font("Tahoma", Font.PLAIN, 11));
		rangeComboBox.setSelectedIndex(0);
		contentPane.add(rangeComboBox);
		
		Button createButton = new Button("create");
		createButton.setBounds(282, 229, 70, 22);
		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int from = (int) fromComboBox.getSelectedItem();
				int to = (int) toComboBox.getSelectedItem();
				int range = (int) rangeComboBox.getSelectedItem();
				if (from <= to) { // tote mono to dexomai
					String chartType = chartList.getSelectedValue();
					ListModel<String> countModel = countryList.getModel();
					ListModel<String> indiModel = indicatorList.getModel();
					if (!(countModel.getSize() == 0 || indiModel.getSize() == 0)) { // mono ama epilseksei xwres kai deiktes me noiazei
						// SELECT private_sector_data.SeriesCode, private_sector_data.CountryCode, private_sector_data.YR1967 from private_sector_data
						//where CountryCode = 'BEL'and SeriesCode = 'BG.GSR.NFSV.GD.ZS'
						List<String> countryCodes = new ArrayList<>();
						List<String> seriesCodes = new ArrayList<>();
						// pairnw to country code
						for (int i = 0; i < countModel.getSize(); i++) {
							ResultSet rs = null;
							rs = databaseConnection.executeQuerry("select CountryCode from countries where CountryName = '" + countModel.getElementAt(i) + "';");
							try {
								while (rs.next()) {
									//System.out.println(rs.getString(1));//TEST
									countryCodes.add(rs.getString(1));
								}
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
						// pairnw to series code
						for (int i = 0; i < indiModel.getSize(); i++) {
							ResultSet rs = null;
							rs = databaseConnection.executeQuerry("select SeriesCode from series where SeriesName = '" + indiModel.getElementAt(i) + "';");
							try {
								while (rs.next()) {
									//System.out.println(rs.getString(1));//TEST
									seriesCodes.add(rs.getString(1));
								}
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
						// kataskeuh tou dynamic query
						String cquery = "'";
						int count = 0;
						for (String c: countryCodes) {
							if (count == countryCodes.size() - 1) {
								cquery += c + "'";
							} else {
								cquery += c + "' or CountryCode = '";
							}
							count++;
						}
						String nquery = "'";
						count = 0;
						for (String n: seriesCodes) {
							if (count == seriesCodes.size() - 1) {
								nquery += n + "'";
							} else {
								nquery += n + "' or SeriesCode = '";
							}
							count++;
						}
						String query = "select * from private_sector_data where (SeriesCode = " + nquery + ") and (" + "CountryCode = " + cquery + ");";
						ResultSet rs = null;
						List<String> queryResult = new ArrayList<>();
						try {
							rs = databaseConnection.executeQuerry(query);
							ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
							int columnsNumber = rsmd.getColumnCount();
							while (rs.next()) {
								String res = " ";
								for (int i = 1; i <= columnsNumber; i++) {
									//System.out.print(rs.getString(i));
									res += rs.getString(i) + " ";
								}
								if (!res.isEmpty()) {
									res = res.trim();
									queryResult.add(res);
								}
							}
						} catch (SQLException e) {
							e.printStackTrace();
						}
						// queryResult: kathe grammh info pou zhthsa.
						String finalQuery = "";
						List<String> allQueries = new ArrayList<>();
						for (String x: queryResult) {
							String[] queryParts = x.split("\\s+"); // split sta kena
							String cName = null;
							rs = databaseConnection.executeQuerry("select CountryName from countries where CountryCode = '" + queryParts[2] +"';"); // pairnw country name apo code
							try {
								while (rs.next()) {
									cName = rs.getString(1);
								}
							} catch (SQLException e) {
								e.printStackTrace();
							}
							String iName = null;
							rs = databaseConnection.executeQuerry("select IndicatorName from indicators where SeriesCode = '" + queryParts[1] + "';"); // pairnw indicator name apo code
							try {
								while (rs.next()) {
									iName = rs.getString(1);
								}
							} catch (SQLException e) {
								e.printStackTrace();
							}
							String years = "";
							for (int i = 0; i < queryParts.length-3; i++) {
								// 1967 thesh 3, 2016 thesh queryParts.length-1
								years += queryParts[i+3] + " ";
							}
							Map<Integer, String> yearMap = new HashMap<>();
							Integer yr = 1967;
							for (String y: years.split("\\s+")) {
								yearMap.put(yr, y);
								yr++;
							}
							years = "";
							for (int i = 1967; i <= 2016; i += range) {
								//System.out.println(item + ":" + yearMap.get(item));
								if (i >= from && i <= to) {
									years += yearMap.get(i) + " ";
								}
								if (i > to) {
									break;
								}
							}
							finalQuery = iName + " " + cName + " " + years;
							allQueries.add(finalQuery);
							//System.out.println(finalQuery);
						}
						// kanw create to .tsv arxeio...
						FileHandler file = new FileHandler(allQueries);
						file.createTSVFile(from, to, range);
						// kalw to d3 javascript analoga me ti tipo chart epelekse o xrhsths
						setVisible(false);
						Application.launch(D3View.class, chartType);

						// diagrafw data arxeio gia na bei allo
						file.deleteDataFile();
					} else {
						JOptionPane.showMessageDialog(new JFrame(), "Error: No country/indicators selected.", "Dialog", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(new JFrame(), "Error: Year " + from + " greater than " + to + ".", "Dialog", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		contentPane.add(createButton);
		
		Button button = new Button("remove");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<String> allCountries = countryList.getSelectedValuesList();
				List<String> allIndicators = indicatorList.getSelectedValuesList();
				for (String item: allCountries) {
					countryListModel.removeElement(item);
				}
				for (String item: allIndicators) {
					indicatorListModel.removeElement(item);
				}
			}
		});
		button.setBounds(358, 152, 70, 22);
		contentPane.add(button);
		
	}
}
