package com.keepcoding.springboot.helloworld;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/*Anotar la clase como controlador
crear métodos que respondan a los endpoints
configurar esos métodos*/
@RestController
public class HelloWorldController {
    // /hello-world
    // GET
    @GetMapping(value = "/hello-world")
    public String helloWorld() {
        return "Hello World!";
    }
    @GetMapping(value ="/hello-world-bean")
    public BeanResponse helloWorldBean() {
        return new BeanResponse("Hello World Bean!!");
    }

    @GetMapping(value ="/hello-world/path-variable/{name}")
    public String helloWorldVariable(@PathVariable String name) {
        return "Hello " + name + "!";
    }
}
