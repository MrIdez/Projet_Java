package joueur;

import java.util.ArrayList;

import paquetDeCarte.PaquetDeCarte;

/**
 *
 */

/**
 * @author guillaume
 */
public abstract class Joueur<C> {

	/** Variable d'instance */
	private String nomJoueur;
	protected PaquetDeCarte<C> pioche;
	private int nb_carte;

	public Joueur(String nomJ) {
		this.nomJoueur = nomJ;
		this.nb_carte = 0;
	}

	public abstract void afficher();

	public void AjouterCarte(C carte) {
		this.pioche.ajouterCarte(carte);
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
	public PaquetDeCarte<C> getPioche() {
		return pioche;
	}

	public abstract void rammasser(ArrayList<C> paquet);

	public abstract void rammasser(PaquetDeCarte<C> paquet);

	/**
	 * @param nb_carte the nb_carte to set
	 */
	protected void setNb_carte(int nb_carte) {
		this.nb_carte = nb_carte;
	}
}
