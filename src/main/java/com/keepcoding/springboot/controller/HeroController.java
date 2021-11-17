package com.keepcoding.springboot.controller;

import com.keepcoding.springboot.dao.HeroService;
import com.keepcoding.springboot.model.Hero;
import com.keepcoding.springboot.exceptions.HeroNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class HeroController {

    @Autowired
    @Qualifier("jpa")
    public HeroService heroService;

    @GetMapping("/hero")
    public List<Hero> findAllHeroes() {
        return heroService.findAll();
    }

    @GetMapping("/hero/{id}")
    public Hero findHeroById(@PathVariable int id) {
        Hero result =  heroService.findHeroById(id);
        if ( result == null) {
            throw new HeroNotFoundException("El héroe con id " + " no existe.");
        }
        return result;
    }

    @DeleteMapping ("/hero/{id}")
    public void deleteHeroById(@PathVariable int id) {
         Hero result =  heroService.findHeroById(id);
        if (result == null) {
            throw new HeroNotFoundException("El héroe con id " + " no existe.");
        }
        heroService.deleteHero(id);
    }

    @PostMapping("/hero")
    public ResponseEntity<Object> addHero(@RequestBody @Valid Hero hero) {
        Hero addedHero =  heroService.addHero(hero);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(addedHero.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

}
