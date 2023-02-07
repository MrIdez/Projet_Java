package paquetDeCarte;
import java.util.Queue;

import Carte.Carte;

/**
 * 
 */

/**
 * @author guillaume
 *
 */
public abstract class PaquetDeCarte {
	
	private int nbcarte;
	private Queue<Carte> paquet ;
	public PaquetDeCarte(Carte[] p) {
		this.setNbcarte(p.length);
		for (Carte carte : p) {
			this.paquet.add(carte);
		}
	}
	
	public Carte tirerCarte()  {
		Carte c = null;
		if (this.nbcarte > 0) {
			c = this.paquet.remove(); 
		}
		this.nbcarte--;
		return c;
	}
	
	public void ajouterCarte(Carte c) {
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
	 * @param nbcarte the nbcarte to set
	 */
	private void setNbcarte(int nbcarte) {
		this.nbcarte = nbcarte;
	}
}