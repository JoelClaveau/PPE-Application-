package vue;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Gestion extends JFrame
{
	private VueProfil uneVueProfil = new VueProfil();
	public Gestion()
	{
		this.setTitle("Connexion");
		this.setBounds(200, 200, 900, 370);
		this.setLayout(null);
		this.setResizable(false);
		this.add(this.uneVueProfil);
		ImageIcon fond = new ImageIcon("src/image/407.jpg");
		
		JLabel fond2 = new JLabel (fond);
		fond2.setBounds(0, 0, 900, 370);
		this.getContentPane().add(fond2);
		this.uneVueProfil.setBounds(290, 150, 400, 150);
		
		ImageIcon image =  new ImageIcon("src/image/Capture22.PNG");
		JLabel titre = new JLabel(image);
		titre.setBounds(340, 45, 320, 700);
	
		this.add(titre);
		
		ImageIcon logo = new ImageIcon("src/image/Capture22.JPG");
		this.setIconImage(logo.getImage());
		
		this.setVisible(true);
		
	}
	
}
