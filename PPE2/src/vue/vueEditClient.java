package vue;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controleur.Client;
import modele.ModeleClient;

public class vueEditClient extends JPanel implements ActionListener
{
	private static JTextField txtNom = new JTextField();
	private static JTextField txtPrenom = new JTextField();
	private static JTextField txtAdresse = new JTextField();
	private static JTextField txtIdClient = new JTextField();
	private static JLabel lbNom = new JLabel("Nom : ");
	private static JLabel lbPrenom = new JLabel("Prenom : ");
	private static JLabel lbAdresse = new JLabel("Adresse : ");
	private static JLabel lbIdClient = new JLabel("IdClient : ");
	
	private JButton btSupprimer = new JButton("Supprimer");
	private JButton btModifier = new JButton("Modifier");
	private JButton btAjouter = new JButton("Ajouter");
	
	public vueEditClient()
	{
		this.setBounds(60,220,600,220);
		this.setBackground(Color.red);
		this.setLayout(null);
		
		lbNom.setBounds(20,40,100,20);
		this.add(lbNom);
		
		txtNom.setBounds(140,40,100,20);
		this.add(txtNom);
		
		lbPrenom.setBounds(260,40,100,20);
		this.add(lbPrenom);
		
		txtPrenom.setBounds(380,40,100,20);
		this.add(txtPrenom);
		
		lbAdresse.setBounds(20,80,100,20);
		this.add(lbAdresse);
		
		txtAdresse.setBounds(140,80,100,20);
		this.add(txtAdresse);
		
		lbIdClient.setBounds(260,80,100,20);
		this.add(lbIdClient);
		
		txtIdClient.setBounds(380,80,100,20);
		this.add(txtIdClient);
		
		btSupprimer.setBounds(20,120,100,20);
		this.add(btSupprimer);
		
		btModifier.setBounds(200,120,100,20);
		this.add(btModifier);
		
		btAjouter.setBounds(320,120,100,20);
		this.add(btAjouter);
		
		//rendre les bouton cliquables
		this.btAjouter.addActionListener(this);
		this.btModifier.addActionListener(this);
		this.btSupprimer.addActionListener(this);
		
		this.setVisible(false);
		
		
	}
	public static void remplir(Client unClient)
	{
		txtIdClient.setText(unClient.getIdClient()+"");
		txtIdClient.setEditable(false);
		txtNom.setText(unClient.getNom());
		txtPrenom.setText(unClient.getPrenom());
		txtAdresse.setText(unClient.getAdresse());
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.btAjouter)
		{
			String nom= txtNom.getText();
			String prenom= txtPrenom.getText();
			String adresse= txtAdresse.getText();
			if(nom.equals("") || prenom.equals("")|| adresse.equals(""))
			{
				JOptionPane.showMessageDialog(this, "Echec insertion  ");
			}
			else
			{
				Client unClient = new Client(0,nom,prenom,adresse);	
				ModeleClient.insert(unClient);
				JOptionPane.showMessageDialog(this, "insertion reussie");
			}
			
		}
		else if(e.getSource()==this.btSupprimer)
		{
			int IdClient = Integer.parseInt(txtIdClient.getText());
			ModeleClient.delete(IdClient);
		}
		else if(e.getSource()==this.btModifier)
		{
			
		}
		
	}
	
}
