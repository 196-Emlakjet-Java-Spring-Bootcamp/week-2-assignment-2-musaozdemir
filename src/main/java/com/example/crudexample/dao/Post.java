package com.example.crudexample.dao;


import com.example.crudexample.enums.CategoryEnum;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "posts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String author;
    private String title;
    @CreationTimestamp
    private LocalDate createDate;
    private String createdBy;
    @UpdateTimestamp
    private LocalDate updateDate;
    private String updatedBy;
    private String text;
    @Enumerated(EnumType.STRING)
    private CategoryEnum category;
}
