package org.example;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.validator.GenericValidator;
import org.example.Movie.MovieInfo;
import org.example.People.Actor;
import org.example.People.Director;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Actor> actors = new ArrayList<>();
        ArrayList<Director> directors = new ArrayList<>();

        Boolean isValid;

        System.out.println("\n###################################");
        System.out.println("SISTEMA DE CADASTRAMENTO DE FILMES:");
        System.out.println("###################################");
        System.out.println("----------------------------");
        System.out.println("1. CADASTRAR DADOS DO FILME:");
        System.out.println("----------------------------");

        System.out.println("Digite o nome do filme: ");
        String movieName = StringUtils.capitalize(input.nextLine().toLowerCase());

        System.out.println("Digite o local de gravação do filme: ");
        String recordAt = StringUtils.capitalize(input.nextLine().toLowerCase());

        int releaseYear = 0;
        do {
            isValid = true;
            try {
                System.out.println("Digite o ano de lançamento: ");
                releaseYear = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException exception) {
                System.out.println("O ano deve ser um número. ");
                isValid = false;
            }
        } while (!isValid);

        String startShooting = "";
        do {
            isValid = true;
            System.out.println("Digite a data de inicio da gravação no formato por AAAA/MM/DD: ");
            startShooting = input.nextLine();
            Boolean dateValidation = GenericValidator.isDate(startShooting, "yyyy/MM/dd", true);
            if (!dateValidation) {
                System.out.println("Data com formato ou valores incorretos: ");
                isValid = false;
            }
        } while (!isValid);

        String endShooting = "";
        do {
            isValid = true;
            System.out.println("Digite a data de encerramento da gravação no formato por AAAA/MM/DD: ");
            endShooting = input.nextLine();
            Boolean dateValidation = GenericValidator.isDate(endShooting, "yyyy/MM/dd", true);
            if (!dateValidation) {
                System.out.println("Data com formato ou valores incorretos: ");
                isValid = false;
            }
        } while (!isValid);

        int movieLength = 0;
        do {
            isValid = true;
            try {
                System.out.println("Digite a duração do filme em minutos: ");
                movieLength = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException exception) {
                System.out.println("A duração deve ser um número. ");
                isValid = false;
            }
        } while (!isValid);

        do {
            System.out.println("\n----------------------------------");
            System.out.println("2. CADASTRAR DADOS DO(S) ATOR(ES):");
            System.out.println("----------------------------------");
            System.out.println("Digite o nome do ator: ");
            String actorsName = input.nextLine();

            int actorsAge = 0;
            do {
                isValid = true;
                try {
                    System.out.println("Digite a idade do ator: ");
                    actorsAge = Integer.parseInt(input.nextLine());
                } catch (NumberFormatException exception) {
                    System.out.println("A idade deve ser um número. ");
                    isValid = false;
                }
            } while (!isValid);

            System.out.println("Digite a nacionalidade do ator: ");
            String actorsNationality = input.nextLine();

            Actor actor = new Actor(actorsName, actorsAge, actorsNationality);
            actors.add(actor);

            System.out.println("\nDeseja cadastrar outro ator? S/N");
            String confirmation = input.nextLine().toLowerCase();

            while (!confirmation.equals("s") && !confirmation.equals("n")) {
                System.out.println("Responda com 'S' ou 'N'.");
                confirmation = input.nextLine().toLowerCase();
            }

            isValid = confirmation.equals("n");
        } while (!isValid);

        do {
            System.out.println("\n-------------------------------------");
            System.out.println("2. CADASTRAR DADOS DO(S) DIRETOR(ES):");
            System.out.println("-------------------------------------");
            System.out.println("Digite o nome do diretor: ");
            String directorsName = input.nextLine();

            int directorsAge = 0;
            do {
                isValid = true;
                try {
                    System.out.println("Digite a idade do diretor: ");
                    directorsAge = Integer.parseInt(input.nextLine());
                } catch (NumberFormatException exception) {
                    System.out.println("A idade deve ser um número. ");
                    isValid = false;
                }
            } while (!isValid);

            System.out.println("Digite a nacionalidade do diretor: ");
            String directorsNationality = input.nextLine();

            Director director = new Director(directorsName, directorsAge, directorsNationality);
            directors.add(director);

            System.out.println("\nDeseja cadastrar outro diretor? S/N");
            String confirmation = input.nextLine().toLowerCase();

            while (!confirmation.equals("s") && !confirmation.equals("n")) {
                System.out.println("Responda com 'S' ou 'N'.");
                confirmation = input.nextLine().toLowerCase();
            }

            isValid = confirmation.equals("n");
        } while (!isValid);

        MovieInfo movie = new MovieInfo(
                movieName,
                releaseYear,
                directors,
                actors,
                recordAt,
                movieLength,
                LocalDate.parse(startShooting.replace("/", "-")),
                LocalDate.parse(endShooting.replace("/", "-")));

        String actorInfo = movie.getActors().stream()
                .map(actor -> String.format("%s, %d anos, %s", actor.getName(), actor.getAge(), actor.getNationality()))
                .collect(Collectors.joining(" / "));

        String directorInfo = movie.getDirectors().stream()
                .map(director -> String.format("%s, %d anos, %s", director.getName(), director.getAge(), director.getNationality()))
                .collect(Collectors.joining(" / "));

        System.out.println(
                String.format("\nNome do filme: %s\nAno de lançamento: %d\nLocal de gravação: %s\nDuração: %d minutos\n" +
                                "Data de início das gravações: %s\nData de término das gravações: %s\nAtores: %s\nDiretor(es): %s",
                        movie.getName(), movie.getReleaseYear(), movie.getRecordAt(), movie.getMovieLength(),
                        movie.getStartShooting().toString(), movie.getEndShooting().toString(),
                        actorInfo, directorInfo));
    }
}