package com.example.tuwaiqproject2entertainmentratingsystem.Controllers;

import com.example.tuwaiqproject2entertainmentratingsystem.Dto.APIResponse;
import com.example.tuwaiqproject2entertainmentratingsystem.Model.Movie;
import com.example.tuwaiqproject2entertainmentratingsystem.Services.MovieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/movie")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping("/get")
    public ResponseEntity getMovies()
    {
        return ResponseEntity.status(201).body(movieService.getMovies());
    }

    @PostMapping("/add")
    public ResponseEntity addMovie(@RequestBody @Valid Movie movie)
    {
        movieService.addMovie(movie);
        return ResponseEntity.status(201).body(new APIResponse("Movie Added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateMovie(@PathVariable Integer id , @RequestBody @Valid Movie movie)
    {
        movieService.updateMovie(id,movie);
        return ResponseEntity.status(201).body(new APIResponse("Movie updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteMovie(@PathVariable Integer id)
    {
        movieService.deleteMovie(id);
        return ResponseEntity.status(201).body(new APIResponse("Movie deleted"));
    }

    /*----------------END OF CRUD-----------------*/

    @GetMapping("/get/by/title")
    public ResponseEntity getMovieByTitle(@RequestBody String title)
    {
        return ResponseEntity.status(201).body(movieService.getMovieByTitle(title));
    }

    @GetMapping("/get/by/genre")
    public ResponseEntity getMoviesByGenre(@RequestBody String genre)
    {
        return ResponseEntity.status(201).body(movieService.getMoviesByGenre(genre));
    }

    @GetMapping("/get/by/rating")
    public ResponseEntity getMoviesByRating(@RequestBody Integer rating)
    {
        return ResponseEntity.status(201).body(movieService.getMoviesByRating(rating));
    }

    @GetMapping("/get/avg/rating")
    public ResponseEntity getAvgRating(@RequestBody String title)
    {
        return ResponseEntity.status(201).body(new APIResponse(movieService.getAvgRating(title)));
    }

    @GetMapping("/get/by/duration")
    public ResponseEntity getMovieByDuration(@RequestBody Integer duration)
    {
        return ResponseEntity.status(201).body(movieService.getMoviesByDuration(duration));
    }
}
