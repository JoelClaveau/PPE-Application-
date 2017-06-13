package modele;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controleur.Profil;

public class Modele 
{
	public static ArrayList<Profil> selectAll()
	{
		String requete = "select*from client;";
		ArrayList<Profil> lesProfils = new ArrayList<Profil>();
		
		try
		{
			BDD uneBdd = new BDD("localhost","Castellanne","root","");
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet unRes= unStat.executeQuery(requete);
			while(unRes.next()) //tant qu'il ya un tuple
			{
				String pseudo = unRes.getString("PSEUDO");
				String email = unRes.getString("ADRESSE_EMAIL");
				String nom = unRes.getString("NOM_CLIENT");
				String prenom = unRes.getString("PRENOM_CLIENT");
				String adresse = unRes.getString("adresse");
				String mdp = unRes.getString("mdp");
				Profil unProfil = new Profil(pseudo, email, nom, prenom, adresse, mdp);
				lesProfils.add(unProfil);
			}
			unStat.close();
			unRes.close();
			uneBdd.seDeconnecter();
		}
		catch(SQLException exp)
		{
			System.out.println("Erreur d'execution de "+requete);
		}
		return lesProfils;
	}
	
	public static Profil verifConnexion (String NUM_CLIENT, String mdp)
	{
		Profil unProfil = null;
		String requete = "select * from profil"+" where NUM_CLIENT ='"+NUM_CLIENT+"' and mdp ='"+mdp+"';";
		System.out.println(requete);
		
		try{
			BDD uneBdd = new BDD("localhost","Castellane","root","");
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			if(unRes.next())
			{
				String ADRESSE_EMAIL = unRes.getString("ADRESSE_EMAIL");
				String NOM_CLIENT = unRes.getString("NOM_CLIENT");
				String PRENOM_CLIENT = unRes.getString("PRENOM_CLIENT");
				String adresse = unRes.getString("adresse");
				unProfil = new Profil(NUM_CLIENT, ADRESSE_EMAIL, NOM_CLIENT, PRENOM_CLIENT, mdp,adresse);
			}
			uneBdd.seDeconnecter();
			unStat.close();
			unRes.close();
		}
		catch(SQLException exp)
		{
			System.out.println("Erreur d'execution de "+requete);
		}
		return unProfil;
	}
	
}
