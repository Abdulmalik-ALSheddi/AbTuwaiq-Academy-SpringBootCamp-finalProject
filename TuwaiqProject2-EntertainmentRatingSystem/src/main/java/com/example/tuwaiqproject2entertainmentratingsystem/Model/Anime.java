package com.example.tuwaiqproject2entertainmentratingsystem.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Anime {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @NotEmpty(message = "TITLE CAN'T BE EMPTY")
    private String title;

    @NotEmpty(message = "GENRE CAN'T BE EMPTY")
    @Pattern(regexp = "(action|horror|drama)" , message = "GENRE MUST BE 'action' Or 'horror' OR 'drama'")
    private String genre;

    @NotNull(message = "RATING CAN'T BE NULL")
    @Min(value = 0 , message = "RATING MUST BE ZERO OR MORE")
    @Max(value = 10 , message = "RATING MUST BE TEN OR LESS")
    private Integer rating;

    @NotNull(message = "NUMBER OF EPISODES CAN'T BE NULL")
    @Min(value = 1,message = "NUMBER OF EPISODES MUST BE AT LEAST 1")
    private Integer epNum;
}
