import React, { useState, useEffect } from 'react';
import Blog from '../Blog/Blog';
import BlogForm from '../Blog/BlogForm';
import { styled } from '@mui/material';

const BlogContainer = styled('div')({
  display: 'flex',
  flexDirection: 'column',
  flexWrap: 'wrap',
  justifyContent: 'center',
  alignItems: 'center',
  backgroundColor: '#e8f1fb',
});

const Home = () => {
  const [error, setError] = useState(null);
  const [isLoaded, setIsLoaded] = useState(false);
  const [blogList, setBlogList] = useState([]);

  useEffect(() => {
    fetch('/blogs')
      .then((res) => res.json())
      .then(
        (result) => {
          setIsLoaded(true);
          setBlogList(result);
        },
        (error) => {
          setIsLoaded(true);
          setError(error);
        }
      );
  }, []);

  if (error) {
    return <div>Error</div>;
  } else if (!isLoaded) {
    return <div>Loading...</div>;
  } else {
    return (
      <BlogContainer>
        <BlogForm
          userId={1}
          userName={"asdasdas"}
          title={"title"}
          content={"content"}
        />
        {blogList.map((blog) => (
          <Blog
            favorites={blog.blogFavorites}
            blogId={blog.id}
            userId={blog.userId}
            userName={blog.userName}
            title={blog.blogTitle}
            content={blog.blogContent}
          ></Blog>
        ))}
      </BlogContainer>
    );
  }
};

export default Home;
