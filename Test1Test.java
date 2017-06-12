import org.junit.*; 
import static org.junit.Assert.*; 
public class Test1Test { 
  //contructeur 
  public Test1Test(String name){ 
    super(name); 
  }
  @Test() 
  public void testEquals() { 
    Test1 premier = new Test1(12,15);
    Test1 second = new Test1(14,14); 
    assertTrue(premier.equals()); 
    assertTrue(second.equals()); 
    assertEquals(premier, second);
    assertEquals(premier, premier);
  }
}
