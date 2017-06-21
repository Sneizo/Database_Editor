package controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JPanel;

import model.ConnexionJDBC;
import model.JDBCOperation;
import model.SaveFileJDBC;
import model.TableJDBC;
import view.Create;
import view.Interface;
import view.MainPanel;
import view.PanelQuery;
import view.Profil;
import view.Rename;
import view.TitleBar;

public class ControllerMainPanel implements ActionListener {

	private MainPanel mainPanel;
	private Interface interf;
	private Create create;
	private TitleBar titleBar;
	private Rename rename;
	private Profil profil;
	private SaveFileJDBC saveFile;
	private ConnexionJDBC con;
	private PanelQuery panelQuery;
	
	public ControllerMainPanel(MainPanel mainPanel, Interface interf,Create create, TitleBar titleBar, Rename rename, Profil profil, SaveFileJDBC saveFile, ConnexionJDBC con, PanelQuery panelQuery) {
		this.mainPanel = mainPanel;
		this.interf = interf;
		this.create = create;
		this.titleBar = titleBar;
		this.rename = rename;
		this.profil = profil;
		this.saveFile = saveFile;
		this.con = con;
		this.panelQuery = panelQuery;
		
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == (mainPanel.getCreate())) {
			JPanel pane = new JPanel();
			pane.setLayout(new BorderLayout());
			pane.add(titleBar, BorderLayout.NORTH);
			pane.add(create, BorderLayout.CENTER);
			this.interf.setPanel(pane);
		}
		
		if (ae.getSource() == (mainPanel.getSave())) {
			saveFile.saveFile();			
		}
		
		if (ae.getSource() == (mainPanel.getSaveAs())) {
			saveFile.saveFileAs();
		}
		
		if (ae.getSource() == (mainPanel.getOpen())) {
			
		}
		
		if (ae.getSource() == (mainPanel.getRename())) {
			JPanel pane = new JPanel();
			pane.setLayout(new BorderLayout());
			pane.add(titleBar, BorderLayout.NORTH);
			pane.add(rename, BorderLayout.CENTER);
			this.interf.setPanel(pane);
		}
		
		if (ae.getSource() == (mainPanel.getDisconnect())) {
			JPanel pane = new JPanel();
			pane.setLayout(new BorderLayout());
			pane.add(titleBar, BorderLayout.NORTH);
			pane.add(profil, BorderLayout.CENTER);
			this.interf.setPanel(pane);
		}
		
		if (ae.getSource() == (mainPanel.getRefresh())) {
			TableJDBC table = new TableJDBC(con);
			Vector<String> vec = table.getVector();
			this.panelQuery.setVector(vec);
			this.interf.repaint();
			this.interf.revalidate();
		}






	}

}
