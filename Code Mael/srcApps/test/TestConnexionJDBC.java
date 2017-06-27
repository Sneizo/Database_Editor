package test;

import org.junit.*; 
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import model.ConnexionJDBC;

public class TestConnexionJDBC {

	 @Test()
	  public void testConnexion() {
		ConnexionJDBC con = new ConnexionJDBC();
	    assertFalse(con.getConnect());
	    con.connexion("SYSTEM", "L4kjR3Xzo", "Database");
	    assertTrue(con.getConnect()); 
	    assertEquals(con, con);
	  }
	 
	 @Test()
	  public void testDeconnexion() {
		ConnexionJDBC con = new ConnexionJDBC();
	    con.connexion("SYSTEM", "L4kjR3Xzo", "Database");
	    assertTrue(con.getConnect());
	    try {
			con.deconnexion();
		} catch (SQLException e) {
			System.out.println("ERREUR : TestConnexionJDBC.testDeconnexion()");
		}
	    
	    assertFalse(con.getConnect());
	  }
	 
}

