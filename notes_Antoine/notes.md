##Hashcode:
Retourne une "signature" de l'objet sous forme d'entier

### Définition:
Utilisé dans collections avec Hash (HashSet, HashMap...)
On range les objets dans des grandes boîtes (premier chiffre est un 1, un 2 etc)
Accès plus rapide (dichotomie)

Hashcode idéalement étendu / bonne dispersion

### Condition:	
* A = B => A.hashcode() = B.hashcode()
* A.equals(B) <=> B.equals(A)
* A.equals(B) et B.equals(C) => A.equals(C)

## Comparaison
4 (ou 5) méthodes:
* `==`
* `equals()`
* `compareTo()`
* `compare(a,b)`
* (`hashCode`)

## TreeSet
De base utilise `CompareTo` (implémenter interface `Comparable`)
