import java.io.IOException;
import java.util.*;

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
        chooseGame(userInput);

    //    chooseGame(userInput);

    }

    public void chooseGame(int userInput) throws IOException {


        if (userInput == 1) {
            letterCryptogram LetterCrypt = new letterCryptogram();
            LetterCrypt.play();
        }
        if (userInput == 2) {
            numberCryptogram NumberCrypt = new numberCryptogram();
            NumberCrypt.play();
        }

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



    public int enterNumber() {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        return i;
    }
    public char enterLetter() {
        // takes in user input
        Scanner sc = new Scanner(System.in);
        char c = sc.nextLine().charAt(0);
        return c;
    }

}




//TODO: create cryptogram generator, dont forget to update gui when complete




