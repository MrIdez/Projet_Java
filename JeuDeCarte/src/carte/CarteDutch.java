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
package carte;

/**
 * Classe pour une carte du Deutch
 *
 * @author Guillaume Baron
 */
final public class CarteDutch extends Carte {
    private static final String[] couleur = {"Pique,Trèfles", "Coeur", "Carreaux"};
    private static final String[] tabFig = {
            "Joker", "As", "Deux", "Trois", "Quatre", "Cinq", "Six", "Sept", "Huit", "Neuf", "Dix", "Valet", "Dame", "Roi"
    };
    private final CarteSpecials actionSpecial;

    /**
     * Permet de construire une carte de Bridge
     *
     * @param val  la valeur de la carte ( >= 0)
     * @param coul la couleur de la carte ex : Pique
     * @throws ArrayIndexOutOfBoundsException quand val < 0
     */
    public CarteDutch(int val, String coul) throws ArrayIndexOutOfBoundsException {
        super(val, tabFig[val], coul);
        if (val == 13 && coul.equals("Rouge")) {
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

    public static String[] getCouleurPossible() {
        return couleur;
    }

    public static String[] getTabFig() {
        return tabFig;
    }

    public CarteSpecials getActionSpecial() {
        return actionSpecial;
    }

    private enum CarteSpecials {
        ROI_ROUGE,
        DAME,
        VALET,
        AS,
        NORMAL
    }
}
