### Cas d'utilisation du jeu

#### 1) Connexion
1 . Le système demande à l'utilisateur ses identifiants
	1.1 . L'utilisateur rentre ses identifiants (clique sur la case Identifiant et rentre son identifiant puis sur la case mot de passe et rentre son mot de passe dans un ordre quelconque et autant de fois que souhaité) et appuie sur "valider".
	1.2 . Le système vérifie que les identifiants rentrés en paramètre sont corrects :
		1.2.1 . Si les 2 sont corrects, accès à son tableau de bord correspondant.
		1.2.2 . Si l'un des identifiants est incorrect (clé (id,mdp) non reconnue), le système affiche un message d'erreur et l'utilisateur reste sur la page de connexion.

**Diagramme de séquence système pour une connexion réussie**
![[ACOL Analyse Connexion Ok.excalidraw]]

**Diagramme de séquence système pour une connexion ratée**
![[ACOL Analyse Connexion Fail.excalidraw]]

#### 2) Déconnexion
1. L'utilisateur clique sur le bouton "déconnexion" (quelque soit le mode dans lequel il se trouve).
2. Le système envoie un message de confirmation de déconnexion.
3. L'utilisateur clique sur "ok".
4. Le système déconnecte l'utilisateur et le renvoie à la page d'accueil à l'étape de connexion

**Diagramme de séquence pour une déconnexion utilisateur**
![[ACOL Analyse Déconnexion.excalidraw]]

#### 3) Mode Achat / Vente Action (AVA)

##### 1) Achat d'action

1. L'utilisateur entre un entier positif dans le champ quantité
2. L'utilisateur sélectionne un titre
3. L'utilisateur clique sur le bouton "Acheter"
	1. La quantité renseignée est un entier inférieure à la quantité disponible
		1. Le programme modifie le contenu du portefeuille et la quantité d'actions disponibles
		2. La quantité disponible affichée est actualisée
	2. La quantité renseignée n'est pas un entier
		1. Le programme n'effectue aucune transaction
	3.  La quantité renseignée est supérieure à la quantité disponible
		1. Le programme n'effectue aucune transaction
		2. Une fenêtre avec un message d'erreur est affichée
			1. L'utilisateur clique sur le bouton "Ok"
			2. L'utilisateur clique sur la croix en haut de la fenêtre
		3. La fenêtre pop-up est fermée

**Diagramme de séquence pour un achat réussi**
![[achat-ok.excalidraw]]
**Diagramme de séquence pour un échec d'achat (quantité disponible insuffisante)**
![[quantity-not-available.excalidraw]]

##### 2) Vente d'action

1. L'utilisateur entre un entier positif dans le champ quantité
2. L'utilisateur sélectionne un titre
3. L'utilisateur clique sur le bouton "Vendre"
	1. La quantité renseignée est un entier positif
		1. Le programme modifie le contenu du portefeuille et la quantité d'actions disponibles
		2. La quantité disponible affichée est actualisée
	2. La quantité renseignée n'est pas un entier
		1. Le programme n'effectue aucune transaction

**Diagramme de séquence pour un achat réussi**
![[vente-ok.excalidraw]]

**Diagramme de séquence pour un échec d'achat ou de vente  (quantité rentrée invalide)**
![[transaction-fail.excalidraw]]

#### 4) Mode Portefeuille

 - Affichage de l'évolution de la valeur du portefeuille
1. L'utilisateur clique sur le bouton "Evolution"
2. La courbe de l'évolution de la valeur du portefeuille s'affiche 

![[ACOL Affichage Courbe Evolution Portefeuille.excalidraw]]

- Visualisation de la date 
1. L'utilisateur peut visualiser la date du jour actuel dans le jeu


#### 5) Changer de mode
Remarques sur le changement de mode : 
1. Si l'utilisateur n'a pas validé ses transactions (i.e cliqué sur "BUY" ou "SELL" pour un champs donné), alors celles ci ne sont pas prises en compte pour l'**actualisation des données du client** (valeur et composition du portefeuille, date de la simulation ...) , qui **s'effectue à chaque passage au jour suivant**.

##### 1) Passage du mode Achat / Vente Actions (AVA) au mode Visualisation Portefeuille (VP)

1. L'utilisateur clique sur le bouton VP
2. Le système passe en mode VP et affiche la nouvelle page VP

**Diagramme de séquence pour un passage du mode AVA au mode VP**
![[ACOL Analyse AVA to VP.excalidraw]]
##### 2) Passage du mode VP au mode AVA
1. L'utilisateur clique sur le bouton AVA
2. Le système passe en mode AVA et affiche la nouvelle page AVA

**Diagramme de séquence pour un passage du mode VP au mode AVA**
![[ACOL Analyse VP to AVA.excalidraw]]

#### 6) Quitter Application
1. L'utilisateur clique sur "quitter" ou tente de fermer l'application
2. Le système envoit un message de demande de confirmation
	2.1. L'utilisateur clique sur "yes"
		2.1.1. Le système stoppe le programme
	2.2. L'utilisateur clique sur "no" et retourne à la page actuelle

**Diagramme de séquence pour une fermeture réussie**
![[ACOL Analyse Fermeture Ok.excalidraw]]

**Diagramme de séquence pour une fermeture annulée**
![[ACOL Analyse Fermeture Fail.excalidraw]]

#### 7) Passer au jour suivant 
Le jeu s'arrête quand le jour M+1 est atteint (où M est le nombre de jour associés à la simulation).
Ici, disons que l'utilisateur est au jour N $\leq$ M.
1. L'utilisateur clique sur le bouton "passer au jour suivant"
2. 1. Si N = M : le jeu est fini, affichage d'une fenêtre "jeu terminé" ainsi que du bilan utilisateur.
2. 2. Sinon, si le joueur est mode VP ("visualisation portefeuille") :  il reste toujours dans ce mode et les données sont actualisées au jour N+1 
     2.2.1 mise à jour des valeur des titres disponible sur le marché (affichage des nouvelles valeurs des actions détenus dans le portefeuille)
     2.2.2 calcul de la nouvelle valeur du portefeuille + mise à jours du graphique de l'évolution du portefeuille

![[Passer-un-jour-réussie]]


#### 8) Bilan Fin du jeu
1. L'utilisateur est au dernier jour de la simulation et passe au jour suivant
2. Le système termine la simulation et renvoit le bilan utilisateur associé
   2.1 Si (valeur du portefeuille initiale - valeur du portefeuille au dernier jour) >= 0 
	   Affichage du message: "   "
   2.2 Si  (valeur du portefeuille initiale - valeur du portefeuille au dernier jour) < 0 
	   Affichage du message: "   "

![[Fin-de-jeu]]