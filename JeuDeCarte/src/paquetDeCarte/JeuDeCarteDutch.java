package paquetDeCarte;

import carte.CarteDutch;

import java.util.ArrayList;
import java.util.Collections;

public final class JeuDeCarteDutch extends PaquetDeCarteDutch {

    public JeuDeCarteDutch() {
        super(creerJeu());
    }

    private static ArrayList<CarteDutch> creerJeu() {
        ArrayList<CarteDutch> jeu = new ArrayList<>();
        CarteDutch uneCarte;
        for (String coul : CarteDutch.getCouleurPossible()) {
            for (int i = 1; i < CarteDutch.getTabFig().length; i++) {
                uneCarte = new CarteDutch(i, coul);
                jeu.add(uneCarte);
            }
        }
        Collections.shuffle(jeu);
        return jeu;
    }
}
