import * as React from 'react';
import { useState } from 'react';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import Typography from '@mui/material/Typography';
import { Button, InputAdornment, OutlinedInput, Alert } from '@mui/material';
import SendIcon from '@mui/icons-material/Send';
import Snackbar from '@mui/material/Snackbar';


const BlogForm = (props) => {
  const {userId } = props;
  const [blogTitle, setBlogTitle] = useState("");
  const [blogContent, setBlogContent] = useState("");
  const [open, setOpen] = useState(false);

  const saveBlog = () => {
    fetch("gateway/blog",
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
