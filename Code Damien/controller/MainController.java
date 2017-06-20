package controller;

import javax.swing.JFrame;

import view.Connexion;
import view.Create;
import view.InformationBar;
import view.Interface;
import view.MainPanel;
import view.PanelQuery;
import view.Rename;
import view.TitleBar;

public class MainController {
	
	private Connexion connexion;
	private Create create;
	private Rename rename;
	private MainPanel mainPanel;
	private TitleBar titleBar;
	private PanelQuery panelQuery;
	private JFrame frame;
	private Interface interf;
	private InformationBar informationBar;
	
	private MouseListenerJFrame mouseListenerJFrame;
	private MouseMotionListenner mouseMotionListenner;
	
	private ControllerConnexion controllerConnexion;
	private ControllerCreate controllerCreate;
	private ControllerRename controllerRename;
	private ControllerMainPanel controllerMainPanel;
	private ControllerTitleBar controllerTitleBar;
	private ControllerPanelQuery controllerPanelQuery;
	
	public MainController(Connexion connexion, Create create, Rename rename, MainPanel mainPanel, 
			TitleBar titleBar, PanelQuery panelQuery, Interface interf, InformationBar informationBar) {
		
		this.connexion = connexion;
		this.create = create;
		this.rename = rename;
		this.mainPanel = mainPanel;
		this.titleBar = titleBar;
		this.panelQuery = panelQuery;
		this.interf = interf;
		this.informationBar = informationBar;
		
		this.mouseListenerJFrame = new MouseListenerJFrame(interf, interf.getPosX(), interf.getPosX());
		this.mouseMotionListenner = new MouseMotionListenner(interf);
		iniJFrame();
		
		this.controllerConnexion = new ControllerConnexion(connexion,interf,titleBar,mainPanel,panelQuery, informationBar);
		initConnexion();
		this.controllerCreate = new ControllerCreate(create,interf);
		initCreate();
		this.controllerRename = new ControllerRename(rename,interf, panelQuery, informationBar, mainPanel, titleBar);
		initRename();
		this.controllerMainPanel = new ControllerMainPanel(mainPanel,interf,create,titleBar,rename);
		initMainPanel();
		this.controllerTitleBar = new ControllerTitleBar(titleBar,interf);
		initTitleBar();
		this.controllerPanelQuery = new ControllerPanelQuery(panelQuery,interf);
		initPanelQuery();
	}
	
	public void initConnexion() {
		this.connexion.getUserLog().addFocusListener(controllerConnexion);
		this.connexion.getPassLog().addFocusListener(controllerConnexion);
		this.connexion.getDataNameLog().addFocusListener(controllerConnexion);
		this.connexion.getConnect().addActionListener(controllerConnexion);
		
		this.connexion.getUserSub().addFocusListener(controllerConnexion);
		this.connexion.getPassSub().addFocusListener(controllerConnexion);
		this.connexion.getConfirmPassSub().addFocusListener(controllerConnexion);
		this.connexion.getDataNameLogSub().addFocusListener(controllerConnexion);
		this.connexion.getSubscribe().addActionListener(controllerConnexion);
		
	}
	public void initCreate() {
		this.create.getNewTableName().addFocusListener(controllerCreate);
		this.create.getConfirmer().addActionListener(controllerCreate);
		this.create.getAnnuler().addActionListener(controllerCreate);
		
	}
	
	public void initRename() {
		this.rename.getOldTableName().addFocusListener(controllerRename);
		this.rename.getNewTableName().addFocusListener(controllerRename);
		this.rename.getConfirmer().addActionListener(controllerRename);
		this.rename.getAnnuler().addActionListener(controllerRename);
	}
	
	public void initMainPanel() {
		this.mainPanel.getCreate().addActionListener(controllerMainPanel);
		this.mainPanel.getOpen().addActionListener(controllerMainPanel);
		this.mainPanel.getSave().addActionListener(controllerMainPanel);
		this.mainPanel.getSaveAs().addActionListener(controllerMainPanel);
		this.mainPanel.getCreate().addActionListener(controllerMainPanel);
		this.mainPanel.getRename().addActionListener(controllerMainPanel);
		this.mainPanel.getDisconnect().addActionListener(controllerMainPanel);
		this.mainPanel.getConsol().addActionListener(controllerMainPanel);

	}
	
	public void initTitleBar() {
		this.titleBar.getExit().addActionListener(controllerTitleBar);
		this.titleBar.getExtend().addActionListener(controllerTitleBar);
		this.titleBar.getReduce().addActionListener(controllerTitleBar);
	}
	
	public void initPanelQuery() {
		this.panelQuery.getExecute().addActionListener(controllerPanelQuery);
	}
	
	public void iniJFrame() {
		this.titleBar.addMouseListener(mouseListenerJFrame);
		this.titleBar.addMouseMotionListener(mouseMotionListenner);
	}

}
