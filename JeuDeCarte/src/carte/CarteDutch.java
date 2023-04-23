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
package carte;


/**
 * Classe pour une carte du Dutch
 *
 * @author Guillaume Baron
 */
final public class CarteDutch extends CarteBridge {
    private final CarteSpecials actionSpecial;

    /**
     * Permet de construire une carte de Bridge
     *
     * @param val  la valeur de la carte ( >= 0)
     * @param coul la couleur de la carte ex : Pique
     * @throws ArrayIndexOutOfBoundsException quand val < 0
     */
    public CarteDutch(int val, String coul) throws ArrayIndexOutOfBoundsException {
        super(val, coul);
        boolean rouge = (coul.equals(getCouleurPossible()[2]) || coul.equals(getCouleurPossible()[3]));
        if ((val == 13 ) && rouge ) {
            this.actionSpecial = CarteSpecials.ROI_ROUGE;
        } else if (val == 12) {
            this.actionSpecial = CarteSpecials.DAME;
        } else if (val == 11) {
            this.actionSpecial = CarteSpecials.VALET;
        } else if (val == 1) {
            this.actionSpecial = CarteSpecials.AS;
        } else {
            this.actionSpecial = CarteSpecials.NORMAL;
        }
    }

    public CarteSpecials getActionSpecial() {
        return actionSpecial;
    }

}
