
// TODO import du module CSS propre à ce composant
// Plus d'informations sur le CSS modulaire : https://create-react-app.dev/docs/adding-a-css-modules-stylesheet/
import styles from './UserCard.module.css'; // Import css modules stylesheet as styles

// TODO ajouter toutes les interface nécessaire à la représentation des données utilisateur de la web API suivante : https://jsonplaceholder.typicode.com/users
// Plus d'information sur comment faire des objets imbriqués en Typescript : https://www.geeksforgeeks.org/how-to-define-interfaces-for-nested-objects-in-typescript/
export interface Coordinates {
    lat: string,
    lng: string
}

export interface Company {
    bs: string,
    catchPhrase: string,
    name: string

}
export interface Address {
    city: string,
    geo: Coordinates,
    street: string,
    suite: string,
    zipcode: string

}
// TODO ajouter les interfaces manquantes

export interface User {
    id: number,
    name: string,
    username: string,
    email: string,
    phone: string,
    website: string,
    company: Company,
    address: Address
    // TODO compléter cette interface
}

export const UserCard = ({ user } : { user: User }) => {
    // if(!user || !user.name) return null;
    return (
        <div className={ styles.userCard }>
            <h3>{user.name}</h3>
            <p><strong>Username:</strong> {user.username}</p>
            <p><strong>Email:</strong> {user.email}</p>
            <p><strong>Phone:</strong> {user.phone}</p>
            <p><strong>Website:</strong> <a href={`https://${user.website}`} target="_blank" rel="noopener noreferrer">{user.website}</a></p>
            <div>
                <h3>Address:</h3>
                <p>{user.address.suite} {user.address.street}, {user.address.city}, {user.address.zipcode}</p>
            </div>
            <div>
                <h3>Company:</h3>
                <p>{user.company.name}</p>
                <p>{user.company.catchPhrase}</p>
                <p>{user.company.bs}</p>
            </div>
        </div>
    )
}
