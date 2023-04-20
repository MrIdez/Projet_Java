package joueur;

import carte.CarteDutch;
import paquetDeCarte.PaquetDeCarte;

import java.util.ArrayList;

public class JoueurDutch extends Joueur<CarteDutch>{

    public JoueurDutch(String nomJ) {
        super(nomJ);
    }

    @Override
    public void rammasser(ArrayList<CarteDutch> paquet) {
        this.pioche.ramasser(paquet);
    }

    @Override
    public void rammasser(PaquetDeCarte<CarteDutch> paquet) {
        this.pioche.ramasser(paquet);
    }
}
