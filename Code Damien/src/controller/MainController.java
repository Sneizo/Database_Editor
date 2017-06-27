package controller;

import model.ChangePasswordJDBC;
import model.ConnexionJDBC;
import model.CreateTableJDBC;
import model.OpenFileJDBC;
import model.RenameTableJDBC;
import model.SaveFileJDBC;
import view.Connexion;
import view.Create;
import view.CreateColonne;
import view.InformationBar;
import view.Interface;
import view.MainPanel;
import view.ModifPassword;
import view.PanelQuery;
import view.Profil;
import view.ProfilPanel;
import view.Rename;
import view.SetAutoSave;
import view.TitleBar;

/**
 * This class allows to manage all the other classes of controller by offering them in attribute of each classes of this project.
 * @author Mael and Damien
 *
 */
public class MainController {
	
	private Connexion connexion;
	private Create create;
	private Rename rename;
	private MainPanel mainPanel;
	private TitleBar titleBar;
	private PanelQuery panelQuery;
	private Interface interf;
	private InformationBar informationBar;
	private ProfilPanel profilPanel;
	private ModifPassword modifPassword;
	private SetAutoSave setAutoSave;
	private CreateColonne createColonne;
	
	private MouseListenerJFrame mouseListenerJFrame;
	private MouseMotionListenner mouseMotionListenner;
	
	private ControllerConnexion controllerConnexion;
	private ControllerCreate controllerCreate;
	private ControllerRename controllerRename;
	private ControllerMainPanel controllerMainPanel;
	private ControllerTitleBar controllerTitleBar;
	private ControllerPanelQuery controllerPanelQuery;
	private ControllerProfil controllerProfil;
	private ControllerQuery controllerQuery;
	private ControllerAutoSave controllerAutoSave;
	private ControllerSetAutoSave controllerSetAutoSave;
	private ControllerProfilPanel controllerProfilPanel;
	private ControllerChangePassword controllerChangePassword;
	
	private Profil profil;
	private SaveFileJDBC saveFile;
	private ConnexionJDBC con;
	private OpenFileJDBC openFile;
	private CreateTableJDBC createTable;
	private ChangePasswordJDBC changePassword;
	private RenameTableJDBC renameTableJDBC;
	
	/**
	 * The main controller class.
	 * @param connexion The connexion class.
	 * @param create The create class.
	 * @param rename The rename class.
	 * @param mainPanel The mainPanel class.
	 * @param titleBar The titleBar class.
	 * @param panelQuery The panelQuery class.
	 * @param interf The main frame.
	 * @param informationBar The informationBar class.
	 * @param profil The profil class.
	 * @param profilPanel The profilPanel class.
	 * @param modifPassword The modifPassword class.
	 * @param setAutoSave The setAutoSave class.
	 * @param createColonne The create colonne class.
	 */
	public MainController(Connexion connexion, Create create, Rename rename, MainPanel mainPanel, 
			TitleBar titleBar, PanelQuery panelQuery, Interface interf, InformationBar informationBar, Profil profil, ProfilPanel profilPanel, ModifPassword modifPassword,SetAutoSave setAutoSave, CreateColonne createColonne) {
		
		this.connexion = connexion;
		this.create = create;
		this.rename = rename;
		this.mainPanel = mainPanel;
		this.titleBar = titleBar;
		this.panelQuery = panelQuery;
		this.interf = interf;
		this.informationBar = informationBar;
		this.profil = profil;
		this.profilPanel = profilPanel;
		this.modifPassword = modifPassword;
		this.setAutoSave = setAutoSave;
		this.createColonne = createColonne;
		
		this.con = new ConnexionJDBC();
		this.saveFile = new SaveFileJDBC(panelQuery);
		this.openFile = new OpenFileJDBC(panelQuery);
		this.createTable = new CreateTableJDBC(con);
		this.changePassword = new ChangePasswordJDBC(con, modifPassword);
		this.renameTableJDBC = new RenameTableJDBC(con, rename);
		
		
		
		this.mouseListenerJFrame = new MouseListenerJFrame(interf, interf.getPosX(), interf.getPosX());
		this.mouseMotionListenner = new MouseMotionListenner(interf);
		iniJFrame();
		
		this.controllerConnexion = new ControllerConnexion(connexion,interf,titleBar,mainPanel,panelQuery, informationBar, con);
		initConnexion();
		this.controllerCreate = new ControllerCreate(create,interf, panelQuery, informationBar, mainPanel, titleBar, createColonne, createTable);
		initCreate();
		this.controllerRename = new ControllerRename(rename,interf, panelQuery, informationBar, mainPanel, titleBar, renameTableJDBC);
		initRename();
		this.controllerMainPanel = new ControllerMainPanel(mainPanel,interf,create,titleBar,rename, profil, saveFile, con, panelQuery, openFile);
		initMainPanel();
		this.controllerTitleBar = new ControllerTitleBar(titleBar,interf);
		initTitleBar();
		this.controllerPanelQuery = new ControllerPanelQuery(panelQuery,interf);
		initPanelQuery();
		this.controllerProfil = new ControllerProfil(mainPanel, interf, titleBar, profil, panelQuery, informationBar, connexion, profilPanel);
		initControllerProfil();
		this.controllerQuery = new ControllerQuery(connexion, interf, titleBar, panelQuery, con);
		initControllerQuery();
		this.controllerAutoSave = new ControllerAutoSave(connexion, profil, saveFile, mainPanel, setAutoSave);
		initControllerAutoSave();
		this.controllerSetAutoSave = new ControllerSetAutoSave(setAutoSave, connexion, titleBar, mainPanel, panelQuery, informationBar, interf);
		initControllerSetAutoSave();
		this.controllerProfilPanel = new ControllerProfilPanel(profilPanel, interf, mainPanel, titleBar, modifPassword, setAutoSave);
		initControllerProfilPanel();
		this.controllerChangePassword = new ControllerChangePassword(connexion, modifPassword, changePassword);
		initControllerChangePassword();
		
	}
	
	/**
	 * This method initializes all the controllers of the connection class.
	 */
	public void initConnexion() {
		this.connexion.getUserLog().addFocusListener(controllerConnexion);
		this.connexion.getPassLog().addFocusListener(controllerConnexion);
		this.connexion.getDataNameLog().addFocusListener(controllerConnexion);
		this.connexion.getConnect().addActionListener(controllerConnexion);
		this.connexion.getConnect().addMouseListener(controllerConnexion);
		this.connexion.getSubscribe().addMouseListener(controllerConnexion);
		this.connexion.getUserSub().addFocusListener(controllerConnexion);
		this.connexion.getPassSub().addFocusListener(controllerConnexion);
		this.connexion.getConfirmPassSub().addFocusListener(controllerConnexion);
		this.connexion.getDataNameSub().addFocusListener(controllerConnexion);
		this.connexion.getSubscribe().addActionListener(controllerConnexion);
		
	}
	
	/**
	 * This method initializes all the controlers of the create class.
	 */
	public void initCreate() {
		this.create.getNewTableName().addFocusListener(controllerCreate);
		this.create.getConfirmer().addActionListener(controllerCreate);
		this.create.getAnnuler().addActionListener(controllerCreate);
		this.createColonne.getContinuer().addActionListener(controllerCreate);
		
	}
	
	/**
	 * This method initializes all the controlers of the rename class.
	 */
	public void initRename() {
		this.rename.getOldTableName().addFocusListener(controllerRename);
		this.rename.getNewTableName().addFocusListener(controllerRename);
		this.rename.getConfirmer().addActionListener(controllerRename);
		this.rename.getAnnuler().addActionListener(controllerRename);
	}
	
	/**
	 * This method initializes all controlers of the mainPanel class.
	 */
	public void initMainPanel() {
		this.mainPanel.getCreate().addActionListener(controllerMainPanel);
		this.mainPanel.getOpen().addActionListener(controllerMainPanel);
		this.mainPanel.getSave().addActionListener(controllerMainPanel);
		this.mainPanel.getSaveAs().addActionListener(controllerMainPanel);
		this.mainPanel.getCreate().addActionListener(controllerMainPanel);
		this.mainPanel.getRename().addActionListener(controllerMainPanel);
		this.mainPanel.getDisconnect().addActionListener(controllerMainPanel);
		this.mainPanel.getConsol().addActionListener(controllerMainPanel);
		this.mainPanel.getRefresh().addActionListener(controllerMainPanel);
		this.mainPanel.getOpen().addActionListener(controllerMainPanel);
		this.mainPanel.getDisconnect().addMouseListener(controllerMainPanel);
		this.mainPanel.getRefresh().addMouseListener(controllerMainPanel);

	}
	
	/**
	 * This method initializes all the controlers of the initTitleBar class.
	 */
	public void initTitleBar() {
		this.titleBar.getExit().addActionListener(controllerTitleBar);
		this.titleBar.getExtend().addActionListener(controllerTitleBar);
		this.titleBar.getReduce().addActionListener(controllerTitleBar);
		this.titleBar.getExit().addMouseListener(controllerTitleBar);
	}
	
	/**
	 * This method initializes all the controlers of the panelQuery class.
	 */
	public void initPanelQuery() {
		this.panelQuery.getExecute().addActionListener(controllerPanelQuery);
	}
	
	/**
	 * This method initializes all the controlers of the class iniFrame
	 */
	public void iniJFrame() {
		this.titleBar.addMouseListener(mouseListenerJFrame);
		this.titleBar.addMouseMotionListener(mouseMotionListenner);
	}
	
	/**
	 * This method initializes all the controlers of the profile class.
	 */
	public void initControllerProfil(){
		this.profil.getHome().addActionListener(controllerProfil);
		this.profil.getHome().addMouseListener(controllerProfil);
		this.profil.getSetting().addMouseListener(controllerProfil);
		this.profil.getSetting().addActionListener(controllerProfil);
		this.profil.getDisconnect().addMouseListener(controllerProfil);
		this.profil.getDisconnect().addActionListener(controllerProfil);
	}
	
	/**
	 * This method initializes all the controlers of the query class.
	 */
	public void initControllerQuery(){
		this.panelQuery.getExecute().addActionListener(controllerQuery);
	}
	
	/**
	 * This method initializes all controlers of the autoSave class.
	 */
	public void initControllerAutoSave() {
		this.connexion.getConnect().addActionListener(controllerAutoSave);
		this.profil.getDisconnect().addActionListener(controllerAutoSave);
		this.mainPanel.getSave().addActionListener(controllerAutoSave);
		this.mainPanel.getSaveAs().addActionListener(controllerAutoSave);
	}
	
	/**
	 * This method initializes all controlers of the save class
	 */
	public void initControllerSetAutoSave() {
		this.setAutoSave.getConfirmer().addActionListener(controllerSetAutoSave);
		this.setAutoSave.getTmp().addFocusListener(controllerSetAutoSave);
	}
	
	/**
	 * This method initializes all controlers of the profilePanel class
	 */
	public void initControllerProfilPanel() {
		this.profilPanel.getMdp().addActionListener(controllerProfilPanel);
		this.profilPanel.getAutoSave().addActionListener(controllerProfilPanel);
	}
	
	/**
	 * This method sets the connection.
	 * @param con The connexionJDBC class.
	 */
	public void setConnexion(ConnexionJDBC con) {
		this.con = con;
	}

	/**
	 * This method initializes all the controlers of the class changePassword
	 */
	public void initControllerChangePassword(){
		this.modifPassword.getConfirmer().addActionListener(controllerChangePassword);
	}
}
