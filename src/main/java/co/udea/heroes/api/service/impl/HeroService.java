package co.udea.heroes.api.service.impl;

import co.udea.heroes.api.model.Hero;
import co.udea.heroes.api.repository.HeroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HeroService implements HeroServiceInt{

    private HeroRepository heroRepository;

    public HeroService(HeroRepository heroRepository){
        this.heroRepository = heroRepository;
    }

    public List<Hero> getHeroes(){
        return heroRepository.findAll();
    }

    public Hero getHero(String id){
        Optional<Hero> posibleHero = heroRepository.findById(id);
        if(posibleHero.isPresent()){
            return posibleHero.get();
        }else{
            return null;
        }

    }

    public List<Hero> searchHeroes(String term){
        return heroRepository.searchByTerm(term);
    }

    public Hero updateHero(Hero hero){
        return heroRepository.save(hero);
    }

    public Hero addHero(Hero hero){
        return heroRepository.save(hero);
    }

    public void deleteHero(String id){
        heroRepository.deleteById(id);
    }
}
