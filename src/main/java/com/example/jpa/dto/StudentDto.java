package com.example.jpa.dto;

import com.example.jpa.entities.StudentEntity;
import lombok.Data;

@Data
public class StudentDto {
    private Long id;
    private String name;
    private String email;

//    public static StudentDto fromEntity(StudentEntity studentEntity) {
//        StudentDto dto = new StudentDto();
//        dto.setId();
//    }

}
