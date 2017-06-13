package vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import controleur.Profil;

public class vueGenerale extends JFrame implements ActionListener
{
	private JMenuBar uneBarre = new JMenuBar();
	private JMenu mnFichier = new JMenu("Fichier");
	private JMenu mnOperations = new JMenu("Operations");
	private JMenu mnAide = new JMenu("Aide");
	private JMenuItem itemQuitter = new JMenuItem("Quitter");
	private JMenuItem itemApropos = new JMenuItem("A propos");
	private JMenuItem ItemLister = new JMenuItem("Lister Clients");
	private vueClient uneVueClient = new vueClient();
	
	private AfficherProfil uneAffichePofil;
	
	private vueEditClient uneVueEditClient = new vueEditClient();
	
	public vueGenerale(Profil unProfil)
	{
		this.setBounds(200, 200, 500, 300);
		this.setLayout(null);
		this.setTitle("Menu general");
		this.uneBarre.add(this.mnFichier);
		this.uneBarre.add(this.mnOperations);
		this.uneBarre.add(this.mnAide);
		this.mnAide.add(this.itemApropos);
		this.mnFichier.add(this.itemQuitter);
		this.mnFichier.add(this.itemApropos);
		
		this.mnOperations.add(this.ItemLister);
		this.uneVueClient.setVisible(false);
		this.add(this.uneVueClient);
		
		this.uneAffichePofil = new AfficherProfil(unProfil);
		this.uneAffichePofil.setVisible(true);
		this.add(this.uneAffichePofil);
		
		//this.add(uneVueClient);
		
		this.add(uneVueEditClient);
		
		this.ItemLister.addActionListener(this);
		this.setJMenuBar(this.uneBarre);
		this.setVisible(true);

	}
	
	

	
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==this.ItemLister)
		{
			this.uneVueClient.setVisible(true);
			this.uneVueEditClient.setVisible(true);
		}
		
		
	}}
