package com.example.tuwaiqproject2entertainmentratingsystem.Services;

import com.example.tuwaiqproject2entertainmentratingsystem.Exception.APIException;
import com.example.tuwaiqproject2entertainmentratingsystem.Model.Game;
import com.example.tuwaiqproject2entertainmentratingsystem.Model.Movie;
import com.example.tuwaiqproject2entertainmentratingsystem.Repositories.AnimeRepository;
import com.example.tuwaiqproject2entertainmentratingsystem.Repositories.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GameService {

    private final GameRepository gameRepository;

    public List<Game> getGames() {
        return gameRepository.findAll();
    }

    public void addGame(Game game) {
        gameRepository.save(game);
    }

    public void updateGame(Integer id, Game game) {
        Game game1 = gameRepository.findGameById(id);
        if(game1 == null)
            throw new APIException("Game NOT FOUND!!");
        game1.setTitle(game.getTitle());
        game1.setGenre(game.getGenre());
        game1.setRating(game1.getRating());
        game1.setGamePlayType(game.getGamePlayType());
        gameRepository.save(game1);
    }

    public void deleteGame(Integer id) {
        Game game = gameRepository.findGameById(id);
        if(game == null)
            throw new APIException("Game NOT FOUND!!");
        gameRepository.deleteById(id);
    }

    public Game getGameByTitle(String title) {
        if(gameRepository.findGameByTitle(title) == null)
            throw new APIException("No Game with this title.");
        return gameRepository.findGameByTitle(title);
    }

    public List<Game> getGamesByGenre(String genre) {
        if(gameRepository.findAllByGenre(genre).isEmpty())
            throw new APIException("No games in this genre.");
        return gameRepository.findAllByGenre(genre);
    }

    public List<Game> getGamesByRating(Integer rating) {
        if(gameRepository.findAllByRatingGreaterThanEqual(rating).isEmpty())
            throw new APIException("No games of this rating or higher");
        return gameRepository.findAllByRatingGreaterThanEqual(rating);
    }

    public String getAvgRating(String title) {
        List<Game> games = gameRepository.findAllByTitle(title);
        if(games.isEmpty())
            throw new APIException("No games with this title.");
        double avg,sum=0;
        for (int i = 0; i <games.size() ; i++) {
            sum += games.get(i).getRating();
        }
        avg = sum/games.size();
        return "The average rating for "+title+" is: "+avg;
    }

    public List<Game> getGamesByType(String type) {
        List<Game> games = gameRepository.findAllBygamePlayType(type);
        if(games.isEmpty())
            throw new APIException("No games of this type");
        return games;
    }
}
