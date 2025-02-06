type UserProps = {
  name: string,
  age?: number;
}

function UserCard({name, age = 18}:UserProps){
  return <p>{name} - {age} </p>
}

export default UserCard