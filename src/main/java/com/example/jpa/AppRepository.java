package com.example.jpa;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AppRepository {
    // db와의 소통 담당
    // @Transactional 세션관리를 위해 사용
    public List<Object> selectStudentAll() {
        return new ArrayList<>();
    }

}
