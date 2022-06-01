package com.example.crudexample.repositories;

import com.example.crudexample.dao.Post;
import com.example.crudexample.enums.CategoryEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post,Long> {

    @Query("select count(u) from Post u where u.title = ?1 and u.text=?2")
    int  getControl(String title, String text);
    @Query("select u from Post u where u.author = ?1 ")
    List<Post> getAllAuthor(String author);
    @Query("select u from Post u where u.category = ?1 ")
    List<Post> getCategory(CategoryEnum category);
    @Query("select u from Post u ORDER BY u.id desc")
    List<Post> getLastPosts(int count);
}
