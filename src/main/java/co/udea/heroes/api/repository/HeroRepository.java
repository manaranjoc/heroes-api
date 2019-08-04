package co.udea.heroes.api.repository;

import co.udea.heroes.api.model.Hero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HeroRepository extends JpaRepository<Hero, String> {

    @Query("SELECT h from Hero h WHERE h.name like %:term%")
    public List<Hero> searchByTerm(@Param("term") String term);

    //public List<Hero> findByNombreContaining(String term);
}
