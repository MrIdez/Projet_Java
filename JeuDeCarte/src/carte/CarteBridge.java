package carte;

public class CarteBridge extends Carte {
	private static final String[] tabFig = {
		"Joker","Un","Deux","Trois","Quatre","Cinq","Six","Sept","Huit","Neuf","Dix","Valet","Dame","Roi","As"
	};
	public CarteBridge(int val, String coul) {
		super(val, tabFig[val], coul);
		// TODO Auto-generated constructor stub
	}


}
