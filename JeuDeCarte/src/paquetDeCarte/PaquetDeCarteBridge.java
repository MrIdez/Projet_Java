/**
 * Copyright (c) 2023 Guillaume Baron
 * <p>
 * This file is part of JeuDeCarte.
 * <p>
 * JeuDeCarte is free software: you can redistribute it and/or modify it under the terms of
 * the GNU General Public License as published by the Free Software Foundation,
 * either version 3 of the License, or (at your option) any later version.
 * <p>
 * JeuDeCarte is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for
 * more details.
 * You should have received a copy of the GNU General Public License along with JeuDeCarte.
 * If not, see <https://www.gnu.org/licenses/>.
 */
/**
 *
 */
package paquetDeCarte;

import carte.CarteBridge;

import java.util.ArrayList;

/**
 * @author Guillaume Baron
 */
public class PaquetDeCarteBridge extends PaquetDeCarte<CarteBridge> {

    public PaquetDeCarteBridge(ArrayList<CarteBridge> p) {
        super(p);
    }

    public PaquetDeCarteBridge() {
        super();
    }

    @Override
    public PaquetDeCarte<CarteBridge> distribuer(int nb) {
        PaquetDeCarteBridge paq = new PaquetDeCarteBridge();
        for (int i = 0; i < nb; i++) {
            paq.ajouterCarte(this.tirerCarte());
        }
        return paq;
    }

}
