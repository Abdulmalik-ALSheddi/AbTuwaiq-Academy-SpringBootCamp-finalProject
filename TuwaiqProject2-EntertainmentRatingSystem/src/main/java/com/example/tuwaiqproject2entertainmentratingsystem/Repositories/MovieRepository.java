package com.example.tuwaiqproject2entertainmentratingsystem.Repositories;

import com.example.tuwaiqproject2entertainmentratingsystem.Model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

    Movie findMovieById(Integer id);

    Movie findMovieByTitle(String title);

    List<Movie> findAllByGenre(String genre);

    List<Movie> findAllByTitle(String title);

    List<Movie> findAllByRatingGreaterThanEqual(Integer rating);

    List<Movie> findAllByDurationGreaterThanEqual(Integer duration);
}
