	
		
		------------------------------------------------------------------
		|                            MINDGAMES 				 |
		------------------------------------------------------------------

	+++++++ LANCEMENT DE L'APPLICATION ++++++++++

    
	Dans le repertoire de MindGames.jar entrer dans la console:
	java -jar MindGames.jar
	Pour lancer en mode develeppement:
	java -jar MindGames.jar -devMode

	NB: le mode developpement peut être activé soit par le fichier config.properties soit au lancement de l'application
	pour qu'il soit inactif il faut que devMode=false dans config.properties ET lancer le jeu en mode normal.
	
	 +++++++ CONFIGURATION IDE ++++++++++
    
   	 Le programme utiliste java 8
   	 Les librairies necessaires sont présentes dans le dossier External Librairies
	 
	 
	 +++++++ CONFIGURATION JEU ++++++++++
	
	Le fichier config.porpeties permet de modifier:
	-> La longueur de la combinaison à trouver : longeurCombinaison
	-> le nombre d'essais maximum : nombreEssais
	-> Le nombre de valeur différente pour le MasterMind : nombreChiffresDifferents
	-> Activer/Desactiver le mode developpeur (affichage du code secret de l'ordinateur en mode challenger et 
	   duel : devMode

    
    
	**************** Recherche +/- *****************

	Le but : découvrir la combinaison à x chiffres de l'adversaire (le défenseur). Pour ce faire, l'attaquant 
	fait une proposition. Le défenseur indique pour chaque chiffre de la combinaison proposée si le chiffre de 
	sa combinaison est plus grand (+), plus petit (-) ou si c'est le bon chiffre (=).

	L'attaquant doit deviner la combinaison secrète en un nombre limité d'essais.

	**************** MasterMind ********************

	Le but : découvrir la combinaison à x chiffresde l'adversaire (le défenseur). Pour ce faire, l'attaquant 
	fait une proposition. Le défenseur indique pour chaque proposition le nombre de chiffre de la proposition 
	qui apparaissent à la bonne place et à la mauvaise place dans la combinaison secrète.

	L'attaquant doit deviner la combinaison secrète en un nombre limité d'essais.

	

	
	Pour chaque jeu 3 modes sont proposés:

	---------- Challenger ----------

	Trouvez la combinaison secrète de l'ordinateur

	---------- Defenseur -----------

	A l'ordinateur de trouver votre combinaison secrète

	---------- Duel ----------------

	L'ordinateur et vous jouez tour à tour, le premier à trouver la combinaison secrète de l'autre a gagné


	 
	
