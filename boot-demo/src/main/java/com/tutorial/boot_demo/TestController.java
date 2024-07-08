package com.tutorial.boot_demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@RestController
//public class TestController {
//    @GetMapping("/hello") //配置api的访问路径
//    public String hello(){
//        return "HellO WoRld";
//    }
//}

@RestController
public class TestController {
    @GetMapping("/hello") //配置api的访问路径
    public List<String> hello(){
        return List.of("HellO", "WoRld");
    }
}
