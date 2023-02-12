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
	public void afficher() {
		System.out.println("Paquet de Carte :");
		for (CarteBridge carte : this.getPaquet()) {
			System.out.println(carte.toString());
		}
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
