/**
 * 
 */
package jeux;

import java.io.IOException;
import java.util.Scanner;

/**
 * Classe contenant le programme principal
 * @author guillaume
 */
public final class Main {
	private final static String[] LISTE_JEUX = {"Bataille"};
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int i = 1;
		String reponse;
		int choix;
		Scanner sc = new Scanner(System.in);
		System.out.println("Bonjour et bienvenu dans mon programme");
		System.out.println("Tu peux jouer aux jeux suivant :");
		for (String jeux : LISTE_JEUX) {
			System.out.println(i+") "+jeux);
			i++;
		}
		System.out.println("Saisie le numéro du jeux auquel tu veux jouer");
		reponse = sc.nextLine();
		choix = Integer.parseInt(reponse);
		
	}

}
