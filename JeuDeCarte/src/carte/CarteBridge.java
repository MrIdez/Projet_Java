package carte;

/**
 * Classe pour une carte du Bridge
 * 
 * @author Guillaume Baron
 */
final public class CarteBridge extends Carte {
	private static final String[] tabFig = {
		"Joker","Un","Deux","Trois","Quatre","Cinq","Six","Sept","Huit","Neuf","Dix","Valet","Dame","Roi","As"
	};
	/**
	 * Permet de construire une carte de Bridge
	 * @param val la valeur de la carte ( >= 0)
	 * @param coul la couleur de la carte ex : Pique
	 * @throws ArrayIndexOutOfBoundsException quand val < 0
	 */
	public CarteBridge(int val, String coul) throws ArrayIndexOutOfBoundsException {
		super(val, tabFig[val], coul);
	}
}
