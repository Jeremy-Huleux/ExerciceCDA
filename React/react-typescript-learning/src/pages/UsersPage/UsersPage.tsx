import { useEffect, useState } from "react";

import { User, UserCard } from "../../components/UserCard/UserCard";
import style from "./UsersPage.module.css"
import useUsers from "../Hook/useUsers";
// TODO importer les utilisateurs du fichier "/assets/data/users.tsx"

// TODO ajouter le css modulaire pour cette page

const UsersPage = () => {
    // Déclaration d'un state permettant de stocker les utilisateur
    //OLD sans hook personnalisé
    //const [users, setUsers] = useState<User[] | [] >([]);
    const { users, loading, error} = useUsers();

    // TODO compléter ce useEffect qui se déclenche à la création du composant
    // Dans un premier temps : complétez le avec la tableau d'utilisateurs provenant du fichier "assets/data/users.tsx"
    //
    // Dans un deuxième temps, ajoutez une requête HTTP pour l'obtention des données
    // Url à utiliser : https://jsonplaceholder.typicode.com/users
    // Tutoriel pouvant vous aider : https://dev.to/antdp425/react-fetch-data-from-api-with-useeffect-27le
    //OLD sans hook personnalisé
    // useEffect(() => {
    //     // TODO mise à jour du state
    //         try{
    //             fetch("https://jsonplaceholder.typicode.com/users")
    //             .then(response => response.json())
    //             .then(donnees => setUsers(donnees));
    //         }catch(e){
    //             console.log(e);
    //         }
    // }, []);

    return (
        <div className={style.usersContainer}>
            {loading && <p>Chargement des utilisateurs...</p>}
            {error && <p style={{ color: "red"}}>{error}</p>}
            {users.length > 0 && users.map((user) => <UserCard key={user.id} user={user}/>)}
        </div>

        //OLD sans hook personnalisé
        // <div className={style.usersContainer}>
        //     {users.length > 0 && users.map((user) => (<UserCard key={user.id} user={user}/>))}
        // </div>
        // // TODO faire interface graphique pour la liste des utilisateurs
        // // Pour générer les "cards" utilisateur veillez à vous servir du composant "UserCard
    );
}

export default UsersPage;