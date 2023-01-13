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
 function pencilClick(){
  document.getElementById("editbox").setAttribute("style", "display: flex")
  document.getElementById("cardnameside").setAttribute("style", "display: none")
  document.getElementById("checkicon").setAttribute("style", "display: flex !important")
  document.getElementById("xicon").setAttribute("style", "display: flex !important")
 }
 function handleCheckClick(){
  console.log(document.getElementById("editbox").value)
  console.log(cid)
    axios
        .put(`/cards/${cid}`,{
          name: document.getElementById("editbox").value
        }).then(
          document.getElementById("editbox").setAttribute("style", "display: none"),
          document.getElementById("checkicon").setAttribute("style", "display: none !important"),
          document.getElementById("xicon").setAttribute("style", "display: none !important"),
          document.getElementById("cardnameside").setAttribute("style", "display: flex"),
          setCname(document.getElementById("editbox").value)
        ).catch((e) => {
          window.alert("Bruh")
        }) 
  }
  
  function handleDelete(){
    let confirm = window.confirm("Are you sure you want to delete this card?")
    if (confirm){
      axios
        .delete(`cards/${cid}`)
        .then(window.setTimeout(window.location.reload.bind(window.location), 1300)
          
        )
    }
  }

  function handleXClick(){
    document.getElementById("editbox").setAttribute("style", "display: none !important")
    document.getElementById("checkicon").setAttribute("style", "display: none !important")
    document.getElementById("xicon").setAttribute("style", "display: none")
    document.getElementById("cardnameside").setAttribute("style", "display: flex")
  }
 
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
                  },
                  setTimeout(window.location.reload.bind(window.location), 1300)
            ).then(window.location.reload)}).catch((e) => {
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
                        <div className="sidebar-namepos">
                          <h2  id="cardnameside">{cname}</h2>
                          {parsedtoken.Role == "Admin" &&
                          <i onClick={handleDelete} class="fa-solid fa-2xl fa-trash icon-trash-pos"></i>}
                          {parsedtoken.Role == "Admin" &&
                          <i href="#" onClick={pencilClick} class="fa-solid fa-pencil icon-pencil-pos"></i>} 
                          {parsedtoken.Role == "Admin" &&
                          <input id="editbox" defaultValue={cname} className="edit-box"></input>}
                          {parsedtoken.Role == "Admin" &&
                          <i id="checkicon" onClick={handleCheckClick} class="fa-solid fa-lg fa-check icon-check-pos"></i>}
                          {parsedtoken.Role == "Admin" &&
                          <i id="xicon" onClick={handleXClick} class="fa-solid fa-lg fa-x icon-x-pos"></i>}
                          </div>
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