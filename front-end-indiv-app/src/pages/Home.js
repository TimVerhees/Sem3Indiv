import React, { useState } from 'react';
import http from "../http-common";
import styled from "styled-components";
import '../style.css'

const URL = '//localhost:8080/home'

function Home(){

    return (
        <header>
            <div>
                This is the home page!
            </div>
        </header>
    )
}

export default Home;