package vue;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import controleur.Profil;

public class AfficherProfil extends JPanel
{
	private JTextArea txtInfos = new JTextArea();

	public AfficherProfil(Profil unProfil)
	{
		this.setBounds(20, 20, 200, 200);
		this.setBackground(Color.red);
		this.setLayout(null);
		
		this.txtInfos .setBounds(20, 20, 0, 700);
		this.add(this.txtInfos);
		this.txtInfos.setText(
			"---- Infos du profil ----\n"+
			" Nom :"+unProfil.getNom()+"\n"+
			" Prenom :"+unProfil.getPrenom()+"\n"+
		 
			"---------------------------\n"
		);
		this.txtInfos.setEditable(false);
		this.setVisible(false);
	}
}
