package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


import model.OpenFileJDBC;
import view.PanelQuery;

public class TestOpenFile {

	
	 @Test()
	  public void testOpenFile() {
		 PanelQuery pane = new PanelQuery();
		OpenFileJDBC open = new OpenFileJDBC(pane);
		assertFalse(open.getOpen());
		open.readFile();
		assertTrue(open.getOpen());

	  }
}
