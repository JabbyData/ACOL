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

