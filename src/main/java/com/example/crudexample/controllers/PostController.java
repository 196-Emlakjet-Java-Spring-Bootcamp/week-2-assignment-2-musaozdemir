package com.example.crudexample.controllers;

import com.example.crudexample.dto.ResponsePost;
import com.example.crudexample.dto.UpdateRequestPost;
import com.example.crudexample.enums.CategoryEnum;
import com.example.crudexample.services.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/post")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/getPost/{id}")
    public ResponsePost  getPost(@PathVariable Long id){
        return postService.getPost(id);
    }

    @PostMapping("/createPost")
    public ResponsePost createPost(@RequestBody ResponsePost post){
        return postService.createPost(post);
    }

    @PutMapping("/updatePost/{id}")
    public ResponsePost updatePost(@RequestBody UpdateRequestPost updateRequestPost, @PathVariable Long id){
        return postService.updatePost(updateRequestPost,id);
    }
    @GetMapping("/findPostByAuthor/{author}")
    public List<ResponsePost> findPostByAuthor(@PathVariable String author){
        return postService.findPostByAuthor(author);
    }

    @GetMapping("/findPostByCategory/{category}")
    public List<ResponsePost> findByCategory(@PathVariable CategoryEnum category){
        return postService.findPostByCategory(category);

    }

    @GetMapping("/getLastPost/{limit}")
    public List<ResponsePost> getLastPost(@PathVariable int limit){
        return postService.getLastPost(limit);
    }

    @GetMapping("/getAll")
    public List<ResponsePost> all(){
        return postService.all();
    }
}
