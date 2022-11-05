import React from "react";
import logo from "./logo.svg";
import "./App.css";
import { Link } from "react-router-dom";

function App() {

    return (
        <div className="App">
            <header className="App-header">
                <img src={logo} className="App-logo" alt="logo" />
                <h1>Hi there, beware the following routes may exceed your memory.</h1>
                <Link to='/normal'>The normal method</Link>
                <Link to='/cached'>The cached method</Link>
                <Link to='/async'>The async method</Link>

            </header>
        </div>
    );
}

export default App;