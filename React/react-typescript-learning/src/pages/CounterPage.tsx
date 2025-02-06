import { useEffect, useState } from "react";

const CounterPage = () => {
    /**
     * TODO Déclaration de l'état stockant la valeur du compteur
     * 
     * Plus d'information sur la déclaration des useState : https://www.carlrippon.com/typed-usestate-with-typescript/
     */

    const [compteur, clickSurLeBouton] = useState(0);

    
    const pourMontrerQueJeSaisFaireEnLeDeclarantDansUnConst = () => clickSurLeBouton(compteur - compteur.valueOf());
    /**
     * TODO implémenter Fonction permettant d'incrémenter l'état du compteur.
     * 
     * Utilisée en tant que "handler" d'un évènement "click".
     */

    /**
     * TODO implémenter un fonction permettant d'incrémenter l'état du compteur
     * 
     * Utilisée en tant que "handler" d'un évènement "click".
     */

    /**
     * On renvoie le JSX correspond à ce qui est à afficher
     */

    return (
        <>
            <h2>Compteur :</h2>
            <p>{compteur}</p>
            <button onClick={() => clickSurLeBouton(compteur+1)}>Cliquez pour incrémenter !</button>
            <button onClick={() => clickSurLeBouton(compteur-1)}>Cliquez pour décrémenter s'il vous plait !</button>
            <button onClick={pourMontrerQueJeSaisFaireEnLeDeclarantDansUnConst}>Cliquez pour réinitialiser s'il vous plait, en toute simplicité ! </button>
            {/* TODO compléter le code affichant le nombre de clics et des boutons */}
        </>
    )
}

export default CounterPage;