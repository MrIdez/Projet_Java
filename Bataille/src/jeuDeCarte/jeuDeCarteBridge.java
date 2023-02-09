/**
 * 
 */
package jeuDeCarte;

import java.util.ArrayList;
import java.util.Collections;

import Carte.CarteBridge;
import paquetDeCarte.PaquetDeCarte;
import paquetDeCarte.PaquetDeCarteBridge;

/**
 * @author guillaume
 *
 */
public class jeuDeCarteBridge extends JeuDeCarte<CarteBridge> {	
	public jeuDeCarteBridge() {
		super();
	}
	
	public jeuDeCarteBridge(int nbcarte) {
		super(nbcarte);
	}
	
	@Override
	protected PaquetDeCarte<CarteBridge> creerJeu() {
		return this.creerJeu(54);
	}

	@Override
	protected PaquetDeCarteBridge creerJeu(int nbcarte) {
		final int min ;
		if (nbcarte == 32) {
			min = 7;
		}
		else {
			min = 1;
		}
		PaquetDeCarteBridge paquet ;
		ArrayList<CarteBridge> jeu = new ArrayList<CarteBridge>();
		CarteBridge uneCarte;
		String[] couleur = {"Tréfle","Pique","Carreaux","Coeur"};
		for (String coul : couleur) {
			for (int i = min; i < 15; i++) {
				uneCarte = new CarteBridge(i, coul);
				jeu.add(uneCarte);
			}
		}
		Collections.shuffle(jeu);
		paquet = new PaquetDeCarteBridge(jeu);
		return paquet;
	}
}
