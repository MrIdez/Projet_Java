/**
 * 
 */
package jeuDeCarte;

import paquetDeCarte.PaquetDeCarte;

/**
 * @author guillaume
 *
 */
public abstract class JeuDeCarte<C> {
	private PaquetDeCarte<C> jeu;

	public JeuDeCarte() {
		this.setJeu(this.creerJeu());
	}

	public JeuDeCarte(int nbcarte) {
		this.setJeu(this.creerJeu(nbcarte));
	}
	/**
	 * @return the jeu
	 */
	public PaquetDeCarte<C> getJeu() {
		return jeu;
	}
	
	public abstract PaquetDeCarte<C> distribuer(int nb);
	protected abstract PaquetDeCarte<C> creerJeu();
	protected abstract PaquetDeCarte<C> creerJeu(int nbcarte);
	/**
	 * @param jeu the jeu to set
	 */
	private void setJeu(PaquetDeCarte<C> jeu) {
		this.jeu = jeu;
	}
}
