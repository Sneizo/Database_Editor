/**
 * 
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
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
	private JTable table;
	private JScrollPane scrollPane3;

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
		execute.setBorder(new CompoundBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY),
				(BorderFactory.createEmptyBorder(5, 5, 5, 5))));

		executePanel = new JPanel();
		GridLayout grid = new GridLayout(1, 1);
		executePanel.setLayout(grid);
		executePanel.add(execute);
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
		queryResult = new JTextArea(8, 20);
		queryResult.setEditable(false);
		// Creation of scrollPane2
		scrollPane2 = new JScrollPane(queryResult);
		// Creation of label Result
		resultQuery = new JLabel("Result");
		resultQuery.setHorizontalAlignment(SwingConstants.CENTER);

		// Creation of resultQuery Panel
		panelResult = new JPanel();
		GridLayout gp = new GridLayout(2, 1);
		panelResult.setLayout(gp);
		panelResult.add(resultQuery);
		panelResult.add(scrollPane2);
		panelResult.setBorder(new CompoundBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.GRAY),
				(BorderFactory.createEmptyBorder(16, 16, 16, 16))));

		// Creation of mainPanelText
		mainPanelText = new JPanel();
		GridLayout gr = new GridLayout(3, 1);
		mainPanelText.setLayout(gr);
		mainPanelText.add(panelInputText);
		mainPanelText.add(panelResult);
		mainPanelText.setBorder(new CompoundBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY),
				(BorderFactory.createEmptyBorder(16, 16, 16, 16))));

		// Les données du tableau
		Object[][] data = { { "Agent" }, { "Client" }, { "Opération" }, { "Agence" } };

		// Les titres des colonnes
		String title[] = { "Name of table" };

		table = new JTable(data, title);
		scrollPane3 = new JScrollPane(table);

		JPanel tablePan = new JPanel();
		tablePan.add(scrollPane3);

		// JTabbedPane tp = new JTabbedPane();
		// tp.addTab("tab1", this);
		// tp.addTab("+", new JLabel());
		// tp.addMouseListener(new MouseAdapter() {
		// @Override
		// public void mouseClicked(MouseEvent e) {
		// if (tp.getSelectedComponent() instanceof JLabel) {
		// int count = tp.getTabCount();
		// JLabel newTabLabel = new JLabel("tab" + count);
		// PanelQuery newTab = new PanelQuery();
		// newTab.add(newTabLabel);
		// tp.add(newTab, count - 1);
		// tp.setTitleAt(count - 1, "tab" + count);
		// tp.setSelectedComponent(newTab);
		// }
		// }
		// });

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

}
