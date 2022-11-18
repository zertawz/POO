# TP1

## Questions
### 4.1.2 Commentaires

Les commentaires utilisés sont des commentaires en une seule ligne `//` et en plusieurs lignes avec `/* .. */`.

### 4.1.3 Bonnes pratiques

Le code respecte bien les bonnes pratiques (nom variables, commentaires etc).

### 4.1.4 Attributs

1. Types construits: `Point, Etat, Sexe` (coord, etat, sexe)
2. Types primitifs: `currentId, id, age` (int) (ont une taille fixe en mémoire)
3. Attributs de classe: `currentId` (static)
Attributs d'instance: `Point, Etat, Sexe, id, age`
4. `Etat` et `Sexe` sont des énumérations, elles sont déclarées dans leur propre fichier .java
5. Initialiser `Etat` dès sa création est recommandé, sinon ce sera la valeur présente déjà en mémoire qui sera utilisée. On pourrait autrement la déclarer dans la classe puis l'initialiser dans le constructeur.
6. Le pilier ilustre le pilier d'Abstraction, on déclare seulement les données internes sans détailler la manière dont oin va les utiliser.

### 4.1.5 Constructeurs

1. `this` dégisne l'instance en cours de création
2. Un constructeur peut servir d'autre constructeur en utilisant la syntaxe `this(params)`.
3. On peut créer un Animal d'âge 25
4.

### 4.1.6 
 
