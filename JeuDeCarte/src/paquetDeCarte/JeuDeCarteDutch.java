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

import carte.CarteDutch;

import java.util.ArrayList;
import java.util.Collections;

public final class JeuDeCarteDutch extends PaquetDeCarteDutch {

    public JeuDeCarteDutch() {
        super(creerJeu());
    }

    private static ArrayList<CarteDutch> creerJeu() {
        ArrayList<CarteDutch> jeu = new ArrayList<>();
        CarteDutch uneCarte;
        for (String coul : CarteDutch.getCouleurPossible()) {
            for (int i = 1; i < CarteDutch.getTabFig().length; i++) {
                uneCarte = new CarteDutch(i, coul);
                jeu.add(uneCarte);
            }
        }
        Collections.shuffle(jeu);
        return jeu;
    }
}
