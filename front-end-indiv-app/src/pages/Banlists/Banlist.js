import './Banlist.css'
import '../../style.css'
import React, { useState } from 'react';
import axios from 'axios';


const URL = '//localhost:8080/banlists'

const Banlist = () =>{
  const [banlists, setBanlist] = useState([]);
    React.useEffect(() => {
    axios.get(URL).then((response) => {
      //response.data.CARDS! .cards IS IMPORTANT ALWAYS USE IT.
      setBanlist(response.data.banlists);
    });
  }, []);
  console.log(banlists);

  return (
    
      <table>
        <div>
          <tr>
            <th className='t1'>Banlist</th>
            <th className='t2'>User</th>
          </tr>
          {banlists.map(banlist => (
          <div key={banlist.id}>
            <tr>
            <td className='t1'>{banlist.name}</td>
              <td className='t2'>{banlist.user.username}</td>
            </tr>
          </div>
        ))}
        </div>
      </table>
    
      
    
  );
}
export default Banlist;

//Banlist.js