```python
def JeuBataille(J1:str,J2:str,mode:bool=False) :
	"""
	Cette fonction permet de gerer le debut,la fin et bon déroulement de la partie de Bataille. elle fait appael a CoupBataille a chaque tour. Elle prend en parametre le nom des deux joueur et aussi optionnellement le 'mode' qui permet de choisir si on veut afficher la partie, par défaut celui-ci est à "Faux". Cette Fonction renvoie le vainqueur et le nombre de coup de la partie
	"""
	Paquet = JeuDeCarteBridge(32)
	Paquet.Melanger()
	JA = Joueur(J1)
	JB = Joueur(J2)
	Pioche = PaquetDeCarte(Paquet.GetJeu())
	JA.Ramasser(Pioche.Distribuer(16))
	JB.Ramasser(Pioche.Distribuer(16))
	nbcoup=0
	while JA.GetNbCarteJ() != 0 and JB.GetNbCarteJ() != 0 :
		CA=JA.TirerCarte()
		CB=JB.TirerCarte()
		jeu1=[CA,CB]
		CoupBataille(JA,JB,jeu1)
		nbcoup+=1
		if mode == True :
			x=JA.GetNbCarteJ()
			y=JB.GetNbCarteJ()
			print(JA.GetNom(),' : ',x*('-'))
			time.sleep(0.1)
			print('\n')
			print(JB.GetNom(),' : ',y*('-'))
	if JB.GetNbCarteJ() == 0 :
		vainqueur = 1
	else :
		vainqueur = 2
	return vainqueur,nbcoup

def CoupBataille(JA,JB,jeu) :
	"""
	Cette fonction s'occupe du coup à la Bataille, elle prend en parametre deuc objet Joueur et les renvoie aprés avoir jouer le coup , elle prend également une liste de deux carte appellée jeu
	"""
	cA1=jeu[0]
	cB1=jeu[1]
	if cA1.GetValeur()>cB1.GetValeur() :
		JA.Ramasser(jeu)
	elif cA1.GetValeur()<cB1.GetValeur() :
		JB.Ramasser(jeu)
	else :
		égalité(JA,JB,jeu)				
	return JA,JB

def égalité(JA,JB,jeu) :
	"""
	Cette Fonction permet de résoudre les situations de "Bataille", ses parametres sont du même type que CoupBataille : Deux Joueur et un Jeu
	En cas d'égalité et d'impossibilité d'effectuer une Bataille, le Joueur avec le moins de carte est avantagé
	"""
	if JB.GetNbCarteJ() == 0 :
		JB.Ramasser(jeu)
	elif JA.GetNbCarteJ() == 0 :
		JA.Ramasser(jeu)
	else :
		cA2 = JA.TirerCarte()
		cB2 = JB.TirerCarte()
		jeu.append(cA2)
		jeu.append(cB2)
		if JB.GetNbCarteJ() == 0 :
			if cA2.GetValeur()>cB2.GetValeur() :
				JA.Ramasser(jeu)
			elif cA2.GetValeur()<cB2.GetValeur() :
				JB.Ramasser(jeu)
			else : 
				JB.Ramasser(jeu)
		elif JA.GetNbCarteJ() == 0 :
			if cA2.GetValeur()>cB2.GetValeur() :
				JA.Ramasser(jeu)
			elif cA2.GetValeur()<cB2.GetValeur() :
				JB.Ramasser(jeu)
			else : 
				JA.Ramasser(jeu)
		else :
			cA3 = JA.TirerCarte()
			cB3 = JB.TirerCarte()
			jeu.append(cA3)
			jeu.append(cB3)
			if cA3.GetValeur()>cB3.GetValeur():
				JA.Ramasser(jeu)
			elif cA3.GetValeur()<cB3.GetValeur() :
				JB.Ramasser(jeu)
			else :
				égalité(JA,JB,jeu)
	return JA,JB
```

# liste des méthodes :
* Nouvelle partie
* Jeu
* tirerCarteJoueur
* égalité
* coupBataille
* meilleurCarte -> revoit la meilleur carte jouer entre les deux dernière dans carteEnJeu
* Une méthode pour ça aussi : ```python 
if cA2.GetValeur()>cB2.GetValeur() :
				JA.Ramasser(jeu)
			elif cA2.GetValeur()<cB2.GetValeur() :
				JB.Ramasser(jeu)
			else : 
				JB.Ramasser(jeu) 
                ``` 

# liste des variables :
* Joueur1
* Joueur2
* (jouerQuiaGagné) pour que ce soit plus rp
* Pioche -> le jeu de carte complet
* carteEnJeu : Paquet de carte
* jeu static et constatante -> le jeu

# Methode de classe
* Jouer x partie
* Aide
* Les regles