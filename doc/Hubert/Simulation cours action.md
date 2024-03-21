**Important :** Quand l'utilisateur passe en mode "visualisation courbe", la courbe d'une action par défaut est affichée (le choix de cette action par défaut est choisi arbitrairement). Il pourra changer d'action s'il le souhaite avec la fonctionnalité "Affichage du cours d'une action".
### Affichage du cours d'une action

1. L'utilisateur clique sur le nom de l'action auquel il veut visualiser la courbe d'action, la liste des actions étant affichée sur la partie gauche de la page
2. Le système affiche la courbe correspondante
 ![[Affichage-cours-action]]

### Affichage du prix au jour n
Le jeu est au jour N.
1. L'utilisateur entre la valeur n dans la case "jour".
	1.1.  Si n est tel que 1 <= n <= N. La valeur de l'action au jour n s'affiche.
	1.2. Sinon, le système affiche un message d'erreur, l'utilisateur appuie sur "ok" et retourne à la page où la courbe de l'action est affichée.
#### Diagramme de séquence pour l'affichage du prix d'une action réussie

![[Affichage-prix-réussie]]

#### Diagramme de séquence pour l'affichage du prix d'une action échouée
![[Affichage-prix-échouée]]
