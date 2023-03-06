import java.io.IOException;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

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
        playGame(userInput);
    }
    public void playGame(int option) throws IOException {
        System.out.println("Game Started!");
        System.out.println("Enter a character to guess, press the ` key to undo a guess");

        Stack<Character> inputs = new Stack<>();
        Stack<Integer> numPositions = new Stack<>();
        Stack<Integer> letPositions = new Stack<>();

        Cryptogram crypt;
        if (option == 1) {
            crypt = new letterCryptogram();
        } else {
            crypt = new numberCryptogram();
        }

        String phrase = crypt.choosePhrase();
        crypt.encryptPhrase(phrase);
        HashMap<Integer, Character> encryptionMap = crypt.encryptionMap;

        StringBuilder encryptedPhrase = new StringBuilder();
        for (int i = 0; i < phrase.length(); i++) {
            if (phrase.charAt(i) == ' ') {
                encryptedPhrase.append(" ");
            } else {
                encryptedPhrase.append(encryptionMap.get(crypt.encryption.get(i)));
            }
        }
        System.out.println("Encrypted Phrase: " + encryptedPhrase);

        int correctGuesses = 0;

        boolean running = true;
        do {
            System.out.println("Current phrase:");
            for (int i = 0; i < crypt.encryption.size(); i++) {
                int number = crypt.encryption.get(i);
                if (encryptionMap.containsKey(number)) {
                    System.out.print(encryptionMap.get(number));
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();

            System.out.println("Enter a character to guess:");
            char guess = enterLetter();
            if (guess == '`') {
                if (!inputs.empty()) {
                    int undoNumber = numPositions.pop();
                    int undoLetter = letPositions.pop();
                    encryptionMap.remove(undoNumber);
                    crypt.encryption.set(undoLetter, undoNumber);
                    inputs.pop();
                    correctGuesses--;
                    System.out.println("Undo successful!");
                } else {
                    System.out.println("No guesses to undo!");
                }
            } else {
                System.out.println("Enter the position to replace (starting from 1):");
                int pos = enterNumber() - 1;
                if (pos < 0 || pos >= crypt.encryption.size()) {
                    System.out.println("Invalid position!");
                } else if (inputs.contains(guess)) {
                    System.out.println("Character already guessed!");
                } else {
                    int num = crypt.encryption.get(pos);
                    encryptionMap.put(num, guess);
                    crypt.encryption.set(pos, num);
                    inputs.push(guess);
                    numPositions.push(num);
                    letPositions.push(pos);
                    correctGuesses++;

                    // Fill in all instances of the entered letter in the cryptogram
                    for (int i = 0; i < crypt.encryption.size(); i++) {
                        int number = crypt.encryption.get(i);
                        if (encryptionMap.containsKey(number) && encryptionMap.get(number) == guess) {
                            crypt.encryption.set(i, num);
                        }
                    }

                    if (correctGuesses == encryptionMap.size()) {
                        running = false;
                        System.out.println("Congratulations, you solved the cryptogram!");
                    }
                }
            }
        } while (running);


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
    public void chooseGame(int userInput) throws IOException {


        if (userInput == 1) {
            letterCryptogram LetterCrypt = new letterCryptogram();
        }
        if (userInput == 2) {
            numberCryptogram NumberCrypt = new numberCryptogram();
        }

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




