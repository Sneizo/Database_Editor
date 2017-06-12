//package vue;
/**
 * 
 */
public class Test1 {
	
	private int valeur1;
	private int valeur2;
	/**
	 * the constructor
	 */
	public Test1(int val1, int val2) {
		this.valeur1 = val1;
		this.valeur2 = val2;
		
	}
	
	/**
	 * the methode save
	 * @return val the value
	 */
	private boolean equals() {
		boolean ret = false;
		if(this.valeur1 == this.valeur2) {
			ret = true;
		}
		return ret;
	}
	

	//public void saveAs() {
	//}
}
