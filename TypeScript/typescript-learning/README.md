# Katas TypeScript

Ce dépôt contient une collection d'exercices pour vous aider à découvrir TypeScript.

Ces exercices prennent la forme de **tests unitaires** à compléter. Les fonctions à compléter sont dans le sous-dossier `function`

Pour commencer à développer vous devez installer les dépendances du définies dans le fichier `package.json` :
- `npm install`

Pour exécuter un test d'un fonction il est possible d'utiliser la commande suivanute :
```bash
npm test <functionName>
```

Par exemple, pour exécuter le test de la première fonction du fichier `1-types.ts` nommée `getGreeting` :
```bash
npm test getGreeting
```

Une fois que vous avez implémenté toutes les fonctions d'un fichier, vous pouvez exécuter tous les tests avec npm test <filename>, par exemple :
```bash
npm test 1-types
npm test 2-functions
# etc...
```

## Qu'est-ce que TypeScript ?

TypeScript est un sur-ensemble de JavaScript qui vient ajouter des fonctionnalités au language.

TypeScript ajoute notamment le **typage** des données.

Par exemple, nous ne pouvons pas changer une variable d'une chaîne de caractères à un nombre, ni passer un nombre à une fonction qui attend une chaîne de caractères.

C'est un langage à **typage statique**, ce qui signifie que les types des variables et des fonctions sont connus au moment de la compilation, plutôt qu'à l'exécution.

La suite de ce README vous permettra d'avoir une vision d'ensemble des capacités du language.

Une excellente documentation pour l'apprentissage du langage est disponible à l'adresse suivante : [https://www.typescriptlang.org/docs/handbook/typescript-in-5-minutes.html](https://www.typescriptlang.org/docs/handbook/typescript-in-5-minutes.html)


## Notion de typage

TypeScript propose plusieurs [types](https://www.typescriptlang.org/docs/handbook/2/everyday-types.html), qui sont similaires à ceux de JavaScript, mais avec des fonctionnalités supplémentaires.

### Types de base

Voici une liste des types de base utilisables :
- string
- number
- boolean
- null
- any -> type définissant "n'importe quel type"

Pour définir une variable, il est possible d'ajouter le type après le nom de la variable, par exemple :
```ts
const myString: string = "hello"

let total: number = 0
```

Il est aussi possible de laisser le transpileur TypeScript de déduire automatiquement le type (on parle alors d'[inférence de type](https://fr.wikipedia.org/wiki/Inf%C3%A9rence_de_types)) :
```ts
const myString = "hello"

let total = 0
```

### Fonction : types des paramètres et type de retour

En TypeScript, nous définissons les types des paramètres et le type de retour d'une fonction, par exemple :
```ts
function add(a: number, b: number): number {
  return a + b
}
```

Nous pouvons également définir les types des paramètres et du type de retour d'une **fonction fléchée**, par exemple :

```ts
const add = (a: number, b: number): number => {
  return a + b
}
```

#### Paramètres optionnels dans les fonctions

Contrairement à JavaScript, TypeScript refuse les appels de fonction n'ayant pas le même nombre de paramètre que ceux attendus.

Nous pouvons rendre un paramètre optionnel en ajoutant un **'?' après le nom du paramètre**, par exemple :
```ts
function greet(name?: string): string {
  return name ? `Hello ${name}` : "Hello World"
}
```

> [!NOTE]
> Dans le cas d'un paramètre manquant la variable prend la valeur `undefined`

### Alias de types et types union


Parfois, il est utile d'avoir un **autre nom** pour un type. Nous pouvons utiliser un **alias de type** pour cela, par exemple :
```ts
type MyString = string
```

Les alias de types sont souvent utilisés avec un type union, qui est un type qui peut être **l'un des types possibles**, par exemple :
```ts
type NumberOrNull = number | null
```

ou lorsque plusieurs options sont possibles pour un type, par exemple :
```ts
type Grade = "A" | "B" | "C" | "D" | "E" | "F"
```

Les unions et les alias de types peuvent être utilisés partout où l'on pourrait utiliser un type classique, comme dans les fonctions :

```ts
// Utilisation d'une union
// value peut être une "string" ou un "number"
function log(value: string | number): void {
  console.log(value)
}

// Utlisation d'un alias de type
type MyStringOrNumber = string | number

// Ici le résultat est le même qu'avec la première proposition
// value peut être une "string" ou un "number"
function log(value: MyStringOrNumber): void {
  console.log(value)
}
```

### Tableaux

Lorsque nous identifions le type d'un tableau, nous devons savoir quel type de contenu le tableau aura, par exemple le tableau suivant sera **inféré** comme `number[]`:
```ts
const myArray = [1, 2, 3]
```

Par contre, celui ci-après sera inféré comme `(number | string)[]` (soit un tableau d'union de `number` et ``string`).
```ts
const myArray = [1, "2", 3]
```

Lorsque des tableaux sont retournés ou passés en paramètres à des fonctions, nous devons connaître le type du tableau (et donc le type des éléments dans le tableau), par exemple :
```ts
function sum(array: number[]): number {
  let total = 0
  array.forEach((num) => total += num)
  return total
}
```

### Tuples

Les tuples sont des tableaux de **longueur fixe**, exemple :
```ts
const myTuple: [string, number] = ["hello", 1]
const myOtherTuple: [string, number, boolean] = ["hello", 1, true]
```

### Assertions de type

Les **assertions de type** sont un moyen d'aider TypeScript à déduire le type d'une variable.

Nous pouvons utiliser le mot-clé `as` pour aider TypeScript à être plus spécifique ou plus général avec un type.

Sans les assertions de type, TypeScript déduira le type d'une variable en fonction de la valeur qui lui est assignée, par exemple :
```ts
  let oneOrNothing = 1
  oneOrNothing = null     // cela entraînera une erreur, car nous avons dit précédemment à TypeScript que oneOrNothing est un nombre

  const nums = []
  nums.push(1)
  nums.push("hello")     // cela devrait entraîner une erreur, mais TypeScript a inféré que nums est de type any[]
```

Ou nous pouvons utiliser les assertions de type pour aider TypeScript à **inférer le type d'une variable**, par exemple :

```ts
type potentialNumber = number | null

let oneOrNothing = 1 as potentialNumber
oneOrNothing = null           // oneOrNothing est un nombre OU null

const nums = [] as number[]
nums.push(1)
nums.push("hello")            // erreur car "hello" n'est pas un nombre
```

### Objets et interfaces

Il est possible de définir la **structure d'un type objet** (aussi nommé JSon, qui est un tableau associatif) en utilisant une `Interface`, par exemple :

```ts
// Déclaration d'une interface "Person"
interface Person {
  name: string
  age: number
}

const person1 = {
  name: 'Michael',
  age: 35,
}
```

> [!CAUTION]
> Les interfaces en TypeScript n'ont rien à voir avec les interfaces en POO traditionnelle.
> Pour rappel : une interface est une classe abstraite ne contenant que des **méthodes sans implémentation**.

#### Clés optionnelles dans les interfaces

Toutes les clés ne sont pas toujours nécessaires pour les objets.
Il est possible de rendre une clé optionnelle en ajoutant un `?` après le nom de la clé, par exemple :
```ts
interface Person {
  name: string
  age?: number // rend l'âge optionnel
}

// il est donc possible de créer une variable cille suit
const person1 = {
  name: 'Michael',
}

const person2 = {
  name: 'Deborah',
  age: 32,
}
```

> [!CAUTION]
> Utilisez cette capacité deavec parcimonie.
> Les propriétés obligatoires permettent de détecter les erreurs tôt et rendent notre code plus sûr (c'est la raison pour laquelle TypeScript est utilisé).
> Évitez donc de rendre des clés optionnelles à moins que vous n'ayez une raison spécifique.

### Records

Parfois, nous avons des structures de données qui sont des paires clé-valeur, mais nous ne savons pas quelles clés spécifiques elles auront (bien que nous connaissons le type des valeurs).

Pour cela, nous pouvons utiliser un type `Record`, qui est une description de paires clé-valeur, par exemple :

```ts
let usersAge = {
  Bob: 10,
  Laura: 20,
  Ada: 30,
  Charles: 96,
}
```

aurait le type Record<string, number> car les clés sont des chaînes et les valeurs sont des nombres.

Ou pour un exemple plus large 
```ts
// interface définissant un chiot
interface Puppy {
  id: number // identifiant du chiot
  name: string // nom du chiot
  breed: string // race du chiot
  img?: string // photo (optionnel)
}

let pups: Record<string, Puppy[]>

pups = {
  Tedddy: [
    {
      id: 1,
      name: 'Teddy',
      breed: 'Labrador',
    },
    {
      id: 2,
      name: 'Zelda',
      breed: 'Golden Retriever',
    },
  ],
  Ada: [
    {
      id: 2,
      name: 'Lola',
      breed: 'Bulldog',
    },
  ],
}
```
