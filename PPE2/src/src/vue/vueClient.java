package vue;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controleur.Client;
import modele.ModeleClient;

public class vueClient extends JPanel implements ActionListener, MouseListener
{
	private JTable uneTable;
	public vueClient()
	{
		this.setBounds(20, 20, 250, 200);
		this.setBackground(Color.cyan);
		this.setLayout(null);
		
		String entete[]={"NUM_CLIENT","NOM_client","PRENOM_CLIENT","ADRESSE_EMAIL"};
		this.uneTable=new JTable(this.remplirDonnees(),entete);
		JScrollPane uneScroll=new JScrollPane(this.uneTable);
		uneScroll.setBounds(20,20,200,400);
		this.add(uneScroll);
		
		//ajout ecoute évenement de la souris sur le JTable
		this.uneTable.addMouseListener(this);
		
		this.setVisible(true);
	}
	
	public Object[][] remplirDonnees()
	{
		ArrayList<Client> lesClients = ModeleClient.selectAll();
		Object donnees [][] = new Object[lesClients.size()][4];
		int i=0;
		for(Client unClient : lesClients)
		{
			donnees[i][0]=unClient.getIdClient();
			donnees[i][1]=unClient.getNom();
			donnees[i][2]=unClient.getPrenom();
			donnees[i][3]=unClient.getAdresse();
			i++;
		}
		return donnees;
	}
	public void actionPerformed(ActionEvent e) {
		
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {

		int lg = this.uneTable.getSelectedRow();
		int cl = this.uneTable.getSelectedColumn();
		int idClient = Integer.parseInt(this.uneTable.getValueAt(lg, 0).toString());
		String nom = this.uneTable.getValueAt(lg, 1).toString();
		String prenom = this.uneTable.getValueAt(lg, 2).toString();
		String adresse = this.uneTable.getValueAt(lg, 3).toString();
		
		Client unClient = new Client(idClient, nom, prenom, adresse);
		
		vueEditClient.remplir(unClient);
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
