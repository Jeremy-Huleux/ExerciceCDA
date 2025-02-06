function ClickButton(){
  const cliquez = (event: React.MouseEvent<HTMLButtonElement>) => {
    console.log("Button cliquez", event);
  };
  return <button onClick={cliquez}>Clique moa</button>;
}

export default ClickButton