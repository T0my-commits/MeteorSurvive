# MeteorSurvive

**MeteorSurvive** est un jeu 2D réalisé en JavaFX dans le cadre d'un projet de 2ème année de DUT Informatique.

Le but du jeu est de faire survivre un dinosaure de la chute de météorites et donc de faire survivre sont espèce. Le jeu sera en 2D avec un dinosaure qui se déplace sur l’axe horizontal avec des chutes de différentes météorites (plus ou moins grosses et vitesse en conséquence). A chaque fois que le dinosaure heurte une météorite il perd de la vie mais il peut en regagner grâce au bonus qui apparaitrons (gains de vie, boost de vitesse, …). Dans le fond de l’écran on verra au fil du temps les époques qui passe. Le jeu pourra mémoriser les scores et avoir un tableau des meilleurs score établis. Le dinosaure peut cracher des boules de feu pour faire exploser les météorites et se défendre.

Ce projet est composé de 3 dossiers :

- ***Documentation*** : contient les fichiers "*en vrac*" qui ont servis à créer la documentation finale (diagrammes UML, sketchs, etc...)
- ***Sources*** : contient les sources du projet, le code
- ***Rendu*** : contient le compte-rendu du projet

Certaines répertoires du dossier ***sources*** ont une utilité précise :

- ***rscr*** : contient les ressources du projet
   - ***FXML*** : contient les fenetres FXML (préfixées du mot `Fenetre`)
   - ***media*** : contient les images, sons, bruitages du projet répartis en sous-dossiers
- ***src*** : contient les sources du projet
   - ***model*** : contient les classes métier (préfixées du mot `Model`)
   - ***view*** : contient les classes liées aux vues FXML via un data-binding (préfixées du mot `View`)

Bon courage !
