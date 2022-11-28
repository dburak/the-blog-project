# The Blog Project
The Blog Project is a java-based full-stack web application

## Functional Requirements
- Users shall be able to register
- Users shall be able to login
- Authenticated users shall be able to post a blog
- Authenticated users shall be able to comment on a blog post
- Authenticated users shall be able to add a blog post to their favorites.

## Technologies Used

**Client:** React, Material UI

**Server:** Spring Boot, Spring Security for microservice, MySQL, PostgreSQL

**Deployment:** Docker & Docker Compose

## Endpoints

### Microservice Endpoints

#### Authentication - Register

###### POST
    http://localhost:3333/api/authentication/register HTTP/1.1
    Content-Type: application/json
    Authorization: No Auth
    
    {
     "username":"user",
     "password":"user"
    }

#### Authentication - Login

###### POST
    http://localhost:3333/api/authentication/login HTTP/1.1
    Content-Type: application/json
    Authorization: No Auth
    
    {
     "username":"user",
     "password":"user"
    }
#### Blog - LIST Blog Posts

###### GET
    http://localhost:3333/gateway/blog HTTP/1.1
    Content-Type: application/json
    Authorization: No Auth
    
#### Blog - FIND Blog with given user id

###### GET
    http://localhost:3333/gateway/blog?userId{userId} HTTP/1.1
    Content-Type: application/json
    Authorization: No Auth
    
#### Blog - FIND a spesific blog post with blog id

###### GET
    http://localhost:3333/gateway/blog/1 HTTP/1.1
    Content-Type: application/json
    Authorization: No Auth
 
#### Blog - CREATE Blog Post

###### POST
    http://localhost:3333/gateway/blog/ HTTP/1.1
    Content-Type: application/json
    Authorization: Bearer
    Content-Type: application/json
    {
    "userId": "1",
    "userName": "burakdiker",
    "blogTitle": "blog title",
    "blogContent": "blog content",
    }
    #### Blog - CREATE Blog Post
    
#### Blog - UPDATE Blog Post

###### UPDATE
    http://localhost:3333/gateway/blog/ HTTP/1.1
    Content-Type: application/json
    Authorization: Bearer
    Content-Type: application/json
    {
    "userId": "1",
    "userName": "burakdiker",
    "blogTitle": "updated blog title",
    "blogContent": "updated blog content",
    }
    
#### Blog - DELETE Blog Post

###### DELETE
    http://localhost:3333/gateway/blog/{blogId} HTTP/1.1
    Content-Type: application/json
    Authorization: Bearer
    Content-Type: application/json
    {
    "userId": "1",
    "userName": "burakdiker",
    "blogTitle": "updated blog title",
    "blogContent": "updated blog content",
    }
    
#### Comment - LIST Comments

###### GET
    http://localhost:3333/gateway/comment HTTP/1.1
    Content-Type: application/json
    Authorization: No Auth
    
#### Comment - FIND a spesific comment with comment id

###### GET
    http://localhost:3333/gateway/comment/{commentId} HTTP/1.1
    Content-Type: application/json
    Authorization: No Auth
    
#### Comment - FIND a spesific comment with given blog id

###### GET
    http://localhost:3333/gateway/comment?blogId={blogId} HTTP/1.1
    Content-Type: application/json
    Authorization: No Auth
    
#### Comment - CREATE Comment

###### POST
    http://localhost:3333/gateway/comment HTTP/1.1
    Content-Type: application/json
    Authorization: Bearer
    {
    "userId": 1,
    "userName": "burakdiker",
    "blogId": "1",
    "text": "this is a comment",
    }
    
#### Comment - DELETE Comment

###### DELETE
    http://localhost:3333/gateway/comment/{commentId} HTTP/1.1
    Authorization: Bearer
    Content-Type: application/json
    
#### Favorite - LIST Favorites

###### GET
    http://localhost:3333/gateway/favorite HTTP/1.1
    Content-Type: application/json
    Authorization: Bearer
    
#### Favorite - FIND a spesific favorite with favorite id

###### GET
    http://localhost:3333/gateway/favorite HTTP/1.1
    Content-Type: application/json
    Authorization: Bearer
  
#### Favorite - CREATE Favorite

###### POST
    http://localhost:3333/gateway/favorite HTTP/1.1
    Content-Type: application/json
    Authorization: Bearer
    {
    "userId": "1",
    "blogId": "1",
    }
    
#### Favorite - DELETE Favorite
###### DELETE
    http://localhost:3333/gateway/favorite/{favoriteId} HTTP/1.1
    Content-Type: application/json
    Authorization: Bearer
    
### Blog Endpoints

#### Blog - LIST Blog Posts

###### GET
    http://localhost:1111/api/v1/blogs HTTP/1.1
    Content-Type: application/json
    Authorization: No Auth
    
#### Blog - FIND Blog with given user id

###### GET
    http://localhost:1111/api/v1/blogs?userId={userId} HTTP/1.1
    Content-Type: application/json
    Authorization: No Auth
    
#### Blog - FIND Blog with given blog id

###### GET
    http://localhost:1111/api/v1/blogs?blogId={blogId} HTTP/1.1
    Content-Type: application/json
    Authorization: No Auth
    
#### Blog - CREATE Blog Post

###### POST
    http://localhost:1111/api/v1/blogs HTTP/1.1
    Content-Type: application/json
    Authorization: No Auth
    {
    "userId": "1",
    "userName": "burakdiker",
    "blogTitle": "blog title",
    "blogContent": "blog content",
  }
  
#### Blog - DELETE Blog Post

###### DELETE
    http://localhost:1111/api/v1/blogs/{blogId} HTTP/1.1
    Content-Type: application/json
    Authorization: No Auth
    
    
#### Comment - LIST Comments

###### GET
    http://localhost:1111/api/v1/comments HTTP/1.1
    Content-Type: application/json
    Authorization: No Auth
    
#### Comment - FIND a spesific comment with comment id

###### GET
    http://localhost:1111/api/v1/comments/{commentId} HTTP/1.1
    Content-Type: application/json
    Authorization: No Auth
    
#### Comment - FIND a spesific comment with given blog id

###### GET
    http://localhost:1111/api/v1/comments?blogId={blogId} HTTP/1.1
    Content-Type: application/json
    Authorization: No Auth
    
 #### Comment - FIND a spesific comment with given user id

###### GET
    http://localhost:1111/api/v1/comments?userId={userId} HTTP/1.1
    Content-Type: application/json
    Authorization: No Auth
    
#### Comment - CRETE Comment

###### POST
    http://localhost:1111/api/v1/comments HTTP/1.1
    Content-Type: application/json
    Authorization: No Auth
    {
    "userId": 1,
    "userName": "burakdiker",
    "blogId": "1",
    "text": "this is a comment",
    }
   
 #### Comment - DELETE Comment

###### DELETE
    http://localhost:1111/api/v1/comments/{commentId} HTTP/1.1
    Content-Type: application/json
    Authorization: No Auth
    
#### Favorite - LIST Favorites

###### GET
    http://localhost:1111/api/v1/favorites HTTP/1.1
    Content-Type: application/json
    Authorization: No Auth
    
#### Favorite - FIND a spesific favorite with favorite id

###### GET
    http://localhost:1111/api/v1/favorites/{favoriteId} HTTP/1.1
    Content-Type: application/json
    Authorization: No Auth
    
#### Favorite - FIND a spesific favorite with blog id

###### GET
    http://localhost:1111/api/v1/favorites?blogId={blogId} HTTP/1.1
    Content-Type: application/json
    Authorization: No Auth

#### Favorite - FIND a spesific favorite with user id

###### GET
    http://localhost:1111/api/v1/favorites?userId={userId} HTTP/1.1
    Content-Type: application/json
    Authorization: No Auth
    
#### Favorite - CREATE Favorite

###### POST
    http://localhost:1111/api/v1/favorites HTTP/1.1
    Content-Type: application/json
    Authorization: No Auth
    {
    "userId": "1",
    "blogId": "1",
    }
 
#### Favorite - DELETE Favorite

###### DELETE
    http://localhost:1111/api/v1/favorites/{favoriteId} HTTP/1.1
    Content-Type: application/json
    Authorization: No Auth
    
