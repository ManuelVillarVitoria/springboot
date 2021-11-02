package com.keepcoding.springboot.controller;

import com.keepcoding.springboot.dao.HeroDaoService;
import com.keepcoding.springboot.model.Hero;
import com.keepcoding.springboot.model.HeroNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.PipedOutputStream;
import java.net.URI;
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
        Hero result =  heroDaoService.findHeroById(id);
        if ( result == null) {
            throw new HeroNotFoundException("El héroe con id " + " no existe.");
        }
        return result;
    }

    @DeleteMapping ("/hero/{id}")
    public void deleteHeroById(@PathVariable int id) {
        boolean result =  heroDaoService.deleteHero(id);
        if (!result) {
            throw new HeroNotFoundException("El héroe con id " + " no existe.");
        }
    }

    //POST
    //Devolver estado 201:Created
    //Devolver URI del nuevo recurso creado
    @PostMapping("/hero")
    public ResponseEntity<Object> addHero(@RequestBody Hero hero) {
        Hero addedHero =  heroDaoService.addHero(hero);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(addedHero.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

}
