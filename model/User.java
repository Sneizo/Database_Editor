package model;


/**
 * 
 * @author Mael and Damien
 *
 */
public class User {
	
	private String login;
	private String passwd;
	
	public User(String login, String passwd) {
		if(login != null && passwd != null) {
			this.login = login;
			this.passwd = passwd;
		}
	}
	
	public String getLogin() {
		return this.login;
	}
	
	public String getPasswd() {
		return this.passwd;
	}

	/**
	 * @param passwd the passwd to set
	 */
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	
}
