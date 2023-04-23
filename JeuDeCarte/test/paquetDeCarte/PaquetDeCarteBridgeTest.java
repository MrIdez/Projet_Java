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
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.TestWatcher;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PaquetDeCarteBridgeTest {

    private static PaquetDeCarteBridge paq;
    private static CarteBridge c;

    @BeforeAll
    static void setUp() {
        paq = new PaquetDeCarteBridge();
        c = new CarteBridge(1,"Pique");
        paq.paquet = (new JeuDeCarteBridge(32).distribuer(16)).getPaquet();
    }

    @Test
    void ajouterCarte() {
        int nbcarteAvant = paq.getNbCarte();
        paq.ajouterCarte(c);
        assertEquals(nbcarteAvant+1,paq.getNbCarte());
        assertEquals(c,paq.getCarte(nbcarteAvant));
    }

    @Test
    void getCarte() {
        int nbcarte = paq.getNbCarte();
        // Test debut
        assertEquals(paq.getCarte(0), paq.getPaquet().get(0));
        // Test milieu
        assertEquals(paq.getCarte(nbcarte/2), paq.getPaquet().get(nbcarte/2));
        // Test fin
        assertEquals(paq.getCarte(nbcarte-1), paq.getPaquet().get(nbcarte-1));
    }

    @Test
    void tirerCarte() {
        int nbcarte = paq.getNbCarte();
        CarteBridge c = paq.getCarte(paq.getNbCarte()-1);
        CarteBridge c2 = paq.tirerCarte();
        assertEquals(c,c2);
        assertEquals(nbcarte-1,paq.getNbCarte());
    }

    @Test
    void distribuer() {
        PaquetDeCarteBridge p2 = paq.distribuer(10);
        assertEquals(10,p2.getNbCarte());
    }
}