import './Banlist.css'
import '../../style.css'
import React, { useState } from 'react';
import axios from 'axios';
import TestCard1 from '../../images/TestCard.png'
import "https://kit.fontawesome.com/0a786263d3.js";


const URL = '//localhost:8080/banlists'

const Banlist = () =>{
  const [banlists, setBanlist] = useState([]);
    React.useEffect(() => {
    axios.get(URL).then((response) => {
      //response.data.CARDS! .cards IS IMPORTANT ALWAYS USE IT.
      setBanlist(response.data.banlists);
      
    });
  }, []);

  const [BCards, setBCards] = useState([]);
  function BanClick(e){
    document.querySelector("body").classList.toggle("active")
    axios.get(URL+"/"+ e.target.id).then(res => {
    setBCards(res.data.banlistItems);
    })}


  function HideOnClick(){
    document.querySelector("body").classList.toggle("active")
  }

  return (
    <div>
    <body>
    <div class="wrapper">
      <div class="sidebarblist">
      <a href="#" onClick={HideOnClick}
        className="fas fa-arrow-left fa-2x back-arrow"></a>
        <div class="cd-img">
          <div class="blist-wrap">
              <div className="ban-body">
              {BCards.map((cardlists) => (
                console.log(cardlists.bantype),
                cardlists.cards.map((realcards) => (
                <div className="ban-pos">
                  <p className="list-name">{cardlists.bantype}</p>
                <div className="ban-img">
                  <img src={realcards.card_image}></img>
                  <p className="text-deco">{realcards.name}</p>
                </div>
                </div>)
                )))}
              </div>
          
        </div>
      </div>
      </div>
      </div>
    </body>
    <div className="section">
      <table>
        <div>
          <tr>
            <th className='t1'>Banlist</th>
            <th className='t2'>User</th>
          </tr>
          {banlists.map(banlist => (
          <div key={banlist.id}>
            <tr>
            <a href="#" onClick={BanClick}><td id={banlist.id} key={banlist.id} className='t1'>{banlist.name}</td></a>
              <td className='t2'>{banlist.user.username}</td>
            </tr>
          </div>
          
        ))}
        
        </div>
      </table>
      </div>
      </div>
      
      
    
  );
}
export default Banlist;

//Banlist.js