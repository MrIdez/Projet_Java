package Carte;
/**
 * 
 */

/**
 * @author guillaume
 *
 */
public abstract class Carte {
	private int valeur;
	private String figure;
	private String Couleur;
	
	public Carte(int val, String fig,String coul) {
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
	 * @return the figure
	 */
	public String getFigure() {
		return figure;
	}

	/**
	 * @return the couleur
	 */
	public String getCouleur() {
		return Couleur;
	}
	/**
	 * @param valeur the valeur to set
	 */
	private void setValeur(int valeur) {
		this.valeur = valeur;
	}
	/**
	 * @param figure the figure to set
	 */
	private void setFigure(String figure) {
		this.figure = figure;
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
	
}


