import { useEffect, useState } from "react";
import { User, UserCard } from "../../components/UserCard/UserCard";

const useUsers = () => {

  const [users, setUsers] = useState<User[]>([]);
  const [loading, setLoading] = useState<boolean>(true);
  const [error, setError] = useState<string | null>(null);

  useEffect(
    () => {
      const fetchUser = async () => {
        setLoading(true);
        setError(null);
        try{
          const response = await fetch("https://jsonplaceholder.typicode.com/users");
          if (!response.ok) throw new Error("Erreur lors de la récupération des utilisateurs.");
          const data = await response.json();
          setUsers(data);
        } catch (err) {
          setError((err as Error).message);
        } finally {
          setLoading(false);
        }
      };
      fetchUser();
    }, []);
    return {users, loading, error};
};

export default useUsers;
