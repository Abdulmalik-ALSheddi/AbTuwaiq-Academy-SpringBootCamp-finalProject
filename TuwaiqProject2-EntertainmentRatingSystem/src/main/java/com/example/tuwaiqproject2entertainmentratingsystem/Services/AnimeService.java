package com.example.tuwaiqproject2entertainmentratingsystem.Services;

import com.example.tuwaiqproject2entertainmentratingsystem.Exception.APIException;
import com.example.tuwaiqproject2entertainmentratingsystem.Model.Anime;
import com.example.tuwaiqproject2entertainmentratingsystem.Repositories.AnimeRepository;
import com.example.tuwaiqproject2entertainmentratingsystem.Repositories.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimeService {

    private final AnimeRepository animeRepository;

    public List<Anime> getAnimes() {
        if(animeRepository.findAll().isEmpty())
            throw new APIException("No Animes Added.");
        return animeRepository.findAll();
    }

    public void addAnime(Anime anime) {
        if(anime.getTitle().equals("AOT") & anime.getRating()!=10)
            throw new APIException("RECONSIDER YOUR TASTE, ANIME NOT ADDED \n \t\t\t#AOT_THE_GOAT");
        animeRepository.save(anime);
    }

    public void updateAnime(Integer id, Anime anime) {
        Anime anime1 = animeRepository.findAnimeById(id);
        if(anime1 == null)
            throw new APIException("Anime NOT FOUND !!");
        if(anime.getTitle().equals("AOT") & anime.getRating()!=10)
            throw new APIException("RECONSIDER YOUR TASTE, ANIME NOT UPDATED \n \t\t\t#AOT_THE_GOAT");
        anime1.setTitle(anime.getTitle());
        anime1.setGenre(anime.getGenre());
        anime1.setRating(anime.getRating());
        anime1.setEpNum(anime.getEpNum());
        animeRepository.save(anime1);
    }

    public void deleteAnime(Integer id) {
        Anime anime = animeRepository.findAnimeById(id);
        if(anime == null)
            throw new APIException("Anime NOT FOUND !!");
        if(anime.getTitle().equals("AOT"))
            throw new APIException("No nO No nO, you can't delete AOT \n \t\t\t#AOT_THE_GOAT");
        animeRepository.deleteById(id);
    }

    public List<Anime> getAnimesByGenre(String genre) {
        if(animeRepository.findAllByGenre(genre).isEmpty())
            throw new APIException("No Animes in this genre.");
        return animeRepository.findAllByGenre(genre);
    }

    public List<Anime> getAnimesByRating(Integer rating) {
        if(animeRepository.findAllByRatingGreaterThanEqual(rating).isEmpty())
            throw new APIException("No animes of this rating or higher.");
        return animeRepository.findAllByRatingGreaterThanEqual(rating);
    }

    public Anime getAnimeByTitle(String title) {
        if(animeRepository.findAnimeByTitle(title) == null)
            throw new APIException("No anime has this title.");
        return animeRepository.findAnimeByTitle(title);
    }

    public String getAvgRating(String title) {
        List<Anime> animes = animeRepository.findAllByTitle(title);
        if(animes.isEmpty())
            throw new APIException("NO Anime has this title.");
        if(title.equals("AOT"))
            return "AOT is not RATABLE.\n \t#AOT_THE_GOAT";
        double avg, sum=0;
        for (int i = 0; i < animes.size() ; i++) {
            sum += animes.get(i).getRating();
        }
        avg = sum/ animes.size();
        return "The average rating for "+title+" is: "+avg;
    }

    public List<Anime> getAnimesByEpNum(Integer epNum) {
        if(animeRepository.findAllByEpNumLessThanEqual(epNum).isEmpty())
            throw new APIException("No animes have this number of episodes or less");
        return animeRepository.findAllByEpNumLessThanEqual(epNum);
    }
}
