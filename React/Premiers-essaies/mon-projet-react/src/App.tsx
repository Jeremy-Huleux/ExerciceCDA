
import './App.css'
import ClickButton from './Bouton';
import Form from './Form';
import Greeting from "./Greetings";
import Saisie from './Saisie';
import UserCard from './UserCard';




function App() {

  return (
    <div>
      <Greeting />
      <UserCard name="Jérémy"  />
      <ClickButton />
      <Saisie/>
      <Form />
    </div>
  )
}

export default App
