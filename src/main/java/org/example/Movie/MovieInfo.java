package org.example.Movie;

import org.example.People.Actor;
import org.example.People.Director;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class MovieInfo extends Movie {
    private String recordAt;
    private Integer movieLength;
    private LocalDate startShooting;
    private LocalDate endShooting;

    public MovieInfo(String name, Integer releaseYear, ArrayList<Director> directors, ArrayList<Actor> actors,
                     String recordAt, Integer movieLength, LocalDate startShooting, LocalDate endShooting) {
        super(name, releaseYear, directors, actors);
        this.recordAt = recordAt;
        this.movieLength = movieLength;
        this.startShooting = startShooting;
        this.endShooting = endShooting;
    }

    public String getRecordAt() {
        return recordAt;
    }

    public void setRecordAt(String recordAt) {
        this.recordAt = recordAt;
    }

    public Integer getMovieLength() {
        return movieLength;
    }

    public void setMovieLength(Integer movieLength) {
        this.movieLength = movieLength;
    }

    public LocalDate getStartShooting() {
        return startShooting;
    }

    public void setStartShooting(LocalDate startShooting) {
        this.startShooting = startShooting;
    }

    public LocalDate getEndShooting() {
        return endShooting;
    }

    public void setEndShooting(LocalDate endShooting) {
        this.endShooting = endShooting;
    }
}
