package controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JPanel;

import view.Create;
import view.InformationBar;
import view.Interface;
import view.MainPanel;
import view.PanelQuery;
import view.TitleBar;

public class ControllerCreate implements FocusListener, ActionListener{
	
	private Create create;
	private Interface interf;
	private PanelQuery panelQuery;
	private InformationBar informationBar;
	private MainPanel mainPanel;
	private TitleBar titleBar;
	
	public ControllerCreate(Create create, Interface interf,PanelQuery panelQuery, InformationBar informationBar, MainPanel mainPanel, TitleBar titleBar) {
		this.create = create;
		this.interf = interf;
		this.informationBar = informationBar;
		this.panelQuery = panelQuery;
		this.titleBar = titleBar;
		this.mainPanel = mainPanel;
	}

	public void focusLost(FocusEvent fe) {
		
	}
	public void focusGained(FocusEvent fe) {
		if(fe.getSource() == this.create.getNewTableName()) {
			
		}
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == this.create.getConfirmer()) {
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
		
		if(ae.getSource() == this.create.getAnnuler()) {
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
}
