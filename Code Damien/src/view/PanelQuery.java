/**
 * 
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Element;

/**
 * @author Damien
 *
 */
public class PanelQuery extends JPanel {

	// MainPanel
	private JPanel mainPanelText;
	private JTabbedPane jtp;

	// PanelTextInPut
	private JPanel panelInputText;
	private JTextArea queryWrite;
	private JButton execute;
	private JLabel nameDataBase;
	private JScrollPane scrollPane1;

	// PanelResult
	private JPanel panelResult;
	private JTextArea queryResult;
	private JScrollPane scrollPane2;
	private JLabel resultQuery;
	private JPanel titlePanel;
	private JPanel executePanel;
	private JList<String> table;
	private JScrollPane scrollPane3;
	private Vector<String> vec;
	

	public PanelQuery() {
		
		initComponent();

	}

	private void initComponent() {

		// Creation of JTextArea
		queryWrite = new JTextArea(8, 20);
		queryWrite.setLineWrap(true);
		queryWrite.setWrapStyleWord(true);
		queryWrite.setOpaque(true);
		// Creation of JButton execute
		execute = new JButton("Execute query");
		this.execute.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		this.execute.setBackground(new Color(80,80,80));
		this.execute.setForeground(Color.WHITE);
		execute.setBorder(new CompoundBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY),
				(BorderFactory.createEmptyBorder(5, 5, 5, 5))));

		executePanel = new JPanel();
		BorderLayout grid = new BorderLayout();
		executePanel.setLayout(grid);
		executePanel.add(execute, BorderLayout.CENTER);
		executePanel.setBorder(new CompoundBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.GRAY),
				(BorderFactory.createEmptyBorder(10, 40, 10, 40))));

		// Creation of DatabaseName label
		nameDataBase = new JLabel("Database_Name");
		// Creation of ScrollBar
		scrollPane1 = new JScrollPane(queryWrite);

		JTextArea lines = new JTextArea("1");

		lines.setBackground(Color.LIGHT_GRAY);
		lines.setEditable(false);

		queryWrite.getDocument().addDocumentListener(new DocumentListener() {
			public String getText() {
				int caretPosition = queryWrite.getDocument().getLength();
				Element root = queryWrite.getDocument().getDefaultRootElement();
				String text = "1" + System.getProperty("line.separator");
				for (int i = 2; i < root.getElementIndex(caretPosition) + 2; i++) {
					text += i + System.getProperty("line.separator");
				}
				return text;
			}

			@Override
			public void changedUpdate(DocumentEvent de) {
				lines.setText(getText());
			}

			@Override
			public void insertUpdate(DocumentEvent de) {
				lines.setText(getText());
			}

			@Override
			public void removeUpdate(DocumentEvent de) {
				lines.setText(getText());
			}

		});

		scrollPane1.getViewport().add(queryWrite);
		scrollPane1.setRowHeaderView(lines);
		scrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		titlePanel = new JPanel();
		GridLayout grd = new GridLayout(1, 2);
		titlePanel.setLayout(grd);
		titlePanel.add(nameDataBase);
		titlePanel.add(executePanel);
		titlePanel.setBorder(new CompoundBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY),
				(BorderFactory.createEmptyBorder(10, 10, 10, 10))));

		// Creation panelInputText and addButton
		panelInputText = new JPanel();
		BorderLayout br = new BorderLayout();
		panelInputText.setLayout(br);
		// panelInputText.add(scrollPane1, BorderLayout.CENTER);
		panelInputText.add(scrollPane1, BorderLayout.CENTER);
		panelInputText.add(titlePanel, BorderLayout.NORTH);
		panelInputText.setBorder(new CompoundBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.GRAY),
				(BorderFactory.createEmptyBorder(16, 16, 16, 16))));

		// Creation of queryResult textArea
		queryResult = new JTextArea(50, 50);
		//queryResult.setMinimumSize(new Dimension(500, 500));
		queryResult.setEditable(false);
		// Creation of scrollPane2
		scrollPane2 = new JScrollPane(queryResult);
		scrollPane2.setPreferredSize(new Dimension(200,50));
		// Creation of label Result
		resultQuery = new JLabel("Result");
		resultQuery.setHorizontalAlignment(SwingConstants.CENTER);

		// Creation of resultQuery Panel
		panelResult = new JPanel();
		BorderLayout gp = new BorderLayout();
		panelResult.setLayout(gp);
		panelResult.add(resultQuery, BorderLayout.NORTH);
		panelResult.add(scrollPane2, BorderLayout.CENTER);
		panelResult.setBorder(new CompoundBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.GRAY),
				(BorderFactory.createEmptyBorder(16, 16, 16, 16))));

		// Creation of mainPanelText
		mainPanelText = new JPanel();
		BorderLayout gr = new BorderLayout();
		mainPanelText.setLayout(gr);
		mainPanelText.add(panelInputText, BorderLayout.NORTH);
		mainPanelText.add(panelResult, BorderLayout.CENTER);
		mainPanelText.setBorder(new CompoundBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY),
				(BorderFactory.createEmptyBorder(16, 16, 16, 16))));

		this.vec = new Vector<String>();
		this.vec.add("TABLE : ");
		if(this.vec != null) {
			table = new JList<String>(this.vec);
		}else{table = new JList<String>();}
		scrollPane3 = new JScrollPane(table);
		scrollPane3.setPreferredSize(new Dimension(200,50));
		

		this.setLayout(new BorderLayout());
		add(scrollPane3,BorderLayout.WEST);
		add(mainPanelText,BorderLayout.CENTER);
	}

	/**
	 * @return the mainPanelText
	 */
	public JPanel getMainPanelText() {
		return mainPanelText;
	}

	/**
	 * @return the jtp
	 */
	public JTabbedPane getJtp() {
		return jtp;
	}

	/**
	 * @return the panelInputText
	 */
	public JPanel getPanelInputText() {
		return panelInputText;
	}

	/**
	 * @return the queryWrite
	 */
	public JTextArea getQueryWrite() {
		return queryWrite;
	}

	/**
	 * @return the execute
	 */
	public JButton getExecute() {
		return execute;
	}

	/**
	 * @return the nameDataBase
	 */
	public JLabel getNameDataBase() {
		return nameDataBase;
	}

	/**
	 * @return the scrollPane1
	 */
	public JScrollPane getScrollPane1() {
		return scrollPane1;
	}

	/**
	 * @return the panelResult
	 */
	public JPanel getPanelResult() {
		return panelResult;
	}

	/**
	 * @return the queryResult
	 */
	public JTextArea getQueryResult() {
		return queryResult;
	}

	/**
	 * @return the scrollPane2
	 */
	public JScrollPane getScrollPane2() {
		return scrollPane2;
	}

	/**
	 * @return the resultQuery
	 */
	public JLabel getResultQuery() {
		return resultQuery;
	}

	/**
	 * @return the titlePanel
	 */
	public JPanel getTitlePanel() {
		return titlePanel;
	}

	/**
	 * @return the executePanel
	 */
	public JPanel getExecutePanel() {
		return executePanel;
	}

	/**
	 * @return the table
	 */
	public JList getTable() {
		return table;
	}

	/**
	 * @param table the table to set
	 */
	public void setTable(JList table) {
		this.table = table;
	}

	/**
	 * @param mainPanelText the mainPanelText to set
	 */
	public void setMainPanelText(JPanel mainPanelText) {
		this.mainPanelText = mainPanelText;
	}

	/**
	 * @param nameDataBase the nameDataBase to set
	 */
	public void setNameDataBase(JLabel nameDataBase) {
		this.nameDataBase = nameDataBase;
	}

	/**
	 * @param queryResult the queryResult to set
	 */
	public void setQueryResult(JTextArea queryResult) {
		this.queryResult = queryResult;
	}

	/**
	 * @param resultQuery the resultQuery to set
	 */
	public void setResultQuery(JLabel resultQuery) {
		this.resultQuery = resultQuery;
	}

	/**
	 * @param titlePanel the titlePanel to set
	 */
	public void setTitlePanel(JPanel titlePanel) {
		this.titlePanel = titlePanel;
	}

	/**
	 * @param executePanel the executePanel to set
	 */
	public void setExecutePanel(JPanel executePanel) {
		this.executePanel = executePanel;
	}
	

	
	public void setVector(Vector<String> vec) {
		this.vec = vec;
		this.table.setListData(vec.toArray(new String[0]));
	}

}
