import * as React from 'react';
import { useState, useEffect, useRef } from 'react';
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
import { Avatar } from '@mui/material';
import { blue, red } from '@mui/material/colors';
import Comment from '../Comment/Comment';
import CommentForm from '../Comment/CommentForm';

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

const Blog = (props) => {
  const { blogId, userId, userName, title, content, favorites, createdDate } = props;
  const [expanded, setExpanded] = useState(false);
  const [commentList, setCommentList] = useState([]);
  const [error, setError] = useState(null);
  const [isLoaded, setIsLoaded] = useState(false);
  const isInitialMount = useRef(true);
  const [refresh, setRefresh] = useState(false);
  const [isFavorited, setIsFavorited] = useState(false);
  const [favoriteCount, setFavoriteCount] = useState(favorites.length);
  const [favoriteId, setFavoriteId] = useState(null);
  let disabled = localStorage.getItem('currentUser') == null ? true : false;

  const setCommentRefresh = () => {
    setRefresh(true);
  };

  const handleExpandClick = () => {
    setExpanded(!expanded);
    getComments();
    console.log(commentList);
  };

  const handleFavorite = () => {
    setIsFavorited(!isFavorited);
    if (!isFavorited) {
      saveFavorite();
      setFavoriteCount(favoriteCount + 1);
      window.location.reload();
      
    } else {
      deleteFavorite();
      setFavoriteCount(favoriteCount - 1);
      window.location.reload();
    }
  };

  const getComments = () => {
    fetch('gateway/comment?blogId=' + blogId)
      .then((res) => res.json())
      .then(
        (result) => {
          setIsLoaded(true);
          setCommentList(result);
        },
        (error) => {
          setIsLoaded(true);
          setError(error);
        }
      );
    setRefresh(false);
  };

  const saveFavorite = () => {
    fetch('gateway/favorite', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
        'Authorization': localStorage.getItem("tokenKey")
      },
      body: JSON.stringify({
        userId: localStorage.getItem("currentUser"),
        blogId: blogId,
      }),
    })
      .then((res) => res.json())
      .catch((err) => console.log('error'));
  };

  const deleteFavorite = () => {
    fetch('gateway/favorite/' + favoriteId, {
      method: 'DELETE',
      headers: {
        "Authorization": localStorage.getItem("tokenKey")
      }
    }).catch((err) => console.log(err));
  };

  const checkFavorites = () => {
    let favoriteControl = favorites.find(
      (favorite) => "" + favorite.userId === localStorage.getItem("currentUser")
    );
    if (favoriteControl != null) {
      setFavoriteId(favoriteControl.id);
      setIsFavorited(true);
    }
  };

  useEffect(() => {
    if (isInitialMount.current) {
      isInitialMount.current = false;
    } else {
      getComments();
    }
  }, [refresh]);

  useEffect(() => {
    checkFavorites();
  }, []);

  return (
    <Card sx={{ width: 800, marginBottom: 10, marginTop: 5 }}>
      <CardContent>
        <Typography
          gutterBottom
          variant='h5'
          component='h2'
          marginBottom='2rem'
        >
          {title}
        </Typography>
        <Typography
          variant='body1'
          color='text.primary'
          component='p'
          textAlign='left'
        >
          {content}
        </Typography>
      </CardContent>
      <CardActionStyle>
        <BoxStyle>
          <BlogLinkImg to={{ pathname: '/users/' + userId }}>
            <Avatar sx={{ bgcolor: blue[500] }}>
              {userName.charAt(0).toUpperCase()}
            </Avatar>
          </BlogLinkImg>
          <Box ml={2}>
            <BlogLinkName to={{ pathname: '/users/' + userId }}>
              <Typography
                gutterBottom
                variant='subtitle2'
                component='p'
                textAlign='left'
              >
                {userName}
              </Typography>
            </BlogLinkName>
            <Typography
              gutterBottom
              variant='subtitle2'
              color='textSecondary'
              component='p'
            >
              {createdDate}
            </Typography>
          </Box>
        </BoxStyle>
        <Box>
          {disabled ? (
            <IconButton disabled onClick={handleFavorite}>
              <FavoriteOutlinedIcon
                style={isFavorited ? { color: red[500] } : null}
              />
            </IconButton>
          ) : (
            <IconButton onClick={handleFavorite}>
              <FavoriteOutlinedIcon
                style={isFavorited ? { color: red[500] } : null}
              />
            </IconButton>
          )}
          {favoriteCount}
          <IconButton>
            <ExpandMore
              expand={expanded}
              onClick={handleExpandClick}
              aria-expanded={expanded}
              aria-label='show more'
            >
              <QuestionAnswerIcon />
            </ExpandMore>
          </IconButton>
        </Box>
      </CardActionStyle>
      <Collapse in={expanded} timeout='auto' unmountOnExit>
        <CardContent>
          <Typography textAlign='left'>
            {error
              ? 'error'
              : isLoaded
              ? commentList.map((comment) => (
                  <Comment
                    userId={comment.userId}
                    userName={comment.userName}
                    content={comment.text}
                  ></Comment>
                ))
              : 'Loading...'}
            {disabled ? (
              ''
            ) : (
              <CommentForm
                userId={localStorage.getItem("currentUser")}
                userName={localStorage.getItem("username")}
                blogId={blogId}
                setCommentRefresh={setCommentRefresh}
              ></CommentForm>
            )}
          </Typography>
        </CardContent>
      </Collapse>
    </Card>
  );
};

export default Blog;
