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

	public PaquetDeCarte() {
		this.setNbcarte(0);
		this.paquet = new ArrayList<>();
	}

	public PaquetDeCarte(ArrayList<C> p) {
		this.setNbcarte(p.size());
		this.paquet = new ArrayList<>();
		for (C carte : p) {
			this.paquet.add(carte);
		}
	}

	public void afficher() {
		System.out.println(this.toString());
	}

	public void ajouterCarte(C c) {
		this.paquet.add(c);
		this.nbcarte++;
	}

	public abstract PaquetDeCarte<C> distribuer(int nb);

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

	public void melanger() {
		Collections.shuffle(paquet);
	}

	public void ramasser(ArrayList<C> paquet) {
		this.paquet.addAll(paquet);
		this.setNbcarte(this.paquet.size());
	}

	public void ramasser(PaquetDeCarte<C> paquet) {
		this.paquet.addAll(paquet.getPaquet());
		this.setNbcarte(this.paquet.size());
	}

	/**
	 * @param nbcarte the nbcarte to set
	 */
	private void setNbcarte(int nbcarte) {
		this.nbcarte = nbcarte;
	}

	public C tirerCarte() {
		C c = null;
		if (this.nbcarte > 0) {
			c = this.paquet.remove(nbcarte-1);
		}
		this.nbcarte--;
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