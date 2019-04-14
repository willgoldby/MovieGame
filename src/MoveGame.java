import java.util.Scanner;
import java.io.File;
import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;
import java.lang.*;

public class MoveGame {
  public static void main (String[] args) throws Exception {

    // Gets user input
    Scanner userInput = new Scanner(System.in);

    // Gets a file of movies into the program
    File movies = new File("movies.txt");

    // Gets a list of movies
    Scanner movieTitles = new Scanner(movies);


    // Loops through list of movies and adds movie name to movieTitlesList
    ArrayList<String> movieTitlesList = new ArrayList<String>();
    int counter = 0;
    while(movieTitles.hasNextLine()){
      String movieName = movieTitles.nextLine();
      movieTitlesList.add(movieName);
      counter++;

    }

    // Gets a random number between 0 and the number of movies
    int randomNumber = ThreadLocalRandom.current().nextInt(0, counter + 1);

    // System.out.println(randomNumber);
    // System.out.println(movieTitlesList.get(randomNumber));

    // Gets the name of a random movie
    String randomMovie = movieTitlesList.get(randomNumber);
    

    // Declares variable to hold movie name as a series of underscores
    StringBuilder movieNameInUnderscores = new StringBuilder();


    // Loops through randomMovie and adds an underscore in movieNameInUnderscores
    for(int i=0; i<randomMovie.length(); i++){
        if(randomMovie.charAt(i) != ' ') {
          movieNameInUnderscores.append('-');
        }else{
          movieNameInUnderscores.append(' ');
        }
    }
    System.out.println(movieNameInUnderscores);

    // Starts the guessing game
     Boolean won = false;
    for(int userGuess=0; userGuess<=10; userGuess++){
      // Test for a win
      if(movieNameInUnderscores.toString().contains("-")){
        // Gets user input
        Scanner getUserInput = new Scanner(System.in);
        System.out.println("What letter do you guest?");
        String usersGuess = getUserInput.nextLine();

        // Check if user's guess is in word
        for(int q=0;q<randomMovie.length();q++){
          if(randomMovie.charAt(q) == usersGuess.charAt(0)){
            movieNameInUnderscores.setCharAt(q, usersGuess.charAt(0));
          }

        }

      }else{
        System.out.println("YOU WON!");
        won = true;
        break;
      }

      System.out.println(movieNameInUnderscores);
      System.out.println("You have " + (10-userGuess) + " more guesses.");

    }

    // When user runs out of guesses
      if(!won){
        System.out.println("You lost :(");
      }
    }
  }
