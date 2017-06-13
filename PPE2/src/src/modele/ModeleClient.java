package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controleur.Client;

public class ModeleClient 
{
	public static ArrayList<Client> selectAll()
	{
		String requete = "select*from client;";
		ArrayList<Client> lesClients = new ArrayList<Client>();
		
		try
		{
			BDD uneBdd = new BDD("localhost","castellane","root","");
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet unRes= unStat.executeQuery(requete);
			while(unRes.next()) //tant qu'il ya un tuple
			{
				int NUM_CLIENT = unRes.getInt("NUM_CLIENT");
				String NOM_CLIENT = unRes.getString("NOM_CLIENT");
				String PRENOM_CLIENT = unRes.getString("PRENOM_CLIENT");
				String ADRESSE_EMAIL = unRes.getString("ADRESSE_EMAIL");
				Client unClient = new Client(NUM_CLIENT, NOM_CLIENT, PRENOM_CLIENT, ADRESSE_EMAIL);
				lesClients.add(unClient);
			}
			unStat.close();
			unRes.close();
			uneBdd.seDeconnecter();
		}
		catch(SQLException exp)
		{
			System.out.println("Erreur d'execution de "+requete);
		}
		return lesClients;
	}
	public static void insert (Client unClient)
	{
		String requete = "insert into Client(NOM_CLIENT,PRENOM_CLIENT,ADRESSE_EMAIL) values('"
				+unClient.getNom()+"';'"+unClient.getPrenom()+"';'"+unClient.getAdresse()+"');";
		
		try
		{
			BDD uneBdd = new BDD("localhost","Castellane","root","");
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch(SQLException exp)
		{
			System.out.println("request Error"+requete);
		}
	}
	
	public static void delete (int NUM_CLIENT)
	{
		String requete = "delete from Client where NUM_CLIENT ="+NUM_CLIENT+";";
		
		try
		{
			BDD uneBdd = new BDD("localhost","Castellane","root","");
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch(SQLException exp)
		{
			System.out.println("request Error"+requete);
		}
	}
}
