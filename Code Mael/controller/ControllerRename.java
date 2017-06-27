package controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JPanel;
import model.RenameTableJDBC;
import view.InformationBar;
import view.Interface;
import view.MainPanel;
import view.PanelQuery;
import view.Rename;
import view.TitleBar;

/**
 * This class allows the application to rename a table in the database.
 * @author Mael and Damien
 *
 */
public class ControllerRename implements FocusListener, ActionListener{
	
	private Rename rename;
	private Interface interf;
	private PanelQuery panelQuery;
	private InformationBar informationBar;
	private MainPanel mainPanel;
	private TitleBar titleBar;
	private RenameTableJDBC renameTableJDBC;
	
	/**
	 * The constructor of the ControllerRename class.
	 * @param rename The rename class.
	 * @param interf The main frame.
	 * @param panelQuery The panelQuery class.
	 * @param informationBar The informationBar class.
	 * @param mainPanel The mainPanel class.
	 * @param titleBar The titleBar class.
	 * @param renameTableJDBC The renameTableJDBC class.
	 */
	public ControllerRename(Rename rename, Interface interf, PanelQuery panelQuery, InformationBar informationBar, MainPanel mainPanel, TitleBar titleBar, RenameTableJDBC renameTableJDBC) {
		this.rename = rename;
		this.interf = interf;
		this.informationBar = informationBar;
		this.panelQuery = panelQuery;
		this.titleBar = titleBar;
		this.mainPanel = mainPanel;
		this.renameTableJDBC = renameTableJDBC;
		
	}
	

	/**
	 * Performs an action if the button pressed is the reference button.
	 */
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == this.rename.getConfirmer()) {
			
			renameTableJDBC.renameTable();
			
			JPanel frame = new JPanel();
			BorderLayout br = new BorderLayout();
			JPanel toolBar = new JPanel();
			BorderLayout cr = new BorderLayout();
			toolBar.setLayout(cr);
			
			frame.setLayout(br);
			frame.add(panelQuery, BorderLayout.CENTER);
			frame.add(informationBar, BorderLayout.SOUTH);
			
			toolBar.add(titleBar, BorderLayout.NORTH);
			toolBar.add(mainPanel, BorderLayout.SOUTH);
			
			JPanel principal = new JPanel();
			BorderLayout prcpl = new BorderLayout();
			principal.setLayout(prcpl);
			principal.add(toolBar, BorderLayout.NORTH);
			principal.add(frame, BorderLayout.CENTER);
			interf.setPanel(principal);
		}
		if(ae.getSource() == this.rename.getAnnuler()) {
			JPanel frame = new JPanel();
			BorderLayout br = new BorderLayout();
			JPanel toolBar = new JPanel();
			BorderLayout cr = new BorderLayout();
			toolBar.setLayout(cr);
			
			frame.setLayout(br);
			frame.add(panelQuery, BorderLayout.CENTER);
			frame.add(informationBar, BorderLayout.SOUTH);
			
			toolBar.add(titleBar, BorderLayout.NORTH);
			toolBar.add(mainPanel, BorderLayout.SOUTH);
			
			JPanel principal = new JPanel();
			BorderLayout prcpl = new BorderLayout();
			principal.setLayout(prcpl);
			principal.add(toolBar, BorderLayout.NORTH);
			principal.add(frame, BorderLayout.CENTER);
			interf.setPanel(principal);
		}
	}

	
	/**
	 * Manage focus on graphical components.
	 */
	public void focusGained(FocusEvent fe) {
		if(fe.getSource() == this.rename.getOldTableName()) {
			
		}
		if(fe.getSource() == this.rename.getNewTableName()) {
			
		}
		
	}

	/**
	 * Manage focus on graphical components.
	 */
	public void focusLost(FocusEvent fe) {
		
	}

}
