import React, {useState} from 'react';
import Login from './login/Login';
import {BrowserRouter, Route, Routes} from "react-router-dom";
import Register from "./register/Register";




export default function DdinggeunMarket() {

    const [authenticated, setAuthenticated] = useState(false);
    const [customer, setCustomer] = useState(null);



    return (
        <Login setAuthenticated={setAuthenticated} setCustomer={setCustomer}/>
    );
}