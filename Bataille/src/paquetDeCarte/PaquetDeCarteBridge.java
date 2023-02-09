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

	@Override
	public void afficher() {
		System.out.println("Paquet de Carte :");
		for (CarteBridge carte : this.getPaquet()) {
			System.out.println(carte.toString());
		}
	}

}
