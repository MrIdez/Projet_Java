/**
 * 
 */
package joueur;

import Carte.CarteBridge;

/**
 * @author guillaume
 *
 */
public class JoueurBridge extends Joueur<CarteBridge>{

	public JoueurBridge(String nomJ) {
		super(nomJ);
	}

	@Override
	public void afficher() {
		System.out.println("Nom du Joueur :" + this.getNomJoueur());
		System.out.println("Nombre de carte : " + this.getNb_carte());
		System.out.println("Pioche :");
		for (CarteBridge carte : this.getPioche()) {
			System.out.println(carte.toString());
		}
	}

}
