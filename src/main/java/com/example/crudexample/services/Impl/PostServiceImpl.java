package com.example.crudexample.services.Impl;

import com.example.crudexample.dao.Post;
import com.example.crudexample.dto.ResponsePost;
import com.example.crudexample.dto.UpdateRequestPost;
import com.example.crudexample.enums.CategoryEnum;
import com.example.crudexample.repositories.PostRepository;
import com.example.crudexample.services.PostService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private Logger log = LoggerFactory.getLogger(PostServiceImpl.class);
    private  final PostRepository postRepository;
    private final ModelMapper modelMapper;

    @Override
    public ResponsePost getPost(Long id) {
        Optional<Post> post = postRepository.findById(id);
        if (post.isPresent()) {
            log.info("Post bulundu");
            return modelMapper.map(post, ResponsePost.class);
        }
        else{
            log.error("Post bulunamadı");
            return null;

        }
    }

    @Override
    public ResponsePost createPost(ResponsePost responsePost) {
        Post post=modelMapper.map((Object) responsePost,Post.class);
        if(postRepository.getControl(post.getTitle(),post.getText())<1) {
            return modelMapper.map(postRepository.save(modelMapper.map(responsePost, Post.class)), ResponsePost.class);
        }
        return null;
    }

    @Override
    public ResponsePost updatePost(UpdateRequestPost updateRequestPost, Long id) {
        Optional<Post> post= postRepository.findById(id);
        if (post.isPresent()){
            post.get().setTitle(updateRequestPost.getTitle());
            post.get().setUpdateDate(updateRequestPost.getUpdateDate());
            post.get().setUpdatedBy(updateRequestPost.getUpdatedBy());
            post.get().setText(updateRequestPost.getText());
            post.get().setCategory(updateRequestPost.getCategory());
            return modelMapper.map(postRepository.save(post.get()),ResponsePost.class);
        }
        return null;
    }

    @Override
    public List<ResponsePost> all() {
        return postRepository.findAll().stream()
                .map(post -> modelMapper.map(post, ResponsePost.class))
                .toList();

    }

    @Override
    public List<ResponsePost> findPostByAuthor(String author) {
        return postRepository.getAllAuthor(author).stream()
                .map(post -> modelMapper.map(post, ResponsePost.class))
                .toList();
    }

    @Override
    public List<ResponsePost> findPostByCategory(CategoryEnum category) {
        return postRepository.getCategory(category).stream()
                .map(post -> modelMapper.map(post, ResponsePost.class))
                .toList();
    }

    @Override
    public List<ResponsePost> getLastPost(int limit) {
        return postRepository.getLastPosts(limit).stream().limit(limit)
                .map(post -> modelMapper.map(post, ResponsePost.class))
                .toList();
    }
}
