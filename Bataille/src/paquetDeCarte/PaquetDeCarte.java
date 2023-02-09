package paquetDeCarte;

import java.util.ArrayList;
import java.util.Queue;

/**
 *
 */

/**
 * @author guillaume
 *
 */
public abstract class PaquetDeCarte<C> {

	private int nbcarte;
	private Queue<C> paquet;

	public PaquetDeCarte(ArrayList<C> p) {
		this.setNbcarte(p.size());
		for (C carte : p) {
			this.paquet.add(carte);
		}
	}

	public abstract void afficher();

	public void ajouterCarte(C c) {
		this.paquet.add(c);
		this.nbcarte++;
	}

	/**
	 * @return the nbcarte
	 */
	public int getNbcarte() {
		return nbcarte;
	}

	/**
	 * @return the paquet
	 */
	public Queue<C> getPaquet() {
		return paquet;
	}

	public C tirerCarte() {
		C c = null;
		if (this.nbcarte > 0) {
			c = this.paquet.remove();
		}
		this.nbcarte--;
		return c;
	}

	/**
	 * @param nbcarte the nbcarte to set
	 */
	private void setNbcarte(int nbcarte) {
		this.nbcarte = nbcarte;
	}
}