import React, { useEffect } from 'react';
import Axios from 'axios';

/*export default function Parent() { 
    //get data from API
    const url = "http://localhost:8080/";

    const [cards, getCards] = useState(' ');

    useEffect( () => {
        getAllCards();
    }, []);

    const getAllCards = () => {
        Axios.get(`http://localhost:8080/cards`)
        .then((response) => {
            const allCards = response.data.cards.allCards;
            getCards(allCards);
        })
        .catch(error => console.error('Error: ', { error}));
    }
        return(
            <NoteTimeline cards= {cards}/>
        )

} */