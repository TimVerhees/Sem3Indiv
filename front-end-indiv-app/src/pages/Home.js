import React, { useState } from 'react';
import '../style.css'

const URL = '//localhost:8080/home'

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
        console.log(x)
        console.log(z)
    }
    return (
        <html>
        <body>
            <div className="scroll-hide">
                <div class="home-wrap">
                    <div className="login-wrap">
                        <h1>LOGIN</h1>
                        <div className="input-contain">
                            <p id="UsernameLabel" className="input-label user-label"></p>
                            <input className="input-wrap input-user" placeholder="Username" id="userTextbox" onInput={TextInputU}></input>
                            <p id="PasswordLabel" className="input-label pass-label"></p>
                            <input type="password" className="input-wrap input-pass" placeholder="Password" id="passTextbox" onInput={TextInputP}></input>
                            
                        </div>
                        <a href="#" className="login-btn" onClick={LogInput}>Log input</a>
                    </div>
                </div>
            </div>
        </body>
        
       
        </html>
    )
}

export default Home;