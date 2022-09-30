import './App.css';
import {Route, Routes, BrowserRouter as Router } from "react-router-dom";
import React from 'react';
import Navbar from "./components/navbar/navbar"
import Card from "./pages/navbar/Cards"
import Banlist from "./pages/navbar/Banlist"
function App() {
  return (
    <Router>
      <Navbar />
      <Routes>
        <Route path='/' exact element={<Card />} />
        <Route path='/banlist' element={<Banlist />} />
      </Routes>
    </Router>
  );
}

export default App;
