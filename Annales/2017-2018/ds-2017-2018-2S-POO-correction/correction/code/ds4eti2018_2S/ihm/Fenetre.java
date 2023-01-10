package ds4eti2018_2S.ihm;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import ds4eti2018_1S.modele.Case;
import ds4eti2018_1S.modele.Jeu;
import ds4eti2018_1S.modele.Plateau;

public class Fenetre extends JFrame {

	private static final int CASE_SIZE = 50;
	
	private Jeu jeu;
	private JComboBox<Integer> jcbNb;
	private JComboBox<Integer> jcbCol;
	private JComboBox<Integer> jcbLigne;
	
	private JLabel lInfo = new JLabel("C'est au tour du joueur 1");
	private Container grille = new JPanel();
	
	private ArrayList<ArrayList<Case>> cases;
	private boolean perdu = false;
	
	public Fenetre(){
		super("Mon super démineur");
		initDialogue();
	}

	private void initDialogue() {
		perdu = false;
		getContentPane().removeAll();
		jcbNb  = new JComboBox<Integer>();
		jcbLigne = new JComboBox<Integer>();
		jcbCol = new JComboBox<Integer>();
		setSize(400,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = this.getContentPane();
		for(int i=1;i<=Jeu.MAX_JOUEURS;i++){jcbNb.addItem(new Integer(i));}
		JLabel jlc = new JLabel("Nombre de joueurs:");
		jlc.setLabelFor(jcbNb);
		jlc.setDisplayedMnemonic('N');
		
		for(int i=Plateau.MIN_COL;i<=Plateau.MAX_COL+1;i++){jcbCol.addItem(new Integer(i));}
		JLabel jlCol = new JLabel("Nombre de colonnes:");
		jlCol.setLabelFor(jcbCol);
		jlCol.setDisplayedMnemonic('c');
		
		for(int i=Plateau.MIN_LIGNE;i<=Plateau.MAX_LIGNE+1;i++){jcbLigne.addItem(new Integer(i));}
		JLabel jlLignes = new JLabel("Nombre de lignes:");
		jlLignes.setLabelFor(jcbLigne);
		jlLignes.setDisplayedMnemonic('l');
		
		JButton btGo = new JButton("C'est parti!");
		btGo.setMnemonic('p');
		btGo.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				init();				
			}
		});
		

		JButton btExit = new JButton("Quitter");
		btExit.setMnemonic('Q');
		btExit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);				
			}
		});
		c.setLayout(new GridLayout(4,2));
		c.add(jlc);
		c.add(jcbNb);
		c.add(jlCol);
		c.add(jcbCol);
		c.add(jlLignes);
		c.add(jcbLigne);
		c.add(btGo);
		c.add(btExit);
		
		setVisible(true);
	}

	private void init() {
		int nbJoueurs = jcbNb.getItemAt(jcbNb.getSelectedIndex()).intValue();
		int nbCol = jcbCol.getItemAt(jcbCol.getSelectedIndex()).intValue();
		int nbLigne = jcbLigne.getItemAt(jcbLigne.getSelectedIndex()).intValue();
		
		jeu = new Jeu(nbLigne,nbCol, nbJoueurs);
		cases = jeu.getCases();
		
		getContentPane().removeAll();
		grille.removeAll();
		grille.setLayout(new GridLayout(nbLigne,nbCol));
		
		for(ArrayList<Case> ligne:cases){
			for(Case c:ligne){
				JButton bt = new JButton();
				//currentCase = c;//à cause du listener interne
				bt.addActionListener(new ListenerBt(c));
				bt.setPreferredSize(new Dimension(Fenetre.CASE_SIZE,Fenetre.CASE_SIZE));
				grille.add(bt);
			}
		}
		Container cont = getContentPane();
		cont.setLayout(new BorderLayout());
		cont.add(grille, BorderLayout.NORTH);
		cont.add(lInfo,BorderLayout.SOUTH);
		pack();
	}


	private void refresh(){
		int i=0;
		boolean gagne = true;
		for(ArrayList<Case> ligne:cases){
			for(Case c:ligne){
				Component bt = grille.getComponent(i);
				i++;
				if(c.isVisible()){
					bt.setEnabled(false);
					bt.setBackground(c.getCouleur());
					((JButton)(bt)).setText(c.toString());
				}
				else{gagne=false;}
			}
		}
		if(perdu){
			JOptionPane.showMessageDialog(this,"le joueur "+jeu.getJoueur()+"a perdu");
			initDialogue();
		}
		else if(gagne){
			JOptionPane.showMessageDialog(this,"le joueur "+jeu.getJoueur()+"a gagné");
			initDialogue();
		}
		else{
			jeu.nextJoueur();
			lInfo.setText("C'est au tour du joueur "+jeu.getJoueur());
		}
	}

	private class ListenerBt implements ActionListener {

		private Case c;
		public ListenerBt(Case c) {
			this.c = c;
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(!c.isVisible()){
				perdu=c.processAction(jeu.getCases());
				refresh();
			}
		}
	}

}
