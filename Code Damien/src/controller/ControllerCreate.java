package controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JPanel;
import model.CreateTableJDBC;
import view.Create;
import view.CreateColonne;
import view.InformationBar;
import view.Interface;
import view.MainPanel;
import view.PanelQuery;
import view.TitleBar;


/**
 * This class manages the control of the creation of tables.
 * @author Mael and Damien
 *
 */
public class ControllerCreate implements FocusListener, ActionListener {

	private Create create;
	private Interface interf;
	private PanelQuery panelQuery;
	private InformationBar informationBar;
	private MainPanel mainPanel;
	private TitleBar titleBar;
	private CreateColonne createColonne;
	private CreateTableJDBC createTable;
	private int i = 0;
	private int val;
	private String nomTable;

	/**
	 * The constructor of the class.
	 * @param create The create class.
	 * @param interf The main frame.
	 * @param panelQuery The panelQuery class.
	 * @param informationBar The InformationBar class.
	 * @param mainPanel The mainPanel class.
	 * @param titleBar The titleBar class.
	 * @param createColonne The createColonne class.
	 * @param createTable The createTable class.
	 */
	public ControllerCreate(Create create, Interface interf, PanelQuery panelQuery, InformationBar informationBar,
			MainPanel mainPanel, TitleBar titleBar, CreateColonne createColonne, CreateTableJDBC createTable) {
		this.create = create;
		this.interf = interf;
		this.informationBar = informationBar;
		this.panelQuery = panelQuery;
		this.titleBar = titleBar;
		this.mainPanel = mainPanel;
		this.createColonne = createColonne;
		this.createTable = createTable;
	}

	/**
	 * Manage focus on graphical components.
	 */
	public void focusLost(FocusEvent fe) {

	}

	/**
	 * Manage focus on graphical components.
	 */
	public void focusGained(FocusEvent fe) {
		if (fe.getSource() == this.create.getNewTableName()) {

		}
	}

	/**
	 * Performs an action if the button pressed is the reference button.
	 */
	public void actionPerformed(ActionEvent ae) {

		if (ae.getSource() == this.create.getConfirmer()) {

			if (!this.create.getNewTableName().getText().equals("")) {
				if (!this.create.getNbCol().getText().equals("")) {
					if (Integer.parseInt(this.create.getNbCol().getText()) >= 1) {
						i = 0;

						this.nomTable = this.create.getNewTableName().getText();
						this.createTable.createTable(this.nomTable);
						val = Integer.parseInt(this.create.getNbCol().getText());
						this.create.getNewTableName().setText("");
						this.create.getNbCol().setText("");

						if (!this.createTable.getExiste()) {
							JPanel frame = new JPanel();
							frame.setLayout(new BorderLayout());
							frame.add(titleBar, BorderLayout.NORTH);
							frame.add(createColonne, BorderLayout.CENTER);

							interf.setPanel(frame);
						}

					} else if (Integer.parseInt(this.create.getNbCol().getText()) == 0) {
						i = 0;
						this.nomTable = this.create.getNewTableName().getText();
						this.createTable.createTable(this.nomTable);
						val = Integer.parseInt(this.create.getNbCol().getText());
						this.create.getNewTableName().setText("");
						this.create.getNbCol().setText("");

						initFrame();
					}
				} else {
					System.out.println("ERREUR : ControllerCreate.actionPerformed();");
				}
			}

		}

		if (ae.getSource() == this.createColonne.getContinuer()) {
			if (!this.createColonne.getNameF().getText().equals("")) {
				if (!this.createColonne.getTypeF().getText().equals("")) {
					// si i = val-1 il n'y a plus de colonnes a créer
					if (this.i < this.val - 1) {
						this.createTable.createColonne(this.nomTable, this.createColonne.getNameF().getText(),
								this.createColonne.getTypeF().getText());
						this.createColonne.getNameF().setText("");
						this.createColonne.getTypeF().setText("");
						if (this.createTable.getExecute() == true) {
							this.i++;
						}

					} else {
						this.createTable.createColonne(this.nomTable, this.createColonne.getNameF().getText(),
								this.createColonne.getTypeF().getText());
						this.createColonne.getNameF().setText("");
						this.createColonne.getTypeF().setText("");
						if (this.createTable.getExecute() == true) {
							this.i = 0;
							initFrame();
						}
					}
				}
			}
		}

		if (ae.getSource() == this.create.getAnnuler()) {
			initFrame();
		}
	}

	private void initFrame() {
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
