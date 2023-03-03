package joueur;

import java.util.ArrayList;

import Carte.CarteBridge;
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

	public void afficher() {
		System.out.println(this.toString());
	}

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
	
	@Override
	public String toString() {
		int nbcarte = this.getNb_carte();
		String str = "Nom du Joueur : " + this.getNomJoueur() + "\nNombre de carte : " + nbcarte;
		if (nbcarte > 0) {
			str = str.concat("\nPioche : \n");
			for (C carte : this.getPioche().getPaquet()) {
				str = str.concat(carte.toString()+"\n");
			}
		}
		return str;
	}
}
