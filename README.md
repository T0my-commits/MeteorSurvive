# MeteorSurvive

**MeteorSurvive** est un jeu 2D réalisé en JavaFX dans le cadre d'un projet de 2ème année de DUT Informatique.

Le but du jeu est de faire survivre un dinosaure de la chute de météorites et donc de faire survivre son espèce. Le jeu sera en 2D avec un dinosaure qui se déplace sur l’axe horizontal. Des météorites tomberons de plus en plus vite et de plus en plus nombreuses au fil du temps. A chaque fois que le dinosaure heurte une météorite il perd de la vie mais il peut en regagner grâce au bonus qui apparaîtrons (gains de vie, augmentation de la hauteur du saut, regains de pets). Le jeu pourra mémoriser les scores et avoir un tableau des meilleurs score établis. Le dinosaure peut péter pour faire exploser les météorites et se défendre. Quand les météorites explosent, elles peuvent libérer des items pour regagner  de la vie ou sauter plus haut. Le joueur peut enregistrer son nom lorsqu’il joue et l’associer à son score.

Ce projet est composé de 3 dossiers :

- ***Documentation*** : contient les fichiers "*en vrac*" qui ont servis à créer la documentation finale (diagrammes UML, sketchs, etc...)
- ***Sources*** : contient les sources du projet, le code
- ***Rendu*** : contient le compte-rendu du projet

Certaines répertoires du dossier ***sources*** ont une utilité précise :

- ***rscr*** : contient les ressources du projet
   - ***FXML*** : contient les fenetres FXML (préfixées du mot `Fenetre`)
   - ***media*** : contient les images, sons, bruitages du projet répartis en sous-dossiers
- ***src*** : contient les sources du projet
   - ***model*** : contient les classes métier
   - ***view*** : contient les classes liées aux vues FXML via un data-binding (préfixées du mot `View`)

Bon courage !
