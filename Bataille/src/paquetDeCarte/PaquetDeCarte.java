package paquetDeCarte;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 */

/**
 * @author guillaume
 *
 */
public abstract class PaquetDeCarte<C> {

	private int nbcarte;
	protected ArrayList<C> paquet;

	public PaquetDeCarte(ArrayList<C> p) {
		this.setNbcarte(p.size());
		for (C carte : p) {
			this.paquet.add(carte);
		}
	}
	
	public PaquetDeCarte() {
		this.setNbcarte(0);
		this.paquet = new ArrayList<>();
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
	public ArrayList<C> getPaquet() {
		return paquet;
	}

	public void Ramasser(PaquetDeCarte<C> paquet) {
		this.paquet.addAll(paquet.getPaquet());
	}
	
	public void Ramasser(ArrayList<C> paquet) {
		this.paquet.addAll(paquet);
	}
	
	public C tirerCarte() {
		C c = null;
		if (this.nbcarte > 0) {
			c = this.paquet.remove(nbcarte);
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
	
	public void melanger() {
		Collections.shuffle(paquet);
	}
	
	public abstract PaquetDeCarte<C> distribuer(int nb);
}