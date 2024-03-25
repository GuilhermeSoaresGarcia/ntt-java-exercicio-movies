package org.example;

import org.example.People.Actor;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Actor> actors = new ArrayList<Actor>();

        Actor actor = new Actor("Anthony Hopkins", 86, "Britânico");
        Actor actor1 = new Actor("Leonardo DiCaprio", 49, "Estadunidense");
        Actor actor2 = new Actor("Fernanda Montenegro", 94, "Brasileira");

        actors.add(actor);
        actors.add(actor1);
        actors.add(actor2);

        actors.forEach(subject -> {
            String actorInfo = String.format(
                    "Nome: %s\nIdade: %d\nNacionalidade: %s\n",
                    subject.getName(), subject.getAge(), subject.getNationality());
            System.out.println(actorInfo);
        });
    }
}
