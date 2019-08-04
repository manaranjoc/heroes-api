package co.udea.heroes.api.service.impl;

import co.udea.heroes.api.model.Hero;

import java.util.List;

public interface HeroServiceInt {

    public List<Hero> getHeroes();
    public Hero getHero(String id);
    public List<Hero> searchHeroes(String term);
    public Hero updateHero(Hero hero);
}
