/**
 *
 */
package jeux;

import java.util.HashMap;

import Carte.CarteBridge;
import joueur.JoueurBridge;
import paquetDeCarte.PaquetDeCarteBridge;
import paquetDeCarte.jeuDeCarteBridge;

/**
 *
 * @author guillaume
 *
 */
/**
 * @author guillaume
 *
 */
public class Bataille {

	private static final jeuDeCarteBridge jeu = new jeuDeCarteBridge(32);

	public static void main(String[] args) {
		JoueurBridge j = new JoueurBridge("test");
		j.rammasser(jeu);
		j.afficher();
//		Bataille bat = new Bataille("test", "test");
	}

	private PaquetDeCarteBridge carteEnJeu;
	private JoueurBridge vainqueur;
	private JoueurBridge j1;

	private JoueurBridge j2;
	private int nbcoup;
	private jeuDeCarteBridge pioche;
	private HashMap<Integer, PaquetDeCarteBridge> coupsMap;

	/**
	 * Permet d'initier une table de Jeu pour la bataille
	 * @param nomj1 le nom du joueur 1
	 * @param nomj2 le nom du joueur 2
	 */
	public Bataille(String nomj1, String nomj2) {
		this.setJ1(new JoueurBridge(nomj1));
		this.setJ2(new JoueurBridge(nomj2));
		this.setVainqueur(new JoueurBridge("Vainqueur"));
		j1.afficher();
		j2.afficher();
		carteEnJeu.afficher();
		this.nouvellePartie();
	}

	/**
	 * @return the coupsMap
	 */
	public HashMap<Integer, PaquetDeCarteBridge> getCoupsMap() {
		return coupsMap;
	}

	/**
	 * @return the nbcoup
	 */
	public int getNbcoup() {
		return nbcoup;
	}

	/**
	 * @return the vainqueur
	 */
	public JoueurBridge getVainqueur() {
		return vainqueur;
	}

	/**
	 * demmarre la partie
	 */
	public void jouerPartie() {
		while (estTerm() == false) {
			this.tirerCarteJoueurs();
			this.incrementeCoup();
			this.coupBataille();
		}
		if (j1.getNb_carte() == 0) {
			vainqueur = j1;
		} else {
			vainqueur = j2;
		}
	}

	/**
	 * Parmet de initialiser le jeu pour une nouvelle partie
	 */
	public void nouvellePartie() {
		this.setCarteEnJeu(new PaquetDeCarteBridge());
		this.setPioche(jeu);
		setNbcoup(0);
		this.j1.rammasser(pioche.distribuer(16));
		this.j2.rammasser(pioche.distribuer(16));
		coupsMap = new HashMap<>();
	}

	private void coupBataille() {
		gagnantCoup();
	}

	/**
	 * Renvoie le gagnant du dernier coup
	 * 1 : J1
	 * 2 : J2
	 * 0 : égalité
	 */
	private int gagnantCoup() {
		CarteBridge c1,c2; // c1 = carte du j1, c2 carte du j2
		c2 = carteEnJeu.tirerCarte();
		c1 = carteEnJeu.tirerCarte();
		if (c1.getValeur() > c2.getValeur()) {
			return 1;
		}
		else if (c1.getValeur() < c2.getValeur()) {
			return 2;
		}
		else {
			return 0;
		}
	}

	/**
	 * Permet de tirer une carte à chaque joueur et de le mettre dans carteEnJeu
	 */
	private void tirerCarteJoueurs() {
		carteEnJeu.ajouterCarte(j1.tirerCarte());
		carteEnJeu.ajouterCarte(j2.tirerCarte());
	}
	
	private boolean estTerm() {
		return (j2.getNb_carte() != 0 && j1.getNb_carte() != 0);
	}
	
	/**
	 * Permet d'incrementer le nb de coup
	 */
	private void incrementeCoup() {
		this.nbcoup++;
	}

	/**
	 * @param carteEnJeu the carteEnJeu to set
	 */
	private void setCarteEnJeu(PaquetDeCarteBridge carteEnJeu) {
		this.carteEnJeu = carteEnJeu;
	}

	/**
	 * @param j1 the j1 to set
	 */
	private void setJ1(JoueurBridge j1) {
		this.j1 = j1;
	}

	/**
	 * @param j2 the j2 to set
	 */
	private void setJ2(JoueurBridge j2) {
		this.j2 = j2;
	}

	/**
	 * @param nbcoup the nbcoup to set
	 */
	private void setNbcoup(int nbcoup) {
		this.nbcoup = nbcoup;
	}

	/**
	 * @param pioche the pioche to set
	 */
	private void setPioche(jeuDeCarteBridge pioche) {
		this.pioche = pioche;
	}

	/**
	 * @param vainqueur the vainqueur to set
	 */
	private void setVainqueur(JoueurBridge vainqueur) {
		this.vainqueur = vainqueur;
	}
}
