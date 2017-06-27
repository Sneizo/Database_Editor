package test;

import org.junit.*;

import model.ConnexionJDBC;
import model.CreateTableJDBC;
import model.CreateUserJDBC;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestCreateUserJDBC {
	
	
	 @Test()
	  public void testCreateUser() {
		CreateUserJDBC create = new CreateUserJDBC("Test", "pass", "pass", "Database");
		assertFalse(create.getConnect());
		assertTrue(create.getCreate());
	  }

}
