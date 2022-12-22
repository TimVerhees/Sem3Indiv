import { Dropdown } from "reactstrap";
import '../../style.css'
import axios from 'axios';
function CreateCard(){

    function handleSubmit(){
        axios
            .post("//localhost:8080/cards", {
            name: document.getElementById("cardName").value,
            desc: document.getElementById("cardDesc").value,
            type: document.getElementById("selectType").value,
            attribute: document.getElementById("selectAttribute").value,
            atk: document.getElementById("atk").value,
            def: document.getElementById("def").value,
            level: document.getElementById("level").value,
            link: document.getElementById("link").value,
            race: document.getElementById("cardRace").value,
            ogbanlist: document.getElementById("ogban").value,
            card_image: "https://res.cloudinary.com/dz6wz2wfd/image/upload/v1671196663/TestCard_hhqo2l.png"
            })
    }

    return(
            <div className="create-wrap">
                <h1 className="header-pos">Create a card</h1>
                <div className="input-create-contain">
                    <input id="cardName" className="create-txt" placeholder="Enter card name..."></input>
                    <textarea id="cardDesc" className="create-txt desc-sizer" placeholder="Enter card description..."></textarea>
                    <div className="select-align">
                        <select id="selectType" className="create-select create-select-type" placeholder="Select card type">
                            <option className="placeholder-txt" disabled selected>Select type...</option>
                            <option>Monster Card</option>
                            <option>Spell Card</option>
                            <option>Trap Card</option>
                        </select>
                        <select id="selectAttribute" className="create-select">
                            <option className="placeholder-txt" disabled selected>Select Attribute...</option>
                            <option>None</option>
                            <option>Earth</option>
                            <option>Dark</option>
                            <option>Wind</option>
                            <option>Water</option>
                            <option>Fire</option>
                        </select>
                    </div>
                    <p className="optional-laberer">Only applicable for Monster Card</p>
                    <div className="atk-def-align">
                        <label>Attack</label><input id="atk" step="100" className="atk-def-txt" defaultValue={"0"} type="number"></input>
                        <label>Defense</label><input id="def" step="100" className="atk-def-txt" defaultValue={"0"} type="number"></input>
                    </div>
                    <div className="atk-def-align">
                        <label>Level</label><input id="level" className="atk-def-txt" defaultValue={"0"} type="number"></input>
                        <label>Link</label><input id="link" className="atk-def-txt" defaultValue={"0"} type="number"></input>
                    </div>
                    <input id="cardRace" className="create-txt" placeholder="Enter card race..."></input>
                    <div className="select-align">
                    <select id="ogban" className="create-select ban-select">
                            <option className="placeholder-txt" disabled selected>Banned in tcg/ocg?</option>
                            <option>None</option>
                            <option>TCG</option>
                            <option>OCG</option>
                            <option>TCG/OCG</option>
                        </select>
                        </div>
                        <button href="#" onClick={handleSubmit} className="submit-btn">Submit</button>
                </div>
                
            </div>
    )
}
export default CreateCard;