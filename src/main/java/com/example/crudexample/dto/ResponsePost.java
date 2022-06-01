package com.example.crudexample.dto;

import com.example.crudexample.enums.CategoryEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponsePost {
    private Long id;
    private String author;
    private String title;
    private LocalDate createDate;
    private String createdBy;
    private LocalDate updateDate;
    private String updatedBy;
    private String text;
    private CategoryEnum category;
}
