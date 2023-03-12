package joueur;

import java.util.ArrayList;

import carte.Carte;
import paquetDeCarte.PaquetDeCarte;

/**
 * Classe abstraite d'un Joueur de carte C
 * Elle permet ensuite la definition d'un joueur d'un jeu particulier comme le bridge
 * 
 * @author Guillaume Baron
 */
public abstract class Joueur<C extends Carte> {

	/** Variable d'instance */
	private String nomJoueur;
	protected PaquetDeCarte<C> pioche;

	/**
	 * 
	 * @param nomJ le nom du joueur
	 */
	public Joueur(String nomJ) {
		this.nomJoueur = nomJ;
	}
	
	/**
	 * Permet d'afficher le Joueur
	 */
	public void afficher() {
		System.out.println(this);
	}

	/**
	 * Permet d'ajouter une carte à la pioche du joueur
	 * @param carte la carte à ajouter
	 */
	public void AjouterCarte(C carte) {
		this.pioche.ajouterCarte(carte);
	}

	/**
	 * 
	 * @return 
	 * Vrai si un joueur n'as plus de carte 
	 * <br>
	 * Faux sinon
	 */
	public boolean plusDeCarte() {
		return (this.getNbCarte() < 1);
	}
	/**
	 * @return Le nb_carte du Joueur
	 */
	public int getNbCarte() {
		return this.pioche.getNbcarte();
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
		this.pioche = pioche;
	}
	
	@Override
	public String toString() {
		int nbcarte = this.getNbCarte();
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
