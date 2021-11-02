package com.keepcoding.springboot.controller;

import com.keepcoding.springboot.dao.HeroDaoService;
import com.keepcoding.springboot.model.Hero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.web.bind.annotation.*;

import java.io.PipedOutputStream;
import java.util.List;

@RestController
public class HeroController {

    @Autowired
    private HeroDaoService heroDaoService;

    @GetMapping("/hero")
    public List<Hero> findAllHeroes() {
        return heroDaoService.findAll();
    }

    @GetMapping("/hero/{id}")
    public Hero findHeroById(@PathVariable int id) {
        return heroDaoService.findHeroById(id);
    }

    //POST
    //Devolver estado 201:Created
    //Devolver URI del nuevo recurso creado
    @PostMapping("/hero")
    public Hero addHero(@RequestBody Hero hero) {
        return heroDaoService.addHero(hero);
    }

}
