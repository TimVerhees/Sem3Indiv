import axios from '../../http-common';
import React, { useImperativeHandle, useState } from 'react';
import '../../style.css'

const URL = '//localhost:8080/cards'
var cdimg = "https://res.cloudinary.com/dz6wz2wfd/image/upload/v1671194611/El%20Shaddoll%20Construct.jpg";
let foundImg = '';
let parsedtoken = "";

function Cards(){
  const [cardimg, setCardimg] = useState();
  const [imgsrc, setImgsrc] = useState();
  const [cards, setCard] = useState([]);
    React.useEffect(() => {
    axios.get(URL).then((response) => {
      setCard(response.data.cards);
    });
  }, []);

  React.useEffect(() => {
    TokenParser()  
  },[localStorage.getItem("accesstoken")]);

  const [cname, setCname] = useState([]);
  const [cdesc, setCdesc] = useState([]);
  const [catk, setCatk] = useState([]);
  const [cdef, setCdef] = useState([]);
  const [clvl, setClvl] = useState([]);
  const [crace, setCrace] = useState([]);
  const [cattribute, setCattribute] = useState([]);
  const [cimage, SetCimage] = useState();
  const [cid, SetCid] = useState();
  
  function CarderClick(e){
    document.getElementById("imgWarning").setAttribute("style", "display: none")
    document.querySelector("body").classList.toggle("active")
    setTimeout(() => axios.get("/cards/"+ e.target.id).then(res => {
      SetCid(res.data.id)
      setCdesc(res.data.desc)
      setCname(res.data.name)
      setCatk(res.data.atk)
      setCdef(res.data.def)
      setClvl(res.data.level)
      setCattribute(res.data.attribute)
      setCrace(res.data.race)
      SetCimage(res.data.card_image)
      if(res.data.card_image === "https://res.cloudinary.com/dz6wz2wfd/image/upload/v1671196663/TestCard_hhqo2l.png"){
        document.getElementById("requestBtn").setAttribute("style", "display: table")
      }
      else{
        document.getElementById("requestBtn").setAttribute("style", "display: none")
      }
    }), 500) 
  }
  function TokenParser(){
    if(localStorage.getItem("accesstoken") != null){
      parsedtoken = JSON.parse(window.atob(localStorage.getItem("accesstoken").split('.')[1]))
      return parsedtoken}
    }
  TokenParser()
 
 async function getCardImg(){
    await axios.get(`/cardimages/${cname}`)
        .then(async (resp) => {
          resp.data.data.map((cdimgarr) => {
            console.log(cdimgarr.card_images[0].image_url)
            foundImg = cdimgarr.card_images[0].image_url})
            console.log(cname)
            console.log(foundImg)
            await axios.put(`/cardimages/updateImage/${cid}`,{
                    card_image: foundImg,  
                    name: cname
                  }
            )}).catch((e) => {
              document.getElementById("imgWarning").setAttribute("style", "display: flex")
            })
  }

  if (!cards) return null;
  return (
    <div>
    <body>
      <div class="wrapper">
                <div class="sidebar">
                    <div class="cd-img">
                        <img src={cimage} ></img>
                          <h2 >{cname}</h2>
                          <div class="desc-box detail-txt">
                           <p>Description: {cdesc}</p> 
                           <p>Attack: {catk} Defense: {cdef}</p>
                           <p>Level: {clvl} </p>
                           <p>Race: {crace} Attribute: {cattribute}</p>
                          </div>
                          
                    </div>
                    <p id="imgWarning" className="image-warning">No image found for this card's name!</p>
                    <div className="request-positioner">
                      <button id="requestBtn" className="request-btn" onClick={getCardImg}>Request image</button>
                    </div>
                </div>
            </div>
        </body>
    
    <div class="body-positioner">
      {parsedtoken.Role == "Admin" &&
      <div className="btn-centerer">
      <a href="/createcard" id="createBtn" className="submit-btn btn-pos">Create Card</a>
      </div>}
      <div class="wrap">
        {cards.map((card, key) => (
          
          <div class="card-align w3-card-2 w3-container">
            <img onClick={CarderClick} key={card.id} id={card.id} src={card.card_image} class="card-sizing" href="#"></img>
          <p class="txt-middle">{card.name}</p>
        </div>))
        }
      </div>
      </div>
      </div>
      
           
  );
  

}
    
    
export default Cards;