'use client'

import { useState } from "react"
import axios from 'axios'
import { useRouter } from "next/navigation"

function Inputbox({
    text, 
    placeholder, 
    action }) {

    return (
        <input type="text" value = {text} placeholder = {placeholder} onChange={(e) => action(e.target.value)}></input>
    )

}

function SubmitButton({ username, password, returnRes }) {
    const router = useRouter()
    const handleClick = async() => {
        try{
            console.log(username)
            console.log(password)
            const response = await axios.post('http://127.0.0.1:8080/login', {
                'username': username,
                'password': password
            },{
                withCredentials: false,
                responseType: 'text'
            })
            returnRes(response.data)

            if (response.data === "true"){
                router.push('/')
            }
        } catch(error){
            console.log(error)
        }

    }
    return (
        <button type="button" onClick={handleClick}>Submit</button>
    )
}


export default function LoginBox() {
    const [username, setUsername] = useState('')
    const [password, setPassword] = useState('')
    const [resData, setResData] = useState('')
    const router = useRouter()
    return (
        <form className="mb-32 grid lg:text-left">
            <Inputbox text={username} placeholder={"username"} action={setUsername} />
            <Inputbox text={password} placeholder={"password"} action={setPassword} />
            <SubmitButton  username={username} password={password} returnRes={(e) => setResData(e)}/>
            {resData}
        </form>
    )
}