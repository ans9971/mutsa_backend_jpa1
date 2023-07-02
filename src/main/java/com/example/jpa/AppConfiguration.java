package com.example.jpa;

import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {//component에서 필요로하는 데이터인데 변할수있는데 api 인증정보 같은걸 담아주고
    //설정을 모아두는곳
    //spring을 활용하는데 필요한 다양한 설정을 담고있는 용도

    @Bean
    public AppConfigData connectionUrl() {
        //이 메소드의 결과,반환값을 Bean 객체로 등록
        if (true/*현재 나의 상황에 따라 다른 url을 지급하는 코드*/) {
            return new AppConfigData("main-url");
        } else return new AppConfigData("backup-url");
    }

    @Bean
    public Gson gson() {
        return new Gson();
    }
}
