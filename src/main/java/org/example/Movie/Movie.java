package org.example.Movie;

import org.example.People.Actor;
import org.example.People.Director;

import java.util.ArrayList;

public class Movie {
    private String name;
    private Integer releaseYear;
    private ArrayList<Director> directors;
    private ArrayList<Actor> actors;

    public Movie(String name, Integer releaseYear, ArrayList<Director> directors, ArrayList<Actor> actors) {
        this.name = name;
        this.releaseYear = releaseYear;
        this.directors = directors;
        this.actors = actors;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public ArrayList<Director> getDirectors() {
        return directors;
    }

    public void setDirectors(ArrayList<Director> directors) {
        this.directors = directors;
    }

    public ArrayList<Actor> getActors() {
        return actors;
    }

    public void setActors(ArrayList<Actor> actors) {
        this.actors = actors;
    }
}
