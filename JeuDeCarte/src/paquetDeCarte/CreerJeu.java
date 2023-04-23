/*
 * Copyright (c) 2023. Guillaume Baron
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
 *  If not, see <https://www.gnu.org/licenses/>.
 */

package paquetDeCarte;

import carte.CarteBridge;
import carte.CarteDutch;

import java.util.ArrayList;
import java.util.Collections;

public class CreerJeu {
    public static ArrayList<CarteBridge> creerJeuBridge(int nbcarte) throws IllegalArgumentException {
        final int min;
        if (nbcarte == 32) {
            min = 7;
        } else if (nbcarte == 54) {
            min = 1;
        } else {
            throw new IllegalArgumentException("Le nombre de carte doit être 32 ou 54");
        }
        ArrayList<CarteBridge> jeu = new ArrayList<>();
        CarteBridge uneCarte;
        for (String coul : CarteBridge.getCouleurPossible()) {
            for (int i = min; i < CarteBridge.getTabFig().length; i++) {
                uneCarte = new CarteBridge(i, coul);
                jeu.add(uneCarte);
            }
        }
        Collections.shuffle(jeu);
        return jeu;
    }

    public static ArrayList<CarteDutch> creerJeuDutch() {
        ArrayList<CarteDutch> jeu = new ArrayList<>();
        CarteDutch uneCarte;
        for (String coul : CarteBridge.getCouleurPossible()) {
            for (int i = 1; i < CarteDutch.getTabFig().length; i++) {
                uneCarte = new CarteDutch(i, coul);
                jeu.add(uneCarte);
            }
        }
        Collections.shuffle(jeu);
        return jeu;
    }
}
