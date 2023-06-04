package models;

import handlers.RandomDataHandler;
import handlers.UserInputHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MovieLibrary {

    private static List<Movie> movieLibrary;

    public void fillMovieLibrary() {
        movieLibrary = new ArrayList<>();

        Director r_Scott = new Director("Ridley","Scott");
        Director g_Verbinski = new Director("Gore","Verbinski");
        Director q_Tarantino = new Director("Quentin","Tarantino");
        Director p_Jackson = new Director("Peter","Jackson");

        Actor j_Deep = new Actor("Johnny", "Deep");
        Actor o_Bloom = new Actor("Orlando", "Bloom");
        Actor k_Knightley = new Actor("Keira", "Knightley");
        Actor j_Travolta = new Actor("John", "Travolta");
        Actor u_Thurman = new Actor("Uma", "Thurman");
        Actor h_Keitel = new Actor("Harvey", "Keitel");
        Actor t_Cruze = new Actor("Tom", "Cruise");



        movieLibrary.add(new Movie("Gladiator", r_Scott, List.of(j_Deep, h_Keitel, t_Cruze)));
        //przechowujemy obiekty tworzone za pomocą konstruktora z klasy Movie
        movieLibrary.add(new Movie("Pirates of the Caribbean",g_Verbinski, List.of(u_Thurman, j_Deep)));
        movieLibrary.add(new Movie("Pulp Fiction",q_Tarantino, List.of(j_Travolta, u_Thurman)));
        movieLibrary.add(new Movie("Hobbit - An Unexpected Journey",r_Scott, List.of(k_Knightley, t_Cruze)));
        movieLibrary.add(new Movie("Poranek Kojota",p_Jackson, List.of(j_Travolta, o_Bloom)));
        movieLibrary.add(new Movie("Transformers",q_Tarantino, List.of(j_Travolta, j_Deep)));
        movieLibrary.add(new Movie("Top Gun",r_Scott, List.of(h_Keitel, t_Cruze)));
        movieLibrary.add(new Movie("Desperado",r_Scott, List.of(u_Thurman, o_Bloom)));
        movieLibrary.add(new Movie("Mission Impossible",p_Jackson, List.of(j_Deep, t_Cruze)));
        movieLibrary.add(new Movie("Forest Gump",g_Verbinski, List.of(k_Knightley, h_Keitel)));
    }

    public static List<Movie> getMovieLibrary() {
        return movieLibrary;
    }

    public void getRandomMovieInformation() { // nie statyczna, bo mamy już obiekt
        System.out.println(movieLibrary.get(RandomDataHandler.getRandomMovieIndex()));
    }

    public void getActorFilmography() {
        Actor actor = UserInputHandler.getActorFromUser();
        var actorFilmography = actorFilmographyList(actor);

        if(actorFilmography.isEmpty()){
            System.out.println("There is no movie with this actor in the Library");
        }else {
            System.out.println("Actor " + actor + " was found in following movie(s):");
            for (String movie : actorFilmography) {
                System.out.println(movie);
            }
        }
    }

    private List<String> actorFilmographyList(Actor actorToFind) {
        Predicate<Movie> moviePredicate = movie -> movie.getListOfActors().stream()
                .anyMatch(actor -> actor.getFirstName().equals(actorToFind.getFirstName()) &&
                        actor.getLastName().equals(actorToFind.getLastName()));

        return movieLibrary.stream()
                .filter(moviePredicate)
                .map(Movie::getTitle)
                .collect(Collectors.toList());
    }
}
