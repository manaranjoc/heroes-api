package co.udea.heroes.api.service.impl;

import co.udea.heroes.api.exceptions.ResourceNotFoundException;
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

    public Hero getHero(int id){
        Optional<Hero> posibleHero = heroRepository.findById(id);
        if(posibleHero.isPresent()){
            return posibleHero.get();
        }else{
            throw new ResourceNotFoundException();
        }

    }

    public Hero getHeroNo404(int id){
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

    public void deleteHero(int id){
        heroRepository.deleteById(id);
    }

    public void deleteHero(Hero hero){
        heroRepository.delete(hero);
    }
}
