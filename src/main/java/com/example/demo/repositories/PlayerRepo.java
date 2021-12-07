package com.example.demo.repositories;

import com.example.demo.controllers.PlayerRest;
import com.example.demo.enums.Type;
import com.example.demo.models.Player;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface PlayerRepo extends CrudRepository<Player, Long> {

    boolean existsByFirstNameAreaAndLastName(String firstNameArea, String lastName);

    Player findByFirstNameAreaAndLastName(String firstNameArea, String lastName);

    Collection<Player> findAllByType(Type type);

}
