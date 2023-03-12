/**
 * 
 */
package paquetDeCarte;

import java.util.ArrayList;

import carte.CarteBridge;

/**
 * @author Guillaume Baron
 */
public class PaquetDeCarteBridge extends PaquetDeCarte<CarteBridge> {

	public PaquetDeCarteBridge(ArrayList<CarteBridge> p) {
		super(p);
	}
	
	public PaquetDeCarteBridge() {
		super();
	}

	/**
	 * 
	 * @param index l'index de la carte
	 * @return la carte à l'index dans le paquet sans la supprimer
	 * @throws IndexOutOfBoundsException quand (index < 0 || index >= nbcarte )
	 */
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
