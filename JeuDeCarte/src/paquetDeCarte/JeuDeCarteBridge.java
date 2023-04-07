/*******************************************************************************
 * Copyright (c) 2023 Guillaume Baron
 *
 * This file is part of JeuDeCarte.
 *
 * JeuDeCarte is free software: you can redistribute it and/or modify it under the terms of 
 * the GNU General Public License as published by the Free Software Foundation, 
 * either version 3 of the License, or (at your option) any later version.
 *
 * JeuDeCarte is distributed in the hope that it will be useful, but WITHOUT ANY 
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or 
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for 
 * more details.
 * You should have received a copy of the GNU General Public License along with JeuDeCarte. 
 * If not, see <https://www.gnu.org/licenses/>.
 *******************************************************************************/
/**
 * 
 */
package paquetDeCarte;

import java.util.ArrayList;
import java.util.Collections;

import carte.CarteBridge;

/**
 * Classe qui caractérise un jeu de Bridge de 32 ou 54 cartes
 * @author Guillaume Baron
 */
public class JeuDeCarteBridge extends PaquetDeCarteBridge {	
	private final static String[] couleur = {"Tréfle","Pique","Carreaux","Coeur"};
		
	/**
	 * Créer un jeu de 32 ou 54 cartes
	 * @param nbcarte le nombre de carte, doit être 32 ou 54.
	 */
	public JeuDeCarteBridge(int nbcarte) {
		super(creerJeu(nbcarte));
	}

	/**
	 * Permet de créer un jeu de 32 ou 54 cartes
	 * @param nbcarte le nombre de carte à créer
	 * @return Une Array list de 32 ou 54 cartes du Bridge mélangée
	 * @throws IllegalArgumentException quand nbcarte != (32 || 54)
	 */
	private static ArrayList<CarteBridge> creerJeu(int nbcarte) throws IllegalArgumentException {
		final int min ;
		if (nbcarte == 32) {
			min = 7;
		}
		else if (nbcarte == 54){
			min = 1;
		}
		else {
			throw new IllegalArgumentException("Le nombre de carte doit être 32 ou 54");
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
