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
 * TODO Le systeme pour passer tout les coups au autre classe
 */
/**
 * @author guillaume
 *
 */
public class Bataille {

	private static final int nbCarteJeu = 32;

	public static void main(String[] args) {
//		Bataille bat = new Bataille("j1", "j2");
//		bat.nouvellePartie();
//		bat.jouerPartie();
//		System.out.println(bat.getVainqueur());
//		System.out.println(bat.getNbcoup());
		jouerPlusieurPartie(10000);
	}

	/**
	 * Permet de jouer plusieur partie
	 * 
	 * @param nbpartie : le nombre de partie à jouer
	 */
	public static void jouerPlusieurPartie(int nbpartie) {
		int totJ1 = 0, totJ2 = 0;
		Bataille bat = new Bataille("1", "2");
		for (int i = 0; i < nbpartie; i++) {
			bat.nouvellePartie();
			bat.jouerPartie();
			if (bat.getVainqueur().getNomJoueur() == "1") {
				totJ1++;
			} else {
				totJ2++;
			}
		}
		System.out.println(totJ1);
		System.out.println(totJ2);

	}

	private PaquetDeCarteBridge carteEnJeu; // la paquet de carte en jeu
	private JoueurBridge vainqueur; // le vainqueur de la dernier partie
	private JoueurBridge j1; // Joueur 1
	private JoueurBridge j2; // Joueur 2
	private int nbcoup;// le nb de coup
	private jeuDeCarteBridge pioche;// la pioche
	private HashMap<Integer, PaquetDeCarteBridge> coupsMap;

	/**
	 * Permet d'initier une table de Jeu pour la bataille
	 * 
	 * @param nomj1 le nom du joueur 1
	 * @param nomj2 le nom du joueur 2
	 */
	public Bataille(String nomj1, String nomj2) {
		this.setJ1(new JoueurBridge(nomj1));
		this.setJ2(new JoueurBridge(nomj2));
		this.setVainqueur(new JoueurBridge("Vainqueur"));
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
			this.setCarteEnJeu(new PaquetDeCarteBridge());
		}
		if (j1.plusDeCarte()) {
			setVainqueur(j2);
		} else {
			setVainqueur(j1);
		}
	}

	/**
	 * Permet de initialiser le jeu pour une nouvelle partie
	 */
	public void nouvellePartie() {
		this.setCarteEnJeu(new PaquetDeCarteBridge());
		this.setPioche(new jeuDeCarteBridge(nbCarteJeu));
		setNbcoup(0);
		this.j1.setPioche(pioche.distribuer(16));
		this.j2.setPioche(pioche.distribuer(16));
		// coupsMap = new HashMap<>();
	}

	private void coupBataille() {
		int r = gagnantCoup(); // r : gagnant du coup
		if (r == 0) {
			if (j1.plusDeCarte()) {
				r = 1;
			} else if (j2.plusDeCarte()) {
				r = 2;
			} else {
				egalite();
			}
		}
		if (r == 1) {
			j1.rammasser(carteEnJeu);
		} else if (r == 2) {
			j2.rammasser(carteEnJeu);
		}
	}

	/**
	 * Permet de résoudre une égalité en faisant une "Bataille"
	 */
	private void egalite() {
		tirerCarteJoueurs();
		if (j1.plusDeCarte()) {
			zeroCarteBataille(j1);
		} else if (j2.plusDeCarte()) {
			zeroCarteBataille(j2);
		} else {
			tirerCarteJoueurs();
			coupBataille();
		}
	}

	/*
	 * Permet de résoudre le probleme quand un joueur n'as pas assez de carte pour
	 * faire la bataille
	 * 
	 * @param j : le joueur qui n'as plus de carte
	 */
	private void zeroCarteBataille(JoueurBridge j) {
		int r = gagnantCoup(); // r : gagnant du coup
		if (r == 1) {
			j1.rammasser(carteEnJeu);
		} else if (r == 2) {
			j2.rammasser(carteEnJeu);
		} else {
			j.rammasser(carteEnJeu);
		}

	}

	/**
	 * Renvoie le gagnant du dernier coup <br>
	 * 1 : J1 <br>
	 * 2 : J2 <br>
	 * 0 : égalité
	 */
	private int gagnantCoup() {
		CarteBridge c1, c2; // c1 = carte du j1, c2 carte du j2
		c2 = carteEnJeu.getCarte(carteEnJeu.getNbcarte() - 1);
		c1 = carteEnJeu.getCarte(carteEnJeu.getNbcarte() - 2);
		if (c1.getValeur() > c2.getValeur()) {
			return 1;
		} else if (c1.getValeur() < c2.getValeur()) {
			return 2;
		} else {
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

	/**
	 * 
	 * @return Vrai si la partie est terminée <br>
	 *         Faux sinon
	 */
	private boolean estTerm() {
		return (j2.plusDeCarte() || j1.plusDeCarte());
	}

	/**
	 * Permet d'incrementer le nb de coup
	 */
	private void incrementeCoup() {
		this.nbcoup++;
	}

	/****************************************/
	/*
	 * / /* SETTERS / /* / /
	 ****************************************/

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
