package com.example.crudexample.services;

import com.example.crudexample.dto.ResponsePost;
import com.example.crudexample.dto.UpdateRequestPost;
import com.example.crudexample.enums.CategoryEnum;

import java.util.List;

public interface PostService {
    public ResponsePost getPost(Long id);
    public ResponsePost createPost(ResponsePost responsePost);
    public ResponsePost updatePost(UpdateRequestPost updateRequestPost, Long id);
    public List<ResponsePost> all();
    public List<ResponsePost> findPostByAuthor(String author);
    public List<ResponsePost> findPostByCategory(CategoryEnum category);
    public List<ResponsePost> getLastPost(int limit);
}
