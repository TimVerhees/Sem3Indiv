import axios from "axios";
import AuthHeader from "./AuthHeader";

export default axios.create({
    baseURL:"//localhost:8080",
    headers: {
        "Content-Type": "application/json",
        "Access-Control-Allow-Origin": "*",
        ...AuthHeader()
    }

})