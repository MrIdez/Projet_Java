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
 *
 */

import java.util.Objects;

/**
 * Classe qui caratérise une Carte et defnie les Getters/Setters
 *
 * @author Guillaume Baron
 */
public abstract class Carte {
    private int valeur;
    private String figure;
    private String Couleur;

    /**
     * @param val  La valeur de la carte à construire
     * @param fig  la figure de la carte ex : Valet
     * @param coul la couleur de la carte ex : Coueur
     * @throws IllegalArgumentException si la valeur de la carte est negative
     */
    public Carte(int val, String fig, String coul) throws IllegalArgumentException {
        this.setCouleur(coul);
        this.setFigure(fig);
        this.setValeur(val);
    }

    public void afficher() {
        System.out.println(this.toString());
    }

    /**
     * @return the valeur
     */
    public int getValeur() {
        return valeur;
    }

    /**
     * @param valeur the valeur to set
     */
    private void setValeur(int valeur) throws IllegalArgumentException {
        if (valeur < 0) {
            throw new IllegalArgumentException("La valeur ne peut pas être negative");
        } else this.valeur = valeur;
    }

    /**
     * @return the figure
     */
    public String getFigure() {
        return figure;
    }

    /**
     * @param figure the figure to set
     */
    private void setFigure(String figure) {
        this.figure = figure;
    }

    /**
     * @return the couleur
     */
    public String getCouleur() {
        return Couleur;
    }

    /**
     * @param couleur the couleur to set
     */
    private void setCouleur(String couleur) {
        Couleur = couleur;
    }

    @Override
    public String toString() {
        return (this.getFigure() + " de " + this.getCouleur());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carte carte = (Carte) o;
        return getValeur() == carte.getValeur() && Objects.equals(getCouleur(), carte.getCouleur());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValeur(), getCouleur());
    }
}


