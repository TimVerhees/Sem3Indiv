import React, {useEffect} from 'react';
import { Collapse, Navbar, NavbarBrand, NavbarText, NavbarToggler, NavItem, NavLink } from 'reactstrap';
import {  Link } from "react-router-dom";
import './navbar.css';
import logo from '../../images/millenniumpuzzle.png'
import cardbtn from '../../images/ButtonCards.png'
import banbtn from '../../images/ButtonBanlist.png'

let accesstoken = "";
let parsedtoken = "";

const MyNavbar= () =>{
  
  // useEffect(() => {
  //   document.getElementById("welcomer").value = `Welcome, ${parsedtoken.sub}` 
  //   TokenParser
  // },[]) 

  useEffect(() => {
        TokenParser()  
      },[localStorage.getItem("accesstoken")]);

  function TokenParser(){
    if(localStorage.getItem("accesstoken") != null){
      parsedtoken = JSON.parse(window.atob(localStorage.getItem("accesstoken").split('.')[1]))
      return parsedtoken}
    }

  TokenParser()

  function handleLogOut(){
    localStorage.removeItem("accesstoken");
    window.location.reload();
  }
  return (
    <header>
        <Navbar className="fixed-top navbar bg-info">
          {localStorage.getItem("accesstoken") != null &&
          <p id="welcomer" className='welcome-pos'>Welcome, {parsedtoken.sub}</p>}
          <div class="navbar-expand-md">
            <div class="navbar-collapse ">
              <Collapse>
                <ul class="navbar-items nav-center">
                  <NavItem className="nav-item-align">
                    <NavLink tag={Link} to='/cards'>
                    <img src={cardbtn} className="nav-btn" ></img>
                    </NavLink>
                  </NavItem>
                  <NavItem>
                    <NavLink tag={Link} to="/">
                      <img src={logo} className="main-image"></img>
                    </NavLink>
                  </NavItem>
                  <NavItem className="nav-item-align">
                    <NavLink tag={Link} to="/banlist">
                    <img src={banbtn} className="nav-btn" ></img>
                    </NavLink>
                    {localStorage.getItem("accesstoken") != null &&
                <a href="#" className="logout-pos" onClick={handleLogOut}>Log out</a>}
                  </NavItem>
                </ul>
                
              </Collapse>
            </div>
          </div>
        </Navbar>
      
    </header>
  );
}
export default MyNavbar;