package com.keepcoding.springboot.dao;

import com.keepcoding.springboot.model.Hero;

import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class HeroDaoService {

    private static int id;
    private static List <Hero> heroes= Arrays.asList(
            new Hero( 1, "Peter Parker", "Spiderman", new Date()),
            new Hero( 2, "Tony Stark", "Ironman", new Date()),
            new Hero( 3, "Bruce Banner", "Hulk", new Date())
            );

    private static int counter = 3;

    //Obtener todos los heroes
    public List<Hero> findAll(){
        return  heroes;
    }

    //Obtener un heroe en concreto
    public Hero findHeroById(int id) {
        Hero result = null;
        for(Hero hero: heroes) {
            if(hero.getId() == id) {
                result = hero;
            }
        }
        return result;
    }

    //Añadir un heroe
    public Hero addHero(Hero hero) {
        hero.setId(++counter);
        heroes.add(hero);
        return hero;
    }

    //Borrar un heroe
    public boolean deleteHero(int id) {
        Iterator<Hero> heroIterator = heroes.iterator();
        Hero heroToRemove = null;
        do {
            heroToRemove = heroIterator.next();
            if(heroToRemove.getId() == id) {
                heroIterator.remove();
                return true;
            }
        } while(heroIterator.hasNext());
        return  false;
    }
}
