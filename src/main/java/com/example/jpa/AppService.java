package com.example.jpa;

import com.example.jpa.dto.StudentDto;
import com.example.jpa.entities.StudentEntity;
import com.example.jpa.repos.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AppService {

    private final AppRepository repository;//데이터관련된거 repository에 넘긴다. //db랑 같이 소통
    private final StudentRepository studentRepository;
    //jpa레포지토리

    public AppService(AppRepository repository, StudentRepository studentRepository) {
        this.repository = repository;
        this.studentRepository = studentRepository;
    }

    //CREATE
    public void createStudent(
            String name,
            Integer age,
            String phone,
            String email
    ) {
        //새로운(new) student(Entity)를 만들고 싶다
        StudentEntity newEntity = new StudentEntity();
        newEntity.setName(name);
        newEntity.setAge(age);
        newEntity.setEmail(email);
        newEntity.setPhone(phone);
        //Repository.save() 저장
        this.studentRepository.save(newEntity);
    }

    //READ
    public void readStudent(Long id) {


        //두상황을 대비해 optional을 사용
        Optional<StudentEntity> optionalStudentEntity = this.studentRepository.findById(id);
        //실제 데이터가 있을때만 출력
        if (optionalStudentEntity.isPresent()) {
            System.out.println(optionalStudentEntity.get());
        }
        //결과가 null이 되었을때
        else {
            System.out.println("no result");
        }
        System.out.println(this.studentRepository.findById(id));

    }
    //READ ALL
    public List<StudentDto> readStudentAll() {
        System.out.println(this.studentRepository.findAll());
        List<StudentEntity> studentEntityList =this.studentRepository.findAll();
        List<StudentDto> studentDtoList = new ArrayList<>();
        for (StudentEntity studentEntity:this.studentRepository.findAll()) {
            StudentDto studentDto = new StudentDto();
            studentDto.setId(studentEntity.getId());
            studentDto.setName(studentEntity.getName());
            studentDto.setEmail(studentEntity.getEmail());
            studentDtoList.add(studentDto);
        }
//        return studentEntityList;
        return studentDtoList;
    }
//    public List<StudentEntity> readStudentAll() {
//        System.out.println(this.studentRepository.findAll());
//        List<StudentEntity> studentEntitiyList = this.studentRepository.findAll();
//        return studentEntitiyList;
//    }

    //UPDATE
    public void updateStudent(
            //어떤 대상을 수정할지 지정
            Long id, String name
    ) {
        //수정할 Entity를 회수
        Optional<StudentEntity> optionalStudentEntity = this.studentRepository.findById(id);
        //수정할 entity를 찾은 경우
        if (optionalStudentEntity.isPresent()) {
            //실제 객체 회수
            StudentEntity target = optionalStudentEntity.get();
            //수정할 데이터 적용
            target.setName(name);
            //save
            this.studentRepository.save(target);
        } else {
            System.out.println("could not find");
        }

    }

    //DELETE
    public void deleteStudent(Long id) {
        Optional<StudentEntity> optionalStudentEntity = this.studentRepository.findById(id);
        if (optionalStudentEntity.isPresent()) {
            StudentEntity student = optionalStudentEntity.get();
            this.studentRepository.delete(student);
        }
    }

    public void findAllByTest() {
        List<StudentEntity> studentEntities = this.studentRepository.findAllByOrderByName();
        for (int i = 0; i < 5; i++) {
            System.out.println(studentEntities.get(i));
        }


        System.out.println("...");
    }



//    public AppService(AppRepository repository) {//나 레포지토리 필요해
//        this.repository = repository;//전달해줬을때 내가사용할수있게
//    }//서비스는 데이터베이스를 이용하기위한 repository 의존성을 주입받는다.

    //주된 비즈니스 로직이 구현되는 공간
    //서비스 컨트롤러 의존성 안높게 구현하면 http요청이 아니라 다른요청할때
    //서비스의 기능사용하는방식으로도 개발할수있다.
    //비즈니스 로직을 사용하기 위한 창구 역할 구분분}
    //Service는 db조회, 컴포넌트 사용, 외부 api 활용, 모은 데이터를 가지고 응답(의사결정)
//    public List<Object> readStudentAll() {
//        List<Object> queryResult = repository.selectStudentAll();
//        return queryResult;
//    }


}