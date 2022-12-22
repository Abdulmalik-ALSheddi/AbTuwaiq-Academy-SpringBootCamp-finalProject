package com.example.tuwaiqproject2entertainmentratingsystem.Services;

import com.example.tuwaiqproject2entertainmentratingsystem.Exception.APIException;
import com.example.tuwaiqproject2entertainmentratingsystem.Model.Movie;
import com.example.tuwaiqproject2entertainmentratingsystem.Repositories.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    public List<Movie> getMovies() {
        if(movieRepository.findAll().isEmpty())
            throw new APIException("No movies Added");
        return movieRepository.findAll();
    }

    public void addMovie(Movie movie) {
        movieRepository.save(movie);
    }

    public void updateMovie(Integer id, Movie movie) {
        Movie movie1 = movieRepository.findMovieById(id);
        if(movie1 == null)
            throw new APIException("Movie NOT FOUND !!");
        movie1.setTitle(movie.getTitle());
        movie1.setGenre(movie.getGenre());
        movie1.setRating(movie.getRating());
        movie1.setDuration(movie.getDuration());
        movieRepository.save(movie1);
    }

    public void deleteMovie(Integer id) {
        Movie movie = movieRepository.findMovieById(id);
        if(movie == null)
            throw new APIException("Movie NOT FOUND !!");
        movieRepository.deleteById(id);
    }

    public String getAvgRating(String title) {
        List<Movie> movies = movieRepository.findAllByTitle(title);
        if(movies.isEmpty())
            throw new APIException("No movies with this title.");
        double avg,sum=0;
        for (int i = 0; i <movies.size() ; i++) {
            sum += movies.get(i).getRating();
        }
        avg = sum/movies.size();
        return "The average rating for "+title+" is: "+avg;
    }

    public List<Movie> getMoviesByRating(Integer rating) {
        if(movieRepository.findAllByRatingGreaterThanEqual(rating).isEmpty())
            throw new APIException("No movies have this rating or higher");
        return movieRepository.findAllByRatingGreaterThanEqual(rating);
    }

    public List<Movie> getMoviesByDuration(Integer duration) {
        if(movieRepository.findAllByDurationGreaterThanEqual(duration).isEmpty())
            throw new APIException("No Movies of this duration or longer");
        return movieRepository.findAllByDurationGreaterThanEqual(duration);
    }

    public Movie getMovieByTitle(String title) {
        if(movieRepository.findMovieByTitle(title) == null)
            throw new APIException("No Movie with this title");
        return movieRepository.findMovieByTitle(title);
    }

    public List<Movie> getMoviesByGenre(String genre) {
        List<Movie> movies = movieRepository.findAllByGenre(genre);
        if(movies.isEmpty())
            throw new APIException("No movies in this genre");
        return movies;
    }
}
