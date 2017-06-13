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
		ImageIcon image =  new ImageIcon("C:/Users/user/Pictures/Capture22.JPG");
		JLabel titre = new JLabel(image);
		titre.setBounds(340, 45, 320, 150);
		this.add(titre);
		ImageIcon logo = new ImageIcon("C:/Users/user/Pictures/407.JPG");
		this.setIconImage(logo.getImage());
		this.getContentPane().setBackground(new Color(152,0,0));
		this.setVisible(true);
	}
	
}
