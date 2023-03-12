package paquetDeCarte;

import java.util.ArrayList;
import java.util.Collections;

import carte.Carte;

/**
 *
 */

/**
 * 
 * Implemente un paquet de carte, la paquet est implenter sous forme de pile
 * @author guillaume
 *
 */
public abstract class PaquetDeCarte<C extends Carte> {

	protected ArrayList<C> paquet;

	public PaquetDeCarte() {
		this.paquet = new ArrayList<>();
	}

	public PaquetDeCarte(ArrayList<C> p) {
		this.paquet = new ArrayList<>();
		for (C carte : p) {
			this.paquet.add(carte);
		}
	}

	public void afficher() {
		System.out.println(this.toString());
	}

	/**
	 * Permet d'ajouter une carte au paquet
	 * @param c, la carte à ajouter
	 */
	public void ajouterCarte(C c) {
		this.paquet.add(c);
	}

	/**
	 * Permet de distribuer des cartes du paquet
	 * @param nb le nombre de carte à distribuer
	 * @return un paquet de carte contenant les cartes à distribuer
	 */
	public abstract PaquetDeCarte<C> distribuer(int nb);

	/**
	 * @return the nbcarte
	 */
	public int getNbcarte() {
		return this.paquet.size();
	}

	/**
	 * @return the paquet
	 */
	public ArrayList<C> getPaquet() {
		return paquet;
	}
	
	/**
	 * Permet de mpelanger le paquet
	 */
	public void melanger() {
		Collections.shuffle(paquet);
	}

	/**
	 * Pemert de rammasser des cartes
	 * @param paquet le paquet à ramasserr
	 */
	public void ramasser(ArrayList<C> paquet) {
		this.paquet.addAll(paquet);
	}

	/**
	 * Pemert de rammasser des cartes
	 * @param paquet le paquet à ramasserr
	 */
	public void ramasser(PaquetDeCarte<C> paquet) {
		this.paquet.addAll(paquet.getPaquet());
	}
	/**
	 * 
	 * @return La carte tirée du paquet
	 */
	public C tirerCarte() {
		C c = null;
		if (this.getNbcarte() > 0) {
			c = this.paquet.remove(this.getNbcarte()-1);
		}
		return c;
	}

	@Override
	public String toString() {
		String str = "Paquet de Carte :\n";
		for (C carte : this.getPaquet()) {
			str = str.concat(carte.toString() + "\n");
		}
		return str;
	}
}