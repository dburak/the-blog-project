
import React, {useState, useEffect} from "react"
import Blog from "../Blog/Blog"
import { Container } from '@mui/system'
import { styled } from '@mui/material';

const BlogContainer = styled(Container)({
  display: "flex",
  flexWrap: "wrap",
  justifyContent: "center",
  alignItems: "center",
  backgroundColor: "#e8f1fb",
  height: "100vh"
})

const Home = () => {
  const [error, setError] = useState(null)
  const [isLoaded, setIsLoaded] = useState(false)
  const [blogList, setBlogList] = useState([])

  useEffect(() => {
    fetch("/blogs")
    .then(res => res.json())
    .then(
      (result) => {
        setIsLoaded(true)
        setBlogList(result)
      },
      (error) => {
        setIsLoaded(true)
        setError(error)
      }
    )
  }, [])

  if(error) {
    return <div>Error</div>
  } else if(!isLoaded) {
    return <div>Loading...</div>
  } else {
    return (
     <BlogContainer fixed>
      {blogList.map(blog => (
        <Blog title={blog.blogTitle} content={blog.blogContent}></Blog>
      ))}
     </BlogContainer>
    )
  }
}

export default Home