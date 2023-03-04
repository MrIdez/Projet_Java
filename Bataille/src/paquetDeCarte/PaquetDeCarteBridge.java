/**
 * 
 */
package paquetDeCarte;

import java.util.ArrayList;

import Carte.CarteBridge;

/**
 * @author guillaume
 *
 */
public class PaquetDeCarteBridge extends PaquetDeCarte<CarteBridge> {

	public PaquetDeCarteBridge(ArrayList<CarteBridge> p) {
		super(p);
	}
	
	public PaquetDeCarteBridge() {
		super();
	}

	public CarteBridge getCarte(int index) throws IndexOutOfBoundsException {
		if ((index < 0 || index >= this.getNbcarte())) {
			throw new IndexOutOfBoundsException();
		}
		else return this.paquet.get(index);
	}

	@Override
	public PaquetDeCarte<CarteBridge> distribuer(int nb) {
		PaquetDeCarteBridge paq = new PaquetDeCarteBridge();
		for (int i = 0; i < nb; i++) {
			paq.ajouterCarte(this.tirerCarte());
		}
		return paq;
	}

}
