package com.example.jpa;

import com.example.jpa.entities.StudentEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller //사용자의 입력을 직접적으로 받는 부분이면 안됨
@RestController//모든 메소드에 @REsponseBody를 붙이는 용도
public class AppController {
    //사용자의 입력을 받는 요소


    private final AppService service;

    public AppController(AppService Service) {
        this.service=Service;//내가받은 서비스가 ioc에서 받는 서비스다? 이러한 데이터가 나에게 필요해
        // 저 Appservice 타입을 보고 만들어져있는 빈객체를 보고 실제 만들어진 서비스가 뭐있느지 확인?
        //ioc 컨테이너가 확인할수있게
    }//annotation사용하면 all아규먼트 그거 쓰면 자동으로 생성해주긴한다. 일단 만들어본거
    //RequestBapping과 같이 사용
    @RequestMapping("students")
    public void students() {

    }

    @GetMapping("create")
    public @ResponseBody String create() {
        this.service.createStudent("alex", 35, "1111", "alex@gmail.com");
        return "done";
    }

//    @GetMapping("read-all")
//    public @ResponseBody String readAll() {
//        this.service.readStudentAll();
//        return "done-read-all";
//    }
    @GetMapping("read-all")
    public @ResponseBody List<StudentEntity> readAll() {
        this.service.readStudentAll();
    //        return "done-read-all";
        return this.service.readStudentAll();
    }

    @GetMapping("read")
    public @ResponseBody String readOne() {
        this.service.readStudent(1L);
        return "done-read-one";
    }

    @GetMapping("update")
    public @ResponseBody String update() {
        this.service.updateStudent(1L,"alexander");
        return "done-update";
    }

    @GetMapping("delete")
    public @ResponseBody String delete() {
        this.service.deleteStudent(1L);
        return "done-delete";
    }

    @GetMapping("find")
    public @ResponseBody String find() {
        this.service.findAllByTest();
        return "done-find";
    }

    @GetMapping("home")
    public String home() {

        return "home";
    }

    @GetMapping("body")
    public @ResponseBody String body() {
        return "body";
    }
}
