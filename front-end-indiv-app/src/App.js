import './App.css';
import {Route, Routes, BrowserRouter as Router } from "react-router-dom";
import React from 'react';
import MyNavbar from "./components/navbar/navbar"
import Card from "./pages/Cards/Cards"
import Banlist from "./pages/Banlists/Banlist"
import Home from "./pages/Home"
import {Layout} from "./components/Layout"
import CreateCard from './pages/Cards/CreateCard';
import Messaging from './pages/Messaging/Messaging';
import SignUp from './pages/SignUp';

function App() {
  return (
    <Layout>
      <Router>
        <MyNavbar />
        <Routes>
          <Route path="/" exact element={<Home />} />
          <Route path="/signup" exact element={<SignUp />} />
          <Route path='/cards' exact element={<Card />} />
          <Route path='/banlist' element={<Banlist />} />
          <Route path='/createcard' element={<CreateCard />} />
        </Routes>
        <Messaging />
      </Router>
    </Layout>
  );
}

export default App;
