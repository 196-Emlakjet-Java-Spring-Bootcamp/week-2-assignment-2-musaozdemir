package com.example.crudexample.dto;

import com.example.crudexample.enums.CategoryEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateRequestPost {
    private String title;
    private LocalDate updateDate;
    private String updatedBy;
    private String text;
    private CategoryEnum category;
}
