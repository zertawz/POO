# 4. Premier pas en objet: définition d'un modèle (une abstraction) d'Animal
# 4.1 Prise en main 
## 4.1.2 Commentaires
Les commentaires en java sont gérées de la même
manière qu'en C.

## 4.1.3 Les bonnes pratiques
- Est-ce que le code est commenté?
- Est-ce que les variables respectent le même schéma (camelCase, snake_case)?
- La portée des variable?
- etc

## 4.1.4 Attributs
1. Les Types construits sont `Points`, `Etat`, `Sexe` (coord, etat, sexe).
2. Les Types primitifs sont des `int` (currentId, id, age).
3. Les attributs de classe sont `currentId` qui est un attribut statique, tous les autres sont des attributs d'instances.
4. Etat et Sexe sont des énumérations elles ont leurs propre fichier java. 
5. L'objet Etat n'est pas primitif si on ne l'initialise pas, il prendra la valeur déjà présente dans la mémoire.
6. Onillustre ici le pilier de l'Abstraction. On déclare les différentes variables sans les utiliser.

## 4.1.5 Les constructeurs
1. C'est le mot `this`
2. Oui c'est ce que l'on a utilisé pour Animals.
3. Oui on le peut mais ce n'est pas très réaliste.
4. Oui on le peut désormais, le code va aller vers le constructeur adéquat et il va lui attribuer les coordonées (0,0)

## 4.1.6 Création des accesseurs et des mutateurs
Les Mutateurs (getters et setters) sont des méthodes qui respectivement permettent de lire ou d'écrire un valeur. La plupart du temps leurs accessibilité est public.
Ils permettent de faire de la saisie protégée ou de rajouter des conditions pour la modification d'une variable
Ils permettent également de structurer mieux le code et d'éviter que on place tous les attributs en public. La bonne pratique est de mettre les attributs en privés et intéragir avec par le biai des mutateurs.
La bonne pratique est de dire que seules le méthodes doivent permettre aux objets d'intéragir (code plus structuré et plus logique).
1. Les mutateurs sont crées.
2. Les mutateurs fonctionnent 
3. Les énumérations définissent quels sont les différentes possibilités, ce n'est pas le cas d'un objet "classique" 
4. Les tests se sont avérés concluents
5. On remarque que sans les accesseurs, au niveau du main de la classe on peut récupérer et modifier les attributs même si ils sont en private. Celà est du au fait que l'ont intéragit avec les attributs en étant dans la même classe.
6. Je ne vois pas l'interêt de mettre un accesseur en privé (c'est le seul accès qui me paraît inutile). En effet, les mutateurs permettent des interactions entre les classes (Accès et modification d'attributs), placer ces méthode en privé, empêcherait ces méthodes de réaliser ce pourquoi elles ont été concues.

## 4.1.7 Programmation des méthodes
### 4.1.7.1 La méthode vieillir
1. La bonne manière semble celle où on utilise les mutateurs codés précédement
2. J'ai changé d'avis les mutateur ont une utilité à être privés. En effet, on peut imaginer que l'age ne puisse être changé que par des éléments de la classe animal, le rôle du mutateur sera alors simplement d'ajouter une contrainte à ce changement d'attribut. En effet le fait de faire un mutateur pour changer proprement l'age dans notre classe nous permet d'éviter qu'un élément se mette à rajeunir. 
### 4.1.7.2 La méthode seDeplacer
1. Je ne sais pas trop, je dirais "minimaliste".
2. elle renvoit un `double`
3. Le transtypage primitif (à vérifier) est un processus dans lequel on change le type d'une variable quelconque pour le transformer en un type primitif par exemple un `int`.
### 4.1.7.3 La méthode getUniqueID 
1. Cette méthode est déclarée statique, cela signifie que cette méthode est liée à la classe et non à ses instances. Dans la pratique celà voudra dire que les objets seront incable d'utliser cette méthode (Incapable de se générer un ID)
2. On va avoir besoin d'utiliser une variable de classe, elle sera défini avec le mot clef `static`.
3. C'est fait.
4. getUniqueId est placé en private car cette méthode n'a pas vocation a être utilisée par d'autres classes.
5. Elle fonctionne.


# 4.2 Spécialisation d'Animal par rapport à sa classe mère Object
## 4.2.1 Redéfinition de comportements par défaut hérités d'Object
### 4.2.1.1 Représentation d'un Animal sous forme de chaîne de caractère
1. C'est la méthode `toString()`. Elle vient directement des fonctions implémentés dans java. Par défaut, elle retourne le nom de la classe et le hashcode de l'objet avec un @ pour séparer les deux parties.
2. Pour celà on redéfinit la méthode `toString()`. En tout cas c'est ce que je vais tenter de faire avec un `@Override`.
> Quel est la bonne méthode à utiliser dans le override récupérer les attributs ou utiliser les accesseurs?
En tout cas c'est réussis mais l'affichage des coordonnées n'est pas parfaitement satisfaisant.
3. On peut récupérer le nom de la classe par de méthodes spécifiques. On nous propose la classe `Class` dont je ne saisi pas correctement l'utilité et la méthode `getClass()` de la bibliothèque `Objet()`.
> D'où viennent ces classes de Java, nos classes déclarées dans le code en héritent toutes?
> Qu'est ce que l'API Java et la machine virtuelle java?
4. Celà est mieux car c'est plus généraliste. Si une autre classe a besoin de cette fonction, elle sera adaptée. Au hasard un classe plus bas niveau qui est un type spécifique d'Animal.
> Est-ce que ça pourrait illustrer l'abstraction?
5. Par défaut si onne met seulement l'objet, il va sortir le contenu de la méthode `toString()` lui spécifier d'afficher la méthode `toString()` est donc equivalent à lui donner seulement l'objet.
On note que `println()` permet seulement d'aller à la ligne après avoir affiché un output.
> Problème pour comprendre la doc (J'ai répondu par déduction).
> Qu'est-ce que ça veut dire de type `PrintStream`? Est-ce que celà veut dire qu'elle hérite de toute les méthode de la classe `PrintStream`?
6. L'abstraction d'une part (On peut toujours dire abtration) et encapsulation d'autre part.
7. Simplement en retournant 0 ou 1... (Je ne sais pas) 
### 4.2.1.2 Comparaison de deux instances d'Animal
1. C'est fait.

