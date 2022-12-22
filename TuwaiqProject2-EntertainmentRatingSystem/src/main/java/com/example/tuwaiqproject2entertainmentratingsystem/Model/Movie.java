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
public class Movie {

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


    @NotNull(message = "DURATION CAN'T BE NULL")
    @Min(value = 30 , message = "DURATION MUST BE AT LEAST 30")
    private Integer duration;

}
