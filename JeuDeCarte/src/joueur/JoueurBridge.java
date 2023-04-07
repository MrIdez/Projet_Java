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
package joueur;

import java.util.ArrayList;
import java.util.Collections;

import carte.CarteBridge;
import paquetDeCarte.PaquetDeCarte;
import paquetDeCarte.PaquetDeCarteBridge;

/**
 * Classe qui caractirise un joueur de Bridge
 * @author Guillaume Baron
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
