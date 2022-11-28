/* eslint-disable no-restricted-globals */
import {
  FormControl,
  Input,
  InputLabel,
  Button,
  FormHelperText,
} from '@mui/material';
import React from 'react';
import { useState } from 'react';

const Auth = () => {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [showPassword,setShow] = useState(false)

  const handleUsername = (value) => {
    setUsername(value);
  };

  const handlePassword = (value) => {
    setPassword(value);
  };

  const sendRequest = (path) => {

    if(path === "register") {
      fetch('http://192.168.1.16:1111/api/v1/users/', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({
          userName: username,
          password: password,
        }),
      })
        .then((res) => res.json())
        .catch((err) => console.log(err));
    }

    fetch('api/authentication/' + path, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({
        username: username,
        password: password,
      }),
    })
      .then((res) => res.json())
      .then((result) => {
        localStorage.setItem('tokenKey', "Bearer " + result.message);
        localStorage.setItem('currentUser', result.id);
        localStorage.setItem('username', username);
      })
      .catch((err) => console.log(err));
  };

  const handleButton = (path) => {
    sendRequest(path);
    setUsername('');
    setPassword('');
    setTimeout(() => {
      window.location.reload(true);
    }, 2000)
    //console.log(localStorage);
  }

  return (
    <div>
      <h1>Register & Login Blog</h1>
      <FormControl>
        <InputLabel>Username</InputLabel>
        <Input onChange={(i) => handleUsername(i.target.value)} />
        <InputLabel style={{ top: 80 }}>Password</InputLabel>
        <Input type={ showPassword ? "text":"password" }
          style={{ top: 40 }}
          onChange={(i) => handlePassword(i.target.value)}
        />
        <Button
          variant='contained'
          style={{ marginTop: 60, marginBottom: 30 }}
          onClick={() => handleButton('register')}
        >
          Register
        </Button>
        <FormHelperText style={{ margin: 20 }}>
          Are you already registered ?
        </FormHelperText>
        <Button variant='contained' onClick={() => handleButton('login')}>
          Login
        </Button>
      </FormControl>
    </div>
  );
};

export default Auth;
