package view;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import controler.CloseButtonListener;


/**
 * Define a TabbedPane, used to display all the InformationPanel
 * @author Daphnis
 *
 */
public class TabbedPane extends JTabbedPane {

	/**
	 * Serialization ID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor, update the preferred size to the size of an InformationPanel 
	 * and remove the border
	 */
	public TabbedPane() {

		this.setBorder(null);
		this.setPreferredSize(new PanelQuery().getPreferredSize());
		System.out.println("TESSST");
		
		
	}

	/**
	 * return the selected component if it is a InformationPanel
	 * else return null
	 */
	@Override
	public PanelQuery getSelectedComponent() {
		PanelQuery panel = null;
		if (super.getSelectedComponent() instanceof PanelQuery)
			panel = (PanelQuery) super.getSelectedComponent();
		return panel;
	}

	/**
	 * Get the InformationPanel at the selected index, if it not a InformationPanel
	 * it returns null
	 */
	@Override
	public PanelQuery getComponentAt(int index) {
		PanelQuery panel = null;
		if (super.getComponentAt(index) instanceof PanelQuery)
			panel = (PanelQuery) super.getComponentAt(index);
		return panel;
	}

	/**
	 * Set the title of the component at the index specified
	 */
	@Override
	public void setTitleAt(int index, String title) {
		if (this.getComponentAt(index) != null)
			((JLabel) ((Container) this.getTabComponentAt(index)).getComponent(0)).setText(title + "   ");
		this.getTabComponentAt(index).revalidate();
	}


	/**
	 * Add a new InformationPanel to the TabbedPane
	 * @param component the InformationPanel to add
	 */
	public void addTab(PanelQuery component) {
		if (component != null) {
			super.add(component);

			int index = this.indexOfComponent(component);

			JPanel titleTab = new JPanel(new BorderLayout());

			JLabel titleLabel = new JLabel("   ");
			JLabel closeButton = new JLabel();
			closeButton.addMouseListener(new CloseButtonListener(closeButton, this));

			titleTab.setOpaque(false);
			titleLabel.setOpaque(false);
			closeButton.setOpaque(false);

			titleTab.add(titleLabel, BorderLayout.WEST);
			titleTab.add(closeButton, BorderLayout.EAST);

			this.getSelectedComponent().requestFocus();
			this.setTabComponentAt(index, titleTab);
			this.setSelectedComponent(component);
		}
	}
	

	/**
	 * Remove the currently displayed InformationPanel
	 */
	public void closeCurrent() {
		if (this.getSelectedComponent() != null)
			if (JOptionPane.showConfirmDialog(null, "Fermer l'onglet") == JOptionPane.YES_OPTION)
				this.remove(this.getSelectedComponent());
	}

	/**
	 * Close all the InformationPanel in the TabbedPane
	 */
	public void closeAll() {
		if (this.getSelectedComponent() != null)
			if (JOptionPane.showConfirmDialog(null, "Fermer tous les onglets") == JOptionPane.YES_OPTION)
				this.removeAll();
	}

	

}
