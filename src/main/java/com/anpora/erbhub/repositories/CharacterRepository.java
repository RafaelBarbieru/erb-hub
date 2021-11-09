package com.anpora.erbhub.repositories;

import com.anpora.erbhub.dao.relational.CharacterRelDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

/**
 * @author Rafael Barbieru, Popular Belbase, Anton Kamenov
 */
public interface CharacterRepository extends JpaRepository<CharacterRelDAO, Long> {

    Optional<CharacterRelDAO> findById(Long id);

    @Query(nativeQuery = true, value =
            "SELECT c.* FROM characters C " +
                    "JOIN actors_characters AC ON C.id = AC.character_id " +
                    "JOIN actors A ON A.id = AC.actor_id " +
                    "WHERE A.id = ?1"
    )
    List<CharacterRelDAO> getCharactersFromActor(Long actorId);

}
