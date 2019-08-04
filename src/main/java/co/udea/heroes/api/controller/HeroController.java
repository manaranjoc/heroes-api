package co.udea.heroes.api.controller;

import co.udea.heroes.api.model.Hero;
import co.udea.heroes.api.service.impl.HeroServiceInt;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;

@RestController
@RequestMapping("/tourofheroes")
public class HeroController {

    private HeroServiceInt heroService;

    public HeroController(HeroServiceInt heroService){
        this.heroService = heroService;
    }

    @GetMapping("heroes")
    public ResponseEntity<List<Hero>> getHeroes(){
        return ResponseEntity.ok(heroService.getHeroes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hero> getHero(@PathVariable("id") int id){
        return ResponseEntity.ok(heroService.getHero(id));
    }

    @GetMapping("consultar404")
    public ResponseEntity<Hero> getHeroNo404(@RequestParam("id") int id){
        return ResponseEntity.ok(heroService.getHeroNo404(id));
    }

    @GetMapping("buscar")
    public ResponseEntity<List<Hero>> searchHeroes(@RequestParam("name") String term){
        return ResponseEntity.ok(heroService.searchHeroes(term));
    }

    @PutMapping("actualizar")
    public ResponseEntity<Hero> updateHero(@RequestBody Hero hero){
        return ResponseEntity.ok(heroService.updateHero(hero));
    }

    @PostMapping("crear")
    public ResponseEntity<Hero> addHero(@RequestBody Hero hero){
        return ResponseEntity.ok(heroService.addHero(hero));
    }
    @DeleteMapping("borrar/{id}")
    public void deleteHero(@PathVariable int id){
        heroService.deleteHero(id);
    }

    @DeleteMapping("borrar")
    public void deleteHero(@RequestBody Hero hero){
        heroService.deleteHero(hero);
    }
}
