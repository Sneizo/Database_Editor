package controller;

import vue.*;

public class MainController {
	
	private Connexion connexion;
	private Create create;
	private Rename rename;
	
	private ControllerConnexion controllerConnexion;
	private ControllerCreate controllerCreate;
	private ControllerRename controllerRename;
	
	public MainController(Connexion connexion, Create create, Rename rename) {
		this.connexion = connexion;
		this.create = create;
		this.rename = rename;
		
		this.controllerConnexion = new ControllerConnexion(connexion);
		initConnexion();
		this.controllerCreate = new ControllerCreate(create);
		initCreate();
		this.controllerRename = new ControllerRename(rename);
		
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
		this.create.getNewTableName().addFocusListener(controllerRename);
		this.create.getConfirmer().addActionListener(controllerRename);
		this.create.getAnnuler().addActionListener(controllerRename);
	}

}
