/**
 * 
 */
package paquetDeCarte;

import java.util.ArrayList;
import java.util.Collections;

import carte.CarteBridge;

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
	
	/**
	 * Permet de créer un jeu de 54 Carte
	 * @return Une Array list des 54 cartes du Bridge mélangée
	 */
	public static ArrayList<CarteBridge> creerJeu() {
		return creerJeu(54);
	}

	/**
	 * Permet de créer un jeu de x carte
	 * @param nbcarte le nombre de carte à créer
	 * @return Une Array list de x cartes du Bridge mélangée
	 */
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
