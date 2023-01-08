# 4. Premier pas en objet: définition d'un modèle (une abstraction) d'Animal
- Abstraction
- Polymorphisme
- Encapsulation
- Héritage
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
2. Visiblement ces deux manières de comparer les choses sont similaires `==` et `equals()` je pense néanmoins que l'on peut `@Override` la fonction pour faire un test de comparaison plus spécifique, tandis que pour le `==` ce n'est pas possible. Reste à comprendre le comportement par défaut de `equals()` c'est à dire celui de `==`. Je vais rajouter de quoi tester le `==`.
3. Je l'ai faite à la main et j'ai appris à cast un objet ducoup
4. Maintenant quand on utilise `equals()` il va comparer les attributs et si les instances ont le même `sexe``age``etat` alors ils sont considérés comme égaux.
5. Deux quand on applique la méthode `equals()` a un objet de type `String` il reprends le comportement par défaut (On a overide seulement la méthode `equals()` de Animal celle de `Object` ne peut pas être overide car `Object` est une superclass) On doit alors s'attendre à un false quand on compare deux chaine de caractère similaire. Sauf qu'en java deux chaine de caractère similaire sont souvent stocké à la mếme adresse mémoire (qu'un seul enregistrement mémoire pour 2 variables) donc c'est `True` qui est renvoyé.


# 6. Héritage et polymorphisme
# 6.1 Nouvelles contraites
## 6.1.1 Définition des acteurs
## 6.1.2 Les agents
## 6.1.3 Les éléments de décors
Réadaption du code en cours. Quand on ajoute le setter de coordonées on va éviter de regénerer une nouvelle instance de point mais on va modifier l'objet déjà existant (notion de lien entre les objets).
Réadaptation terminé, je suis capble de lancer le code depuis le launcher.
J'ai sauté les étapes.


# 6.2 Mise en place de la hiérarchie des agents
Notion `d'interface` et de `responsabilité unique`, et `substitution de Liskov` pas très claires.


# 6.3 Conception d'une hiérarchie d'agents
## 6.3.1 travail préliminaire
1. J'avance un peu vite

## 6.3.2 Réutilisation du travail précédent
1. Fait!
2. Fait!
3. Fait avec VIM!

## 6.3.3 Classe de test
1. C'est un principe d'abstraction. Le lanceur lance et ne s'occupe pas du reste
2. Fait.
3. De mémoire j'avais une 30aines d'erreurs et celle du launcher était un import qui n'était pas fait.

## 6.3.4 Animal et Agent
1. Le code est plus répartit et plus logique. On ne devra pas coder plusieurs fois les éléments dans la classe fille.
2. C'est l'héritage qui est mis en oeuvre ici. On peut aussi parler d'abstraction.
3. Je ne saisi pas bien la question.

## 6.3.5 Hiérarchie complète des agents
1. je vais voir si je peux la voler.
2. En java on a 3 éléments:
- Les classes
- Les énum
- Les interfaces
Les interfaces: C'est quelque chose qui oblige l'implémentation de certaines méthodes dans la classe. Dans l'interface on définit seulement des fonctions (sous forme de prototype). Les interfaces utilisent le mot clef `implements`. Elle se code avec le mot clef `interface`. Elle correspond une contrainte, elle est très utile pour réaliser des collections car elle peut être utilisé pour "définir" le contenu de la liste. Ex: interface d'hebergeurs on peut donc faire un collection d'hebergeurs alors que les instances proviennent de classes différentes.
Pour répondre à la question: `Abeille` est un hébergeur ce qui fait que ses versions `AbeilleSolitaire` et `AbeilleDomestique` sont aussi des hébergeurs (Du `Varroa`).
3. C'est une fonctionnalité qui va donc être implémenté dans la classe `Animal`
4. Je vais skip et je regarderai comment celà à été codé (Je pense qu'on doit ajouter un attribut `Hebergeur` ainsi que des mutateurs).
5. Fonctionnalité qui doit être codée dans la classe abeille et probablement avec une `enumération`.


# 6.4 Décor
1. Pas fait la hiérarchie
2. toutes les classes abstraites sont des classes qui ne vont pas être directement instanciés. Ici il faut voir avec la hiérarchie.


# 7 Un peu d'algorithmie
Pas fait (Je reviendrai si le temps me le permet)


# 8 Les collections
# 8.2 Mise en place
## 8.2.1 Nouveau projet
Je suis en train de merge


# 8.3 Compléter le projet avec votre existant
C'est là où c'est la sauce...
