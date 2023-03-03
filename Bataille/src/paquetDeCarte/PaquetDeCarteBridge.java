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



	@Override
	public PaquetDeCarte<CarteBridge> distribuer(int nb) {
		PaquetDeCarteBridge paq = new PaquetDeCarteBridge();
		for (int i = 0; i < nb; i++) {
			paq.ajouterCarte(this.tirerCarte());
		}
		return paq;
	}

}
