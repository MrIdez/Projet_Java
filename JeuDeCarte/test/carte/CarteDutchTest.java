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

import static org.junit.jupiter.api.Assertions.*;

class CarteDutchTest {
    private CarteDutch carteTest;

    @org.junit.jupiter.api.BeforeEach
    void creerCarte() {
        carteTest = new CarteDutch(1, CarteDutch.getCouleurPossible()[0]);
    }

    @org.junit.jupiter.api.Test
    void getCouleurPossible() {
        assertArrayEquals(new String[]{"Pique", "Trèfles", "Coeur", "Carreaux"}, CarteDutch.getCouleurPossible());
    }

    @org.junit.jupiter.api.Test
    void getTabFig() {
        assertArrayEquals(new String[]{
                "Joker", "As", "Deux", "Trois", "Quatre", "Cinq", "Six", "Sept", "Huit", "Neuf", "Dix", "Valet", "Dame", "Roi"
        }, CarteDutch.getTabFig());
    }

    @org.junit.jupiter.api.Test
    void getActionSpecialRoiNoir() {
        CarteDutch roiNoir = new CarteDutch(13, "Pique");
        assertNotEquals(CarteSpecials.ROI_ROUGE, roiNoir.getActionSpecial());
    }

    @org.junit.jupiter.api.Test
    void getActionSpecialRoiRouge() {
        CarteDutch roiRouge = new CarteDutch(13, CarteDutch.getCouleurPossible()[2]);
        assertEquals(CarteSpecials.ROI_ROUGE, roiRouge.getActionSpecial());
    }

    @org.junit.jupiter.api.Test
    void getActionSpecialDame() {
        CarteDutch Dame = new CarteDutch(12, CarteDutch.getCouleurPossible()[0]);
        assertEquals(CarteSpecials.DAME, Dame.getActionSpecial());
    }

    @org.junit.jupiter.api.Test
    void getActionSpecialValet() {
        CarteDutch valet = new CarteDutch(11, CarteDutch.getCouleurPossible()[0]);
        assertEquals(CarteSpecials.VALET, valet.getActionSpecial());
    }

    @org.junit.jupiter.api.Test
    void getActionSpecialAs() {
        CarteDutch as = new CarteDutch(1, CarteDutch.getCouleurPossible()[0]);
        assertEquals(CarteSpecials.AS, as.getActionSpecial());
    }

    @org.junit.jupiter.api.Test
    void getActionSpecialNormal() {
        CarteDutch normal = new CarteDutch(9, CarteDutch.getCouleurPossible()[0]);
        assertEquals(CarteSpecials.NORMAL, normal.getActionSpecial());
    }
}