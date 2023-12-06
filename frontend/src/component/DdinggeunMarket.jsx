import React, {useState} from 'react';
import Login from '../view/login/Login';




export default function DdinggeunMarket() {

    const [authenticated, setAuthenticated] = useState(false);
    const [customer, setCustomer] = useState(null);

    return (
        <Login setAuthenticated={setAuthenticated} setCustomer={setCustomer}/>
    );
}