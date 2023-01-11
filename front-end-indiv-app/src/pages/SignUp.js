import axios from 'axios';
import React, { useState } from 'react';
import { useNavigate } from "react-router-dom";
import '../style.css'

const URL = '//localhost:8080/users'
let accesstoken = "";

function SignUp(){
    const navigate = useNavigate();
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
    
    function handleSignUp(){
        var x = document.getElementById("userTextbox").value
        var z = document.getElementById("passTextbox").value
        var element = document.getElementById("login_box")
        axios.post(URL, {
            username: `${x}`,
            password: `${z}`,
            type: "User"
        }).then(
            element.setAttribute("style", "display: none !important"),
            document.getElementById("loginsucces").setAttribute("style","display: flex !important"),
            setTimeout(()=>{
            navigate("/")}, 3000)
        ).catch(error => {
            alert("Invalid sign up!")
        })
    }

    return (
        <html>
        <body>
        <h3 id="loginsucces" className="succes-pos">Sign up succes! Redirecting...</h3>
            <div className="scroll-hide">
                <div class="home-wrap">
                    <div id ="login_box"className="login-wrap">
                        <h1>Sign Up</h1>
                        
                        <div className="input-contain">
                            <p id="UsernameLabel" className="input-label user-label"></p>
                            <input className="input-wrap input-user" placeholder="Username" id="userTextbox" onInput={TextInputU}></input>
                            <p id="PasswordLabel" className="input-label pass-label"></p>
                            <input type="password" className="input-wrap input-pass" placeholder="Password" id="passTextbox" onInput={TextInputP}></input>
                            
                        </div>
                        <a href="#" className="login-btn" onClick={handleSignUp}>Register</a>
                    </div>
                </div>
            </div>
        </body>
        
       
        </html>
    )
}

export default SignUp;