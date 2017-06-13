package modele;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Formatter;

import controleur.Profil;




public class Modele 
{
	private static final String Identifiant = null;

	public static ArrayList<Profil> selectAll()
	{
		String requete = "select * from admin;";
		ArrayList<Profil> lesProfils = new ArrayList<Profil>();
		
		try
		{
			BDD uneBdd = new BDD("localhost","castellane2","root","root");
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet unRes= unStat.executeQuery(requete);
			while(unRes.next()) //tant qu'il y a un tuple
			{
				String identifiant = unRes.getString("Identifiant");
				String nom = unRes.getString("Nom");
				String prenom = unRes.getString("Prenom");
				String mdp = unRes.getString("MDP");
				
               Profil unProfil = new Profil(identifiant, nom,prenom, mdp);
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
	
	public static Profil verifConnexion (String identifiant, String mdp)
	{
		Profil unProfil = null;
		String requete = "select * from admin "+" where Identifiant ='"+identifiant+"' and MDP ='"+mdp+"';";
		System.out.println(requete);
		
		try{
			BDD uneBdd = new BDD("localhost","castellane2","root","root");
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			if(unRes.next())
			{
				
				String nom = unRes.getString("NOM");
				String prenom = unRes.getString("PRENOM");
			
				
				 
                unProfil = new Profil(identifiant, nom,prenom, mdp);
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
	
	private static String encryptPassword(String password)
	{
	    String sha1 = "";
	    try
	    {
	        MessageDigest crypt = MessageDigest.getInstance("SHA-1");
	        crypt.reset();
	        crypt.update(password.getBytes("UTF-8"));
	        sha1 = byteToHex(crypt.digest());
	    }
	    catch(NoSuchAlgorithmException e)
	    {
	        e.printStackTrace();
	    }
	    catch(UnsupportedEncodingException e)
	    {
	        e.printStackTrace();
	    }
	    return sha1;
	}

	private static String byteToHex(final byte[] hash)
	{
	    Formatter formatter = new Formatter();
	    for (byte b : hash)
	    {
	        formatter.format("%02x", b);
	    }
	    String result = formatter.toString();
	    formatter.close();
	    return result;
	}
}
