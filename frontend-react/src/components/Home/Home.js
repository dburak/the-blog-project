
import React, {useState, useEffect} from "react"
import Blog from "../Blog/Blog"

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
     <div>
      Home
      {blogList.map(blog => (
        <Blog title={blog.blogTitle} content={blog.blogContent}></Blog>
      ))}
     </div>
    )
  }
}

export default Home