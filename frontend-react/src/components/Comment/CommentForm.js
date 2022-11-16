import React from 'react';
import { useState } from 'react';
import { Link } from 'react-router-dom';
import { styled } from '@mui/material/styles';
import CardContent from '@mui/material/CardContent';
import {
  Avatar,
  Button,
  InputAdornment,
  OutlinedInput,
  Alert,
} from '@mui/material';
import { blue, red } from '@mui/material/colors';
import SendIcon from '@mui/icons-material/Send';


const CommentLinkImg = styled(Link)({
  textDecoration: 'none',
  boxShadow: 'none',
});

const CommentForm = (props) => {
  const { userId, userName, blogId, setCommentRefresh} = props;
  const [text, setText] = useState("");


  const saveComment = () => {
    fetch("/comments",
    {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        userId: userId,
        blogId: blogId,
        text: text,
      }),
    })
    .then((res) => res.json())
    .catch((err) => console.log("error"))
  }

  const handleSubmit = () => {
    saveComment();
    setText("");
    setCommentRefresh();
  }

  const handleChange = (value) => {
    setText(value);
  }



  return (
    <CardContent>
      <OutlinedInput
        id='outlined-adornment-amount'
        multiline
        inputProps={{ maxLength: 250 }}
        fullWidth
        onChange={(i) => handleChange(i.target.value)}
        startAdornment={
          <InputAdornment position='start'>
            <CommentLinkImg to={{ pathname: '/users/' + userId }}>
              <Avatar sx={{ bgcolor: blue[500] }}>
                {userName.charAt(0).toUpperCase()}
              </Avatar>
            </CommentLinkImg>
          </InputAdornment>
        }
        endAdornment = {
          <InputAdornment position='end'>
             <Button variant='contained' onClick={handleSubmit}>
                    <SendIcon />
                  </Button>
          </InputAdornment>
        }
        value = {text}
      ></OutlinedInput>
    </CardContent>
  );
};

export default CommentForm;
