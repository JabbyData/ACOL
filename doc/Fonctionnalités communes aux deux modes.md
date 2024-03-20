
### Passer au jour suivant 
Le jeu s'arrête quand le jour M est fini.
Ici, disons que l'utilisateur est au jour N <= M
1. L'utilisateur clique sur le bouton "passer"
2. 1. Si N = M : le jeu est fini, affichage d'une fenêtre "jeu terminé"
2. 2. Si le joueur est mode VP "visualisation portefeuille" :  il reste toujours dans ce mode après avoir fait 1. mais toutes les données sont actualisées au jour N+1 (valeur du portefeuille + mis à jour du graphique sur l'évolution de la valeur du portefeuille + mise à jour des valeur des titres détenus)

![[Passer-un-jour-réussie]]
![[Fin-de-jeu]]
### Passage d'un mode à l'autre
Pour changer de mode, l'utilisateur clique sur le bouton "switch". 

Il faut noter que si l'utilisateur a préalablement entrer des valeurs dans les cases de la page "visualisation courbe", le switch va faire perdre les données rentrées. Par exemple, si l'utilisateur est en mode "visualisation courbe" et il a entré une valeur dans la case "jour", en allant à la page "portefeuille" puis en revenant à "visualisation de courbe", cette valeur entrée n'y sera plus.

Lorsque l'utilisateur passe du mode "portefeuille" à "visualisation de courbe", c'est toujours la courbe de l'action par défaut qui est affichée. 

Lorsque l'utilisateur passe du mode AVA au mode VP, la fenetre "visualisation portefeuille s'ouvre avec les données actuelles". Attention aucun calcul n'est effectué, les données du portefeuilles sont mis à jour uniquement lors du passage au jour suivant.
![[Passage-mode]]


