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

package joueur;

import carte.CarteBridge;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import paquetDeCarte.JeuDeCarteBridge;

import static org.junit.jupiter.api.Assertions.*;

class JoueurTest {
    private static JoueurBridge j;
    private static CarteBridge c;
    @BeforeAll
    static void creerJ() {
        j = new JoueurBridge("A");
        c = new CarteBridge(1,"Pique");
        j.setPioche(new JeuDeCarteBridge(32).distribuer(16));
    }
    @Test
    void ajouterCarte() {
        int nbcarteAvant = j.getNbCarte();
        j.ajouterCarte(c);
        assertEquals(nbcarteAvant+1,j.getNbCarte());
        assertEquals(c,j.getCarte(nbcarteAvant));
    }

    @Test
    void getCarte() {
        int nbcarte = j.getNbCarte();
        // Test debut
        assertEquals(j.getCarte(0), j.getPioche().getCarte(0));
        // Test milieu
        assertEquals(j.getCarte(nbcarte/2), j.getPioche().getCarte(nbcarte/2));
        // Test fin
        assertEquals(j.getCarte(nbcarte-1), j.getPioche().getCarte(nbcarte-1));
    }

    @Test
    void plusDeCarte() {
        assertFalse(j.plusDeCarte());
        JoueurBridge j2 = new JoueurBridge("j2");
        assertTrue(j2.plusDeCarte());
    }
}