function Saisie(){
  const changement = (event: React.ChangeEvent<HTMLInputElement>) => {
    console.log("Valeur :", event.target.value);
  };

  return <input type="text" onChange={changement}/>;
}

export default Saisie