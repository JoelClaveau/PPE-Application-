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
			BDD uneBdd = new BDD("localhost","castellane2","root","root");
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet unRes= unStat.executeQuery(requete);
			while(unRes.next()) //tant qu'il ya un tuple
			{
				int Num = unRes.getInt("NumC");
				String Nom = unRes.getString("NOM");
				String Prenom = unRes.getString("PRENOM");
				 
				String Adresse = unRes.getString("ADRESSE");
			 
				Client unClient = new Client(Num, Nom, Prenom,Adresse);
			 	
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
		String requete = "insert into client(NOM,PRENOM,EMAIL,ADRESSE,TELEPHONE,MDP) values('"
				+unClient.getNom()+"','"+unClient.getPrenom()+"','"+unClient.getEmail()+"','"+unClient.getAdresse()+"','"+unClient.getTel()+"','"+unClient.getMdp()+"');";
		
		try
		{
			BDD uneBdd = new BDD("localhost","castellane2","root","root");
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch(SQLException exp)
		{
			System.out.println("request Error"+requete);
			exp.printStackTrace();
		}
	}
	
	public static void delete (int NumC)
	{
		String requete = "delete from client where NumC ="+NumC+";";
		
		try
		{
			BDD uneBdd = new BDD("localhost","castellane2","root","root");
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
