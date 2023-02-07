import java.util.Queue;

/**
 * 
 */

/**
 * @author guillaume
 *
 */
public class Joueur {

	/** Variable d'instance */
	private String nomJoueur;
	private int nb_carte;
	private Queue<Carte> pioche;

	public Joueur(String nomJ) {
		this.nomJoueur = nomJ;
		this.nb_carte = 0;
	}

	public void AjouterCarte(Carte c) {
		this.pioche.add(c);
		this.nb_carte++;
	}
	
	/**
	 * @return the nomJoueur
	 */
	public String getNomJoueur() {
		return nomJoueur;
	}

	/**
	 * @return the nb_carte
	 */
	public int getNb_carte() {
		return nb_carte;
	}

	/**
	 * @return the pioche
	 */
	public Queue<Carte> getPioche() {
		return pioche;
	}
}
