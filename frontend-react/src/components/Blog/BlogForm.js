import * as React from 'react';
import { useState } from 'react';
import { Link } from 'react-router-dom';
import { styled } from '@mui/material/styles';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import CardActions from '@mui/material/CardActions';
import Collapse from '@mui/material/Collapse';
import IconButton from '@mui/material/IconButton';
import Typography from '@mui/material/Typography';
import QuestionAnswerIcon from '@mui/icons-material/QuestionAnswer';
import Box from '@mui/material/Box';
import FavoriteOutlinedIcon from '@mui/icons-material/FavoriteOutlined';
import { Avatar, Button, InputAdornment, OutlinedInput, Alert } from '@mui/material';
import { blue, red } from '@mui/material/colors';
import SendIcon from '@mui/icons-material/Send';
import { Redirect } from 'react-router-dom/cjs/react-router-dom';
import Stack from '@mui/material/Stack';
import Snackbar from '@mui/material/Snackbar';

const ExpandMore = styled((props) => {
  const { expand, ...other } = props;
  return <IconButton {...other} />;
})(({ theme, expand }) => ({
  marginLeft: 'auto',
  transition: theme.transitions.create('transform', {
    duration: theme.transitions.duration.shortest,
  }),
}));

const CardActionStyle = styled(CardActions)({
  display: 'flex',
  margin: '0 10px',
  justifyContent: 'space-between',
});

const BoxStyle = styled(Box)({
  display: 'flex',
  justifyContent: 'center',
  alignItems: 'center',
});

const BlogLinkName = styled(Link)({
  textDecoration: 'none',
  boxShadow: 'none',
  '&:visited': {
    color: 'inherit',
  },
  '&:hover': {
    textDecoration: 'underline',
  },
});

const BlogLinkImg = styled(Link)({
  textDecoration: 'none',
  boxShadow: 'none',
});

const BlogForm = (props) => {
  const {userId, userName} = props;
  const [blogTitle, setBlogTitle] = useState("");
  const [blogContent, setBlogContent] = useState("");
  const [open, setOpen] = useState(false);

  const saveBlog = () => {
    fetch("/blog",
    {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        userId: userId,
        blogTitle: blogTitle,
        blogContent: blogContent,
      }),
    })
    .then((res) => res.json())
    .catch((err) => console.log("error"))
  }

  
  const handleSubmit = () => {
    saveBlog();
    setOpen(true);
    setTimeout(() => {
      window.location.reload(true);
    }, 2500)
  }
  
  const handleTitle = (value) => {
    setBlogTitle(value);
  }

  const handleContent = (value) => {
    setBlogContent(value);
  }

  


  return (
    <div>
      <Snackbar open={open} autoHideDuration={61000}>
        <Alert severity="success" sx={{ width: '100%'}}>
          Your blog post is successfully sent !
        </Alert>
      </Snackbar>
    <Card sx={{ width: 800, marginBottom: 10, marginTop: 5 }}>
      <CardContent>
        <Typography
          gutterBottom
          variant='h5'
          component='h2'
          marginBottom='2rem'
        >
          <h3>Post a Blog</h3>{' '}
          {
            <OutlinedInput
              id='outlined-adornment-amount'
              placeholder='Title'
              inputProps={{maxLength: 25}}
              fullWidth
              onChange= {(i) => handleTitle(i.target.value)}
            ></OutlinedInput>
          }
        </Typography>
        <Typography
          variant='body1'
          color='text.primary'
          component='p'
          textAlign='left'
        >
          <OutlinedInput
              id='outlined-adornment-amount'
              placeholder='Content'
              inputProps={{maxLength: 250}}
              fullWidth
              multiline
              onChange= {(i) => handleContent(i.target.value)}
              endAdornment = {
                <InputAdornment position='end'>
                  <Button variant='contained' onClick={handleSubmit}>
                    <SendIcon />
                  </Button>
                </InputAdornment>
              }
            ></OutlinedInput>
        </Typography>
      </CardContent>
    </Card>
    </div>
  );
};

export default BlogForm;
