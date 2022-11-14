import React, {useState, useEffect} from "react"

const Blog = (props) => {
  const {title, content} = props;

  return(
    <div>
      {title}
      {content}
    </div>
  )

}

export default Blog