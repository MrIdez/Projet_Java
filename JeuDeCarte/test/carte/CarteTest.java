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

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarteTest {
    private static CarteBridge carteTest;

    @BeforeAll
    static void creerCarte() {
        carteTest = new CarteBridge(0, "Pique");
    }

    @Test
    void getValeur() {
        assertEquals(0, carteTest.getValeur());
    }

    @Test
    void getFigure() {
        assertEquals(CarteBridge.getTabFig()[0], carteTest.getFigure());
    }

    @Test
    void getCouleur() {
        assertEquals("Pique", carteTest.getCouleur());
    }

}