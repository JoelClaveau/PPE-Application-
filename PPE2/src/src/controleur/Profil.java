package controleur;

public class Profil 
{
	private String pseudo, email, nom, prenom;
	private String mdp, adresse;
	
	public Profil(String pseudo, String email, String nom, String prenom, String mdp, String adresse)
	{
		this.pseudo=pseudo;
		this.email=email;
		this.nom=nom;
		this.prenom=prenom;
		this.mdp=mdp;
		this.adresse=adresse;
	}
	
	public String getPseudo()
	{
		return pseudo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	
	
}
