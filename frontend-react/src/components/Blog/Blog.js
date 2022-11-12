import React, {useState, useEffect} from "react"
import ReactDOM from "react-dom"


const Blog = () => {
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
      <ul>
        {blogList.map(blog => (
          <li>
            {blog.blogTitle} {blog.blogContent}
          </li>
        ))}
      </ul>
    )
  }
}

export default Blog