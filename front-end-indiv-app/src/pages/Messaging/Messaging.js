import React, { useState, useEffect } from 'react';
import SockJS from 'sockjs-client';
import Stomp from 'stompjs';
import { v4 as uuidv4 } from 'uuid';
import ChatMessagesPlaceholder from './ChatMessagesPlaceHolder';
import SendMessagePlaceholder from './SendMessagePlaceHolder';
import UsernamePlaceholder from './UserNamePlaceHolder';
// Set the backend location
const ENDPOINT = "http://localhost:8080/ws";

function Messaging() {

  const [stompClient, setStompClient] = useState();
  const [username, setUsername] = useState();
  const [messagesReceived, setMessagesReceived] = useState([]);


  useEffect(() => {
    // use SockJS as the websocket client
    const socket = SockJS(ENDPOINT);
    // Set stomp to use websockets
    const stompClient = Stomp.over(socket);
    // connect to the backend
    stompClient.connect({}, () => {
      // subscribe to the backend
      stompClient.subscribe('/topic/publicmessages', (data) => {
        console.log(data);
        onMessageReceived(data);
      });
    });
    // maintain the client for sending and receiving
    setStompClient(stompClient);
  }, []);

  // send the data using Stomp
  const sendMessage = (newMessage) => {
    const payload = { 'id': uuidv4(), 'from': username, 'to': newMessage.to, 'text': newMessage.text };
    if (payload.to) {
      stompClient.send(`/user/${payload.to}/queue/inboxmessages`, {}, JSON.stringify(payload));
    } else {
      stompClient.send('/topic/publicmessages', {}, JSON.stringify(payload));
    }
  };

  // display the received data
  const onMessageReceived = (data) => {
    const message = JSON.parse(data.body);
    setMessagesReceived(messagesReceived => [...messagesReceived, message]);
  };

  const onUsernameInformed = (username) => {
    setUsername(username);
    stompClient.subscribe(`/user/${username}/queue/inboxmessages`, (data) => {
      onMessageReceived(data);
    });
  }

  return (
    <div className="App wrap-pos">
      <UsernamePlaceholder username={username} onUsernameInformed={onUsernameInformed} />
      <br></br>
      <SendMessagePlaceholder username={username} onMessageSend={sendMessage} />
      <br></br>
      <ChatMessagesPlaceholder username={username} messagesReceived={messagesReceived} />
    </div>
  );

}

export default Messaging;