import axios from 'axios';
import Axios from 'axios';
import React, { useState } from 'react';
import http from "../../http-common";
import styled from "styled-components";

const URL = '//localhost:8080/cards'

function Cards(){
  const [cards, setCard] = useState([]);
    React.useEffect(() => {
    axios.get(URL).then((response) => {
      //response.data.CARDS! .cards IS IMPORTANT ALWAYS USE IT.
      setCard(response.data.cards);
    });
  }, []);
  console.log(cards);
  
  function postOnClick(){
    axios
        .post(URL, {
          name: "Pot of greed",
          desc: "Draw 2 cards.",
          type: "Spell Card."
        })
        .then((response) => {
          setCard(response.data.cards);
        });
  }
  
  function pageReload(){
    window.location.reload(false);
  }
  
  function wrapperFunction() {
    postOnClick()
    .then(pageReload)
  }

  function wrapperFunction2() {
    deleteOnClick()
    .then(pageReload)
  }

  function updateOnClick(){
    axios
        .put(`${URL}/3`,{
          name:"Pot of Duality",
          desc:"Excavate the top 3 cards of your Deck, add 1 of them to your hand, also, after that, shuffle the rest back into your Deck. You can only activate 1 \"Pot of Duality\" per turn. You cannot Special Summon during the turn you activate this card."
        })
        .then((response) => {
          setCard(response.data.cards);
        })
  }
  function deleteOnClick(){
    axios
        .delete(`${URL}/3`)
        .then((response) => {
          setCard(response.data.cards);
        })
  }

  if (!cards) return null;
  return (
    <div>
      {cards.map(card => (
        <div key={card.id}>
          <p>{card.name}</p>
          <p>{card.desc}</p>
        </div>
      ))}
      <p><button onClick={wrapperFunction}>Post Pot of Greed</button></p>
      <div><p><button onClick={updateOnClick}>Update to Pot of Duality</button></p></div>
      <div><p><button onClick={wrapperFunction2}>Delete the third card</button></p></div>
      <div><p><button onClick={pageReload}>Reload page</button></p></div>
        </div>
  );
  

      }
    
    
export default Cards;