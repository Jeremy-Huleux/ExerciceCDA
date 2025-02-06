function Form(){
  const submit = (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault();//empêche le rechargement
    console.log("Formulaire soumis !");
  };

  return (
    <form onSubmit={submit}>
      <button type="submit">Envoyer</button>
    </form>
  )
}
export default Form