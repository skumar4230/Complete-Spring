package com.learning.spingboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController//mixture of @Controller and @Responsebody
public class HelloController {
    @GetMapping("/greet")
    public String greet(){
        return "Hello World";
    }
    @PostMapping("/hello")
    public String helloPost(@RequestBody String name){
        return "Hello "+name;
    }
}
