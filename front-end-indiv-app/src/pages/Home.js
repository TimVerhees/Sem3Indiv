import React, { useState } from 'react';
import http from "../http-common";
import styled from "styled-components";
import '../style.css'
import TestCard1 from '../images/TestCard.png'

const URL = '//localhost:8080/home'

function Home(){

    //var carder = document.querySelector(".carder");
    function CarderClick(){
        document.querySelector("body").classList.toggle("active")
    }

    return (
        <html>
        <header>
            <div>
                This is the home page!

            </div>
            <div class="section">
                <div >
                    <a href="#" onClick={CarderClick}>Click me!</a>
                </div>
            </div>
        </header>

        <body>
            <div class="wrapper">
                <div class="sidebar">
                    <div class="cd-img">
                        <img src={TestCard1}></img>
                        <h1>Test Card</h1>
                        <p> Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                    </div>
                </div>
            </div>

        </body>
        </html>
    )
}

export default Home;