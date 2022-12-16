# TP1

## Questions
### 4.1.2 Commentaires
Les commentaires en java sont gérées de la même
manière qu'en C.
### 4.1.3 Les bonnes pratiques
- Est-ce que le code est commenté?
- Est-ce que les variables respectent le même schéma (camelCase, snake_case)?
- La portée des variable?
- etc
### 4.1.4 Attributs
1. Les Types construits sont "Points", "Etat", "Sexe" (coord, etat, sexe).
2. Les Types primitifs sont des "int" (currentId, id, age).
3. Les attributs de classe sont "currentId" qui est un attribut statique, tous les autres sont des attributs d'instances.
4. Etat et Sexe sont des énumérations elles ont leurs propre fichier java. 
5. L'objet Etat n'est pas primitif si on ne l'initialise pas, il prendra la valeur déjà présente dans la mémoire.
6. Onillustre ici le pilier de l'Abstraction. On déclare les différentes variables sans les utiliser.
### 4.1.5 Les constructeurs
1. C'est le mot "this"
2. Oui c'est ce que l'on a utilisé pour Animals.
3. Oui on le peut mais ce n'est pas très réaliste.
4. Oui on le peut désormais, le code va aller vers le constructeur adéquat et il va lui attribuer les coordonées (0,0)

