import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import * as serviceWorker from './serviceWorker';
import Normal from './Normal';
import Cached from './Cached';
import Async from './Async';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import App from './App';

const routes = (
   < BrowserRouter >
      <Routes>
         <Route path="/" element={<App />} />
         <Route path="/normal" element={<Normal />} />
         <Route path="/cached" element={<Cached />} />
         <Route path="/async" element={<Async />} />
      </Routes>
   </ BrowserRouter >
);

ReactDOM.render(routes, document.getElementById('root'));

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();
