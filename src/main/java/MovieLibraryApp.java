import handlers.UserInputHandler;
import models.MovieLibrary;

import static handlers.MenuHandler.print;

public class MovieLibraryApp {

    public static void main(String[] args) {

        // ŁADOWANIE BIBLIOTEKI FILMÓW
        MovieLibrary movieLibrary = new MovieLibrary(); //jak static - musi być obiekt
        movieLibrary.fillMovieLibrary();


        while (true){
            print();

            switch (UserInputHandler.getMenuOptionFromUser()){
                case DISPLAY_INFORMATION_ABOUT_RANDOM_MOVIE:
                    movieLibrary.getRandomMovieInformation();
                    break;
                case DISPLAY_ALL_MOVIES_FOR_SELECTED_ACTOR:
                    movieLibrary.getActorFilmography();
                    break;
                case QUIT:
                    System.out.println("See you later!");
                    System.exit(1);
            }

        }


    }




}
