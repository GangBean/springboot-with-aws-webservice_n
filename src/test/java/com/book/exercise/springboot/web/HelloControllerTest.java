package com.book.exercise.springboot.web;

import com.book.exercise.springboot.web.HelloController;
import org.junit.Test;
import  org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class) // #1
@WebMvcTest(controllers = HelloController.class) // #2
public class HelloControllerTest {

    @Autowired //#3
    private MockMvc mvc; // #4

    @Test
    public void hello_return() throws Exception {
        String hello = "hello";

        mvc.perform( get("/hello") ) // #5
                .andExpect( status().isOk() ) // #6
                .andExpect( content().string(hello) ); // #7
    }

    @Test
    public void helloDto_return() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                get("/hello/dto")
                        .param("name", name)
                        .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
    }

}

/**
 * #1
 * 테스트 진행시 JUnit 내자된 실행자 외 다른 실행자를 실행시킴
 * 해당 프로젝트에선 SpringRunner 라는 스프링 실행자 사용
 * 스프링 부트 테스트와 JUit 사이 연결자 역할
 *
 * #2
 * 스프링 테스트 어노테이션 중, WEB(Spring MVC)에 집중가능핞 어노테이션
 * 선언시 , @Controller, @ControllerAdvice 사용 가능
 * @Service, @Component, @Repository는 사용 불가
 *
 * #3
 * 스프링이 관리하는 Bean 주입
 *
 * #4
 * 웹 API 테스트시 사용
 * 해당 클래스 통해 HTTP GET, POST 등의 API 테스트 가능
 *
 * #5
 * MockMvc 통해 /hello 주소로 HTTP GET 요청
 * 체이닝 지원됨 -> 여러가지 검증 기능 이어서 진행 가능함
 *
 * #6
 * mvc.perform 결과 검증
 * HTTP Header의 Status 검증
 * 200,404,500 등의 상태 검증
 * 200이 OK
 * 
 * #7
 * Controller의 리턴 예상값 "hello" 가 맞는지 검증
 */