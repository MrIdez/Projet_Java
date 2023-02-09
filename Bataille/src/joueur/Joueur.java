package joueur;

import java.util.Queue;

/**
 *
 */

/**
 * @author guillaume
 */
public abstract class Joueur<C> {

	/** Variable d'instance */
	private String nomJoueur;
	private int nb_carte;
	private Queue<C> pioche;

	public Joueur(String nomJ) {
		this.nomJoueur = nomJ;
		this.nb_carte = 0;
	}

	public abstract void afficher();

	public void AjouterCarte(C carte) {
		this.pioche.add(carte);
		this.nb_carte++;
	}

	/**
	 * @return Le nb_carte du Joueur
	 */
	public int getNb_carte() {
		return nb_carte;
	}

	/**
	 * @return le nom du Joueur
	 */
	public String getNomJoueur() {
		return nomJoueur;
	}

	/**
	 * @return La pioche du joueur
	 */
	public Queue<C> getPioche() {
		return pioche;
	}
}
