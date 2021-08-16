package com.book.exercise.springboot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.book.exercise.springboot.web.dto.HelloResponseDto;

@RestController // #1
public class HelloController {

    @GetMapping("/hello") // #2
    public String hello(){
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount){
        return new HelloResponseDto(name, amount);
    }
}

/**
 *  #1
 *  컨트롤러를 JSON을 반환하는 컨트롤러로 만들어 줌
 *  이전에 각 메소드마다 @ResponseBody 선언했던걸 한번에 사용가능하게 해줌...(?)
 *  
 *  #2
 *  HTTP Method인 Get의 요청을 받을수 있는 API 만들어 줌
 *  예전엔, @RequestMapping(method = RequestMethod.GET)으로 사용함(?)
 *  이제 해당 프로젝트엔 /hello 로 요청이 오면 문자열 hello를 반환하는 기능을 가짐
 */