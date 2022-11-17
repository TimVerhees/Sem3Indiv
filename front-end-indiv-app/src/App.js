import './App.css';
import {Route, Routes, BrowserRouter as Router } from "react-router-dom";
import React from 'react';
import Navbar from "./components/navbar/navbar"
import Card from "./pages/Cards/Cards"
import Banlist from "./pages/Banlists/Banlist"
import Home from "./pages/Home"
import {Layout} from "./components/Layout"

function App() {
  return (
    <Layout>
      <Router>
        <Navbar />
        <Routes>
          <Route path="/" exact element={<Home />} />
          <Route path='/cards' exact element={<Card />} />
          <Route path='/banlist' element={<Banlist />} />
        </Routes>
      </Router>
    </Layout>
  );
}

export default App;
