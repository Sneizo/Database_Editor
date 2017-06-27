package test;

import org.junit.*; 
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import model.ConnexionJDBC;
import model.CreateTableJDBC;

public class TestCreateTableJDBC {

	 @Test()
	  public void testCreateTable() {
		ConnexionJDBC con = new ConnexionJDBC();
		con.connexion("SYSTEM", "L4kjR3Xzo", "Database");
		CreateTableJDBC create = new CreateTableJDBC(con);
		assertTrue(create.getExiste());
		assertFalse(create.getExecute());
		create.createTable("JUnit");
		assertFalse(create.getExiste());
		create.createTable("JUnit");
		assertTrue(create.getExiste());
	  }
	 
	 @Test()
	  public void testCreateColonne() {
		ConnexionJDBC con = new ConnexionJDBC();
		con.connexion("SYSTEM", "L4kjR3Xzo", "Database");
		CreateTableJDBC create = new CreateTableJDBC(con);
		create.createColonne("JUnit", "col", "NUMBER");
		assertFalse(create.getExecute());
		create.createColonne("JUnit", "col", "");
		assertFalse(create.getExecute());
	 }
	 
}

