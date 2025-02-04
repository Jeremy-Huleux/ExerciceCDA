/**
 * TODO définir l'interface qui représente un contact.
 * 
 * Informations :
 * - id
 * - name
 * - address
 */
interface Contact {
  id: number;
  name: string;
  address:string;
}

/**
 * Renvoie l'adresse d'un contact.
 * 
 * @param contact Le contact à traiter
 * @returns l'adress du contact
 */
export function getAddress(contact:Contact): string {
  return contact.address;
}

/**
 * Renvoie le nombre d'amis d'une liste de contacts
 * 
 * @param friends La liste de contact concernée
 * @returns Le nombre d'amis
 */
export function howManyFriends(friends:Contact[]): number {
  return friends.reduce((accumulateur) => accumulateur + 1 , 0);
}

/**
 * Renvoie l'adresse de "Batman" si celui-ci est présent dans le tableau.
 * Renvoie "null" si "Batman" n'est pas dans le tableau.
 * 
 * @param contacts Tableau de contacts à traiter 
 * @returns Une adresse ou "null"
 */
export function findTheBat(contacts:Contact[]): string | null {
  return contacts.find(contact => contact.name === "Batman") != undefined ? contacts.find(contact => contact.name === "Batman").address : null;
}

// ----------- CLEF OPTIONNELLES -----------

/**
 * TODO définir l'interface qui représente un utilisateur.
 * 
 * Documentation : https://www.typescriptlang.org/docs/handbook/interfaces.html#optional-properties
 * 
 * Informations :
 * - name (obligatoire)
 * - verified : indique si le compte utilisateur a été vérifié, booléen. Obligatoire et par défaut à "false" (obligatoire)
 * - address (optionnel)
 * - picture : url vers une image (optionnel)
 * - email : email de l'utilisateur (optionnel)
 */
interface User {
  name:string;
  verified:boolean;
  address?:string;
  picture?: string;
  email?:string;
}

/**
 * Crée un objet "User" nom vérifié à partir d'un nom.
 * 
 * @param name Le nom de l'utilisateur
 * @returns Nouvel objet "User"
 */
export function generateNewUser(name:string): User {
  const user: User = {name: name, verified: false};
  return user;
}

/**
 * Crée un nouvel objet "User" et :
 * - met à jour son email avec celui passé en paramètre
 * - passe le nouvel utilisateur en "vérifié"
 * 
 * Pour copier et mettre à jour l'objet passé en paramètre il vous est conseillé
 * d'adopter une approche basée sur le "spread operator" de JS.
 * 
 * Plus d'informations sur cette opérateur : 
 * https://dev.to/abhay_yt_52a8e72b213be229/mastering-the-spread-operator-for-objects-and-arrays-in-javascript-4efp#adding-new-properties-to-an-object
 * 
 * @param user L'objet utilisateur initial
 * @param email Nouvel email en chaîne de caractères
 * @returns Nouvel objet "User" avec les informations à jour
 */
export function verifyUser(user:User, email:string): User {
  //const newUser: User = {name: user.name, verified: user.verified, address: user.address, picture: user.picture, email: email};
  const newUser: User = {...user, email: email, verified: true};
  return newUser;
}


/**
 * Met à jour un objet "User" avec l'url vers une photo de profile.
 * 
 * @param user L'objet "User" à modifier
 * @param pictureUrl L'URL vers la photo de l'utilisateur
 * @returns Nouvel objet "User" avec les informations à jour
 */
export function updateUserPhoto(user:User, pictureUrl:string): User {
  const newUser: User = {...user, picture: pictureUrl};
  return newUser;
}


/**
 * Renvoie l'url vers l'image de l'utilisateur.
 * 
 * Si cette URL n'est pas présente dans l'objet, renvoyer une URL vers une photo de chien -> https://place.dog/300/200 
 * 
 * @param user L'objet "User" concerné par l'opération
 * @returns La chaîne de caractères attendue
 */
export function getUserPhoto(user:User): string {
  return user.picture === undefined ? "https://place.dog/300/200" : user.picture;
}

/**
 * Retrouve un objet "User" situé dans un Json qui liste plusieurs utilisateurs.
 * 
 * Pour plus d'information sur la structure du Json à traiter veillez vous référer au fichier de test "getUser.test.ts"
 * 
 * Vous pouvez vous servir de la ressource suivante pour boucler sur les objets :
 * https://developer.mozilla.org/fr/docs/Web/JavaScript/Reference/Global_Objects/Object/entries
 * 
 * @param id La valeur de la clef dans le Json à traiter
 * @param users Le Json comprenant plusieurs objets "User"
 * @returns L'objet "User" retrouvé ou "null" si aucun utilisateur associé à la clef
 */
export function getUser(id:number, users:JSON): User | null {
  const unUserObject: JSON | undefined = Object.entries(users).find(([key,value]) => key == id)?.[1];
  if(typeof unUserObject === "undefined"){
    return null;
  }else{
    let newUser: User = {name:"default", verified:false};
    Object.entries(unUserObject).forEach(([clef,valeur]) => {
        if(clef === "name") newUser.name = valeur;
        if(clef === "address") newUser.address = valeur;
        if(clef === "verified") newUser.verified = valeur;
        if(clef === "picture") newUser.picture = valeur;
        if(clef === "email") newUser.email = valeur;
      });
      return newUser;
  }
}
