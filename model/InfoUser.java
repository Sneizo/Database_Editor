package model;


public class InfoUser {
	
	private HashMap<String,User> listeUtilisateur;
	
	
	public InfoUser() {
		this.listeUtilisateur = new HashMap<String,User>();
	}
	
	public void addUser(User user) {
		
		boolean existe = false;
		
		for (String login : this.listeUtilisateur.keySet()) {
				if(login.equals(user.getLogin())) {
					existe = true;
				}
		 }
		 
		 if(!existe) {
			listeUtilisateur.put(user.getLogin(),user);
		 }
	 }
	 
	public void setListeUtilisateur(HashMap<String,User> liste) {
		if(liste != null) {
			this.listeUtilisateur = liste;
		}
	}
	
	public HashMap<String,User> getlisteUtilisateur() {
		return this.listeUtilisateur;
	}
}
	
