package com.example.jpa.repos;

import com.example.jpa.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//db와 소통하기 위한 창구
public interface StudentRepository
        //jparepository<내가사용할엔티티, 그 엔티티 id컬럼 타입>
        extends JpaRepository<StudentEntity,Long> {

    // 1. method 이름을 우리가 조회하고 싶은 조건을 붙여서 만든다.
    // findBy || findAllBy

    // select * from students order by name
    List<StudentEntity> findAllByOrderByName();

    // select * from sutdents order by age DESC;
    List<StudentEntity> findAllByOrderByAgeDesc();

    // select * from students where age < 21;
    List<StudentEntity> findAllByAgeLessThan(Integer age);


    // select * from students where phone like '010-%
    List<StudentEntity> findAllByPhoneStartingWith(String phone);
    // select * from sutdents where age < 30;






}
