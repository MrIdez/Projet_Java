/**
 *
 */
package joueur;

import java.util.ArrayList;
import java.util.Collections;

import carte.CarteBridge;
import paquetDeCarte.PaquetDeCarte;
import paquetDeCarte.PaquetDeCarteBridge;

/**
 * @author guillaume
 *
 */
public class JoueurBridge extends Joueur<CarteBridge> {

	public JoueurBridge(String nomJ) {
		super(nomJ);
		this.pioche = new PaquetDeCarteBridge();
	}

	/**
	 * Permet de tirer une carte de la pioche du joueur
	 * @return la carte tirée
	 */
	public CarteBridge tirerCarte() {
		return this.pioche.tirerCarte();
	}
	

	@Override
	public void rammasser(ArrayList<CarteBridge> paquet) {
		Collections.shuffle(paquet);
		this.pioche.ramasser(paquet);
	}

	@Override
	public void rammasser(PaquetDeCarte<CarteBridge> paquet) {
		paquet.melanger();
		this.pioche.ramasser(paquet);
	}

}
