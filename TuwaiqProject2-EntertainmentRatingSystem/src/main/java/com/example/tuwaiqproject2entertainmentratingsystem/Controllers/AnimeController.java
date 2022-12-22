package com.example.tuwaiqproject2entertainmentratingsystem.Controllers;

import com.example.tuwaiqproject2entertainmentratingsystem.Dto.APIResponse;
import com.example.tuwaiqproject2entertainmentratingsystem.Model.Anime;
import com.example.tuwaiqproject2entertainmentratingsystem.Services.AnimeService;
import jakarta.validation.Valid;
import jdk.jfr.BooleanFlag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/anime")
@RequiredArgsConstructor
public class AnimeController {

    private final AnimeService animeService;

    @GetMapping("/get")
    public ResponseEntity getAnimes()
    {
        return ResponseEntity.status(201).body(animeService.getAnimes());
    }

    @PostMapping("/add")
    public ResponseEntity addAnime(@RequestBody @Valid Anime anime)
    {
        animeService.addAnime(anime);
        return ResponseEntity.status(201).body(new APIResponse("Anime Added !!"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateAnime(@PathVariable Integer id , @RequestBody @Valid Anime anime)
    {
        animeService.updateAnime(id,anime);
        return ResponseEntity.status(201).body(new APIResponse("Anime updated !!"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteAnime(@PathVariable Integer id)
    {
        animeService.deleteAnime(id);
        return ResponseEntity.status(201).body(new APIResponse("Anime Deleted !!"));
    }

    /*----------------END OF CRUD-----------------*/

    @GetMapping("/get/by/title")
    public ResponseEntity getAnimeByTitle(@RequestBody String title)
    {
        return ResponseEntity.status(201).body(animeService.getAnimeByTitle(title));
    }

    @GetMapping("/get/by/genre")
    public ResponseEntity getAnimesByGenre(@RequestBody String genre)
    {
        return ResponseEntity.status(201).body(animeService.getAnimesByGenre(genre));
    }

    @GetMapping("/get/by/rating")
    public ResponseEntity getAnimesByRating(@RequestBody Integer rating)
    {
        return ResponseEntity.status(201).body(animeService.getAnimesByRating(rating));
    }

    @GetMapping("/get/avg/rating")
    public ResponseEntity getAvgRating(@RequestBody @Valid String title)
    {
        return ResponseEntity.status(201).body(animeService.getAvgRating(title));
    }

    @GetMapping("/get/by/epnum")
    public ResponseEntity getAnimesByEpNum(@RequestBody Integer epNum)
    {
        return ResponseEntity.status(201).body(animeService.getAnimesByEpNum(epNum));
    }
}
