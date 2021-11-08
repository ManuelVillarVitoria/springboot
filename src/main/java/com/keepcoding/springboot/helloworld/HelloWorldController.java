package com.keepcoding.springboot.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

/*1.- Anotar la clase como controlador
 *2.- Crear métodos que respondan a los endpoints
 *3.- Configurar esos métodos
*/
@RestController
public class HelloWorldController {

    @Autowired
    private MessageSource messageSource;

    // /hello-world
    // GET
    @GetMapping(value = "/hello-world")
    public String helloWorld() {
        return messageSource.getMessage("hello.world.message", null, LocaleContextHolder.getLocale());
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
