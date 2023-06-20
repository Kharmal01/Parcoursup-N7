# Projet théorie des graphes N7

## Lancer le programme
**Attention:** Ce Projet utilise Java 17
```
Vérifier que les 2 fichiers dans lib soient enregistré en tant que biblithèque dans le projet
Vérifier que les 2 jeux de tests (test.csv et test2.csv) soient à la racine du projet

Lancer Main.java avec votre IDE
```

## Exemple
```
Nom du fichier contenant les données: test.csv
Voulez-vous favoriser les écoles ? (y/n): y
[Ecole 1, Ecole 2, Ecole 3]
[Elève 1, Elève 2, Elève 3, Elève 4, Elève 5, Elève 6, Elève 7, Elève 8, Elève 9, Elève 10, Elève 11, Elève 12, Elève 13, Elève 14]
Lancement de l'algorithme de marriage stable...

Lancement du tour 1
-- Lancement étape 1
-- Lancement étape 2
Résultat du tour: 
- Sans correspondance: [Ecole 3]
- Etape 1: {Elève 10=[Ecole 1, Ecole 3], Elève 2=[Ecole 1], Elève 6=[Ecole 1], Elève 5=[Ecole 1, Ecole 3], Elève 8=[Ecole 1], Elève 9=[Ecole 1], Elève 11=[Ecole 2], Elève 1=[Ecole 1], Elève 14=[Ecole 2], Elève 3=[Ecole 1], Elève 4=[Ecole 1], Elève 13=[Ecole 1]}
- Etape 2: {Elève 10=[Ecole 1], Elève 2=[Ecole 1], Elève 6=[Ecole 1], Elève 5=[Ecole 1], Elève 8=[Ecole 1], Elève 9=[Ecole 1], Elève 11=[Ecole 2], Elève 1=[Ecole 1], Elève 14=[Ecole 2], Elève 3=[Ecole 1], Elève 4=[Ecole 1], Elève 13=[Ecole 1]}

Lancement du tour 2
-- Lancement étape 1
-- Lancement étape 2
Résultat du tour: 
- Sans correspondance: [Ecole 3]
- Etape 1: {Elève 10=[Ecole 1], Elève 2=[Ecole 1, Ecole 3], Elève 6=[Ecole 1], Elève 5=[Ecole 1], Elève 8=[Ecole 1], Elève 9=[Ecole 1], Elève 11=[Ecole 2], Elève 1=[Ecole 1], Elève 14=[Ecole 2], Elève 3=[Ecole 1], Elève 4=[Ecole 1], Elève 13=[Ecole 1, Ecole 3]}
- Etape 2: {Elève 10=[Ecole 1], Elève 2=[Ecole 1], Elève 6=[Ecole 1], Elève 5=[Ecole 1], Elève 8=[Ecole 1], Elève 9=[Ecole 1], Elève 11=[Ecole 2], Elève 1=[Ecole 1], Elève 14=[Ecole 2], Elève 3=[Ecole 1], Elève 4=[Ecole 1], Elève 13=[Ecole 1]}

Lancement du tour 3
-- Lancement étape 1
-- Lancement étape 2
Résultat du tour: 
- Sans correspondance: [Ecole 3]
- Etape 1: {Elève 10=[Ecole 1], Elève 2=[Ecole 1], Elève 8=[Ecole 1], Elève 12=[Ecole 3], Elève 6=[Ecole 1], Elève 5=[Ecole 1], Elève 9=[Ecole 1], Elève 11=[Ecole 2], Elève 1=[Ecole 1], Elève 14=[Ecole 2], Elève 3=[Ecole 1], Elève 4=[Ecole 1, Ecole 3], Elève 13=[Ecole 1]}
- Etape 2: {Elève 10=[Ecole 1], Elève 2=[Ecole 1], Elève 8=[Ecole 1], Elève 12=[Ecole 3], Elève 6=[Ecole 1], Elève 5=[Ecole 1], Elève 9=[Ecole 1], Elève 11=[Ecole 2], Elève 1=[Ecole 1], Elève 14=[Ecole 2], Elève 3=[Ecole 1], Elève 4=[Ecole 1], Elève 13=[Ecole 1]}

Lancement du tour 4
-- Lancement étape 1
-- Lancement étape 2
Résultat du tour: 
- Sans correspondance: [Ecole 3]
- Etape 1: {Elève 10=[Ecole 1], Elève 2=[Ecole 1], Elève 8=[Ecole 1], Elève 12=[Ecole 3], Elève 6=[Ecole 1], Elève 5=[Ecole 1], Elève 9=[Ecole 1], Elève 11=[Ecole 2], Elève 1=[Ecole 1, Ecole 3], Elève 14=[Ecole 2], Elève 3=[Ecole 1], Elève 4=[Ecole 1], Elève 13=[Ecole 1]}
- Etape 2: {Elève 10=[Ecole 1], Elève 2=[Ecole 1], Elève 8=[Ecole 1], Elève 12=[Ecole 3], Elève 6=[Ecole 1], Elève 5=[Ecole 1], Elève 9=[Ecole 1], Elève 11=[Ecole 2], Elève 1=[Ecole 1], Elève 14=[Ecole 2], Elève 3=[Ecole 1], Elève 4=[Ecole 1], Elève 13=[Ecole 1]}

Lancement du tour 5
-- Lancement étape 1
-- Lancement étape 2
Résultat du tour: 
- Sans correspondance: []
- Etape 1: {Elève 10=[Ecole 1], Elève 7=[Ecole 3], Elève 2=[Ecole 1], Elève 8=[Ecole 1], Elève 12=[Ecole 3], Elève 6=[Ecole 1], Elève 5=[Ecole 1], Elève 9=[Ecole 1], Elève 11=[Ecole 2], Elève 1=[Ecole 1], Elève 14=[Ecole 2], Elève 3=[Ecole 1], Elève 4=[Ecole 1], Elève 13=[Ecole 1]}
- Etape 2: {Elève 10=[Ecole 1], Elève 7=[Ecole 3], Elève 2=[Ecole 1], Elève 8=[Ecole 1], Elève 12=[Ecole 3], Elève 6=[Ecole 1], Elève 5=[Ecole 1], Elève 9=[Ecole 1], Elève 11=[Ecole 2], Elève 1=[Ecole 1], Elève 14=[Ecole 2], Elève 3=[Ecole 1], Elève 4=[Ecole 1], Elève 13=[Ecole 1]}

Fin de l'algorithme de marriage stable !
  Durée de l'algorithme: 30ms

Ecole 1 => Elève 10, Elève 2, Elève 8, Elève 6, Elève 5, Elève 9, Elève 1, Elève 3, Elève 4, Elève 13
Ecole 2 => Elève 11, Elève 14
Ecole 3 => Elève 7, Elève 12

Process finished with exit code 0```