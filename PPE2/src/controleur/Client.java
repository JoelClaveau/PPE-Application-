package controleur;

public class Client 
{
	int NumC;
	private String NOM, PRENOM, ADRESSE;
	
	public Client()
	{
		this.NumC=0;
		this.NOM=this.PRENOM=this.ADRESSE="";
	}
	
	public Client(int numClient,String nom, String prenom, String adresse)
	{
		this.NumC=numClient;
		this.NOM=nom;
		this.PRENOM=prenom;
		this.ADRESSE=adresse;
	}

	public int getIdClient() {
		return NumC;
	}

	public void setIdClient(int numClient) {
		this.NumC = numClient;
	}

	public String getNom() {
		return NOM;
	}

	public void setNom(String nom) {
		this.NOM = nom;
	}

	public String getPrenom() {
		return PRENOM;
	}

	public void setPrenom(String prenom) {
		this.PRENOM = prenom;
	}

	public String getAdresse() {
		return ADRESSE;
	}

	public void setAdresse(String adresse) {
		this.ADRESSE = adresse;
	}

	public String getTel() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getMdp() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getEmail() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
