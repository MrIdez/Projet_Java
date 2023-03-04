package joueur;

import java.util.ArrayList;

import paquetDeCarte.PaquetDeCarte;

/**
 * Fichier pour la classe Joueur
 */

/**
 * Classe abstraite d'un Joueur de carte C
 * Elle permet ensuite de définir la Classe JoueurBridge
 * 
 * @author Guillaume Baron
 */
public abstract class Joueur<C> {

	/** Variable d'instance */
	private String nomJoueur;
	protected PaquetDeCarte<C> pioche;

	private int nb_carte;

	/**
	 * 
	 * @param nomJ le nom du joueur
	 */
	public Joueur(String nomJ) {
		this.nomJoueur = nomJ;
		this.nb_carte = 0;
	}
	
	/**
	 * Permet d'afficher le Joueur
	 */
	public void afficher() {
		System.out.println(this.toString());
	}

	/**
	 * 
	 * @param carte la carte à ajouter
	 */
	public void AjouterCarte(C carte) {
		this.pioche.ajouterCarte(carte);
		this.nb_carte++;
	}

	/**
	 * 
	 * @return 
	 * Vrai si un joueur n'as plus de carte 
	 * <br>
	 * Faux sinon
	 */
	public boolean plusDeCarte() {
		return (this.getNb_carte() == 0);
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

	/**
	 * 
	 * @param paquet l'ArrayList de C à rammasser
	 */
	public abstract void rammasser(ArrayList<C> paquet);

	/**
	 * @param paquet le paquet de carte à rammasser
	 */
	public abstract void rammasser(PaquetDeCarte<C> paquet);
 	
	/**
	 * Permet de changer le nombre de carte du joueur
	 * @param nb_carte the nb_carte to set
	 */
	protected void setNb_carte(int nb_carte) {
		this.nb_carte = nb_carte;
	}

	/**
	 * Permet de définir un nouveau nom pour le joueur
	 * @param nomJoueur le nouveau nom
	 */
	public void setNomJoueur(String nomJoueur) {
		this.nomJoueur = nomJoueur;
	}

	/**
	 * Permet de définir une nouvelle pioche pour le joueur
	 * Le nombre de carte est mis à jour avec la taille de cette nouvelle pioche
	 * @param pioche la nouvelle pioche
	 */
	public void setPioche(PaquetDeCarte<C> pioche) {
		setNb_carte(pioche.getNbcarte());
		this.pioche = pioche;
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
