Question1 answer is in the postsService by using get method to hit /posts/top will get the top post.
Question2 answer is in the commentsService by using post method to hit /comments/filter.
          - can use cmd to curl endpoint to get filter, here is an example script "curl -H "Accept: application/json" -H "Content-type: application/json" -X POST -d {"postId":1,"name":"e"} http://localhost:8081/comments/filter".
