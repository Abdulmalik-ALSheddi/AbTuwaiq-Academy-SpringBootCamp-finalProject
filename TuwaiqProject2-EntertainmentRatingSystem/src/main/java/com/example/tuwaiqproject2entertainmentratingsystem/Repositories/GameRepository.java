package com.example.tuwaiqproject2entertainmentratingsystem.Repositories;

import com.example.tuwaiqproject2entertainmentratingsystem.Model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {

    Game findGameById(Integer id);

    Game findGameByTitle(String title);


    List<Game> findAllByGenre(String genre);

    List<Game> findAllByRatingGreaterThanEqual(Integer rating);

    List<Game> findAllByTitle(String title);

    List<Game> findAllBygamePlayType(String type);

}
