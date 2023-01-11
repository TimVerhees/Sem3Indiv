import axios from 'axios';
import React, { useState } from 'react';
import * as ReactDOM from 'react-dom'
import '../style.css'

const URL = '//localhost:8080/login'
let accesstoken = "";
function Home(){
    
    function TextInputU(e){
        return(
            document.getElementById("UsernameLabel").innerHTML = "Username"
        )
    }
    function TextInputP(e){
        return(
            document.getElementById("PasswordLabel").innerHTML = "Password"
        )
    }
    function LogInput(){
        var x = document.getElementById("userTextbox").value
        var z = document.getElementById("passTextbox").value
        var element = document.getElementById("login_box")
        axios
            .post(URL,{
            username: `${x}`,
            password: `${z}`
        }).then((response) => {
            accesstoken = response.data.accessToken
            element.setAttribute("style", "display: none !important")
            document.getElementById("loginsucces").setAttribute("style","display: flex !important")
            localStorage.setItem("accesstoken", accesstoken)
            var parsedtoken = JSON.parse(window.atob(localStorage.getItem("accesstoken").split('.')[1]))
            window.location.reload()
            })
            .catch(error => {
                alert("Login Failed!")
            })
    }

    return( 
        <html>
        <body>
        <h3 id="loginsucces" className="succes-pos">Login succes!</h3>
            <div className="scroll-hide">
                <div class="home-wrap">
                    {localStorage.getItem("accesstoken") != null &&
                <p className="loggedin-pos">Logged in!</p>}
                {localStorage.getItem("accesstoken") == null &&
                    <div id="login_box" className="login-wrap">
                        <h1>LOGIN</h1>
                        <div className="input-contain">
                            <p id="UsernameLabel" className="input-label user-label"></p>
                            <input className="input-wrap input-user" placeholder="Username" id="userTextbox" onInput={TextInputU}></input>
                            <p id="PasswordLabel" className="input-label pass-label"></p>
                            <input type="password" className="input-wrap input-pass" placeholder="Password" id="passTextbox" onInput={TextInputP}></input>
                            <a href="/signup" className="signup-pos">Sign up</a>
                        </div>
                        
                        <a href="#" className="login-btn" onClick={LogInput}>Login</a>
                    </div>}
                </div>
            </div>
        </body>
        </html>
    )
}

export default Home;