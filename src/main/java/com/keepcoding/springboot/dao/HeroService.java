package com.keepcoding.springboot.dao;

import com.keepcoding.springboot.model.Hero;

import java.util.List;

public interface HeroService {
    List<Hero> findAll();
    Hero findHeroById(int id);
    Hero addHero(Hero hero);
    void deleteHero(int id);
}
