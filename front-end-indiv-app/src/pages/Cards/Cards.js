import axios from 'axios';
import React, { useImperativeHandle, useState } from 'react';
import '../../style.css'

const URL = '//localhost:8080/cards'
var cdimg = "../../images/TestCard.png";
function Cards(){
  const [cardimg, setCardimg] = useState();
  const [imgsrc, setImgsrc] = useState();
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

  function imgUpdater(card){
    console.log(card.card_image)
    if (card.card_image != null){
      const cdimg = card.card_image
    }
    else {cdimg = "../../images/TestCard.png"}
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

  function getCardImg(){
    axios
        .get(`//localhost:8080/cardimages/${cname}`)
        .then((resp) => 
        resp.data.data.map((cdimgarr) => console.log(cdimgarr.card_images[0].image_url)))
  }

  if (!cards) return null;
  return (
    <div>
    <body>
      <div class="wrapper">
                <div class="sidebar">
                    <div  class="cd-img">
                        <img src={require(`../../images/TestCard.png`)} ></img>
                          <h2 >{cname}</h2>
                          <div class="desc-box detail-txt">
                           <p>Description: {cdesc}</p> 
                           <p>Attack: {catk} Defense: {cdef}</p>
                           <p>Level: {clvl} </p>
                           <p>Race: {crace} Attribute: {cattribute}</p>
                          </div>
                          <a href="#" onClick={getCardImg}> Test</a>
                    </div>
                </div>
            </div>
        </body>
    
    <div class="body-positioner">
      <div class="wrap">
        {cards.map((card, key) => (
          
          <div class="card-align w3-card-2 w3-container">
            <img onClick={CarderClick} key={card.id} id={card.id} src={require("../../images/TestCard.png")} class="card-sizing" href="#"></img>
          <p class="txt-middle">{card.name}</p>
        </div>))
        }
      <div><p><button onClick={updateOnClick}>Update to Pot of Duality</button></p></div>
      <div><p><button onClick={pageReload}>Reload page</button></p></div>
      </div>
      </div>
      </div>
      
           
  );
  

      }
    
    
export default Cards;