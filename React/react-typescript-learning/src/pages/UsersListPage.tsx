import { FunctionComponent, useReducer } from "react";

enum UsersAction {
    ADD = 'ADD',
    DELETE = 'DELETE',
}
const userData: Array<User> = [
    {
        id:1,
        name: 'kunal',
        age: 22,
        admin: true
    },
    {
        id:2,
        name: 'rounak',
        age: 23,
        admin: false
    },
    {
        id:3,
        name: 'utkarsh',
        age: 22,
        admin: false
    },   
]

interface User {
    id: number,
    name: string,
    age: number,
    admin: boolean
}

interface UsersList extends Array<User> {

}

const onDispatchUsersList = (usersState: UsersList, action: UsersAction): UsersList => {
    console.log("Méthode associé au reducer");

    return usersState;
}

/**
 * Le hook "userReducer" permet de centraliser dans une fonction la mise à jour d'états.
 * 
 * Ci-dessous la déclaration d'un reducer dans un composant React : 
 * const [state, dispatch] = useReducer(reducerMethod, initialValue)
 * 
 * La "reducerMethod" contient la logique de modification de l'état.
 * 
 */
const UsersListPage: FunctionComponent = () => {

    const [usersState, dispatch] = useReducer(onDispatchUsersList, userData);

    return (
        <>
            <h2>Utilisateurs :</h2>
            <ol>
                {
                    usersState.map((u: User) => {
                        return <li>{ u.name }</li>
                    })
                }
            </ol>
        </>
    )
}

export default UsersListPage;