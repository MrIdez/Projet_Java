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
package jeux;

import carte.CarteBridge;
import joueur.JoueurBridge;
import paquetDeCarte.PaquetDeCarteBridge;

import java.util.HashMap;


/**
 * @author Guillaume Baron
 * Cette classe permet de simuler le jeu de la bataille
 */
public class Bataille {

    private static final int nbCarteJeu = 32;
    private PaquetDeCarteBridge carteEnJeu; // la paquet de carte en jeu
    private JoueurBridge vainqueur; // le vainqueur de la dernier partie
    private JoueurBridge j1; // Joueur 1
    private JoueurBridge j2; // Joueur 2
    private int nbcoup;// le nb de coup
    private PaquetDeCarteBridge pioche;// la pioche
    private HashMap<Integer, PaquetDeCarteBridge> coupsMap; // une HashMap de tout les coups

    /**
     * Permet d'initier une table de Jeu pour la bataille
     *
     * @param nomj1 le nom du joueur 1
     * @param nomj2 le nom du joueur 2
     */
    public Bataille(String nomj1, String nomj2) {
        this.setJ1(new JoueurBridge(nomj1));
        this.setJ2(new JoueurBridge(nomj2));
        this.setVainqueur(new JoueurBridge("Vainqueur"));
        this.nouvellePartie();
    }

    /**
     * Permet de jouer plusieur partie
     *
     * @param nbpartie : le nombre de partie à jouer
     */
    public static void jouerPlusieurPartie(int nbpartie) {
        int totJ1 = 0, totJ2 = 0;
        Bataille bat = new Bataille("1", "2");
        for (int i = 0; i < nbpartie; i++) {
            bat.nouvellePartie();
            bat.jouerPartie();
            if (bat.getVainqueur().getNomJoueur() == "1") {
                totJ1++;
            } else {
                totJ2++;
            }
        }
        System.out.println(totJ1);
        System.out.println(totJ2);

    }

    public static void main(String[] args) {
        Bataille bat = new Bataille("j1", "j2");
        bat.nouvellePartie();
        bat.jouerPartie();
        System.out.println(bat.getVainqueur());
        System.out.println(bat.getNbcoup());
        System.out.println(bat.getCoupsMap());
    }

    /**
     * @return coupsMap, la HashMap des coups de la partie <br>
     * La clef est le numero du coup (ex le 1 coup à une clef de 1) <br>
     * La valeur le paquet rammasser par le joueur qui à gagné ce coups <br>
     * les cartes à indice paire sont celle du J1, impraire celle du J2
     */
    public HashMap<Integer, PaquetDeCarteBridge> getCoupsMap() {
        return coupsMap;
    }

    /**
     * @return le nbcoup de la partie
     */
    public int getNbcoup() {
        return nbcoup;
    }

    /**
     * @return the vainqueur
     */
    public JoueurBridge getVainqueur() {
        return vainqueur;
    }

    /**
     * @param vainqueur the vainqueur to set
     */
    private void setVainqueur(JoueurBridge vainqueur) {
        this.vainqueur = vainqueur;
    }

    /**
     * Permet de jouer la partie <br>
     * Determine le vainqueur de la bataille
     */
    public void jouerPartie() {
        while (!estTerm()) {
            this.tirerCarteJoueurs();
            this.incrementeCoup();
            this.coupsMap.put(nbcoup, carteEnJeu);
            this.coupBataille();
            this.setCarteEnJeu(new PaquetDeCarteBridge());
        }
        if (j1.plusDeCarte()) {
            setVainqueur(j2);
        } else {
            setVainqueur(j1);
        }
    }

    /**
     * Permet de (re)initialiser le jeu pour une nouvelle partie
     */
    public void nouvellePartie() {
        this.setCarteEnJeu(new PaquetDeCarteBridge());
        this.setPioche(PaquetDeCarteBridge.jeuDeCarteBridge(nbCarteJeu));
        nbcoup = 0;
        this.j1.setPioche(pioche.distribuer(16));
        this.j2.setPioche(pioche.distribuer(16));
        coupsMap = new HashMap<>();
    }

    /**
     * Cette fonction permet de jouer un coup
     */
    private void coupBataille() {
        int r = gagnantCoup(); // r : gagnant du coup
        if (r == 0) {
            if (j1.plusDeCarte()) {
                r = 1;
            } else if (j2.plusDeCarte()) {
                r = 2;
            } else {
                egalite();
            }
        }
        if (r == 1) {
            j1.rammasser(carteEnJeu);
        } else if (r == 2) {
            j2.rammasser(carteEnJeu);
        }
    }

    /**
     * Permet de résoudre une égalité en faisant une "Bataille"
     */
    private void egalite() {
        tirerCarteJoueurs();
        if (j1.plusDeCarte()) {
            zeroCarteBataille(j1);
        } else if (j2.plusDeCarte()) {
            zeroCarteBataille(j2);
        } else {
            tirerCarteJoueurs();
            coupBataille();
        }
    }

    /**
     * @return Vrai si la partie est terminée <br>
     * Faux sinon
     */
    private boolean estTerm() {
        return (j2.plusDeCarte() || j1.plusDeCarte());
    }

    /**
     * Renvoie le gagnant du dernier coup <br>
     * 1 : J1 <br>
     * 2 : J2 <br>
     * 0 : égalité
     */
    private int gagnantCoup() {
        CarteBridge c1, c2; // c1 = carte du j1, c2 carte du j2
        c2 = carteEnJeu.getCarte(carteEnJeu.getNbCarte() - 1);
        c1 = carteEnJeu.getCarte(carteEnJeu.getNbCarte() - 2);
        if (c1.getValeur() > c2.getValeur()) {
            return 1;
        } else if (c1.getValeur() < c2.getValeur()) {
            return 2;
        } else {
            return 0;
        }
    }

    /**
     * Permet d'incrementer le nb de coup
     */
    private void incrementeCoup() {
        this.nbcoup++;
    }

    /**
     * @param carteEnJeu the carteEnJeu to set
     */
    private void setCarteEnJeu(PaquetDeCarteBridge carteEnJeu) {
        this.carteEnJeu = carteEnJeu;
    }

    /****************************************/
    /* 				SETTERS
    /****************************************/

    /**
     * @param j1 the j1 to set
     */
    private void setJ1(JoueurBridge j1) {
        this.j1 = j1;
    }

    /**
     * @param j2 the j2 to set
     */
    private void setJ2(JoueurBridge j2) {
        this.j2 = j2;
    }

    /**
     * @param pioche the pioche to set
     */
    private void setPioche(PaquetDeCarteBridge pioche) {
        this.pioche = pioche;
    }

    /**
     * Permet de tirer une carte à chaque joueur et de le mettre dans carteEnJeu
     */
    private void tirerCarteJoueurs() {
        carteEnJeu.ajouterCarte(j1.tirerCarte());
        carteEnJeu.ajouterCarte(j2.tirerCarte());
    }

    /*
     * Permet de résoudre le probleme quand un joueur n'as pas assez de carte pour
     * faire la bataille
     *
     * @param j : le joueur qui n'as plus de carte
     */
    private void zeroCarteBataille(JoueurBridge j) {
        int r = gagnantCoup(); // r : gagnant du coup
        if (r == 1) {
            j1.rammasser(carteEnJeu);
        } else if (r == 2) {
            j2.rammasser(carteEnJeu);
        } else {
            j.rammasser(carteEnJeu);
        }

    }
}
