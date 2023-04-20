package paquetDeCarte;

import carte.CarteDutch;

import java.util.ArrayList;

public class PaquetDeCarteDutch extends PaquetDeCarte<CarteDutch> {
    public PaquetDeCarteDutch() {
        super();
    }

    public PaquetDeCarteDutch(ArrayList<CarteDutch> p) {
        super(p);
    }

    @Override
    public PaquetDeCarte<CarteDutch> distribuer(int nb) {
        PaquetDeCarteDutch paq = new PaquetDeCarteDutch();
        for (int i = 0; i < nb; i++) {
            paq.ajouterCarte(this.tirerCarte());
        }
        return paq;
    }
}
