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
3. On peut créer un Animal d'âge 25, celà permet de faire une population d'age variée sans avoir à répéter la fonction viellir()
4. Si on n'indique pas de coordonnées, le constructeur sans coordonée sera appelé et la position sera à sa valeur par défaut (0,0)

### 4.1.6 Assesseurs / Mutateurs

3. Une énumération est un objet, ne contenant aucun attribut ni aucune méthode0
6. Un mutateur peut être privé mais ne sera utilisable que dans la classe, là où la variable est totalement accessible, il ne servirait donc à rien.

### 4.1.7 Méthodes

#### 4.1.7.2 seDéplacer

1. Math.random fournit un chiffre aléatoire entre 0 et 1.
2. Elle fournit un type `double`
3. Le transtypage est la conversion d'un type en un autre, ici on convertit un `double` en `int`.

#### 4.1.4.3 getUniqueId

1. Cette méthode est déclarée statique car c'est une méthode qui assure le fonctionnement interne de notre classe Animal, elle ne doit donc pas pouvoir être parasitée depuis l'extérieur de la classe.
2. On utilise une variable de classe, qui est une variable partagée accessible par toutes les instances d'une classe.
3. Le mot clé `static` (pour les variables et les méthodes) fait référence à une variable ou une méthode de classe (/!\ `this` n'a plus de sens dans une méthode static).
4. UniqueId est `private` car l'ID d'objet est relatif au fonctionnement interne de notre classe et ne doit pas être accessible ni modifiable depuis l'extérieur.

### toString

1. La méthode toString retourne la description d'un objet sous forme de chaîne de caractère.
2. On override la fonction `toString` de notre objet grâce au décorateur `@Override` qui retourne une chaîne de caractères personnalisée.
3. On récupère le nom d'une classe grâce à la fonction `getClass().getName()`
4. On préfère utiliser cette manière plutôt que de hardcode "Animal" pour éviter d'avoir à modifier cette ligne si on change le nom de la classe.
5. `System.out.println(a)` appelle la commande `toString` des objets qui lui sont donnés.
6. Le pilier mis en oeuvre est le polymorphisme.
