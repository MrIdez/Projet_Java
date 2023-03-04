/**
 *
 */
package joueur;

import java.util.ArrayList;
import java.util.Collections;

import Carte.CarteBridge;
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

	public CarteBridge tirerCarte() {
		this.setNb_carte(this.getNb_carte()-1);
		return this.pioche.tirerCarte();
	}
	

	@Override
	public void rammasser(ArrayList<CarteBridge> paquet) {
		Collections.shuffle(paquet);
		this.pioche.ramasser(paquet);
		this.setNb_carte(this.pioche.getNbcarte());
	}

	@Override
	public void rammasser(PaquetDeCarte<CarteBridge> paquet) {
		paquet.melanger();
		this.pioche.ramasser(paquet);
		this.setNb_carte(this.pioche.getNbcarte());
	}

}
