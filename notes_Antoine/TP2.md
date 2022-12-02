# TP2

## 4.2.1.2 Comparaison d'instances

2. Les variables objets contiennent un pointeur vers l'emplacement mémoire de la structure de l'objet. Ces deux instances étant distinctes en mémoie, la comparaison échoue car les pointeurs sont différents.
4. La méthode `.equals()` retourne le bon résultat, là où la comparaison avec l'opérateur `==` n'a pas été modifiée. En effet, Java supporte l'overload de méthodes mais pas d'opérateurs.
5. Les chaînes de caractère sont aussi des objets, par conséquent leur variables stockent aussi leur valeur de pointeur et devraient donc être différentes et retourner false

## 6.3.3 Classe de tests

1. On sépare la classe contenant notre objet Main pour assurer l'axiome de responsabilité unique de chaque objet.
3. Il y a une erreur car on a pas importé les classes du dossier tp.model.agents

## 6.3.4 Animal et Agent

1. Le code est plus court car la classe Agent permet de le réutiliser pour chaque classe héritant Agent.
2. Le principe de single responsability ? Least Effort ?

## 6.4

2. Les classes qui pourraient être abstraites sont Agent, Animal, Abeille, Frelon, Decor et Vegetal puisqu'ils ne sont pas des classes finales.
