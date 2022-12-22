package com.example.tuwaiqproject2entertainmentratingsystem.Repositories;

import com.example.tuwaiqproject2entertainmentratingsystem.Model.Anime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimeRepository extends JpaRepository<Anime, Integer> {

    Anime findAnimeById(Integer id);

    Anime findAnimeByTitle(String title);

    List<Anime> findAllByGenre(String genre);

    List<Anime> findAllByRatingGreaterThanEqual(Integer rating);


    List<Anime> findAllByTitle(String title);

    List<Anime> findAllByEpNumLessThanEqual(Integer EpNum);
}
