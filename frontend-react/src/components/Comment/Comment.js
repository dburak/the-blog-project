import React from 'react';
import { Link } from 'react-router-dom';
import { styled } from '@mui/material/styles';
import CardContent from '@mui/material/CardContent';
import {
  Avatar,
  InputAdornment,
  OutlinedInput,
} from '@mui/material';
import { blue, red } from '@mui/material/colors';

const CommentLinkImg = styled(Link)({
  textDecoration: 'none',
  boxShadow: 'none',
});

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
            <CommentLinkImg to={{ pathname: '/users/' + userId }}>
              <Avatar sx={{ bgcolor: blue[500] }}>
                {userName.charAt(0).toUpperCase()}
              </Avatar>
            </CommentLinkImg>
          </InputAdornment>
        }
      ></OutlinedInput>
    </CardContent>
  );
};

export default Comment;
