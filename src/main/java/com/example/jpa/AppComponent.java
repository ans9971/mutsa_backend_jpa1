package com.example.jpa;

import org.springframework.stereotype.Component;

@Component
public class AppComponent {//컴포넌트는 기능담당
    //Controller, Service, Repository 가 아닌
    // 평범한 Bean 객체// 주된 흐름은 아니지만 가장 기본적인 어노테이션
    // 외부 api 사용, 공유된 기능 개발, 그냥 IoC 등록하고싶은 객체

    //필요로 하는 설정
    private final AppConfigData configData;

    public AppComponent(AppConfigData configData) {
        this.configData = configData;
    }

    //외부 Api를 사용하는 메소드
    public void useApi() {
        //send request

    }


}
