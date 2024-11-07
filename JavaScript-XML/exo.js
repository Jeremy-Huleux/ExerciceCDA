// let personne = {
//   nom: "Huleux",
//   prenom: "Jérémy",
//   age: 34,
//   saluer: function () {
//     console.log("Salut ! " + this.prenom + " " + this.nom);
//   },
// };

// const text = (a, b, c) =>
//   console.log(
//     "Salut ! " +
//       personne.nom +
//       " " +
//       personne.prenom +
//       " Tu as : " +
//       personne.age +
//       " ans"
//   );

// personne.saluer();

// text();

// let voiture = {
//   marque: "Tesla",
//   model: "X",
//   annee: 2024,
// };

// console.log(voiture);

// voiture["annee"] = 2023;

// console.log(voiture);

// voiture.couleur = "Bluje";

// console.log(voiture);

// delete voiture.model;

// console.log(voiture);

// for (cle in voiture) {
//   console.log(voiture[cle]);
// }

// let maPromesse = new Promise((resolve, reject) => {
//   setTimeout(() => {
//     let success = false;
//     if (success) {
//       resolve("Succes après 2s !");
//     } else {
//       reject("Echec après 2s !");
//     }
//   }, 2000);
// });

/*maPromesse
  .then((resultat) => console.log(resultat))
  .catch((erreur) => console.log(erreur));
*/
// async function testerPromesse() {
//   try{
//     let message = await maPromesse;
//     console.log(message);
//   }catch(erreur){
//     console.log(erreur);
//   }
// }

//testerPromesse();

async function testXML() {
  try {
    const reponse = await fetch("https://rss.app/feeds/CCPB6d7l5UKlrEEC.xml")
      .then((reponse) => reponse.text())
      .then((dataDeLaReponse) => {
        //mettre ici les fonctions de gestion de la reponse
        affichage(dataDeLaReponse);
      })
      .catch((error) => console.log("Erreur :", error));
  } catch {
    console.log(error);
  }
}

function affichage(data) {
  const parse = new DOMParser();
  const doc = parse.parseFromString(data, "text/xml");
  //Pour visualiser la première node
  //console.log(doc.documentElement.nodeName);
  //On va chercher nos nodes
  let elementsTitle = doc.querySelector("rss").querySelector("channel");
  //Pour vérifier les nodes et aller chercher les nodes que l'on a besoin
  //console.log(elementsTitle);

  //Je créer un objet intro pour un appel plus simple
  let intro = {
    titre: elementsTitle.querySelector("title").textContent,
    description: elementsTitle.querySelector("description").textContent,
  };

  //On remplis le h2
  let h2 = document.getElementById("titleBase");
  h2.innerText = intro.titre;

  //On remplis de p
  let pDescription = document.getElementById("titleDescription");
  pDescription.innerText = intro.description;

  //On vas chercher les données des donnes d'articles
  let articles = elementsTitle.querySelectorAll("item");

  //foreach pour mettre tous les articles
  articles.forEach((article) => {
    let unArticle = document.getElementById("rss-feed");
    let h4Article = document.createElement("h4");
    let descriptionArticle = document.createElement("article");
    //On récupére le ce qui nous interesses et on le mets dans le text content du h4
    h4Article.textContent = article.childNodes[0].textContent;
    //On met dans le h4 dans l'article
    unArticle.appendChild(h4Article);
    //lors de la recuperation du XML à l'interieur il y avait du HTML
    //Donc on parse le textcontent en text/html
    let desc = parse.parseFromString(
      article.childNodes[1].textContent,
      "text/html"
    );
    //On va chercher le text content dans l'objet html récupérer
    descriptionArticle.textContent = desc.querySelector("div").querySelector("div").textContent
    //On le met dans l'article
    unArticle.appendChild(descriptionArticle);
  });
}

testXML();
