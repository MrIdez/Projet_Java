/**
 * 
 */
package paquetDeCarte;

import java.util.ArrayList;
import java.util.Collections;

import Carte.CarteBridge;

/**
 * @author guillaume
 *
 */
public class jeuDeCarteBridge extends PaquetDeCarteBridge {	
	private final static String[] couleur = {"Tréfle","Pique","Carreaux","Coeur"};
	
	public jeuDeCarteBridge() {
		super(creerJeu());
	}
	
	public jeuDeCarteBridge(int nbcarte) {
		super(creerJeu(32));
	}
	

	public static ArrayList<CarteBridge> creerJeu() {
		return creerJeu(54);
	}

	private static ArrayList<CarteBridge> creerJeu(int nbcarte) {
		final int min ;
		if (nbcarte == 32) {
			min = 7;
		}
		else {
			min = 1;
		}
		ArrayList<CarteBridge> jeu = new ArrayList<CarteBridge>();
		CarteBridge uneCarte;
		for (String coul : couleur) {
			for (int i = min; i < 15; i++) {
				uneCarte = new CarteBridge(i, coul);
				jeu.add(uneCarte);
			}
		}
		Collections.shuffle(jeu);
		return jeu;
	}
}
