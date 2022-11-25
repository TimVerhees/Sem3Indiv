import axios from 'axios';
import Axios from 'axios';
import React, { useState } from 'react';
import http from "../../http-common";
import styled from "styled-components";
import '../../style.css'
import TestCard1 from '../../images/TestCard.png'

const URL = '//localhost:8080/cards'

const cardDesc = "";
function Cards(){
  const [cards, setCard] = useState([]);
    React.useEffect(() => {
    axios.get(URL).then((response) => {
      setCard(response.data.cards);
    });
  }, []);

  const [cname, setCname] = useState([]);
  const [cdesc, setCdesc] = useState([]);
  const [catk, setCatk] = useState([]);
  const [cdef, setCdef] = useState([]);
  const [clvl, setClvl] = useState([]);
  const [crace, setCrace] = useState([]);
  const [cattribute, setCattribute] = useState([]);
  function CarderClick(e){
    document.querySelector("body").classList.toggle("active")
    setTimeout(() => axios.get(URL+"/"+ e.target.id).then(res => {
      setCdesc(res.data.desc)
      setCname(res.data.name)
      setCatk(res.data.atk)
      setCdef(res.data.def)
      setClvl(res.data.level)
      setCattribute(res.data.attribute)
      setCrace(res.data.race)
    }), 500) 
  }

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
    <body>
      <div class="wrapper">
                <div class="sidebar">
                    <div class="cd-img">
                        <img src={TestCard1} ></img>
                          <h2 >{cname}</h2>
                          <div class="desc-box detail-txt">
                           <p>Description: {cdesc}</p> 
                           <p>Attack: {catk} Defense: {cdef}</p>
                           <p>Level: {clvl} </p>
                           <p>Race: {crace} Attribute: {cattribute}</p>
                          </div>
                          
                    </div>
                </div>
            </div>
        </body>
    
    <div class="body-positioner">
      <div class="wrap">
        {cards.map((card, key) => (
          <div  class="card-align w3-card-2 w3-container">
                  <img onClick={CarderClick} key={card.id} id={card.id} src={TestCard1} class="card-sizing" href="#"></img>
                <p class="txt-middle">{card.name}</p>
          </div>
      ))}
      <p><button onClick={wrapperFunction}>Post Pot of Greed</button></p>
      <div><p><button onClick={updateOnClick}>Update to Pot of Duality</button></p></div>
      <div><p><button onClick={wrapperFunction2}>Delete the third card</button></p></div>
      <div><p><button onClick={pageReload}>Reload page</button></p></div>
      </div>
      </div>
      </div>
      
           
  );
  

      }
    
    
export default Cards;