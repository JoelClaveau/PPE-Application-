package controleur;

public class Profil 
{
	private String  Nom, Prenom;
	private String Identifiant;
	private String MDP;
	
	public Profil( String identifiant, String nom, String prenom, String mdp)
	{
		this.Identifiant = identifiant;
		this.Nom = nom; 
		this.Prenom = prenom; 
		this.MDP = mdp;
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		this.Nom = nom;
	}

	public String getPrenom() {
		return Prenom;
	}

	public void setPrenom(String prenom) {
		this.Prenom = prenom;
	}

	public String getIdentifiant() {
		return Identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.Identifiant = identifiant;
	}

	public String getMdp() {
		return MDP;
	}

	public void setMdp(String mdp) {
		this.MDP = mdp;
	}
	
}