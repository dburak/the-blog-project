import React from 'react';
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

const Comment = (props) => {
  const { content, userId, userName } = props;
  return (
    <CardContent>
      <OutlinedInput
        disabled
        id='outlined-adornment-amount'
        multiline
        inputProps={{ maxLength: 25 }}
        fullWidth
        value={content}
        startAdornment={
          <InputAdornment position='start'>
            <Avatar sx={{ bgcolor: blue[500] }}>
              {userName.charAt(0).toUpperCase()}
            </Avatar>
          </InputAdornment>
        }
      ></OutlinedInput>
    </CardContent>
  );
};

export default Comment;
