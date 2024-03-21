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
4. Le système déconnecte l'utilistauer et le renvoie à la page d'accueil à l'étape de connexion

**Diagramme de séquence pour une déconnexion utilisateur**
![[ACOL Analyse Déconnexion.excalidraw]]

#### 3) Changer de mode
Remarques sur le changement de mode : 
1. Si l'utilisateur n'a pas validé ses transactions (i.e cliqué sur "BUY" ou "SELL" pour un champs donné), alors celles ci ne sont pas prises en compte pour l'**actualisation des données du client** (valeur et composition du portefeuille, date de la simulation ...) , qui **s'effectue à chaque passage au jour suivant**.

2. Pour le mode visualisation courbe, aucune information liée à une action spécifique n'est affichée par défaut, l'utilisateur doit cliquer sur une action pour obtenir les informations souhaitées.
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

#### 4) Quitter Application
1. L'utilisateur clique sur "quitter" ou tente de fermer l'application
2. Le système envoit un message de demande de confirmation
	2.1. L'utilisateur clique sur "yes"
		2.1.1. Le système stoppe le programme
	2.2. L'utilisateur clique sur "no" et retourne à la page actuelle

**Diagramme de séquence pour une fermeture réussie**
![[ACOL Analyse Fermeture Ok.excalidraw]]

**Diagramme de séquence pour une fermeture annulée**
![[ACOL Analyse Fermeture Fail.excalidraw]]

#### 5) Accéder à l'historique des transactions

1) L'utilisateur est dans le mode Visualisation portefeuille
2) Il clique sur le bouton "Historique Transaction"
3) Le système affiche l'historique des transactions

**Diagramme de séquence pour l'ouverture de la fenetre "Historique Transaction**
![[ACOL Analyse Transaction.excalidraw]]

#### 6) Passer au jour suivant 
Le jeu s'arrête quand le jour M+1 est atteint (où M est le nombre de jour associés à la simulation).
Ici, disons que l'utilisateur est au jour N $\leq$ M.
1. L'utilisateur clique sur le bouton "passer"
2. 1. Si N = M : le jeu est fini, affichage d'une fenêtre "jeu terminé" ainsi que du bilan utilisateur.
2. 2. Si le joueur est mode VP ("visualisation portefeuille") :  il reste toujours dans ce mode et les données sont actualisées au jour N+1 (valeur du portefeuille + mis à jour du graphique sur l'évolution de la valeur du portefeuille + mise à jour des valeur des titres détenus). 
   Enfin le système affiche les nouvelles données.

![[Passer-un-jour-réussie]]


#### 7) Bilan Fin du jeu
1) L'utilisateur est au dernier jour de la simulation et apsse au jour suivant
2) Le système termine la simulation et renvoit le bilan utilisateur associé
![[Fin-de-jeu]]