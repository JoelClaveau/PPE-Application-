package vue;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controleur.Main;
import controleur.Profil;
import modele.Modele;

public class VueProfil extends JPanel implements ActionListener, KeyListener
{
	private JButton btAnnuler = new JButton("Annuler", new ImageIcon("src/image/logout.png"));
	private JButton btConnecter = new JButton("Se Connecter");
	private JTextField txtPseudo = new JTextField();
	private JPasswordField txtMdp = new JPasswordField();
	public VueProfil()
	{
		this.setBounds(150, 80, 250, 100);
		this.setLayout(new GridLayout(3,2));
		this.setBackground(new Color(223,242,255));
		this.add(new JLabel("Pseudo: "));
		this.add(this.txtPseudo);
		this.add(new JLabel("Mdp: "));
		this.add(this.txtMdp);
		this.add(this.btAnnuler);
		this.add(this.btConnecter);
		
		Font police = new Font("Helveltica",Font.ITALIC, 19); //police taille
		this.btAnnuler.setFont(police);
		this.btAnnuler.setText("Annuler");
		
		this.btAnnuler.addActionListener(this); //rendre cliquable les boutons
		this.btConnecter.addActionListener(this);
		
		this.txtMdp.addKeyListener(this);
		this.txtPseudo.addKeyListener(this);
		
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) //recevoir l'evenement e
	{
		if(e.getSource()==this.btAnnuler)
		{
			this.txtMdp.setText("");
			this.txtPseudo.setText("");
		}
		else if(e.getSource()==this.btConnecter)
		{
			this.traitement();
			
			
		}
	}
	public void traitement()
	{
		String pseudo = this.txtPseudo.getText(); // on recupere le pseudo
		String mdp = new String(this.txtMdp.getPassword());
		Profil unProfil = Modele.verifConnexion(pseudo, mdp);
		if(unProfil==null)
		{
			JOptionPane.showMessageDialog(this, "Erreur de connexion !");
		}
		else
		{
			JOptionPane.showMessageDialog(this, "Vous etes "+ " Connectes avec \n"+unProfil.getNom()+" "+ unProfil.getPrenom());
			new vueGenerale(unProfil);
			Main.rendreVisible(false);
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER){
			this.traitement();
		}
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
