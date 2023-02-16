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
		return this.pioche.tirerCarte();
	}
	
	@Override
	public void afficher() {
		int nbcarte = this.getNb_carte();
		System.out.println("Nom du Joueur :" + this.getNomJoueur());
		System.out.println("Nombre de carte : " + nbcarte);
		if (nbcarte > 0) {
			System.out.println("Pioche :");
			for (CarteBridge carte : this.getPioche().getPaquet()) {
				System.out.println(carte.toString());
			}
		}
	}

	@Override
	public void rammasser(ArrayList<CarteBridge> paquet) {
		Collections.shuffle(paquet);
		this.pioche.ramasser(paquet);
		this.setNb_carte(this.pioche.getNbcarte());
	}

	@Override
	public void rammasser(PaquetDeCarte<CarteBridge> paquet) {
		this.pioche.melanger();
		this.pioche.ramasser(paquet);
		System.out.println(this.pioche.getNbcarte());
		this.setNb_carte(this.pioche.getNbcarte());
	}

}
