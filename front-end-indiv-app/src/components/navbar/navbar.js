import React from 'react';
import {  Link } from "react-router-dom";
const navbar= () =>{
  return (
  <div>
    <li>
      <Link to="/">Cards</Link>
    </li>
    <li>
      <Link to="/banlist">Ban Lists</Link>
    </li>
  </div>
  );
}
export default navbar;