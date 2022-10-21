import React from 'react';
import { Collapse, Navbar, NavbarBrand, NavbarText, NavbarToggler, NavItem, NavLink } from 'reactstrap';
import {  Link } from "react-router-dom";
import './navbar.css';
import logo from '../../images/millenniumpuzzle.png'
import cardbtn from '../../images/ButtonCards.png'
import banbtn from '../../images/ButtonBanlist.png'

const navbar= () =>{
  

  
  return (
    <header>
        <Navbar className="fixed-top navbar bg-info">
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
                  </NavItem>
                </ul>
              </Collapse>
            </div>
          </div>
        </Navbar>
      
    </header>
  );
}
export default navbar;