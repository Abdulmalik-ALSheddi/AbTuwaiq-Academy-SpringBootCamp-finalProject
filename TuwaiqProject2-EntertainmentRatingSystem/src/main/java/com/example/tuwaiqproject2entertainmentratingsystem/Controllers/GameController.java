package com.example.tuwaiqproject2entertainmentratingsystem.Controllers;

import com.example.tuwaiqproject2entertainmentratingsystem.Dto.APIResponse;
import com.example.tuwaiqproject2entertainmentratingsystem.Model.Game;
import com.example.tuwaiqproject2entertainmentratingsystem.Services.GameService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/game")
@RequiredArgsConstructor
public class GameController {

    private final GameService gameService;

    @GetMapping("/get")
    public ResponseEntity getGames()
    {
        return ResponseEntity.status(201).body(gameService.getGames());
    }

    @PostMapping("/add")
    public ResponseEntity addGame(@RequestBody @Valid Game game)
    {
        gameService.addGame(game);
        return ResponseEntity.status(201).body(new APIResponse("Game Added !!"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateGame(@PathVariable Integer id , @RequestBody @Valid Game game)
    {
        gameService.updateGame(id, game);
        return ResponseEntity.status(201).body(new APIResponse("Game Updated !!"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteGame(@PathVariable Integer id)
    {
        gameService.deleteGame(id);
        return ResponseEntity.status(201).body(new APIResponse("Game deleted !!"));
    }

    /*----------------END OF CRUD-----------------*/

    @GetMapping("/get/by/title")
    public ResponseEntity getGameByTitle(@RequestBody String title)
    {
        return ResponseEntity.status(201).body(gameService.getGameByTitle(title));
    }

    @GetMapping("/get/by/genre")
    public ResponseEntity getGamesByGenre(@RequestBody String genre)
    {
        return ResponseEntity.status(201).body(gameService.getGamesByGenre(genre));
    }

    @GetMapping("/get/by/rating")
    public ResponseEntity getGamesByRating(@RequestBody Integer rating)
    {
        return ResponseEntity.status(201).body(gameService.getGamesByRating(rating));
    }

    @GetMapping("/get/avg/rating")
    public ResponseEntity getAvgRating(@RequestBody String title)
    {
        return ResponseEntity.status(201).body(new APIResponse(gameService.getAvgRating(title)));
    }

    @GetMapping("/get/by/type")
    public ResponseEntity getGamesByType(@RequestBody String type)
    {
        return ResponseEntity.status(201).body(gameService.getGamesByType(type));
    }
}
