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

import carte.Carte;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 */

/**
 * Implemente un paquet de carte, la paquet est representé sous forme de pile
 *
 * @author Guillaume Baron
 */
public abstract class PaquetDeCarte<C extends Carte> {

    protected ArrayList<C> paquet;

    public PaquetDeCarte() {
        this.paquet = new ArrayList<>();
    }

    public PaquetDeCarte(ArrayList<C> p) {
        this.paquet = new ArrayList<>();
        for (C carte : p) {
            this.paquet.add(carte);
        }
    }

    public void afficher() {
        System.out.println(this.toString());
    }

    /**
     * Permet d'ajouter une carte au paquet
     *
     * @param c, la carte à ajouter
     */
    public void ajouterCarte(C c) {
        this.paquet.add(c);
    }

    /**
     * Permet de distribuer des cartes du paquet
     *
     * @param nb le nombre de carte à distribuer
     * @return un paquet de carte contenant les cartes à distribuer
     */
    public abstract PaquetDeCarte<C> distribuer(int nb);

    public C getCarte(int index) throws IllegalArgumentException {
        if (index < 0 || index > this.getNbCarte()) {
            throw new IllegalArgumentException("L'index doit être compris entre 0 et nbCarte");
        } else {
            return this.paquet.get(index);
        }
    }

    /**
     * @return the nbcarte
     */
    public int getNbCarte() {
        return this.paquet.size();
    }

    /**
     * @return the paquet
     */
    public ArrayList<C> getPaquet() {
        return paquet;
    }

    /**
     * Permet de mpelanger le paquet
     */
    public void melanger() {
        Collections.shuffle(paquet);
    }

    /**
     * Pemert de rammasser des cartes
     *
     * @param paquet le paquet à ramasserr
     */
    public void ramasser(ArrayList<C> paquet) {
        this.paquet.addAll(paquet);
    }

    /**
     * Pemert de rammasser des cartes
     *
     * @param paquet le paquet à ramasserr
     */
    public void ramasser(PaquetDeCarte<C> paquet) {
        this.paquet.addAll(paquet.getPaquet());
    }

    /**
     * @return La carte tirée du paquet
     */
    public C tirerCarte() {
        C c = null;
        if (this.getNbCarte() > 0) {
            c = this.paquet.remove(this.getNbCarte() - 1);
        }
        return c;
    }

    @Override
    public String toString() {
        String str = "Paquet de Carte :\n";
        for (C carte : this.getPaquet()) {
            str = str.concat(carte.toString() + "\n");
        }
        return str;
    }
}