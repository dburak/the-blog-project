# The Blog Project
The Blog Project is a java-based full-stack web application

# Table of Contents  
[1. Functional Requirements](#functional-requirements)  

[2. Technologies Used](#technologies-used)

[3. Endpoints](#endpoints)

[3.1 Microservice Endpoints](#microservice-endpoints)

[3.1.1 Authentication - Register](#authentication---register)

[3.1.2 Authentication - Login](#authentication---login)

[3.1.3 Blog - LIST Blog Posts](#blog---list-blog-posts)

[3.1.4 Blog - FIND Blog with given user id](#blog---find-blog-with-given-user-id)

[3.1.5 Blog - FIND a spesific blog post with blog id](#blog---find-a-spesific-blog-post-with-blog-id)

[3.1.6 Blog - CREATE Blog Post](#blog---create-blog-post)

[3.1.7 Blog - UPDATE Blog Post](#blog---update-blog-post)

[3.1.8 Blog - DELETE Blog Post](#blog---delete-blog-post)

[3.1.9 Comment - LIST Comments](#comment---list-comments)

[3.1.10 Comment - FIND a spesific comment with comment id](#comment---find-a-spesific-comment-with-comment-id)

[3.1.11 Comment - FIND a spesific comment with given blog id](#comment---find-a-spesific-comment-with-given-blog-id)

[3.1.12 Comment - CREATE Comment](#comment---create-comment)

[3.1.13 Comment - DELETE Comment](#comment---delete-comment)

[3.1.14 Favorite - LIST Favorites](#favorite---list-favorites)

[3.1.15 Favorite - FIND a spesific favorite with favorite id](#favorite---find-a-spesific-favorite-with-favorite-id)

[3.1.16 Favorite - CREATE Favorite](#favorite---create-favorite)

[3.1.17 Favorite - DELETE Favorite](#favorite---delete-favorite)

[3.2 Blog Endpoints](#blog-endpoints)

[3.2.1 Blog - LIST Blog Posts](#blog---list-blog-posts-1)

[3.2.2 Blog - FIND Blog with given user id](#blog---find-blog-with-given-user-id-1)

[3.2.3 Blog - FIND Blog with given blog id](#blog---find-blog-with-given-blog-id)

[3.2.4 Comment - LIST Comments](#comment---list-comments-1)

[3.2.5 Comment - FIND a spesific comment with comment id](#comment---find-a-spesific-comment-with-comment-id-1)

[3.2.6 Comment - FIND a spesific comment with given blog id](#comment---find-a-spesific-comment-with-given-blog-id-1)

[3.2.7 Comment - FIND a spesific comment with given user id](#comment---find-a-spesific-comment-with-given-user-id)

[3.2.8 Comment - CRETE Comment](#comment---crete-comment)

[3.2.9 Comment - DELETE Comment](#comment---delete-comment-1)

[3.2.10 Favorite - LIST Favorites](#favorite---list-favorites-1)

[3.2.11 Favorite - FIND a spesific favorite with favorite id](#favorite---find-a-spesific-favorite-with-favorite-id-1)

[3.2.12 Favorite - FIND a spesific favorite with blog id](#favorite---find-a-spesific-favorite-with-blog-id)

[3.2.13 Favorite - FIND a spesific favorite with user id](#favorite---find-a-spesific-favorite-with-user-id)

[3.2.14 Favorite - CREATE Favorite](#favorite---create-favorite-1)

[3.2.15 Favorite - DELETE Favorite](#favorite---delete-favorite-1)

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
    
