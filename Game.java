import java.io.IOException;
import java.util.Scanner;

public class Game {
 //  private List<List<String>> encryption;
    int userInput;

    public static void main(String[] args) throws IOException {
        // Create a new game
        Game game = new Game();
        Gui gui = new Gui();



        // Start the game
        gui.startMenu();
    }

    public Game() throws IOException {
        userInput = getUserInput();
        Cryptogram crypt = new Cryptogram(userInput);

    }
    public void playGame() {
        System.out.println("Game Started!");


    }
    private int getUserInput() {
        int choice = 0;
        boolean correctInput = false;
        do {

            System.out.println("Please enter 1 to play a letter cryptogram or 2 to play a number cryptogram");
            Scanner input = new Scanner(System.in);
            choice = input.nextInt();
            input.nextLine();

            if (choice == 1 || choice == 2){
                correctInput = true;
            }
            else {
                System.out.println("Please enter a valid input");
            }
        } while (!correctInput);

        return choice;
    }

}




        //TODO: create cryptogram generator, dont forget to update gui when complete




