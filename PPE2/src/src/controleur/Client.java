package controleur;

public class Client 
{
	int idClient;
	private String nom, prenom, adresse;
	
	public Client()
	{
		this.idClient=0;
		this.nom=this.prenom=this.adresse="";
	}
	
	public Client(int idClient,String nom, String prenom, String adresse)
	{
		this.idClient=idClient;
		this.nom=nom;
		this.prenom=prenom;
		this.adresse=adresse;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
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

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
}
