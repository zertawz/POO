# Séance 3

**Code importé d'e-campus, section8-normal**

## 8

### 8.3

3. sInstaller est finale car elle n'a pas besoin d'être redéfinie dans les classes filles.
4. Deplacable permet de faire une fonction cycle dans `Agents` vérifiant si l'objet est un déplacable plutôt que de tester si un objet est un `Animal`.
5. Peut acceuillir permet de savoir si l'objet considéré peut exécuter la commande acceuillir et donc si c'est un hébergeur
6. On ajoute un argument Ruche à son constructeur

## 9 collections

### 9.1

1. `LinkedList`, `Iterator`
2. Une énumération prend une valeur parmi un ensemble, une liste contient plusieurs valeurs
3. Iterator ne marche que dans un sens (premier au dernier élément), ListIterator permet de parcourir la liste dans l'autre sens
4. `ArrayList` est optimisée en lecture (array, donc si deletion, shift de tous les autres éléments) et non en écriture au contraire d'une `LinkedList` (il faut traverser la liste à chaque fois que l'on veut accéder à élément)
5. `ameliorerEtat()` et `aggraverEtat()` sont finales car elles n'ont pas besoin d'être redéfinies, elles sont "finales" dans leur fonctionnement et ne nécessitent pas de précision / information supplémentaire disponibles dans les classes filles.

### 9.2

1. `instanceof` n'est pas portable puisqu'il faut modifier ajouter / supprimer un cas à chaque fois
2. En faisant une collection "proie" on peut facilement modifier la liste des proies sans pour autant avoir à rajouter des cas particuliers avec des `instanceof`

1. `ArrayList<Class<? extends Animal>>` est une `ArrayList` d'objets `Class` inconnues `?` héritant d'`Agents`
2. Celle liste contient des classes héritant d'`Agents`
3. `getClass()` renvoir un objet de type `Class`
5. On ne teste plus un type, on teste si le type de l'objet est dans la liste des proies il faut donc un test d'égalité plutôt qu'un `instanceof`

### 9.3

5. Les abeilles ne sont pas classées dans l'ordre
6. En ajoutant une méthode compareTo() on peut alors classer la liste
7. Mettre un main dans une classe à tester ne doit être utilisé que pour du test de cette classe isolée, cette fonction doit également être supprimée lors de la fin des tests.


## 10 Monde

### 10.1 
