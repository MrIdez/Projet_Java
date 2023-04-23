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

public class PaquetDeCarteDutch extends PaquetDeCarte<CarteDutch> {
    public PaquetDeCarteDutch() {
        super();
    }

    public PaquetDeCarteDutch(ArrayList<CarteDutch> p) {
        super(p);
    }

    public static PaquetDeCarteDutch jeuDeCarteDutch() {
        return new PaquetDeCarteDutch(CreerJeu.creerJeuDutch());
    }

    @Override
    public PaquetDeCarteDutch distribuer(int nb) {
        PaquetDeCarteDutch paq = new PaquetDeCarteDutch();
        for (int i = 0; i < nb; i++) {
            paq.ajouterCarte(this.tirerCarte());
        }
        return paq;
    }
}
