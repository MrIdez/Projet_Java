/**
 *
 */
package jeux;

import joueur.JoueurBridge;
import paquetDeCarte.PaquetDeCarteBridge;
import paquetDeCarte.jeuDeCarteBridge;

/**
 *
 * @author guillaume
 *
 */
public class Bataille {
	public static void main(String[] args) {
		Bataille bat = new Bataille("test", "test");
	}

	private JoueurBridge j1;
	private JoueurBridge j2;
	private jeuDeCarteBridge pioche;
	private PaquetDeCarteBridge carteEnJeu;
	private int nbcoup;

	public Bataille(String nomj1, String nomj2) {
		this.setJ1(new JoueurBridge(nomj1));
		this.setJ2(new JoueurBridge(nomj2));
		this.setPioche(new jeuDeCarteBridge(32));
		this.setCarteEnJeu(new PaquetDeCarteBridge());
		this.j1.rammasser(pioche.distribuer(16));
		this.j2.rammasser(pioche.distribuer(16));
		j1.afficher();
		j2.afficher();
		pioche.afficher();
		carteEnJeu.afficher();
	}

	/**
	 * @return the nbcoup
	 */
	public int getNbcoup() {
		return nbcoup;
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
	 * @param pioche the pioche to set
	 */
	private void setPioche(jeuDeCarteBridge pioche) {
		this.pioche = pioche;
	}

}
