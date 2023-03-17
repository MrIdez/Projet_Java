package carte;
/**
 * 
 */

/**
 * Classe qui caratérise une Carte et defnie les Getters/Setters
 * @author Guillaume Baron
 *
 */
public abstract class Carte {
	private int valeur;
	private String figure;
	private String Couleur;
	
	/**
	 * 
	 * @param val La valeur de la carte à construire
	 * @param fig la figure de la carte ex : Valet
	 * @param coul la couleur de la carte ex : Coueur
	 * @throws IllegalArgumentException si la valeur de la carte est negative
	 */
	public Carte(int val, String fig,String coul) throws IllegalArgumentException {
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
	private void setValeur(int valeur) throws IllegalArgumentException {
		if (valeur < 0 ) {
			throw new IllegalArgumentException("La valeur ne peut pas être negative");
		}
		else this.valeur = valeur;
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


